import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hedge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hedge extends Actor
{
        MoveRandomly moverandomly= new MoveRandomly(this, Wall.class);

    /**
     * Act - do whatever the Hedge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moverandomly.moveRandomly(4, 5, 90);
    }    
}
