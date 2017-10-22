import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hippo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hippo extends Actor
{
    Projectile projectile = new Projectile(this);
    /**
     * Act - do whatever the Hippo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(10);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
            move(10);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(10);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(10);
        }
        projectile.fireProjectile();
    }    
}
