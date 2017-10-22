import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ladybug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ladybug extends Actor
{
    /**
     * Act - do whatever the Ladybug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveOnCommand();
        eatAphid();
    }    
    public void moveOnCommand()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
            move(5);
            Actor rockInTheWay = getOneIntersectingObject(Rock.class);
            if(rockInTheWay!=null)
            {
                move(-5);
            }
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(5);
            Actor rockInTheWay = getOneIntersectingObject(Rock.class);
            if(rockInTheWay!=null)
            {
                move(-5);
            }
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(5);
            Actor rockInTheWay = getOneIntersectingObject(Rock.class);
            if(rockInTheWay!=null)
            {
                move(-5);
            }
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(5);
            Actor rockInTheWay = getOneIntersectingObject(Rock.class);
            if(rockInTheWay!=null)
            {
                move(-5);
            }
        }

    }

    
    
    public void eatAphid()
    {
        Actor aphid = getOneIntersectingObject(Aphid.class);
        if(aphid != null)
        {
            World myWorld = getWorld();
            myWorld.removeObject(aphid);
        }
    }
}
