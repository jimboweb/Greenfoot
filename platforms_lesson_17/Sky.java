import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Sky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sky extends World
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

    /**
     * Constructor for objects of class Sky.
     * 
     */
    public Sky()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        makeMap();  //Calls the function that makes the map from the image
        update();   //Draws the platforms on the screen
    }

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
                    thePlatforms.add(new Platform(mapX,mapY));      //Adds the platform with its x and y coordinate
                    //in the map.

                }
            }
        }

    }

    /*
     * This draws each platform in the correct place. Currently doesn't yet move the platform, but
     * when the shiftScreen() method is added it will move platforms and remove them when they
     * go off the screen.
     */
    public void update()
    {
        Platform thisPlatform;
        int thisPlatformX;
        int thisPlatformY;
        int screenX;
        int screenY;
        for(int i=0; i<thePlatforms.size(); i++)
        {
            thisPlatform = thePlatforms.get(i);
            thisPlatformX = thisPlatform.mapX;
            thisPlatformY = thisPlatform.mapY;

            if(thisPlatformX>=leftBound && thisPlatformX<=rightBound && thisPlatformY >=topBound && thisPlatformY <= bottomBound)
            {
                screenX = thisPlatformX - leftBound;
                screenY = thisPlatformY - topBound;
                if(thisPlatform.getWorld()==null)
                {
                    addObject(thisPlatform, screenX, screenY);
                } 
            }
        }
    }

}
