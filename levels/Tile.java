import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends World
{

    /**
     * Constructor for objects of class Tile.
     * 
     */
    public Tile()
    {
        this(new Car());
    }
    
    public Tile(Car car)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(car, 255, 155);

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
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
    }
}
