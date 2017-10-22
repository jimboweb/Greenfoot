import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    Projectile2 projectile2 = new Projectile2(this);
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveWASD();
        projectile2.fireProjectile();
    }    

    private void moveWASD()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(5);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(5);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(5);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(5);
        }

    }
}





