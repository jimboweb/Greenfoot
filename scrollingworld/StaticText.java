import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * <p>StaticText creates a non-changing text object, such as a game over screen, on the world. 
 * StaticText automatically adds itself to the middle of the world when it is created. 
 * The basic call, when done by an Actor, looks like:</p>
 * 
 * <p style = "font-weight: bold">StaticText st = new StaticText(getWorld(), "My text here"); . </p>
 * 
 * 
 * <p>The intermediate call of StaticText specifies font size and x and y location of the text. For example to get
 * 16 point text at x = 100, y = 200, you would call:</p>
 * <p style = "font-weight: bold">StaticText st = new StaticText(getWorld(), "My text here", 16, 100, 200); </p>
 * 
 * <p>'st' could be anything. It is the name of the variable that represents the StaticText object.</p>
 * 
 * <p>By default StaticText gives black text on a white background. The advanced call of StaticText 
 * specifies the color and background color of the text. To get white text on a black background call:</p>
 * <p style = "font-weight: bold">StaticText st = new StaticText(getWorld(), "My text here", 16, 100, 200, Color.WHITE, Color.BLACK); </p>
 * 
 * <p>To use the advance call which specifies color, you must import java.awt.Color at the beginning of the class that calls 
 * StaticText, right below import greenfoot.*, as in:<p>
 * 
 * <p style = "font-weight: bold">import java.awt.Color;</p>
 * 
 * <p>If you want to create StaticText at the beginning of a game, you can call it from your World, using:</p>
 * <p style = "font-weight: bold">StaticText st = new StaticText(this, "My text here"); . </p>
 * 
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class StaticText extends HelperClasses
{
    
    public StaticText(World myWorld, String text)
    {
         setImage(new GreenfootImage(text, 48, Color.BLACK, Color.WHITE));
         int startX = myWorld.getWidth()/2;
         int startY = myWorld.getHeight()/2;
         myWorld.addObject(this, startX, startY);
    }

        public StaticText(World myWorld, String text, int fontSize, int startX, int startY)
    {
         setImage(new GreenfootImage(text, fontSize, Color.BLACK, Color.WHITE));
         myWorld.addObject(this, startX, startY);
    }


        public StaticText(World myWorld, String text, int fontSize, int startX, int startY, Color textColor, Color bgColor)
    {
         setImage(new GreenfootImage(text, fontSize, textColor, bgColor));
         myWorld.addObject(this, startX, startY);
    }
    

}
