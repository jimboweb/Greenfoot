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
        /*
         * The "move" command below makes the gold buggy go forward 5 pixels 
         * every turn. If you press the 'act' button it will go forward 5.
         * If you press the 'run' button it will keep going forward until it hits
         * the wall and stops.
         */
        move(5);
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-30);
        }
    }    
}
