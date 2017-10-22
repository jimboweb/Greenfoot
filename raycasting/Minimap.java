import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Minimap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Minimap extends Actor
{
    private boolean blink;
    
    public void addedToWorld(World world)
    {
        act(); // draw mini-map
    }

    /**
     * Act - do whatever the Minimap wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        final int width = getWorld().getWidth();
        final int height = getWorld().getHeight();
        final int scale = 4;
        GreenfootImage img = new GreenfootImage(width * scale, height * scale);
        
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                if (!getWorld().getObjectsAt(x, y, Box.class).isEmpty())
                    img.setColor(((Box)getWorld().getObjectsAt(x, y, Box.class).get(0)).getColor());
                else if (!getWorld().getObjectsAt(x, y, Player.class).isEmpty())
                    img.setColor(Color.WHITE);
                else
                    img.setColor(Color.LIGHT_GRAY);
                img.fillRect(x * scale, y * scale, scale, scale);
            }
        }
        
        setImage(img);
        blink = !blink;
    }    
}
