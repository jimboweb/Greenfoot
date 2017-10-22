import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spaceship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spaceship extends Actor
{
    /**
     * Act - do whatever the Spaceship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int deltaX = 0;
    private int deltaY = 0;
    public void act() 
    {
        move();
        checkTurn();
        checkAccel();
        checkFire();
    }    

    public void move()
    {
        int newX = getX() + deltaX;
        int newY = getY() + deltaY;
        World myWorld = getWorld();
        int myWidth = myWorld.getWidth();
        int myHeight = myWorld.getHeight();
        newX = wrapAround(newX, myWidth);
        newY = wrapAround(newY, myHeight);

        setLocation(newX, newY);
        
    }

    public void checkTurn()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(getRotation()-5);
        } else if (Greenfoot.isKeyDown("right"))
        {
            setRotation(getRotation()+5);
        }
    }

    public void checkAccel()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            deltaX = deltaX + (int)Math.ceil((3 * Math.cos(Math.toRadians(getRotation()))));
            deltaY = deltaY + (int)Math.ceil((3 * Math.sin(Math.toRadians(getRotation()))));
        }

    }
    public int wrapAround(int coord, int limit)
    {
        World myWorld = getWorld();
        if(coord<=0)
        {
            coord = limit;
        } else if(coord>=limit)
        {
            coord = 0;
        }
        return coord;
      
    }
    public void checkFire()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            World myWorld = getWorld();
            Bullet myBullet = new Bullet();
            myWorld.addObject(myBullet, getX(), getY());
            myBullet.setRotation(getRotation());
        }
    }
}
