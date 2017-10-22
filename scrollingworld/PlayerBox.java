import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class PlayerBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBox extends BuildTools
{
    GreenfootImage myImage;
    public PlayerBox()
    {
        myImage = new GreenfootImage(100, 100);
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, 99, 99);
        Font f = new Font("Arial", Font.BOLD, 22);
        myImage.setFont(f);
        myImage.setColor(Color.RED);
        myImage.drawString("Player", 15, 85);
        setImage(myImage);
    }
    /**
     * Act - do whatever the PlayerBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    
}
