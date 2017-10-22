import greenfoot.*;
import java.awt.Color;

/**
 * Class InfoWorld: a world that displays information;
 * there are 3 different worlds that, when started, will create a new instance of this world
 * (they are: MainWorld, ImageWorld, and MenuWorld);
 * any mouse click will cause a return to the previous world
 */
public class InfoWorld extends World
{
    World toWorld = null;

    /**
     * InfoWorld Constructor: creates the appropriate background image depending on the value of 'value' recieved
     *
     * @param value: the value indicating which world information to show
     * @param inWorld: so that we can return to the calling world, a reference to it is passed and saved here
     */
    public InfoWorld(int value, World inWorld)
    {
        super(720, 480, 1);
        setMainImage(); // create a base image to work on
        // add the appropriate information to the base image
        switch (value)
        {
            case 0: imageZero(); break; // the MainWorld info
            case 1: imageOne(); break; // the MenuWorld info
            case 2: imageTwo(); break; // the ImageWorld info
        }
        toWorld = inWorld; // save world to return to
    }
    
    /**
     * Method setMainImage: creates the base image that information will be added to
     */
    private void setMainImage()
    {
        // create the image for the background
        GreenfootImage main = new GreenfootImage(getWidth(), getHeight());
        main.setColor(Color.black);
        main.fill(); // set a flat black background
        // create images and draw them on the background
        GreenfootImage img = new GreenfootImage("INFORMATION", 36, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 50);
        img = new GreenfootImage("(you are now in InfoWorld)", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 90);
        // draw separator lines on the background
        main.setColor(Color.yellow);
        main.drawLine(0, 125, 720, 125);
        main.drawLine(0, 420, 720, 420);
        setBackground(main); // set the background image
    }
    
    /**
     * Method imageZero: adds the information about MainWorld to the base image
     */
    private void imageZero()
    {
        // retrieve the background image
        GreenfootImage main = getBackground();
        // create text images and draw them on the background
        GreenfootImage img = new GreenfootImage("Click anywhere to return to MainWorld", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 440);
        img = new GreenfootImage("Click anywhere on MainWorld to proceed to MenuWorld", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 280);
    }
    
    /**
     * Method imageOne: adds the information about MenuWorld to the base image
     */
    private void imageOne()
    {
        // retrieve the background image
        GreenfootImage main = getBackground();
        // create text images and draw them on the background
        GreenfootImage img = new GreenfootImage("The menu has four options:", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 150);
        img = new GreenfootImage("Click on 'Show wallpaper' to show design pattern of image", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 200);
        img = new GreenfootImage("Click on 'Clear background' to clean up the baby mess", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 250);
        img = new GreenfootImage("Click on 'Quit' to stop the execution of the program", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 300);
        img = new GreenfootImage("Click on 'Cancel' to return to MainWorld", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 350);
        img = new GreenfootImage("Click anywhere to proceed to MenuWorld", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 440);
    }
    
    /**
     * Method imageTwo: adds the information about ImageWorld to the base image
     */
    private void imageTwo()
    {
        // retrieve the background image
        GreenfootImage main = getBackground();
        // create text images and draw them on the background
        GreenfootImage img = new GreenfootImage("You can use the number keys across the top of the keyboard", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 200);
        img = new GreenfootImage("to change the apparent distance from the wall", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 230);
        img = new GreenfootImage("Click anywhere on ImageWorld to return to MainWorld", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 320);
        img = new GreenfootImage("Click anywhere to proceed to ImageWorld", 18, Color.yellow, Color.black);
        main.drawImage(img, (main.getWidth() - img.getWidth()) / 2, 440);
    }
    
    /**
     * Method act: returns to calling world when mouse is clicked
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(null)) Greenfoot.setWorld(toWorld); // change to calling world when the mouse is clicked
    }
}
