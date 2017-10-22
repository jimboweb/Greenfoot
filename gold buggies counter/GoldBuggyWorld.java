import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldBuggyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldBuggyWorld extends World
{

    /**
     * Constructor for objects of class GoldBuggyWorld.
     * 
     */
    ScoreCounter counter = new ScoreCounter();
    public GoldBuggyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(counter, 60, 20);

        prepare();
    }

    public ScoreCounter getCounter(){
        return counter;
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        GoldBuggy goldbuggy = new GoldBuggy();
        addObject(goldbuggy, 280, 199);
        GoldBuggy goldbuggy2 = new GoldBuggy();
        addObject(goldbuggy2, 307, 285);
        removeObject(goldbuggy2);
        Gold gold = new Gold();
        addObject(gold, 326, 82);
        Gold gold2 = new Gold();
        addObject(gold2, 456, 190);
        Gold gold3 = new Gold();
        addObject(gold3, 162, 182);
        Gold gold4 = new Gold();
        addObject(gold4, 231, 330);
        Gold gold5 = new Gold();
        addObject(gold5, 405, 302);
        Gold gold6 = new Gold();
        addObject(gold6, 269, 101);
        Gold gold7 = new Gold();
        addObject(gold7, 509, 88);
        Gold gold8 = new Gold();
        addObject(gold8, 532, 318);
        Gold gold9 = new Gold();
        addObject(gold9, 423, 121);
    }
}
