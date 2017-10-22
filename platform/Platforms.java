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
    PlatformMap map = new PlatformMap();
    GreenfootImage mapImg = map.getImage();
    int mapWidth = mapImg.getWidth();
    int mapHeight = mapImg.getHeight();
    Platform platformTemplate = new Platform();
    int platformHeight = platformTemplate.getImage().getHeight();
    int platformWidth = platformTemplate.getImage().getWidth();
    //int[][] coords = new int[mapWidth][mapHeight];
    List<int[]> platformCoords = new ArrayList<int[]>();
    private List<Platform> thePlatforms = new ArrayList<Platform>();
    int numberOfPlatforms = 0;
    Color platformColor;
    
    
    //Debugging
    int thisPlatformX;
    int thisPlatformY;
    int numberOfLoops=0;
    int numberOfPlatformCoords = 0;
    //****************
    /**
     * Constructor for objects of class Platforms.
     * 
     */
    public Platforms()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        makeMap();
        numberOfPlatformCoords = platformCoords.size();
        startScreen();
    }

    public void makeMap()
    {
        for(int y=0;y<mapHeight;y++)
        {
            for(int x=0;x<mapWidth;x++)
            {
                platformColor = mapImg.getColorAt(x, y);
                int colorRGB = mapImg.getColorAt(x, y).getRGB();
                if(mapImg.getColorAt(x, y).getRGB()==Color.BLACK.getRGB())
                {
            numberOfLoops++;
                    platformCoords.add(new int[2]);
                    platformCoords.get(platformCoords.size()-1)[0]= x*platformWidth;
                    platformCoords.get(platformCoords.size()-1)[1]= y*platformHeight;
                   //coords[x][y] = 1;   //1 means there is a platform at that coordinate
                } /*else {
                //coords[x][y] = 0;   //0 means there is nothing at that coordinate
                }*/
            }
        }
    }

    public void startScreen()
    {
        for(int i=0;i<platformCoords.size();i++)
        {
            //Debugging
            thisPlatformX = platformCoords.get(i)[0];
            thisPlatformY = getHeight() - (mapHeight*platformHeight - platformCoords.get(i)[1]);
            //**************
       
            thePlatforms.add(new Platform());
            if(thisPlatformX<getWidth() && thisPlatformY < getHeight())
            {
                addObject(thePlatforms.get(i), thisPlatformX, thisPlatformY);
                    numberOfPlatforms++;          

            }

        }

    }
}
