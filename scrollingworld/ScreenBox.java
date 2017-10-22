import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ScreenBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScreenBox extends BuildTools
{
    private int width;
    private int height;
    GreenfootImage myImage;
    public ScreenBox (int width, int height)
    {
        this.width = width;
        this.height = height;
        update();
    }
    
    public void reScale(int width, int height)
    {
        this.width = width;
        this.height = height;
        update();
    }
  
    private void update()
    {
        setImage(new GreenfootImage(width, height));
        myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.drawRect(0,0,width-1,height-1);
    }
}
