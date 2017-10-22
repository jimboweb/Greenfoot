import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Actor
{
    int speed;
    
    public Mover()
    {
        this.speed = 5;
    }
    
    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveWASD();
    }    

    private void moveWASD()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(speed);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(speed);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(speed);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(speed);
        }
    }
}
