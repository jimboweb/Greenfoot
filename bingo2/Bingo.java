import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bingo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bingo extends World
{
    int columns = 10;   //Number of columns on the bingo board
    int rows = 9;       //Number of rows ont the bingo board
    Number n = new Number(columns*rows);        //Creates a place to click and pick random numbers
    LottoBoard lb = new LottoBoard(columns, rows);  //Creates a lotto board to place the numbers on
    
    /**
     * Constructor for objects of class Bingo.
     * 
     */
    public Bingo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(n, 100, 100); //Add the Number actor to the world
        addObject (lb, 400, 250);   //Add the lottoboard actor to the world
    }
    /*
     * The getLottoBoard method returns the LottoBoard actor so its methods
     * can be called by the Numbers actor
     */
    public LottoBoard getLottoBoard()
    {
        return lb;
    }
}
