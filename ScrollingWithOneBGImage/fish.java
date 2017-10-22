import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fish extends Actor
{
    MoveRandomly moverandomly = new MoveRandomly(this);
    /**
     * Act - do whatever the fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moverandomly.moveRandomly(5);
        // Add your action code here.
    }    
}
