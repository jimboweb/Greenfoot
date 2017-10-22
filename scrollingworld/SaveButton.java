import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class SaveButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveButton extends BuildTools
{
    WorldBuilder myWorld;
    public SaveButton(World myWorld)
    {
        setImage(new GreenfootImage("Save", 24, Color.BLACK, Color.YELLOW));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, myImage.getWidth()-1, myImage.getHeight()-1);
        this.myWorld = (WorldBuilder)myWorld;
    }

    /**
     * Act - do whatever the SaveButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            myWorld.writeWorld();
        }
    }    
}
