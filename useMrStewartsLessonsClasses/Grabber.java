import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grabber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grabber extends Actor
{
    MoveWithMouse mwm = new MoveWithMouse(this);
    RemoveObjectOnCollision rooc = new RemoveObjectOnCollision(this, Target.class);
    ScoreBoard scoreboard;
    public void addedToWorld(World w)
    {
        scoreboard = new ScoreBoard(w, 24, 100, 25);
    }
    /**
     * Act - do whatever the Grabber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mwm.moveWithMouse();
        scoreboard.increaseScore(rooc.removeObjectOnCollision());
    }    
}
