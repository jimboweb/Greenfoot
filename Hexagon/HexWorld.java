import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class HexWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HexWorld extends World
{
    int turnCount = 0;
    boolean gameOver = false;
    /**
     * Constructor for objects of class HexWorld.
     * 
     */
    public HexWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    public void prepare()
    {
        GreenfootImage bg = new GreenfootImage(1,1);
        bg.setColorAt(0, 0, Color.BLACK);
        setBackground(bg);
        CenterHex ch = new CenterHex();
        addObject(ch, getWidth()/2, getHeight()/2);
        Player p = new Player();
        addObject(p, getWidth()/2, getHeight()/2-30);

    }

    public void act()
    {
        if(!isGameOver())
        {
            turnCount++;
            if(turnCount%90==0)
            {
                int numberOfWalls = 0;
                for(int i=0; i<6; i++)
                {
                    if(Greenfoot.getRandomNumber(2)<1)
                    {
                        if(numberOfWalls<4)
                        {
                            addObject(new HexWall(i*60+turnCount, 200), getWidth()/2, getHeight()/2);
                            numberOfWalls++;
                        }
                    }
                }

            }
            if(turnCount==360)
                turnCount =0;
        }

    }

    public void gameOver()
    {
        gameOver = true;
    }

    public boolean isGameOver()
    {
        return gameOver;
    }
}
