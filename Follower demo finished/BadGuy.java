import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BadGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadGuy extends Actor
{
    Actor target;
    int speed;
    public BadGuy(Actor target, int speed)
    {
        this.target = target;
        this.speed = speed;
    }

    /**
     * Act - do whatever the BadGuy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        followActor();
        if(getOneIntersectingObject(target.getClass())!=null)
            removeTouching(target.getClass());
    }    

    public void followActor() 
    {
        if(target.getWorld()!=null)
        {
            int targetX = target.getX();
            int targetY = target.getY();
            turnTowards(targetX, targetY);
            move(speed);
        }
    }
}
