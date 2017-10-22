import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        Actor myBee = getOneIntersectingObject(Bee.class);
        World myWorld = getWorld();
        if(myBee !=null)
        {

            myWorld.removeObject(this);
            myWorld.removeObject(myBee);
        } else if (getX()<=0 || getY()<=0 || getX() >= myWorld.getWidth() || getY() >= myWorld.getHeight())
        {
            myWorld.removeObject(this);
        }
    }    
}
