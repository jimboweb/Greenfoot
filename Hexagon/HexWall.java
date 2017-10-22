import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class HexWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HexWall extends Actor
{
    private int angle1;
    private int angle2;
    private int distance;
    HexWorld hw;
    int centerOfWorldX;
    int centerOfWorldY;
    public HexWall (int angle, int distance)
    {
        this.angle1 = angle;
        this.angle2 = angle + 60;
        this.distance = distance;

    }

    public void addedToWorld(World myWorld)
    {
        update();
        this.hw = (HexWorld)myWorld;
        centerOfWorldX = myWorld.getWidth()/2;
        centerOfWorldY = myWorld.getHeight()/2;
    }

    /**
     * Calls the update() function that draws the line, rotates and contracts the line. 
     */
    public void act() 
    {
        if(!hw.isGameOver())
        {
            update();
            angle1++;
            angle2++;        
            distance--;
            if(isTouching(Player.class))
                hw.gameOver();
                
            if(distance <20)
                getWorld().removeObject(this);
        }
    }  

    public void update()
    {
        double point1X = (Math.cos(Math.toRadians(angle1))*distance);
        double point1Y = (Math.sin(Math.toRadians(angle1))*distance);
        double point2X = (Math.cos(Math.toRadians(angle2))*distance);
        double point2Y = (Math.sin(Math.toRadians(angle2))*distance);
        int width = (int)Math.ceil(Math.hypot(point2X-point1X, point2Y-point1Y));
        GreenfootImage myImage = new GreenfootImage(width, 1);
        setImage(myImage);
        int angle = (angle1 + angle2)/2;
        int newX = centerOfWorldX + (int)(Math.cos(Math.toRadians(angle))*distance);
        int newY = centerOfWorldY + (int)(Math.sin(Math.toRadians(angle))*distance);
        setLocation(newX, newY);
        setRotation(angle-270);
        myImage.setColor(Color.RED);
        myImage.drawLine(0,0,myImage.getWidth(),0);
    }
}
