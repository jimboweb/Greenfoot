import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformWorld extends World
{

    /**
     * Constructor for objects of class PlatformWorld.
     * 
     */
    public PlatformWorld()
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
        Platform platform = new Platform();
        addObject(platform, 78, 310);
        Platform platform2 = new Platform();
        addObject(platform2, 211, 215);
        Platform platform3 = new Platform();
        addObject(platform3, 347, 316);
        Platform platform4 = new Platform();
        addObject(platform4, 532, 217);
        Platform platform5 = new Platform();
        addObject(platform5, 385, 120);
        Platform platform6 = new Platform();
        addObject(platform6, 246, 126);
        platform6.setLocation(245, 121);
        platform2.setLocation(196, 243);
        platform.setLocation(77, 336);
        platform3.setLocation(344, 338);
        platform4.setLocation(532, 244);
        platform2.setLocation(265, 246);
        platform6.setLocation(65, 178);
        platform6.setLocation(67, 167);
        platform5.setLocation(206, 167);
        platform5.setLocation(207, 150);
        platform6.setLocation(67, 151);
        Platform platform7 = new Platform();
        addObject(platform7, 248, 70);
        Platform platform8 = new Platform();
        addObject(platform8, 395, 75);
        platform8.setLocation(394, 71);
        Platform platform9 = new Platform();
        addObject(platform9, 534, 74);
        platform9.setLocation(515, 150);
        platform8.setLocation(394, 70);
        platform5.setLocation(207, 151);
        Player player = new Player();
        addObject(player, 382, 299);
        player.setLocation(382, 295);
        player.setLocation(382, 293);
    }
}
