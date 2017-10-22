import java.awt.Graphics;
import java.awt.Point;
import java.lang.String;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Administrator
 */
public class Player extends Sprite {

    private final static int GRAVITY = 1;

    private final static int INISPEED = 20;

    private Animation animRight, animLeft;

    public boolean runningRight, runningLeft, standRight, standLeft;

    private GameWorldManager gameWorld;

    private int offsetX, offsetY;

    public int jumpSpeed;

    public boolean isJumping = false;

    public boolean canJump = false;

    public boolean onGround = false;

    public static final int UNATTACK = 3;

    public static final int UpScrollY = 4;

    public static final int DownScrollY = 5;

    public int runningState = 2;

    public static final int RUNRT = 0;

    public static final int RUNLT = 1;

    public static final int STDRT = 2;

    public static final int STDLT = 3;

    public static final int LFNUM = 3;

    public int lives = LFNUM;

    private int count = 0;

    private ArrayList hearts;

    private Life heart;

    private myWorld gameP;

    private int scrollCount = myWorld.HEIGHT;

    // public static int locX;

    public Player(GameWorldManager world, myWorld gp) {

        super(0, 0, "images/player_right.gif", 6);

        gameP = gp;
        animRight = new Animation("images/player_right.gif", 6, 100, 3, true);
        animLeft = new Animation("images/player_left.gif", 6, 100, 3, true);
        runningRight = false;
        runningLeft = false;
        standRight = true;
        standLeft = false;

        gameWorld = world;
        offsetX = gameWorld.getOffsetX();
        offsetY = gameWorld.getOffsetY();
        setDX(0);
        setX(myWorld.WIDTH / 2);
        setY(myWorld.HEIGHT/2);
        setDY(0);
        setJumpSpeed(INISPEED);

        state = MOVE;
        hearts = new ArrayList();
        updateHearts();
    }

    public void update() {
        switch (state) {

            case ISHITTED:
            lives--;
            updateHearts();
            if (lives <= 0) {
                changeState(DISMISS);
            } else {
                changeState(UNATTACK);
            }

            break;

            case UNATTACK:			
            count = (count + 1) % (myWorld.FPS * 3);

            if (count == 0) {
                changeState(MOVE);
            }

            case MOVE:
            move();
            break;

            case DISMISS:
            break;

            case UpScrollY:

            // 			gameP.removeKeyListener(gameP);
            if (scrollCount > 0) {
                onGround=false;
                gameWorld.canMoveLeft = false;
                gameWorld.canMoveRight = false;
                if (runningState == RUNRT) {
                    runningState = STDRT;
                } else if (runningState == RUNLT) {
                    runningState = STDLT;
                }
                scrollCount -= 5;
                offsetY -= 5;
                locY += 5;
                gameWorld.setOffsetY(offsetY);
            } else {
                scrollCount = myWorld.HEIGHT;
                // 				gameP.addKeyListener(gameP);
                gameP.leftPressed = false;
                gameP.rightPressed = false;
                changeState(MOVE);
            }
            break;

            case DownScrollY:

            // 			gameP.removeKeyListener(gameP);
            if (scrollCount > 0) {
                onGround=false;
                gameWorld.canMoveLeft = false;
                gameWorld.canMoveRight = false;
                if (runningState == RUNRT) {
                    runningState = STDRT;
                } else if (runningState == RUNLT) {
                    runningState = STDLT;
                }
                scrollCount -= 5;
                offsetY += 5;
                locY -= 5;
                gameWorld.setOffsetY(offsetY);
            } else {
                scrollCount = myWorld.HEIGHT;
                // 				gameP.addKeyListener(gameP);
                gameP.leftPressed = false;
                gameP.rightPressed = false;
                changeState(MOVE);
            }
            break;

        }
    }

    public void drawHearts(BufferedImage g) {
        for (int i = 0; i < hearts.size(); i++) {
            heart = (Life) hearts.get(i);
            heart.draw(g);
        }
    }

    public void updateHearts() {
        hearts.clear();
        for (int i = 0; i < lives; i++) {

            heart = new Life();
            heart.setX(i * heart.getWidth());
            hearts.add(heart);
        }
    }

    public void resetCount(){
        count=0;
    }

