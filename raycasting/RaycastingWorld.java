import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class RaycastingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RaycastingWorld extends World
{

    /**
     * Constructor for objects of class RaycastingWorld.
     * 
     */
    public RaycastingWorld()
    {    
        super(31, 19, 20);
        
        setPaintOrder(Minimap.class, View.class);
        
        GreenfootImage map = new GreenfootImage("map.png");
        
        for (int x = 0; x < getWidth(); x++)
        {
            for (int y = 0; y < getHeight(); y++)
            {
                Color c = map.getColorAt(x, y);
                if (x == 0 || y == 0 || x == getWidth() - 1 || y == getHeight() - 1)
                    c = Color.BLACK;
                
                if (c.getAlpha() == 255)
                {
                    addObject(new Box(c), x, y);
                    
                }
            }
        }
        
        Player player = new Player();
        addObject(player, 15, 9);
        addObject(new Minimap(), 3, 2);
        addObject(new View(player), getWidth() / 2, getHeight() / 2);
    }
    
}
