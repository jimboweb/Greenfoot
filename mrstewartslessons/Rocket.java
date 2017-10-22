import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    DriftMove dm = new DriftMove(this, 3);
    Projectile pj = new Projectile(this, "space", 10, "bomb.png", Balloon.class);
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void addedToWorld(World myWorld)
    {
        //dm.setRandomSpeed(3, 3);
    }
    public void act() 
    {
        pj.fireProjectile();
        dm.wrapAtEdge();
        dm.turnAccelArrows();
        dm.drift();
        //dm.bounceOffObject(Balloon.class);
        //dm.fall(.05);
    }    
}
