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
        addObject(wall, 34, 31);
        Wall wall2 = new Wall();
        addObject(wall2, 40, 81);
        Wall wall3 = new Wall();
        addObject(wall3, 40, 128);
        Wall wall4 = new Wall();
        addObject(wall4, 44, 186);
        wall2.setLocation(33, 81);
        wall.setLocation(27, 26);
        wall2.setLocation(25, 77);
        wall3.setLocation(25, 128);
        wall4.setLocation(24, 180);
        Wall wall5 = new Wall();
        addObject(wall5, 95, 30);
        Wall wall6 = new Wall();
        addObject(wall6, 132, 30);
        Wall wall7 = new Wall();
        addObject(wall7, 187, 42);
        Wall wall8 = new Wall();
        addObject(wall8, 224, 42);
        wall5.setLocation(78, 25);
        wall6.setLocation(126, 25);
        wall7.setLocation(177, 24);
        wall8.setLocation(127, 75);
        Wall wall9 = new Wall();
        addObject(wall9, 131, 143);
        Wall wall10 = new Wall();
        addObject(wall10, 135, 204);
        wall9.setLocation(128, 124);
        wall10.setLocation(27, 230);
        wall10.setLocation(23, 231);
        Wall wall11 = new Wall();
        addObject(wall11, 80, 236);
        Wall wall12 = new Wall();
        addObject(wall12, 141, 238);
        Wall wall13 = new Wall();
        addObject(wall13, 215, 238);
        Wall wall14 = new Wall();
        addObject(wall14, 255, 237);
        wall11.setLocation(74, 232);
        wall12.setLocation(129, 233);
        wall13.setLocation(179, 234);
        Wall wall15 = new Wall();
        addObject(wall15, 235, 29);
        Wall wall16 = new Wall();
        addObject(wall16, 235, 100);
        Wall wall17 = new Wall();
        addObject(wall17, 236, 166);
        Wall wall18 = new Wall();
        addObject(wall18, 238, 198);
        wall16.setLocation(232, 87);
        wall15.setLocation(228, 24);
        wall16.setLocation(226, 77);
        wall17.setLocation(226, 130);
        wall18.setLocation(227, 181);
        wall14.setLocation(230, 235);
        Hedge hedge = new Hedge();
        addObject(hedge, 94, 182);
        wall10.setLocation(21, 237);
        wall11.setLocation(74, 237);
        wall15.setLocation(237, 24);
        wall16.setLocation(236, 75);
        wall17.setLocation(235, 129);
        wall18.setLocation(236, 184);
        wall14.setLocation(233, 238);
        wall13.setLocation(182, 240);
        wall12.setLocation(128, 241);
        wall9.setLocation(134, 127);
        wall8.setLocation(135, 78);
        removeObject(hedge);
        Hedge hedge2 = new Hedge();
        addObject(hedge2, 95, 186);
    }
}
