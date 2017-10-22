import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.ArrayList;

/**
 * Write a description of class myWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class myWorld extends World
{
    public static final int FPS = 50;

    public final static int WIDTH = 500;

    public final static int HEIGHT = 360;

    public static int direction;

    public static final int SOUTH = 4;

    public static final int NORTH = 1;

    public static final int EAST = 2;

    public static final int WEST = 3;

    public static final int TILESIZE = 64;

    public int width=640;

    public int heigth=640;

    private BufferedImage im,backImage,mim;

    private int state;

    private static final int GameRunning = 0;

    private static final int GameOver = 1;

    private static final int GamePaused = 2;

    private static final int GameFinish = 3;

    public Player man;

    private ArrayList enemy;

    private GameWorldManager gameWorld;

    private int score;

    public boolean isGameOver = false;

    public boolean isMusicStopped = false;

    public Bullet bul;

    public ArrayList bullets;

    String keycode;
    private Font font;
    public boolean leftPressed = false;

    public boolean rightPressed = false;

    public static final int TOTALLEVEL = 2;

    public static int level = 1;

    private boolean levelUp = false;

    public static int backX=0;

    public MusicPlayer music;
    
    private boolean  canShowRank=false;
    
    public boolean mimiMode=false;

    public myWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        gameWorld = new GameWorldManager(this);
        gameWorld.init();
        man = new Player(gameWorld, this);
        bullets = new ArrayList();

        music = new MusicPlayer();
        music.loadMusic("sounds/music.midi");
        im =new BufferedImage(width, heigth);
        backImage=new BufferedImage("images/clouds.png");
        im.drawImage(backImage,0,0);
        man.draw(im);
         
        Font font = new Font("Arial", Font.BOLD, 30);
        im.setFont(font);
        im.setColor(Color.black);
        im.drawString("Fairy Footsteps in Green Land" , 30, 150);
        im.drawString("with" , 190, 210);
        im.setColor(Color.red);
        im.drawString("High Score",150,270);
        font = new Font("Arial", Font.BOLD, 15);
        im.setFont(font);
        im.setColor(Color.black);
        im.drawString("Click \"Run\" to Start..." , 150, 320);
        setBackground(im); 
    }
    
    public void stopped()
    {
        music.stopPlaying();   
    }

    public void started()
    {
        music.playMusic();
    }

    public void gamePaint() {
        if(canShowRank==false)
          setBackground(im); 
    }

    public void gameRender() {
        if(backX>0){
            im.drawImage(backImage,backX,0);
            im.drawImage(backImage,-(WIDTH-backX),0);
        }
        else{
            im.drawImage(backImage,backX,0);
            im.drawImage(backImage,(WIDTH+backX),0);
        }

        gameWorld.draw(im);
        man.draw(im);
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bul = (Bullet) bullets.get(i);
            if (bul.isActive()) {
                bul.draw(im);
            } else {
                bullets.remove(i);
            }
        }
//         drawMimiMap();
        Font font = new Font("Arial", Font.BOLD, 20);
        im.setFont(font);
        im.setColor(Color.black);
        if (level >= 1 && level <= TOTALLEVEL) {
            im.drawString("level " + (level), 10, 350);
            im.drawString("Score:" + score, 400, 40);
            im.drawString("Enemy Left:" + gameWorld.anpcNum, 350, 350);
        }

        if (state == GameOver) {
            font = new Font("Arial", Font.BOLD, 90);
            im.setFont(font);
            im.drawString("Game Over!", 0, HEIGHT / 2);
            font = new Font("Arial", Font.BOLD, 30);
            im.setFont(font);
            im.setColor(Color.red);
            im.drawString("Loading High Score……", 80,HEIGHT / 2 + 80);
        } else if (state == GameFinish) {
            font = new Font("Arial", Font.BOLD, 90);
            im.setFont(font);
            im.drawString("  Finished!", 0, HEIGHT / 2);
            font = new Font("Arial", Font.BOLD, 30);
            im.setFont(font);
             im.setColor(Color.red);
            im.drawString("Loading High Score……", 80,HEIGHT / 2 + 80);
        }

    }

    public void gameUpdate() {
        //         if (music.isStopped()==true) {
        //             music.playMusic();
        //         }
        music.repeating();

        if(man.getState()!=Player.UpScrollY&&man.getState()!=Player.DownScrollY)            
            testkeyPressed();

        if (state == GameRunning) {
            checkGameOver();
            checkCollision();
            man.update(); // man.move() must be first operated!
            checkShooting();
            gameWorld.update();
        }
        else {      
            canShowRank=true;
            setBackground(backImage);
            showRank();
            Greenfoot.stop();
        }
    }
    
    public void drawMimiMap(){  
        mim=new BufferedImage(gameWorld.tMap.getWidth()*gameWorld.tMap.TILE_SIZE, gameWorld.tMap.getHeight()*gameWorld.tMap.TILE_SIZE);
//         mim.scale(gameWorld.tMap.getWidth()*gameWorld.tMap.TILE_SIZE, gameWorld.tMap.getHeight()*gameWorld.tMap.TILE_SIZE);
        gameWorld.drawMim(mim);
        man.drawMim(mim);
        mim.scale(WIDTH, HEIGHT);
//         im.setColor(Color.white);
//         im.fillRect(0, 0,gameWorld.tMap.getWidth()*gameWorld.tMap.TILE_SIZE, gameWorld.tMap.getHeight()*gameWorld.tMap.TILE_SIZE);
       im.drawImage(backImage,0,0);
 im.drawImage(mim,0, 0);
    }
    
    public void showRank(){
        if(UserInfo.isStorageAvailable()) {
            if(UserInfo.getMyInfo() != null) {
                UserInfo player = UserInfo.getMyInfo();
                if(player.getScore() < score) {
                    player.setScore(score);
                    player.store();
                }
            }
        }   
        addObject(new ScoreBoard(getWidth(), getHeight()), getWidth()/2, getHeight()/2);
    }

    public void act() {

        gameUpdate();
        if(mimiMode==false){
          gameRender();
          gamePaint();
        }
        else {
            drawMimiMap();
            setBackground(im);
        }
    }

    public void testkeyPressed() {

        if(Greenfoot.isKeyDown("r")){
            if (state!= GameFinish) {
                score=0;
                level--;
                levelUp = true;
                changeState(GameRunning);
            }
        }

        if (state == GameRunning) {
            
            if(Greenfoot.isKeyDown("="))
                if (level < TOTALLEVEL) {
                    score=0;
                    levelUp = true;
            }

            if(Greenfoot.isKeyDown("-"))
                if (level > 1) {
                    score=0;
                    level -= 2;
                    levelUp = true;
            }

            if(Greenfoot.isKeyDown("right")){
                //                 if(backX>WIDTH-gameWorld.tMap.getHeight())
                //                     backX=(backX-(int)(0.5*gameWorld.imMoveSize))%WIDTH;
                if (leftPressed == false) {
                    gameWorld.canMoveLeft = true;
                    man.runningState = Player.RUNRT;
                    rightPressed = true;
                }
            }
            else 	if (rightPressed == true) {
                gameWorld.canMoveLeft = false;
                man.runningState = Player.STDRT;
                rightPressed = false;
            }

            if(Greenfoot.isKeyDown("left")){
                //                 if(backX<0)
                //                     backX=(backX+(int)(0.5*gameWorld.imMoveSize))%WIDTH;
                if (rightPressed == false) {
                    gameWorld.canMoveRight = true;
                    man.runningState = Player.RUNLT;
                    leftPressed = true;
                }
            }
            else if (leftPressed == true) {
                gameWorld.canMoveRight = false;
                man.runningState = Player.STDLT;
                leftPressed = false;
            }

            if(Greenfoot.isKeyDown("space"))
                if (man.onGround==true&&man.getDY()==0) {
                    man.isJumping = true;
                    Greenfoot.playSound("jump.wav");
            }
            String keycode=Greenfoot.getKey();
            if(keycode!=null&&keycode.equals("control"))
                if (!isGameOver) {
                    bul = new Bullet(man);
                    bullets.add(bul);
            }
            if(keycode!=null&&keycode.equals("m")){
                mimiMode =  !mimiMode ;
            }
        }

    }

    public void checkGameOver() {

        if (gameWorld.anpcNum == 0)
            levelUp = true;

        if (levelUp == true) {
            levelUp = false;
            if (level < TOTALLEVEL){
                level ++;
                loadLevel();
            }
            else
                changeState(GameFinish);
        }

        if (man.state == Sprite.DISMISS) {
            changeState(GameOver);
        }

    }

    public void loadLevel() {

        //         music.stopPlaying();
        gameWorld = new GameWorldManager(this);
        gameWorld.init();
        man = new Player(gameWorld, this);		
        bullets = new ArrayList();
        music.replay();
        //         music = new MusicPlayer();
        //         music.loadMusic("sounds/music.midi");
    }

    public void checkShooting() {
        // man.move() must be first operated!
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bul = (Bullet) bullets.get(i);
            for (int j = 0; j < gameWorld.getSprites().size(); j++) {
                NPC eny = (NPC) gameWorld.getSprites().get(j);
                if (gameWorld.spriteCollision(bul, eny, true)
                && (eny.npcType == NPC.ANPC)
                && (eny.state != Sprite.ISHITTED) && bul.isActive()) {
                    //                     sound.loadSound("Sounds/collision.wav");
                    //                     sound.playSound();
                    Greenfoot.playSound("collision.wav");
                    eny.changeState(Sprite.ISHITTED);
                    //					gameWorld.anpcNum--;
                    bul.changeState(Sprite.DISMISS);
                    score += 50;
                }
            }
            bul.update();
        }
    }

    public void changeState(int s) {
        state = s;
    }

    public void checkCollision() {
        for (int i = 0; i < gameWorld.getSprites().size(); i++) {
            NPC eny = (NPC) gameWorld.getSprites().get(i);
            if (gameWorld.spriteCollision(man, eny, true)
            && (eny.state == Sprite.MOVE)
            && (man.state != Player.UpScrollY)
            && (man.state != Player.DownScrollY)) {
                if ((eny.npcType == NPC.ANPC) && (man.state != Player.UNATTACK)) {
                    //                     sound.loadSound("Sounds/collision.wav");
                    //                     sound.playSound();
                    Greenfoot.playSound("collision.wav");
                    if ((man.dy > 0)
                    && (man.locY < (eny.locY - gameWorld.getOffsetY()))) {
                        eny.changeState(Sprite.ISHITTED);
                        //						gameWorld.anpcNum--;
                        score += 100;
                    } else {
                        man.changeState(Sprite.ISHITTED);

                    }
                } else if (eny.npcType == NPC.SNPC) {
                    Greenfoot.playSound("eat.wav");
                    //                     sound.loadSound("Sounds/eat.wav");
                    //                     sound.playSound();

                    if (eny.npcName.equals("star")) {
                        eny.changeState(Sprite.DISMISS);
                        man.resetCount();
                        man.changeState(Player.UNATTACK);
                    }
                    if (eny.npcName.equals("heart")) {
                        eny.changeState(Sprite.DISMISS);
                        if (man.lives < Player.LFNUM) {
                            man.lives++;
                        }
                        man.updateHearts();
                    }
                    if (eny.npcName.equals("power")) {
                        eny.changeState(Sprite.DISMISS);
                        man.jumpSpeed -= 5;
                    }
                }
            }
        }
    }
}
