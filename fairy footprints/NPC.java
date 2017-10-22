import java.awt.Graphics;
import java.awt.Point;
import java.lang.String;
import greenfoot.*;  
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Administrator
 */
public class NPC extends Sprite {

	private final static int GRAVITY = 1;

	private final static int JUMPSPEED = 20;

	private Animation animRight, animLeft;

	private int numImages;

	public boolean runningRight, runningLeft, standRight, standLeft;

	private GameWorldManager gameWorld;

	private int offsetX, offsetY;

	private int jumpSpeed;

	public boolean isJumping = false;

	public boolean canJump = false;

	public boolean onGround = false;

	public int npcType;

	public static final int ANPC = 0;

	public static final int SNPC = 1;

	public String npcName;

	public NPC(int x, int y, int type, String name, int numImage,
			GameWorldManager gameW) {
		super(x, y, "images/" + name + "Right.gif", numImage);
		npcName = name;
		npcType = type;
		if (npcType == ANPC) {
			animRight = new Animation("images/" + npcName + "Right.gif",
					numImage, 50, 3, true);
			animLeft = new Animation("images/" + npcName + "Left.gif",
					numImage, 50, 3, true);
			runningRight = false;
			runningLeft = false;
			standRight = true;
			standLeft = false;
			setDX(4);
			setDY(0);
			setJumpSpeed(JUMPSPEED);
		}
		gameWorld = gameW;
	}

	public NPC(int x, int y, int type, String name, GameWorldManager gameW) {
		super(x, y, "images/" + name + ".png", 1);
		npcName = name;
		npcType = type;

		gameWorld = gameW;
		// offsetX = world.getOffsetX();
		// offsetY = world.getOffsetY();

	}

	public void jump() {

		jumpSpeed += GRAVITY;
		setDY(jumpSpeed);
	}

	public void jumpStopped() {

		isJumping = false;
		setJumpSpeed(JUMPSPEED);
	}

	public void drop() {
		if (locY - gameWorld.getOffsetY() >myWorld.HEIGHT) {
			changeState(DISMISS);
		}
		setDY(dy + GRAVITY);
		locY += dy;
	}

	public void update() {
		if (npcType == NPC.ANPC) {
			switch (state) {
			case MOVE:
				if (gameWorld.gameP.man.getState() != Player.UpScrollY
						&& gameWorld.gameP.man.getState() != Player.DownScrollY)
					move();
				break;
			case ISHITTED:
				drop();
				break;
			case DISMISS:
				setActive(false);
				break;
			}
		}
		else if (npcType == NPC.SNPC) {
			switch (state) {
			case DISMISS:
				setActive(false);
				break;
			}
		}
	}

	public void move() {

		if (isJumping) {
			jump();
			onGround = false;

			if (jumpSpeed >= 0) {
				jumpStopped();
			}
		}

		if (!isJumping) {
			dy += GRAVITY;
		}

		locY += dy;
		if (locY  > gameWorld.tMap.getHeight()
				* gameWorld.tMap.TILE_SIZE)
			changeState(DISMISS);
		
		if (dx > 0) {
			runningRight = true;
			runningLeft = false;
		} else if (dx < 0) {
			runningLeft = true;
			runningRight = false;
		}
		
		locX += dx;

		if (hasFoundPlayer()) {
			if(Math.abs(locY
						- gameWorld.getOffsetY()- gameWorld.gameP.man.getY() ) <myWorld.HEIGHT/3)
			if (locX - gameWorld.getOffsetX() > gameWorld.gameP.man.getX()) {
				dx = -Math.abs(dx);
			} else {
				dx = Math.abs(dx);
			}
		}

		if (runningRight) {
			animRight.updateImage();

		} else if (runningLeft) {
			animLeft.updateImage();
		}

		if (gameWorld.worldCollisionVertical(this, thisPosition(), nextPosition(),
				0)) {

			if (dy > 0) {
				onGround = true;
				setDY(0);
			}

		} else {
			onGround = false;

		}

		if (gameWorld.worldCollisionHorizontal(this, thisPosition(),
				nextPosition(), 0)) {
			dx = -dx;
			if (hasFoundPlayer())
				if(Math.abs(locY
						- gameWorld.getOffsetY()- gameWorld.gameP.man.getY() ) <myWorld.HEIGHT/3
						&& onGround == true) {
				isJumping = true;
				Greenfoot.playSound("jump.wav");
// 				sound.loadSound("Sounds/jump.wav");
// 				sound.playSound();
			}
		}
	}

	public boolean hasFoundPlayer() {
		return (locX - gameWorld.getOffsetX() > 0)
				&& (locX - gameWorld.getOffsetX() <myWorld.WIDTH
						&& locY - gameWorld.getOffsetY() > 0 && locY
						- gameWorld.getOffsetY() <myWorld.HEIGHT);
	}

	public Point thisPosition() {

		int thisX = locX, thisY = locY + offsetY;
		return new Point(thisX, thisY);
	}

	public Point nextPosition() {

		int nextX = locX, nextY = locY + offsetY;
		nextY += dy;
		if (runningRight) {

			nextX += dx;
		} else if (runningLeft) {

			dx = -dx;
			nextX += dx;
		}

		return new Point(nextX, nextY);
	}

	public void draw(BufferedImage g) {
		int locX, locY;
		locX = getX() - gameWorld.getOffsetX();
		locY = getY() - gameWorld.getOffsetY();
		if (npcType == NPC.ANPC) {
			if (runningRight) {
				animRight.draw(g, locX, locY);

			} else if (runningLeft) {
				animLeft.draw(g, locX, locY);

			} else if (standRight) {
				animRight.draw(g, locX, locY);
			} else if (standLeft) {
				animLeft.draw(g, locX, locY);
			}
		}

		else if (npcType == NPC.SNPC)
			g.drawImage(image, locX, locY);

	}
	
		public void drawMim(BufferedImage g) {
		int locX, locY;
		locX = getX() ;
		locY = getY() ;
		if (npcType == NPC.ANPC) {
			if (runningRight) {
				animRight.draw(g, locX, locY);

			} else if (runningLeft) {
				animLeft.draw(g, locX, locY);

			} else if (standRight) {
				animRight.draw(g, locX, locY);
			} else if (standLeft) {
				animLeft.draw(g, locX, locY);
			}
		}

		else if (npcType == NPC.SNPC)
			g.drawImage(image, locX, locY);

	}

	private void setJumpSpeed(int jumpS) {
		if (jumpS > 0) {
			jumpS = -jumpS;
		}
		jumpSpeed = jumpS;
	}
}
