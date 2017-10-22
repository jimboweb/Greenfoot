import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Actor
{
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int moveCount = 0;
    public void act() 
    {
        moveCount++;
        if(moveCount%20==0)
        {
            setRotation(Greenfoot.getRandomNumber(8)*45);
        }
        move(2);
    }    
}