    public void move() {

        if (!isJumping) {
            dy += GRAVITY;
        } else {
            jumpSpeed += GRAVITY;
            setDY(jumpSpeed);
            onGround = false;
            if (jumpSpeed >= 0) {
                isJumping = false;
                jumpSpeed = -INISPEED;
            }
        }

        locY += dy;

        if (locY + gameWorld.getOffsetY() > gameWorld.tMap.getHeight()
        * gameWorld.tMap.TILE_SIZE)
            changeState(DISMISS);
        else if (locY > myWorld.HEIGHT ) {
            if(gameP.mimiMode==false)
                changeState(DownScrollY);
            else{
                locY-=myWorld.HEIGHT;
                gameWorld.setOffsetY(gameWorld.getOffsetY()+myWorld.HEIGHT);
                offsetY=gameWorld.getOffsetY();
            }
        }

        switch (runningState) {
            case RUNRT:
            animRight.updateImage();
            break;
            case RUNLT:
            animLeft.updateImage();
            break;
        }

        if (gameWorld.worldCollisionVertical(this, thisPosition(),
            nextPosition(), offsetY)) {
            if (dy > 0) {
                onGround = true;
                setDY(0);
                if (locY + this.getHeight() < 0){
                    if(gameP.mimiMode==false)
                        changeState(UpScrollY);
                    else{
                        locY+=myWorld.HEIGHT;
                        gameWorld.setOffsetY(gameWorld.getOffsetY()-myWorld.HEIGHT);
                        offsetY=gameWorld.getOffsetY();
                    }
                }
            }

        } else if (dy < 0) {
            isJumping = false;
            jumpSpeed = -INISPEED;

        }

        if (gameWorld.worldCollisionHorizontal(this, thisPosition(),
            nextPosition(), offsetX)) {

            gameWorld.canScroll = false;
        } else {
            // if(locX>=myWorld.WIDTH/2)
            // bgManager.canScroll = true;
            switch (runningState) {
                case RUNLT:
                if (gameWorld.getOffsetX() <= 0 || (locX > myWorld.WIDTH / 2)) {
                    setDX(5);
                    locX -= dx;
                    gameWorld.canScroll = false;
                } else
                    gameWorld.canScroll = true;
                break;
                case RUNRT:
                if (locX < myWorld.WIDTH / 2
                || (gameWorld.getOffsetX() >= (gameWorld.tMap
                        .getWidth()
                        * gameWorld.tMap.TILE_SIZE - myWorld.WIDTH))) {
                    setDX(5);
                    locX += dx;
                    gameWorld.canScroll = false;
                } else
                    gameWorld.canScroll = true;
                break;
            }
        }
    }

    public Point thisPosition() {
        offsetX = gameWorld.getOffsetX();

        int thisX = offsetX + locX, thisY = locY + offsetY;
        return new Point(thisX, thisY);
    }

    public Point nextPosition() {

        offsetX = gameWorld.getOffsetX();

        int nextX = offsetX + locX, nextY = locY + offsetY;
        nextY += dy;

        if (runningState == RUNRT) {

            dx = 5;
            nextX += dx;
        } else if (runningState == RUNLT) {

            dx = -10;
            nextX += dx;
        }

        return new Point(nextX, nextY);
    }

    public void draw(BufferedImage g) {

        drawHearts(g);

        if (state == UNATTACK && (count % 5 == 0)) {
        } else {
            switch (runningState) {
                case RUNRT:
                animRight.draw(g, locX, locY);
                break;
                case RUNLT:
                animLeft.draw(g, locX, locY);
                break;
                case STDRT:
                animRight.draw(g, locX, locY);
                break;
                case STDLT:
                animLeft.draw(g, locX, locY);
                break;
            }
        }
    }

    public void drawMim(BufferedImage g) {

        int locX1=locX+gameWorld.getOffsetX();
        int locY1=locY+gameWorld.getOffsetY();
        if (state == UNATTACK && (count % 5 == 0)) {
        } else {
            switch (runningState) {
                case RUNRT:
                animRight.draw(g, locX1, locY1);
                break;
                case RUNLT:
                animLeft.draw(g, locX1, locY1);
                break;
                case STDRT:
                animRight.draw(g, locX1, locY1);
                break;
                case STDLT:
                animLeft.draw(g, locX1, locY1);
                break;
            }
        }
    }

    private void setJumpSpeed(int jumpS) {
        if (jumpS > 0) {
            jumpS = -jumpS;
        }
        jumpSpeed = jumpS;
    }
}
