import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Piston here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piston extends Actor
{
    World myWorld;
    Hinge hinge;
    int length;
    int width;
    public Piston(World myWorld, Hinge hinge, int length, int width)
    {
        this.myWorld = myWorld;
        this.hinge = hinge;
        this.length = length;
        this.width = width;
        GreenfootImage myImage = new GreenfootImage(length, width);
        myImage.setColor(Color.BLACK);
        myImage.fillRect(0,0,length - 1, width - 1);
        setImage(myImage);
        int startX = hinge.getX() + 300 - length/2;
        int startY = hinge.getY();
        myWorld.addObject(this, startX, startY);
        
    }
    /**
     * Act - do whatever the Piston wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int newX = hinge.getX() + 300 - length/2;
        setLocation(newX, getY());
    }    
}
