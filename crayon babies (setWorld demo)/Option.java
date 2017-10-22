import greenfoot.*;
import java.awt.Color;

/**
 * Actor Option: the images (in this case, text buttons) the user clicks on
 *
*/
public class Option extends Actor
{
    protected static int selected = -1; // holds '-1' by default, 'menu option number' if menu option clicked on; reset to '-1' when value is checked
    int value = -1; // menu option number
    
    /**
     * Option Constructor: sets the text to display and the value to return if clicked on;
     * and creates the image for the Option object
     *
     * @param text: A parameter of String type that is the text to display on the Option object
     * @param val: A parameter of int type that will be returned to the MenuWorld object if clicked on
     */
    public Option(String text, int val)
    {
        value = val; // save menu option number
        setImage(new GreenfootImage(" " + text + " ", 36, Color.black, Color.yellow)); // create the button image
    }
    
    /**
     * Method act: sets the value of 'selected' to this Option object's value if clicked on
     *
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) selected = value; // set class variable 'selected' to menu option number when clicked on
    }
    
    /**
     * Method getSelected: returns the value of 'selected' and clears it back to the default of -1
     *
     * @return: the value that was stored in 'selected' (the menu option selected)
     */
    public static int getSelected()
    {
        int retVal = selected; // get a copy of the value in 'selected'
        selected = -1; // set 'selected' to its default value
        return retVal; // return the copied value of 'selected'
    }
}
