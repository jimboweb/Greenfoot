import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Baloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baloon extends Actor
{
    /**
     * Act - do whatever the Baloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int n = 0;
    public void act() 
    {
        n++;
        if(n%10 == 0)
        {
            setImage("balloon1.png");
        } else if (n%5 == 0)
        {
            setImage("balloon2.png");
        }
    }    
}
