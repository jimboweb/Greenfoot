import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;
/**
 * Write a description of class CenterHex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CenterHex extends Actor
{
    int distance = 20;
    int angle = 0;
    HexWorld hw;
    /**
     * Act - do whatever the CenterHex wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!hw.isGameOver())
        {
            update();
            angle++;
        }
    }    

    public void addedToWorld(World w)
    {
        update();
        hw = (HexWorld)w;
    }

    public void update()
    {
        GreenfootImage myImage = new GreenfootImage(getWorld().getWidth(), getWorld().getHeight());
        setImage (myImage);
        myImage.setColor(Color.RED);
        int[] pointX = new int[6];
        int[] pointY = new int[6];
        for(int i=0;i<6;i++)
        {
            pointX[i] = (int)(Math.cos(Math.toRadians(angle + i*60))*distance) + myImage.getWidth()/2;
            pointY[i] = (int)(Math.sin(Math.toRadians(angle + i*60))*distance) + myImage.getHeight()/2;

            if(i>0)
            {
                myImage.drawLine(pointX[i-1], pointY[i-1], pointX[i], pointY[i]);
            }
        }
        myImage.drawLine(pointX[5], pointY[5], pointX[0], pointY[0]);
    }    
}
