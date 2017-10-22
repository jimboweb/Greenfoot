import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bingo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bingo extends World
{
    Number number = new Number(90);
    LottoBoard lb = new LottoBoard();
    int maxNumber;
    /**
     * Constructor for objects of class Bingo.
     * 
     */
    public Bingo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(number, 100, 100);
        addObject(lb, 400,250);
        maxNumber = lb.getArrayLength();
    }
    
    public LottoBoard getLottoBoard()
    {
        return lb;
    }
}
