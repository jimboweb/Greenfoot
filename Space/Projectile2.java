import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile2 extends Actor
{
    Actor shooter;
    World myWorld;
    int x;
    int y;
    public Projectile2(Actor shooter) 
    {
        this.shooter = shooter;
    }

    /**
     * Act - do whatever the Projectile2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        if(isAtEdge())
        {
            myWorld.removeObject(this);
        }
    }    

    public void fireProjectile() {
        if(Greenfoot.isKeyDown("space")){
            this.x = shooter.getX();
            this.y = shooter.getY();
            myWorld = shooter.getWorld();
            myWorld.addObject(this, x, y);
            setLocation(x,y);
            setRotation(shooter.getRotation());
        }
    }
}
