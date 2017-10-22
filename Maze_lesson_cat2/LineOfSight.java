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
    Mouse mouse;
    Cat cat;
    int mouseX;
    int mouseY;
    int catX;
    int catY;
    GreenfootImage myImage;
    GreenfootSound meow = new GreenfootSound("cat13.wav");
    public LineOfSight(Cat c, Mouse m)
    {
        cat = c;
        mouse = m;
    }

    /**
     * Act - do whatever the LineOfSight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(mouse.getWorld()!=null&&cat.getWorld()!=null)
        {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            int catX = cat.getX();
            int catY = cat.getY();
            int locX = (catX+mouseX)/2;
            int locY = (catY+mouseY)/2;
            setLocation(locX, locY);
            turnTowards(mouseX, mouseY);
            int d = (int)Math.sqrt(Math.pow((catX-mouseX),2)+Math.pow((catY-mouseY),2));
            setImage(new GreenfootImage(d,1));
            myImage = getImage();
            //myImage.setColor(Color.BLACK);
            //myImage.drawLine(0, 0, d, 0);
        }
    }    

    public boolean clearLineOfSight()
    {
        return (getOneIntersectingObject(Wall.class)==null);
    }
}
