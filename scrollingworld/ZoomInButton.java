import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZoomInButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZoomInButton extends BuildTools
{
    WorldBuilder myWorld;
    public ZoomInButton(WorldBuilder myWorld)
    {
        this.myWorld = myWorld;
    }
    /**
     * Act - do whatever the ZoomInButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            myWorld.zoomIn();
        }
    }    
}
