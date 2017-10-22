import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Car()
    {
        //Greenfoot.setWorld(new Tile(this));
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(5);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(5);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(5);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
            move(5);
        }
        
        Actor coin = getOneIntersectingObject(Coin.class);
        if(coin!=null)
        {
            getWorld().removeObject(coin);
            if(getWorld().getObjects(Coin.class).size() == 0)
                newWorld();
        }
    }    
    
    public void newWorld()
    {
       Greenfoot.setWorld(new Rock(this));
    }
}
