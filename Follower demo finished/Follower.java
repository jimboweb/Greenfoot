import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Follower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Follower extends Actor
{
    int speed;
    Actor target;
    public Follower(int speed, Actor target) 
    {
        this.speed = speed;
        this.target = target;
    }
    /**
     * Act - do whatever the Follower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        follow();
    }    
    
    public void follow()
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
