import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private boolean moved = false;
    private boolean proper = true;
    
    public Player()
    {
        setRotation(-45);
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-2);
            moved = true;
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            turn(2);
            moved = true;
        }
        
        String key = Greenfoot.getKey();
        
        
        if ("w".equals(key))
        {
            moveTo(getX(), getY() - 1);
            moved = true;
        }
        else if ("s".equals(key))
        {
            moveTo(getX(), getY() + 1);
            moved = true;
        }
        else if ("a".equals(key))
        {
            moveTo(getX() - 1, getY());
            moved = true;
        }
        else if ("d".equals(key))
        {
            moveTo(getX() + 1, getY());
            moved = true;
        }
        else if ("p".equals(key))
        {
            proper = !proper;
            moved = true; // to force redraw
        }
    }    
    
    private static double calculateDirection(double x, double y)
    {
        return Math.toDegrees(Math.atan2(y, x));
    }
       
    private static double calculateX(double dir)
    {
        return Math.cos(Math.toRadians(dir));
    }
    
    private static double calculateY(double dir)
    {
        return Math.sin(Math.toRadians(dir));
    }
    
    
    private void moveTo(int x, int y)
    {
        World w = getWorld();
        List obj = w.getObjectsAt(x, y, Box.class);
        if (obj.isEmpty())
        {
            setLocation(x, y);
        }
    }
    
    public double getExactX()
    {
        return getX(); //TODO
    }

    public double getExactY()
    {
        return getY(); //TODO
    }
    
    public boolean hasMoved()
    {
        boolean old = moved;
        moved = false;
        return old;
    }
    
    public boolean showProperView()
    {
        return proper;
    }
}
