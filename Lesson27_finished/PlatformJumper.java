import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformJumper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformJumper extends Actor
{
    private int jumpHeight = 10;
    private int walkSpeed = 5;
    private double fallSpeed = 0.4;

    private boolean inTheAir = false;
    private double deltaX = 0;
    private double deltaY = 0; 
    private int groundHeight = getImage().getHeight()/2;
    private int sideWidth = getImage().getWidth()/2;
    private World myWorld;
    int worldHeight;
    int worldWidth;

    public void addedToWorld(World myWorld)
    {
        this.myWorld = myWorld;
        this.worldHeight = myWorld.getHeight();
        this.worldWidth = myWorld.getWidth();
    }

    /**
     * Act - do whatever the PlatformJumper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(inTheAir)
        {
            fall();
        } else {
            getCommand();
        }
        move();
    }    

    private void run (String direction)
    {
        if(direction=="left")
            deltaX = walkSpeed*-1;
        else
            deltaX = walkSpeed;
    }

    private void stop ()
    {
        deltaX = 0;
    }

    private void jump()
    {
        deltaY += jumpHeight;
        inTheAir = true;
    }

    /*
     * fall() will be called whenever BallGuy is in the air. Decreases the deltaY by 1, creating
     * gravity.
     */
    private void fall()
    {
        deltaY-=fallSpeed;
    }

    private void move()
    {
        double newX = getX() + deltaX;
        double newY = getY() - deltaY;

        Actor platformBelow = getOneObjectAtOffset(0, groundHeight + 5, Platform.class);
        if(platformBelow!=null)
        {
            if(deltaY<0)
            {
                deltaY = 0;
                inTheAir = false;
                GreenfootImage platformImage = platformBelow.getImage();
                int topOfPlatform = platformBelow.getY() - platformImage.getHeight()/2;
                newY = topOfPlatform - groundHeight;
            }
        }else if(getY() >= worldHeight - groundHeight) {
            if(deltaY < 0)
            {
                deltaY = 0;
                inTheAir = false;
                newY = worldHeight - groundHeight;
            }
        } else {
            inTheAir = true;
        }
        setLocation((int)newX,(int)newY);
    }

    private void getCommand()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            run("left");
        } else if (Greenfoot.isKeyDown("right"))
        {
            run("right");
        } else 
        {
            stop();
        }

        if(Greenfoot.isKeyDown("up"))
        {
            jump();
        }
    }

}
