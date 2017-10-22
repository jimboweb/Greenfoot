import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Seal2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seal2 extends Actor
{
    Projectile projectile = new Projectile(this);
    RemoveObjectOnCollision rooc = new RemoveObjectOnCollision(this, Fish.class);
    MoveWithArrows movewitharrows = new MoveWithArrows(this);
    /**
     * Act - do whatever the Seal2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getWorld().getObjects(Fish.class).size()==0)
        {
            StaticText st = new StaticText(getWorld(), "You won!");
        }
        rooc.removeObjectOnCollision();
        movewitharrows.moveActorWithArrows(5);
        projectile.fireProjectile();
    }    
}
