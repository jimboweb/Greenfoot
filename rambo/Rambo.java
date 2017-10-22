import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rambo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rambo extends Actor
{

    /**
     * Act - do whatever the Rambo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         move(5);
        if (Greenfoot.isKeyDown("up"))
        {
         setRotation(270);
        
        }
    if (Greenfoot.isKeyDown("right"))
        {
         setRotation(0);
        
        setImage("pug_puppy_cartoon_590.png");
        }
    if (Greenfoot.isKeyDown("left"))
        {
         setRotation(180);
        setImage("pug_puppy_cartoon_590_upsidedown.png");
        }
    if (Greenfoot.isKeyDown("down"))
        {
         setRotation(90);
        
        }
     }    
}
