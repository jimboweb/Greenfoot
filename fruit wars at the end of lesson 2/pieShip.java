import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pieShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pieShip extends myActors
{
    int deltaX = 0;
    int deltaY = 0;
    /**
     * Act - do whatever the pieShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int myX = getX();
        int myY = getY();
        move(myX, myY, deltaX, deltaY);
        turnOnCommand();
        accelOnCommand();
    }    

    public void turnOnCommand()
    {
        int direction = getRotation();
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
        }

        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
        }

    }

    public void move(int x, int y, int deltaX, int deltaY)
    {
        int newX = x + deltaX;
        int newY = y + deltaY;
        setLocation(newX, newY);
    }


    public void accelOnCommand()
    {
        int rotation = getRotation();
        if(Greenfoot.isKeyDown("space"))
        {
            if(rotation == 0)
            {
                deltaX = deltaX + 2;
            } else if(rotation <=90)
            {
                deltaY = deltaY + 2;
            }  else if(rotation <=180)
            {
                deltaX = deltaX - 2;
            } else if(rotation <=270)
            {
                deltaY = deltaY - 2;
            }
        }
    }
}
