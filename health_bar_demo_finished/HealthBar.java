import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
// ******************************************************************************
// Code Clip 4
import java.awt.Color;    

/**
 *  Creates a Health Bar
 * 
 * @author Jim Stewart
 * @version 1
 */
public class HealthBar extends Actor
{
    int health = 4;     // Change this to give the ship more or less health.
    
    public HealthBar()  // This is a constructor. It's called when the HealthBar is
    {                   // created. By running the update() method we'll see a bar 
        update();       // before we run instead of a blank line. 
    }

    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        update();   // Updates the image every turn as the health changes. 
    }    

    public void update()
    {
        setImage(new GreenfootImage(82,17)); //Makes blank image 82 pixels wide by 17 high
        GreenfootImage myImage = getImage(); //Assigns the image to the variable myImage
        myImage.setColor(Color.WHITE);  // Sets the drawing color to white
        myImage.drawRect(0, 0, 81, 16); // Draws an empty white 81x16 rectangle
        myImage.setColor(Color.RED);    // Sets the drawing color to red
        int rectWidth = health * 20; // rectWidth will be 20 pixels per health bar
        myImage.fillRect(1, 1, rectWidth, 15); //Draws a filled red rectangle 15 pixels high
                                               // and a width of rectWidth variable        
    }
    
        public void loseHealth()
    {
        health--;   // Reduce the health by one 
    }
}
// End Code Clip 4
// ******************************************************************************

