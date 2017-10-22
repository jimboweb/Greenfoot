import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldBuggy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldBuggy extends Vehicle
{
    /**
     * Act - do whatever the GoldBuggy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        move(5);
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-5);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            turn(5);
        }
        if(offTheMap())
{
     turn(180);
}
        if(isTouching(Gold.class))
        {
            get(Gold.class);
            GoldBuggyWorld myWorld = (GoldBuggyWorld)getWorld();
            ScoreCounter counter = myWorld.getCounter();
            counter.score++;
        }
    }

}
