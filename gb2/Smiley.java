import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smiley here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smiley extends Vehicle
{
    /**
     * Act - do whatever the Smiley wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        int turnVar = Greenfoot.getRandomNumber(5);
        if(turnVar<2)
        {
            turn(-30);
        } else if (turnVar < 3)
        {
            turn(30);
        }
    }    
}
