import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class myWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class myWorld extends World
{
    Timer timer = new Timer(this);
    /**
     * Constructor for objects of class myWorld.
     * 
     */
    public myWorld()
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

        Bee bee = new Bee();
        addObject(bee, 258, 173);
        Balloon balloon = new Balloon();
        addObject(balloon, 463, 69);
        Balloon balloon2 = new Balloon();
        addObject(balloon2, 385, 375);
        Balloon balloon3 = new Balloon();
        addObject(balloon3, 117, 62);
        Wall wall = new Wall();
        addObject(wall, 455, 229);
        Butterfly bf = new Butterfly(bee);
        addObject(bf, 200,300);
        Wall wall2 = new Wall();
        addObject(wall2, 389, 44);
        Wall wall3 = new Wall();
        addObject(wall3, 187, 125);
        Wall wall4 = new Wall();
        addObject(wall4, 66, 274);
        Wall wall5 = new Wall();
        addObject(wall5, 261, 366);
        Wall wall6 = new Wall();
        addObject(wall6, 462, 331);
        Wall wall7 = new Wall();
        addObject(wall7, 383, 152);
        Wall wall8 = new Wall();
        addObject(wall8, 314, 282);
        Wall wall9 = new Wall();
        addObject(wall9, 67, 137);
        removeObject(wall);
        Bomb bomb = new Bomb();
        addObject(bomb, 509, 190);
        Bomb bomb2 = new Bomb();
        addObject(bomb2, 74, 33);
        Bomb bomb3 = new Bomb();
        addObject(bomb3, 138, 230);
        Bomb bomb4 = new Bomb();
        addObject(bomb4, 131, 345);
        removeObject(wall7);
        wall3.setLocation(239, 123);
        wall3.setLocation(354, 131);
        wall8.setLocation(351, 275);
        removeObject(wall3);
        wall8.setLocation(377, 226);
        removeObject(bee);
        Elephant elephant = new Elephant();
        addObject(elephant, 262, 177);
    }
}
