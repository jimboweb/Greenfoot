import greenfoot.*;

/**
 * Class ImageWorld: a world to show the wallpaper images
 */
public class ImageWorld extends World
{
    World toWorld = null; // holds world to return to
    GreenfootImage image = null; // holds the single panel image for the wallpaper
    static boolean infoShown = false; // flag indicating whether info was shown or not

    /**
     * ImageWorld Constructor: saves the world to return to and the image panel;
     * and sets up the initial background image
     *
     * @param world A parameter
     * @param bg A parameter
     */
    public ImageWorld(World world, GreenfootImage bg)
    {
        super(720, 480, 1);
        toWorld = world; // save world to return to
        setBackground(bg); // set the background image to what was received in the parameter
        image = bg; // save the image applied to the background
    }
    
    /**
     * Method act: If first time in act, shows info on ImageWorld with InfoWorld;
     * checks for mouse click to return to MainWorld;
     * and checks for numeric keystroke to change the apparent distance of image
     */
    public void act()
    {
        // Initial act calls InfoWorld to display info on ImageWorld
        if (!infoShown)
        {
            infoShown = true; // flag info for this world as shown
            Greenfoot.setWorld(new InfoWorld(2, this)); // change to info world
        }
        // Check for mouse click to return to MainWorld
        if (Greenfoot.mouseClicked(null)) Greenfoot.setWorld(toWorld); // change to calling world when the mouse is clicked
        // Check for a numeric keystroke to change the apparent distance of image
        String key = Greenfoot.getKey(); // gets any keystroke made ('null' if none found)
        if (key != null && "1234567890".indexOf(key) >= 0)
        { // a numeric key was pressed and released
            int num = "1234567890".indexOf(key) + 1; // get the value of the key (0 is 10)
            GreenfootImage img = new GreenfootImage(image); // creates a new copy of the image for the wallpaper
            img.scale(getWidth() / num, getHeight() / num); // sizes the image to show (num * num) images
            setBackground(img); // sets the background image
        }
    }
}
