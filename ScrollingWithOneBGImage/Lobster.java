import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    MoveObstructedByObstacle moveobstructedbyobstacle = new MoveObstructedByObstacle(this, Wall.class);
    ScrollingWorld sw;
    public void addedToWorld(World w)
    {
        sw = (ScrollingWorld)w;
    }
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveobstructedbyobstacle.moveWithArrowsOb(5);
        sw.scrollAround(this);
    }    
}
