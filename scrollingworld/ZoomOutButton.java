import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZoomOutButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZoomOutButton extends BuildTools
{
    WorldBuilder myWorld;
    public ZoomOutButton(WorldBuilder myWorld)
    {
        this.myWorld = myWorld;
    }
    /**
     * Act - do whatever the ZoomOutButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
            myWorld.zoomOut();
    }    
}
