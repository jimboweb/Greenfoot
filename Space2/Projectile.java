import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    Actor shooter;
    World myWorld;
    int x;
    int y;
    public Projectile(Actor shooter) 
    {
        this.shooter = shooter;
    }

    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        Actor target = getOneIntersectingObject(Actor.class);
        if(target!=null && !target.equals(shooter))
        {
            getWorld().removeObject(target);
        }
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
