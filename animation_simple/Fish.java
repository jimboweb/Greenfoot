import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    int moved;
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moved++;
        if(moved<50)
        {
            move(2);
        } else {
        getWorld().showText("That was fun.", getX() + 5, getY()-20);
        Greenfoot.delay(20);
        getWorld().showText("", getX() + 5, getY() - 20);
        turn(180);
        moved=0;
        getImage().mirrorVertically();
        
        }
    }    
}










