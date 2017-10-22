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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }

    public void act()
    {
        int numberOfRoaches = getObjects(Roach.class).size();
        if(numberOfRoaches>100)
        {
            showText("You've been overrun!", getWidth()/2, getHeight()/2);
            GameOver.endGame();
        } else if (numberOfRoaches==0)
        {
            showText("You eliminated the infestation!", getWidth()/2, getHeight()/2);
            GameOver.endGame();    
        }
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Roach roach = new Roach();
        addObject(roach, 282, 191);
        Shoe shoe = new Shoe();
        addObject(shoe, 498, 78);
        Roach roach2 = new Roach();
        addObject(roach2, 480, 354);
        Roach roach3 = new Roach();
        addObject(roach3, 127, 357);
        Roach roach4 = new Roach();
        addObject(roach4, 118, 77);
        Roach roach5 = new Roach();
        addObject(roach5, 537, 225);
        Roach roach6 = new Roach();
        addObject(roach6, 121, 192);
    }
}

















