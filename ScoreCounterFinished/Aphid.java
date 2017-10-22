import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aphid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aphid extends Actor
{
    ScoreBoard sb;
    Leaf leafWorld;
    public void addedToWorld(World w)
    {
        leafWorld = (Leaf)w;
        sb = leafWorld.getScoreBoard();
    }
    /**
     * Act - do whatever the Aphid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Mover.class))
        {
            sb.addScore(5);
            leafWorld.removeObject(this);
        }
    }    
}







