import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    Projectile p = new Projectile(this, "space", "brick.png");
    MoveWithArrows mwa=new MoveWithArrows(this);
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mwa.MoveActorWithArrows(5);
        p.fireProjectile();
    }    
}
