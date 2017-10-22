import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int moveCount = 0;
    public void act() 
    {
        moveCount++;
        if(moveCount%30==0)
        {
            setRotation(Greenfoot.getRandomNumber(8)*45);
        }
        move(2);

    }    
}
