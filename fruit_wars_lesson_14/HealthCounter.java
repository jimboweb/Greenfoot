import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class HealthCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthCounter extends Actor
{
    int health = 4;
    /**
     * Act - do whatever the HealthCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage(82,17));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, 81, 16);
        myImage.setColor(Color.RED);
        int rectWidth = health * 20;
        myImage.fillRect(1, 1, rectWidth, 15);
    }    
    public void loseHealth()
    {
        health--;
    }
}
