import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends Actor
{ 
    int radius;
    public Circle(int radius, Color color){
        GreenfootImage myImage = new GreenfootImage(radius,radius);
        myImage.setColor(color);
        myImage.fillOval(0, 0, myImage.getWidth()-1, myImage.getHeight()-1);
        this.setImage(myImage);
    }
    /**
     * Act - do whatever the Circle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
