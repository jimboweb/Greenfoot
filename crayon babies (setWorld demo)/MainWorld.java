import greenfoot.*;

/**
 * World MainWorld:  a world where babies randomly crawl around dragging their crayons wherever they go
 *
 */
public class MainWorld extends World
{
    static final int WIDE = 720;
    static final int HIGH = 480;
    static boolean infoShown = false; // flag to indicate whether info about MainWorld was shown or not

    /**
     * MainWorld Constructor: adds a random number (between 3 and 6) of babies to the world at random locations
     */
    public MainWorld()
    {    
        super(WIDE, HIGH, 1);
        for (int i = 0; i < Greenfoot.getRandomNumber(4) + 3; i++)
        { // for between 3 and 6 times
            int x = Greenfoot.getRandomNumber(WIDE); // get random x
            int y = Greenfoot.getRandomNumber(HIGH); // get random y
            addObject(new Baby(), x, y); // add a baby to the world at random location
        }
    }

    /**
     * Method act: The first time act is run an information world is executed
     * checks for a mouse click to begin Menu world;
     * also, responds to a menu option click
     */
    public void act()
    {
        // Run information world, if first time in act
        if (!infoShown)
        {
            infoShown = true; // flag that info has been shown
            Greenfoot.setWorld(new InfoWorld(0, this)); // change to info world
        }
        // Proceed to MenuWorld if mouse was clicked
        if (Greenfoot.mouseClicked(null))
        {
            String[] opts = { "Show wallpaper", "Clear background", "Quit", "Cancel" }; // the menu items
            Greenfoot.setWorld(new MenuWorld(opts, this)); // change to menu world
        }
        // If a menu item was clicked on, Option.getSelected should return the value of the button, else its value should be -1
        switch (Option.getSelected()) // gets the value of 'selected' in the Option class
        {
            // 'Show wallpaper' was clicked
            case 0: Greenfoot.setWorld(new ImageWorld(this, (new Image(getBackground())).image)); // change to image world
                    break;
            // 'Clear background' was clicked
            case 1: getBackground().fill(); // erase the crayon markings (clear the background image)
                    break;
            // 'Quit' was clicked
            case 2: Greenfoot.stop(); // quit the scenario
                    break;
            // Either 'Cancel' was clicked or no Option object was clicked on
            default: break; // do nothing
        }
    }
}
