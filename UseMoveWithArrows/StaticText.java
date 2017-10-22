import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * StaticText creates a static text object, such as a game over screen, on the world. The basic call of
 * StaticText is StaticText st = new StaticText(getWorld(), "My text here"); . If you want to choose
 * the fontsize, call it like StaticText st = new StaticText(getWorld(), "My text here", 16); to get 
 * font  size 16. If you want to choose the color, call 
 * StaticText st = new StaticText(getWorld(), "My text here", 16, Color.RED); . To do this you must
 * import java.awt.Color to the class that calls StaticText. You can also specifiy a foreground and 
 * background color using 
 * StaticText st = new StaticText(getWorld(), "My text here", 16, Color.RED, Color.BLACK);
 * Finally you can specify x and y the location. This would look like: 
 * StaticText st = new StaticText(getWorld(), "My text here", 16, Color.RED, Color.BLACK, 300, 200);
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class StaticText extends Actor
{
    
    public StaticText(World myWorld, String text)
    {
         setImage(new GreenfootImage(text, 48, Color.BLACK, Color.WHITE));
         int startX = myWorld.getWidth()/2;
         int startY = myWorld.getHeight()/2;
         myWorld.addObject(this, startX, startY);
    }
    
    public StaticText(World myWorld, String text, int fontSize)
    {
         setImage(new GreenfootImage(text, fontSize, Color.BLACK, Color.WHITE));
         int startX = myWorld.getWidth()/2;
         int startY = myWorld.getHeight()/2;
         myWorld.addObject(this, startX, startY);
    }
    
    public StaticText(World myWorld, String text, int fontSize, Color textColor)
    {
         setImage(new GreenfootImage(text, fontSize, textColor, Color.WHITE));
         int startX = myWorld.getWidth()/2;
         int startY = myWorld.getHeight()/2;
         myWorld.addObject(this, startX, startY);
    }
    
    public StaticText(World myWorld, String text, int fontSize, Color textColor, Color backgroundColor)
    {
         setImage(new GreenfootImage(text, fontSize, textColor, backgroundColor));
         int startX = myWorld.getWidth()/2;
         int startY = myWorld.getHeight()/2;
         myWorld.addObject(this, startX, startY);
    }
    public StaticText(World myWorld, String text, int fontSize, Color textColor, Color backgroundColor, int startX, int startY)
    {
         setImage(new GreenfootImage(text, fontSize, textColor, backgroundColor));
         myWorld.addObject(this, startX, startY);
    }
}
