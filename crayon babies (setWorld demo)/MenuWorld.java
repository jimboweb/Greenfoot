import greenfoot.*;
import java.awt.Color;

/**
 * World MenuWorld: a world that displays menu options
 */
public class MenuWorld extends World
{
    World toWorld = null;
    static boolean infoShown = false;

    /**
     * MenuWorld Constructor: prepares the background image, creates the Option objects, and saves the world to return to
     *
     * @param world: A parameter to set 'toWorld' with
     */
    public MenuWorld(String[] option, World inWorld)
    {       
        super(720, 480, 1);
        setBG(); // prepares the background image
        toWorld = inWorld; // save world to return to
        // Create the option objects
        for (int i = 0; i < option.length; i++)
        { // for each menu option
            int x = getWidth() / 2; // set x to center of world
            int y = (i + 1) * (getHeight() - 80) / (1 + option.length) + 80; // set y to be evenly spaced with the other options
            addObject(new Option(option[i], i), x, y); // add the option to the world
        }
    }
    
    /**
     * Method setBG: prepares the background image
     */
    private void setBG()
    {
        GreenfootImage main = getBackground();
        main.setColor(Color.black);
        main.fill(); // set a flat black background
        GreenfootImage img = new GreenfootImage("MENU", 48, Color.yellow, Color.black); // create title image
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 40); // draw title image on background centered near the top
    }
    
    /**
     * Method act: First time in act calls InfoWorld to display info about MenuWorld;
     * and returns to MainWorld if an Option object was selected (clicked on)
     */
    public void act()
    {
        // Calls InfoWorld to display info on MenuWorld (if first time in act)
        if (!infoShown)
        {
            infoShown = true; // flag info for this world as shown
            Greenfoot.setWorld(new InfoWorld(1, this)); // change to info world
        }
        // Returns to MainWorld if an Option object was selected
        if (Option.selected > -1) Greenfoot.setWorld(toWorld); // if menu option selected, change back to calling world
    }
}
