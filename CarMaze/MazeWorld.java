import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeWorld extends World
{

    /**
     * Constructor for objects of class MazeWorld.
     * 
     */
    public MazeWorld()
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
        Wall wall = new Wall();
        addObject(wall, 210, 163);
        Wall wall2 = new Wall();
        addObject(wall2, 268, 170);
        Wall wall3 = new Wall();
        addObject(wall3, 336, 172);
        Wall wall4 = new Wall();
        addObject(wall4, 396, 169);
        Wall wall5 = new Wall();
        addObject(wall5, 457, 175);
        Wall wall6 = new Wall();
        addObject(wall6, 335, 235);
        Wall wall7 = new Wall();
        addObject(wall7, 342, 292);
        Wall wall8 = new Wall();
        addObject(wall8, 342, 332);
        Wall wall9 = new Wall();
        addObject(wall9, 341, 111);
        Wall wall10 = new Wall();
        addObject(wall10, 343, 60);
        Wall wall11 = new Wall();
        addObject(wall11, 351, 12);
        Wall wall12 = new Wall();
        addObject(wall12, 308, 15);
        Wall wall13 = new Wall();
        addObject(wall13, 259, 22);
        Wall wall14 = new Wall();
        addObject(wall14, 198, 19);
        Wall wall15 = new Wall();
        addObject(wall15, 132, 21);
        Car car = new Car();
        addObject(car, 484, 275);
    }
}
