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
    public Tile2() throws IOException
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        mapArray = readMapFromTextFile(MAPWIDTH, MAPHEIGHT, FILENAME);
        drawWallMapFromTextArray(WALLWIDTH, WALLHEIGHT, WALLMARKER, mapArray);
    }
    public void drawWallMapFromTextArray (int wallWidth, int wallHeight, String wallMarker, String[][] mapArray)
    {
        int x = 0;
        int y = 0;
        
        for(y=0;y<mapArray.length;y++)
        {
            for(x=0;x<mapArray[y].length;x++)
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
    
    public String[][] readMapFromTextFile(int mapWidth, int mapHeight, String fileName) throws IOException
    {
        BufferedReader br = null;
        String [][] mArray = new String[mapHeight][mapWidth];
        try{
            br = new BufferedReader(new FileReader(fileName));
            String l;
            int mapRow = 0;
            while((l=br.readLine())!=null)
            {
                mArray[mapRow] = l.split("");
                mapRow++;
            }
        } finally {
            if(br!=null)
                br.close();
        }
        return mArray;
    }
}
