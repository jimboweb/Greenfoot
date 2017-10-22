import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    MoveObstructedByObstacle moveobstructedbyobstacle = new MoveObstructedByObstacle(this, Wall.class);
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveobstructedbyobstacle.moveWithArrowsOb(5);
    }    
}
