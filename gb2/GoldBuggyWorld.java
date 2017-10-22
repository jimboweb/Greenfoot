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
    public GoldBuggyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Gold gold = new Gold();
        addObject(gold, 186, 65);
        Gold gold2 = new Gold();
        addObject(gold2, 343, 95);
        Gold gold3 = new Gold();
        addObject(gold3, 227, 331);
        Gold gold4 = new Gold();
        addObject(gold4, 131, 325);
        Gold gold5 = new Gold();
        addObject(gold5, 180, 168);
        Gold gold6 = new Gold();
        addObject(gold6, 466, 292);
        Gold gold7 = new Gold();
        addObject(gold7, 363, 217);
        Gold gold8 = new Gold();
        addObject(gold8, 333, 342);
        Gold gold9 = new Gold();
        addObject(gold9, 420, 118);
        Bomb bomb = new Bomb();
        addObject(bomb, 272, 43);
        Bomb bomb2 = new Bomb();
        addObject(bomb2, 278, 158);
        Bomb bomb3 = new Bomb();
        addObject(bomb3, 166, 253);
        Bomb bomb4 = new Bomb();
        addObject(bomb4, 346, 276);
        Bomb bomb5 = new Bomb();
        addObject(bomb5, 426, 357);
        Bomb bomb6 = new Bomb();
        addObject(bomb6, 449, 181);
        Bomb bomb7 = new Bomb();
        addObject(bomb7, 446, 35);
        GoldBuggy goldbuggy = new GoldBuggy();
        addObject(goldbuggy, 53, 204);
        Smiley smiley = new Smiley();
        addObject(smiley, 536, 276);
        Smiley smiley2 = new Smiley();
        addObject(smiley2, 352, 88);
        Smiley smiley3 = new Smiley();
        addObject(smiley3, 272, 336);
    }
}
