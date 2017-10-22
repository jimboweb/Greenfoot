import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class LineOfSight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineOfSight extends Actor
{
    Actor mouse;
    Actor cat;
    int mouseX;
    int mouseY;
    int catX;
    int catY;
    GreenfootImage myImage;
    /**
     * Act - do whatever the LineOfSight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public LineOfSight (Actor c, Actor m)
    {
        cat = c;
        mouse = m;
        setImage(new GreenfootImage(1,1));
    }
    public void act() 
    {
        if(mouse.getWorld()!=null && cat.getWorld()!=null)
        {
            mouseX = mouse.getX();
            mouseY = mouse.getY();
            catX = cat.getX();
            catY = cat.getY();
            int myX = (catX + mouseX)/2;
            int myY = (catY + mouseY)/2;
            setLocation(myX, myY);
            turnTowards(mouseX, mouseY);
            int d = (int)Math.sqrt(Math.pow((catX-mouseX),2)+Math.pow((catY-mouseY),2));
            setImage(new GreenfootImage(d,1));
            myImage = getImage();
            myImage.setColor(Color.BLACK);
            myImage.drawLine(0,0,d,0);
        }
    }    
    public boolean clearLineOfSight()
    {
        return(getOneIntersectingObject(Wall.class)==null);
    }
}
