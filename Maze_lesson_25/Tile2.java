import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.List;


/**
 * Write a description of class Tile2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile2 extends World
{
    private final int WORLDWIDTH = getWidth();
    private final int WORLDHEIGHT = getHeight();
    Wall wallTemplate = new Wall();
    GreenfootImage wtImg = wallTemplate.getImage();
    private final int WALLHEIGHT = wtImg.getHeight();
    private final int WALLWIDTH = wtImg.getWidth();
    private final int MAPWIDTH = (int)(WORLDWIDTH/WALLWIDTH);
    private final int MAPHEIGHT = (int)(WORLDHEIGHT/WALLHEIGHT);
    private final String FILENAME = "map.txt";
    private final String WALLMARKER = "*";
    String[][] mapArray = new String[MAPHEIGHT][MAPWIDTH];
    /**
     * Constructor for objects of class Tile2.
     * 
     */
    public Tile2() throws IOException, InstantiationException, IllegalAccessException
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        mapArray = readMapFromTextFile(MAPWIDTH, MAPHEIGHT, FILENAME);
        drawWallMapFromTextArray(WALLWIDTH, WALLHEIGHT, WALLMARKER, mapArray);
    }

    /*
     * drawWallMapFromTextArray draws a map of walls from a text array. It requires as arguments the width and height of the walls, 
     * the symbol that represents a wall, and the text array to draw the map from. It will throw an error if any of the map symbols are 
     * null. It will ignore any symbol that is not a wall marker. Future implementations will allow multiple symbols to represent 
     * multiple actors.
     */
    public void drawWallMapFromTextArray(int wallWidth, int wallHeight, String wallMarker, String[][] mapArray) 
    {
        int x=0;
        int y=0;
       

            for(y=0;y<mapArray.length;y++)
            {
                for(x=0; x<mapArray[y].length;x++)
                {
                    
                    if(mapArray[y][x].equals(wallMarker))
                    {
                        int wallX = x*wallWidth - wallWidth/2;
                        int wallY = y*wallHeight + wallHeight/2;
                        addObject(new Wall(), wallX, wallY);
                    }
                }
            }
        } 
     

    /*
     * readMapFromTextFile reads a map file and returns a 2D String array where each row represents an
     * row of the map. The arguments are the width of the map in walls, the height of the
     * map in walls, and the name of the file that will be read.  
     * The text file must have no more than the height of the map.
     * Each row must have no more than the width of the map. 
     * If the file is too big for the size of the map that was passed, it will
     * throw an ArrayIndexOutOfBounds error. 
     */

    public String[][] readMapFromTextFile(int mapWidth, int mapHeight, String fileName) throws IOException
    {
        BufferedReader br = null;
        String[][] mArray = new String[mapHeight][mapWidth];
        try {
            br = new BufferedReader(new FileReader(fileName));
            String l;
            int mapRow = 0;
            while((l=br.readLine())!=null)
            {
                mArray[mapRow] = l.split("");
                if(mArray[mapRow].length-1>mapWidth)
                    throw new ArrayIndexOutOfBoundsException("Row# " + mapRow +" size = " + mArray[mapRow].length + " map width =" + mapWidth);
                mapRow++;
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            String errorString = ("The map file is not the right size! Error: " + e.getMessage());
            ErrorMessage em = new ErrorMessage(errorString);
            addObject (em, getWidth()/2, getHeight()/2);
        }catch(FileNotFoundException e) {
            String errorString = ("Couldn't find the map file! Error: " + e.getMessage());
            ErrorMessage em = new ErrorMessage(errorString);
            addObject (em, getWidth()/2, getHeight()/2);

        }catch(IOException e) {
            String errorString = ("The map file is not the right size! Error: " + e.getMessage());
            ErrorMessage em = new ErrorMessage(errorString);
            addObject (em, getWidth()/2, getHeight()/2);

        }finally {
            if(br!=null)
                br.close();
        }
        return mArray;
    }
}
