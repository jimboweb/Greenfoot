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
        super(800, 600, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Platform platform = new Platform();
        addObject(platform, 42, 555);
        platform.setLocation(41, 527);
        Platform platform2 = new Platform();
        addObject(platform2, 129, 534);
        platform2.setLocation(120, 527);
        Platform platform3 = new Platform();
        addObject(platform3, 206, 534);
        platform3.setLocation(200, 527);
        Platform platform4 = new Platform();
        addObject(platform4, 212, 424);
        Platform platform5 = new Platform();
        addObject(platform5, 292, 419);
        platform5.setLocation(292, 424);
        Platform platform6 = new Platform();
        addObject(platform6, 375, 427);
        platform6.setLocation(372, 424);
        PlatformJumper platformjumper = new PlatformJumper();
        addObject(platformjumper, 46, 492);
        platformjumper.setLocation(45, 490);
        Platform platform7 = new Platform();
        addObject(platform7, 496, 363);
        Platform platform8 = new Platform();
        addObject(platform8, 572, 372);
        platform8.setLocation(574, 363);
        Platform platform9 = new Platform();
        addObject(platform9, 665, 369);
        platform9.setLocation(655, 364);
        platform9.setLocation(653, 364);
        platform.setLocation(36, 526);
        platform2.setLocation(117, 526);
        platform2.setLocation(114, 526);
        platform3.setLocation(192, 527);
        platform9.setLocation(653, 364);
        platform9.setLocation(653, 363);
        platform3.setLocation(192, 527);
        platform3.setLocation(191, 526);
        Platform platform10 = new Platform();
        addObject(platform10, 42, 298);
        platform10.setLocation(36, 298);
        Platform platform11 = new Platform();
        addObject(platform11, 145, 287);
        platform11.setLocation(112, 298);
        Platform platform12 = new Platform();
        addObject(platform12, 275, 283);
        platform12.setLocation(182, 298);
        Platform platform13 = new Platform();
        addObject(platform13, 333, 284);
        platform13.setLocation(257, 298);
        Platform platform14 = new Platform();
        addObject(platform14, 181, 187);
        platform14.setLocation(517, 218);
        platform14.setLocation(331, 298);
        Platform platform15 = new Platform();
        addObject(platform15, 411, 220);
        Platform platform16 = new Platform();
        addObject(platform16, 476, 226);
        platform16.setLocation(487, 220);
        Platform platform17 = new Platform();
        addObject(platform17, 604, 208);
        platform17.setLocation(556, 220);
        Platform platform18 = new Platform();
        addObject(platform18, 667, 222);
        platform18.setLocation(629, 220);
        Platform platform19 = new Platform();
        addObject(platform19, 741, 225);
        platform19.setLocation(703, 220);
        Platform platform20 = new Platform();
        addObject(platform20, 55, 154);
        platform20.setLocation(34, 151);
        Platform platform21 = new Platform();
        addObject(platform21, 98, 149);
        platform21.setLocation(109, 151);
        Platform platform22 = new Platform();
        addObject(platform22, 227, 153);
        platform22.setLocation(181, 151);
        Platform platform23 = new Platform();
        addObject(platform23, 263, 78);
        Platform platform24 = new Platform();
        addObject(platform24, 365, 80);
        platform24.setLocation(332, 78);
        Platform platform25 = new Platform();
        addObject(platform25, 478, 84);
        platform25.setLocation(410, 78);
        Platform platform26 = new Platform();
        addObject(platform26, 524, 84);
        platform26.setLocation(488, 78);
        Platform platform27 = new Platform();
        addObject(platform27, 688, 84);
        platform27.setLocation(688, 77);
        Platform platform28 = new Platform();
        addObject(platform28, 769, 83);
        platform28.setLocation(768, 78);
        platform15.setLocation(411, 199);
        platform16.setLocation(487, 199);
        platform17.setLocation(567, 199);
        platform18.setLocation(645, 199);
        platform19.setLocation(724, 199);
        Platform platform29 = new Platform();
        addObject(platform29, 528, 518);
        platform29.setLocation(528, 522);
        Platform platform30 = new Platform();
        addObject(platform30, 646, 527);
        platform30.setLocation(607, 522);
        Platform platform31 = new Platform();
        addObject(platform31, 731, 531);
        platform31.setLocation(684, 522);
        Platform platform32 = new Platform();
        addObject(platform32, 769, 527);
        platform32.setLocation(760, 522);
        platform28.setLocation(768, 77);
    }
}
