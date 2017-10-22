import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Platforms here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platforms extends World
{
    PlatformMap map = new PlatformMap();    //This is the image that the map will be drawn from
    GreenfootImage mapImg = map.getImage(); // Gets the image
    final int MAPIMGWIDTH = mapImg.getWidth();  // The width of the map image
    final int MAPIMGHEIGHT  = mapImg.getHeight();   //The height of the map image
    Platform platformTemplate = new Platform(0,0);      //This is a template so we can see
    GreenfootImage pfImg = platformTemplate.getImage(); //how tall and wide the platform is
    final int PLATFORMHEIGHT = pfImg.getHeight();       //The width of the platforms
    final int PLATFORMWIDTH = pfImg.getWidth();         //The height of the platform
    final int MAPWIDTH = MAPIMGWIDTH * PLATFORMWIDTH;   //The height and width of the map is the size
    final int MAPHEIGHT = MAPIMGHEIGHT * PLATFORMHEIGHT;//of the image times the size of the platform
    private List<Platform> thePlatforms = new ArrayList<Platform>();//This list contains all the platforms
    int leftBound = 0;                      //This is where the left side of the screen is on the map
    int bottomBound = MAPHEIGHT;            //Where the bottom of the screen is on the map
    int topBound = MAPHEIGHT - getHeight(); //Where the top of the screen is on the map
    int rightBound = getWidth();            //Where the right side of the screen is on the map
    BallGuy ballguytemplate = new BallGuy(0,0,0,0);
    BallGuy ballguy = new BallGuy(getWidth()/2, MAPHEIGHT-ballguytemplate.getImage().getHeight()/2,leftBound,topBound);
    ControlCommand control = new ControlCommand(ballguy);
    /**
     * Constructor for objects of class Platforms.
     * 
     */
    public Platforms()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        makeMap();  //Calls the function that makes the map from the image
        update();   //Draws the platforms on the screen
        addObject(ballguy, ballguy.screenX, ballguy.screenY);
        addObject(control, getWidth()/2, 20);
        
    }

    /*
     * The MakeMap method uses the map image to put each platform into an the thePlatfoms array
     * and to give each platform its location on the map in its mapX and mapY field.
     * THIS METHOD WILL ONLY WORK WITH A GIF IMAGE WITH NO ANTI-ALIASING OR COLOR AVERAGING!
     */
    public void makeMap()
    {
        for(int y=0;y<MAPIMGHEIGHT;y++) //One for each row of pixels
        {
            for(int x=0;x<MAPIMGWIDTH;x++) //One for each pixel in the row
            {
                int colorRGB = mapImg.getColorAt(x, y).getRGB(); //Get the RGB color of the pixel
                if(colorRGB==Color.BLACK.getRGB()) //Check to see if it's black
                {
                    /*
                     * One pixel is the size of a platform, so we multiply the x and y of the pixel on the
                     * map image times the width and height of a platform. Depending on the proportions of the 
                     * platform you'll get a different shape of map. The current game uses a square
                     * platform.
                     */
                    int mapX = x * PLATFORMWIDTH + PLATFORMWIDTH/2; //Pixel location times width of platform plus half its width
                    int mapY = y * PLATFORMHEIGHT +PLATFORMHEIGHT/2;//Pixel location times height of platform plus half its height
                    thePlatforms.add(new Platform(mapX,mapY));  //Adds the platform with its x and y coordinate
                    //in the map.

                }
            }
        }
    }
    /*
     * The shiftScreen makes the screen scroll when we need it to. 
     */
    public void shiftScreen(int changeX, int changeY)   // This method shifts the screen up, down,
    {                                                   // left and right.
            leftBound += changeX;                       // Move the left bound by the change in X
            rightBound += changeX;                      // Move the right bound by the change in X
            if(leftBound <0)                            // If the left bound goes off the map...
            {                
                leftBound =0;                           // ...set it to the left side of the map...
                rightBound = getWidth();                // ...and move the right bound to the right place.
            } else if(rightBound >= MAPWIDTH)           // If the right bound goes off the map...
            {
                rightBound = MAPWIDTH;                  // ...set right bound to right side of map...
                leftBound = MAPWIDTH - getWidth();      // ...and move left bound to right place.
            }
            
            topBound -= changeY;                        // Move the top bound and the bottom bound
            bottomBound -= changeY;                     // by the change in Y. 
            if(topBound <0)                             // If the top bound moves off the map...
            {
                topBound =0;                            //...move the top bound to top of map
                bottomBound = getHeight();              //...and move the bottom bound to right place.
            } else if (bottomBound > MAPHEIGHT)         // If the bottom bound goes off the map...
            {
                bottomBound = MAPHEIGHT;                // ...move the bottom bound to bottom of map...
                topBound = MAPHEIGHT - getHeight();     // ...and move the top bound to right place.
            }

        update();                                       // Now redraw the screen. 
    }

    /*
     * The update() method draws each platform in the correct place, and moves each platform already
     * on the screen to the correct place. When a platform goes off the screen
     * it will remove it, and it will add a platform if it comes onto the screen.
     * 
     * TO CHANGE: The platform needs to be added when its right or left side comes on the
     * screen. Then they won't appear in that ugly way.
     */
    public void update()
    {
        Platform thisPlatform;  // This will be the platform we are working with
        int thisPlatformX;      // This will be the X coordinate of the platform on the map
        int thisPlatformY;      // This will be the Y coordinate of the platform on the map
        int screenX;            // If the platform is on the screen, this will be its screen X coordinate
        int screenY;            // If the platform is on the screen, this will be its screen Y coordinate

        for(int i=0; i<thePlatforms.size(); i++) //Go through each of the platforms we created in makeMap()
        {
            thisPlatform = thePlatforms.get(i); //Assign the current platform to thisPlatform variable
            thisPlatformX = thisPlatform.mapX;  //Assign its map X coordinate to thisPlatformX
            thisPlatformY = thisPlatform.mapY;  //Assign its map Y coordinate to thisPlatformY

            /*
             * This conditional will compare the map X and Y coordinates to the left, right, top and
             * bottom bounds of the screen to see if it should be on the map.
             */
            if(thisPlatformX+PLATFORMWIDTH>=leftBound && thisPlatformX-PLATFORMWIDTH<=rightBound && thisPlatformY + PLATFORMHEIGHT >=topBound && thisPlatformY -PLATFORMWIDTH<= bottomBound)
            {                                           //If it belongs on the map...
                screenX = thisPlatformX - leftBound;    //...the screen X will be the map X minus left bound...
                screenY = thisPlatformY - topBound;     //... and the screen Y will be map Y minus left bound.
                if(thisPlatform.getWorld()==null)               //If it is not on the map...
                {
                    addObject(thisPlatform, screenX, screenY);  //...then add it with the right coordinates.
                } else {                                        //If it's already on the map...
                    thisPlatform.setLocation(screenX, screenY); //...then move it to the right coordinates.
                } 
            }else {                                     //If it doesn't belong on the map...
                    if(thisPlatform.getWorld()!=null)   //...check to see if it's on the map.
                    {                                   //If it is...
                        removeObject(thisPlatform);     //...then remove it.
                    }
                }
        }
    }
}
