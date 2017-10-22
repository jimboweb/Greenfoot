import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(GoldBuggy.class))
        {
            Greenfoot.playSound("kaboom.wav");
            setImage("skull.png");
            get(GoldBuggy.class);
        }

    }    
    public boolean isTouching(Class clss)
        {
            Actor actor = getOneObjectAtOffset(5, 5, clss);
            return actor != null;        
        }
    public void get(Class clss)
        {
            Actor actor = getOneObjectAtOffset(0, 0, clss);
            if(actor != null) {
                getWorld().removeObject(actor);
            }
        }
}
