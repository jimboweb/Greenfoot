import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cherries here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cherries extends Actor
{
    /**
     * Act - do whatever the Cherries wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        Actor bananas = getOneIntersectingObject(Bananas.class);
        int x = getX();
        int y = getY();
        World myWorld = getWorld();
        int rightSideOfScreen = myWorld.getWidth()-1;
        int bottomOfScreen = myWorld.getHeight()-1;
        if (bananas !=null)
        {
            myWorld.removeObject(bananas);
            myWorld.removeObject(this);
        } else if (x <= 0 || x >= rightSideOfScreen || y <= 0 || y>= bottomOfScreen)
        {
            myWorld.removeObject(this);
        }
    }    
}
