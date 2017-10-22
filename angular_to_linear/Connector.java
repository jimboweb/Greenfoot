import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class LineOfSight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Connector extends Actor
{
    Actor hinge;
    Actor piston;
    int hingeX;
    int hingeY;
    int pistonX;
    int pistonY;
    GreenfootImage myImage;
    /**
     * Act - do whatever the LineOfSight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Connector (World w, Actor h, Actor p)
    {
        hinge = h;
        piston = p;
        setImage(new GreenfootImage(1,1));
        w.addObject(this,0,0);
    }
    public void act() 
    {
        if(hinge.getWorld()!=null && piston.getWorld()!=null)
        {
            hingeX = hinge.getX();
            hingeY = hinge.getY();
            pistonX = piston.getX()-piston.getImage().getWidth()/2;
            pistonY = piston.getY();
            int myX = (hingeX + pistonX)/2;
            int myY = (hingeY + pistonY)/2;
            setLocation(myX, myY);
            turnTowards(hingeX, hingeY);
            int d = (int)Math.sqrt(Math.pow((pistonX-hingeX),2)+Math.pow((hingeY-pistonY),2));
            setImage(new GreenfootImage(d,20));
            myImage = getImage();
            myImage.setColor(Color.BLACK);
            myImage.fillRect(0,0,d,myImage.getHeight());
            
        }
    }    
}
