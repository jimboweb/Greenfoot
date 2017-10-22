import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    boolean open = false;
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(countOpponents() == 0)
            openDoor();
            
        if(open && getOneIntersectingObject(PlatformJumper.class)!=null)
        {
             Greenfoot.setWorld(new PlatformWorld2());
        }
    }   
    
    private int countOpponents()
    {
        int opponents = getWorld().getObjects(PlatformOpponent.class).size();
        return opponents;
    }
    
    private void openDoor()
    {
        setImage("lift-open.png");
        open = true;
    }
}
