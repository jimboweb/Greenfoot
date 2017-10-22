import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Sand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leaf extends World
{
    
    /**
     * Constructor for objects of class Sand.
     * 
     */
    public Leaf()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage(10,10);
        bg.setColor(Color.GREEN);
        bg.fill();
        setBackground(bg);
        prepare();
    }    
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Wall wall = new Wall();
        addObject(wall, 274, 191);
        Wall wall2 = new Wall();
        addObject(wall2, 280, 147);
        wall2.setLocation(274, 143);
        Wall wall3 = new Wall();
        addObject(wall3, 281, 100);
        wall3.setLocation(274, 94);
        Wall wall4 = new Wall();
        addObject(wall4, 215, 85);
        wall4.setLocation(224, 93);
        Wall wall5 = new Wall();
        addObject(wall5, 175, 99);
        wall5.setLocation(174, 93);
        Wall wall6 = new Wall();
        addObject(wall6, 130, 99);
        wall6.setLocation(126, 94);
        Wall wall7 = new Wall();
        addObject(wall7, 133, 152);
        wall7.setLocation(127, 145);
        Mover mover = new Mover(Wall.class);
        addObject(mover, 200, 203);
        Wall wall8 = new Wall();
        addObject(wall8, 398, 284);
        Wall wall9 = new Wall();
        addObject(wall9, 398, 284);
        Wall wall10 = new Wall();
        addObject(wall10, 398, 284);
        Wall wall11 = new Wall();
        addObject(wall11, 398, 284);
        Wall wall12 = new Wall();
        addObject(wall12, 398, 284);
        Wall wall13 = new Wall();
        addObject(wall13, 398, 284);
        Wall wall14 = new Wall();
        addObject(wall14, 398, 284);
        Wall wall15 = new Wall();
        addObject(wall15, 398, 284);
        Wall wall16 = new Wall();
        addObject(wall16, 398, 284);
        Wall wall17 = new Wall();
        addObject(wall17, 398, 284);
        Wall wall18 = new Wall();
        addObject(wall18, 398, 284);
        Wall wall19 = new Wall();
        addObject(wall19, 398, 284);
        Wall wall20 = new Wall();
        addObject(wall20, 398, 284);
        Wall wall21 = new Wall();
        addObject(wall21, 398, 284);
        Wall wall22 = new Wall();
        addObject(wall22, 398, 284);
        Wall wall23 = new Wall();
        addObject(wall23, 398, 284);
        Wall wall24 = new Wall();
        addObject(wall24, 398, 284);
        wall24.setLocation(324, 95);
        wall23.setLocation(372, 101);
        wall23.setLocation(372, 95);
        wall22.setLocation(372, 146);
        wall21.setLocation(372, 196);
        wall20.setLocation(372, 245);
        wall19.setLocation(421, 200);
        wall18.setLocation(471, 199);
        wall17.setLocation(521, 200);
        wall16.setLocation(520, 251);
        wall15.setLocation(519, 301);
        wall14.setLocation(470, 301);
        wall13.setLocation(127, 195);
        wall12.setLocation(130, 249);
        wall12.setLocation(127, 245);
        wall11.setLocation(128, 295);
        wall10.setLocation(175, 299);
        wall9.setLocation(224, 297);
        wall10.setLocation(175, 296);
        wall8.setLocation(273, 296);
        Wall wall25 = new Wall();
        addObject(wall25, 527, 157);
        Wall wall26 = new Wall();
        addObject(wall26, 530, 100);
        Wall wall27 = new Wall();
        addObject(wall27, 514, 54);
        wall25.setLocation(523, 152);
        wall26.setLocation(524, 103);
        wall27.setLocation(525, 54);
        Wall wall28 = new Wall();
        addObject(wall28, 480, 110);
        wall28.setLocation(476, 105);
        Wall wall29 = new Wall();
        addObject(wall29, 226, 352);
        wall29.setLocation(223, 346);
        Wall wall30 = new Wall();
        addObject(wall30, 378, 303);
        wall30.setLocation(375, 288);
        wall29.setLocation(77, 244);
        wall30.setLocation(373, 292);
        Wall wall31 = new Wall();
        addObject(wall31, 279, 335);
        wall31.setLocation(275, 353);
        removeObject(wall31);
        Wall wall32 = new Wall();
        addObject(wall32, 183, 349);
        wall32.setLocation(175, 344);
        Wall wall33 = new Wall();
        addObject(wall33, 527, 353);
        wall33.setLocation(517, 348);
        Wall wall34 = new Wall();
        addObject(wall34, 277, 53);
        wall34.setLocation(275, 51);

        Aphid aphid = new Aphid();
        addObject(aphid, 274, 252);
        Aphid aphid2 = new Aphid();
        addObject(aphid2, 328, 158);
        Aphid aphid3 = new Aphid();
        addObject(aphid3, 333, 305);
        Aphid aphid4 = new Aphid();
        addObject(aphid4, 427, 108);
        Aphid aphid5 = new Aphid();
        addObject(aphid5, 577, 160);
        Aphid aphid6 = new Aphid();
        addObject(aphid6, 464, 366);
        Aphid aphid7 = new Aphid();
        addObject(aphid7, 76, 187);
        Aphid aphid8 = new Aphid();
        addObject(aphid8, 174, 42);
        ScoreBoard scoreboard = new ScoreBoard();
        addObject(scoreboard, 40, 33);
        scoreboard.setLocation(64, 22);
    }
}
