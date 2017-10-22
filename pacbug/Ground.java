import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 
/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends World
{
    private List<Rock> theRocks = new ArrayList<Rock>();
    Rock testRock = new Rock();
    private int rockWidth = testRock.rockWidth();
    private int rockHeight = testRock.rockHeight();
    private int widthInRocks = (int)getWidth()/rockWidth;
    private int heightInRocks = (int)getHeight()/rockHeight;
    /**
     * Constructor for objects of class Ground.
     * 
     */
    public Ground()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        drawRocksAcrossTop();
        drawRocksAcrossBottom();
        drawRocksDownLeft();
        drawRocksDownRight();
        drawRowOfRocks("h", 60, 120, 5);
        drawRowOfRocks("v", 500, 60, 3);
        Ladybug bug = new Ladybug();
        addObject(bug, getWidth()/2, getHeight()/2);

    }

    public void drawRocksAcrossTop()
    {
        for(int i=0; i<widthInRocks; i++)
        {
            theRocks.add(new Rock());
            int xLoc =rockWidth/2+(i)*rockWidth;
            int yLoc = rockHeight/2;
            addObject(theRocks.get(theRocks.size() - 1), xLoc, yLoc);

        }
    }

    public void drawRocksAcrossBottom()
    {
        for(int i=0; i<widthInRocks; i++)
        {
            theRocks.add(new Rock());
            int xLoc =rockWidth/2+(i)*rockWidth;
            int yLoc = getHeight()-rockHeight/2;
            addObject(theRocks.get(theRocks.size() - 1), xLoc, yLoc);

        }
    }

    public void drawRocksDownLeft()
    {
        for(int i=0; i<heightInRocks; i++)
        {
            theRocks.add(new Rock());
            int xLoc =rockWidth/2;
            int yLoc = rockHeight/2+i*rockHeight;
            addObject(theRocks.get(theRocks.size() - 1), xLoc, yLoc);

        }
    }

    public void drawRocksDownRight()
    {
        for(int i=0; i<heightInRocks; i++)
        {
            theRocks.add(new Rock());
            int xLoc = getWidth()-rockWidth/2;
            int yLoc = rockHeight/2+i*rockHeight;
            addObject(theRocks.get(theRocks.size() - 1), xLoc, yLoc);

        }
    }

    public void drawRowOfRocks(String dir, int startX, int startY, int numRocks)
    {
        if(dir == "h")
        {
            for(int i=0; i<numRocks; i++)
            {
                theRocks.add(new Rock());
                int xLoc = startX + rockWidth/2 + rockWidth*i;
                int yLoc = startY + rockWidth/2;
                addObject(theRocks.get(theRocks.size() - 1), xLoc, yLoc);

            }
        }
        if(dir == "v")
        {
            for(int i=0; i<numRocks; i++)
            {
                theRocks.add(new Rock());
                int xLoc = startX + rockWidth/2;
                int yLoc = startY + rockWidth/2 + rockHeight * i;
                addObject(theRocks.get(theRocks.size() - 1), xLoc, yLoc);

            }
        }

    }

}
