import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends World
{

    /**
     * Constructor for objects of class Rock.
     * 
     */
    public Rock()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this(new Car());
    }
    
    public Rock (Car car)
    {
        super(600, 400, 1); 
        Coin coin = new Coin();
        addObject(coin, 102, 96);
        Coin coin2 = new Coin();
        addObject(coin2, 135, 283);
        Coin coin3 = new Coin();
        addObject(coin3, 390, 117);
        Coin coin4 = new Coin();
        addObject(coin4, 288, 259);
        Coin coin5 = new Coin();
        addObject(coin5, 482, 352);

        addObject(car, getWidth()/2, getHeight()/2);
    }
}
