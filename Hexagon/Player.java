import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int width = 15;
    World myWorld;
    int centerOfWorldX;
    int centerOfWorldY;
    int angle=270;
    int distanceFromCenter = 30;
    HexWorld hw;
    public Player()
    {
        int height = (int)(width/2 * Math.sqrt(3));
        GreenfootImage myImage = new GreenfootImage(width,height);
        setImage(myImage);
        myImage.setColor(Color.RED);
        myImage.drawLine(0, height-1, width-1, height-1);
        myImage.drawLine(0, height-1, width-1, height-1);
        myImage.drawLine(width-1, height-1, width/2, 0);        
        myImage.drawLine(width/2, 0 , 0, height-1);        
    }

    public void addedToWorld(World myWorld)
    {
        this.myWorld = myWorld;
        this.hw = (HexWorld)myWorld;
        centerOfWorldX = myWorld.getWidth()/2;
        centerOfWorldY = myWorld.getHeight()/2;
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!hw.isGameOver())
        {
            int newX = centerOfWorldX + (int)(Math.cos(Math.toRadians(angle))*distanceFromCenter);
            int newY = centerOfWorldY + (int)(Math.sin(Math.toRadians(angle))*distanceFromCenter);
            setLocation(newX, newY);
            setRotation(angle-270);
            angle++;
            if(Greenfoot.isKeyDown("left"))
                angle -=10;
            if(Greenfoot.isKeyDown("right"))
                angle +=10;
        }
    }    
}
