import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class BorderBoundary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BorderBoundary extends BuildTools
{
    private int length;
    GreenfootImage myImage;
    public BorderBoundary(int length)
    {
        this.length = length;
        setImage(new GreenfootImage(length, 1));
        myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawLine(0, 0, length-1, 0);
    }
    
}
