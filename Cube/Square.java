import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Face here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Actor
{
    Color color;
    int size;
    int width;
    int height;
    public Square(Color color, int size)
    {
        this.color  = color;
        this.size = size;
        GreenfootImage image = new GreenfootImage(size,size);
        image.setColor(this.color);
        this.width = image.getWidth();
        this.height = image.getHeight();
        int xPoints[] = {width - 1, width/2 - 1, 0, width /2 - 1};
        int yPoints[] = {height/2 - 1, height - 1, height/2 - 1, 0};
        int nPoints = 4;
        image.fillPolygon(xPoints, yPoints, nPoints);
        setImage(image);
    }
    /**
     * Act - do whatever the Face wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
