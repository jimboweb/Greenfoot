import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    Projectile projectile = new Projectile(this);
    double deltaX = 0;
    double deltaY = 0;
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        driftMove();
        projectile.fireProjectile();
     }    

    private void driftMove()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            deltaY -= 0.5;
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            deltaX -= 0.5;
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            deltaY += 0.5;
        }
        if(Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            deltaX += 0.5;
        }
        setLocation(getX() + (int)deltaX, getY() + (int)deltaY);
    }
}





