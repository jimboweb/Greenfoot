import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cliffs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliffs extends World
{

    /**
     * Constructor for objects of class Cliffs.
     * 
     */
    JetPackGuy theGuy;
    Platform platforms;
    diags theDiags;
    public Cliffs()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(400, 600, 1);
        theGuy = new JetPackGuy();
        theDiags = new diags();
        addObject(theGuy, 200, 100);
        //addObject(theDiags, 200, 20);

        prepare();
    }


    public JetPackGuy getGuy(){
        return theGuy;
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Platform platform = new Platform();
        addObject(platform, 392, 513);
        Platform platform2 = new Platform();
        addObject(platform2, 367, 518);
        platform2.setLocation(362, 512);
        platform2.setLocation(363, 512);
        platform2.setLocation(362, 513);
        Platform platform3 = new Platform();
        addObject(platform3, 22, 385);
        platform3.setLocation(69, 390);
        Platform platform4 = new Platform();
        addObject(platform4, 98, 394);
        platform4.setLocation(99, 390);
        Platform platform5 = new Platform();
        addObject(platform5, 152, 390);
        platform5.setLocation(128, 390);
        Platform platform6 = new Platform();
        addObject(platform6, 21, 531);
        platform6.setLocation(15, 526);
        Platform platform7 = new Platform();
        addObject(platform7, 45, 528);
        platform7.setLocation(45, 526);
        Platform platform8 = new Platform();
        addObject(platform8, 71, 523);
        platform8.setLocation(73, 526);
        Platform platform9 = new Platform();
        addObject(platform9, 238, 331);
        Platform platform10 = new Platform();
        addObject(platform10, 264, 325);
        platform10.setLocation(268, 331);
        Platform platform11 = new Platform();
        addObject(platform11, 300, 315);
        platform11.setLocation(297, 332);
        platform11.setLocation(298, 331);
        Platform platform12 = new Platform();
        addObject(platform12, 193, 469);
        Platform platform13 = new Platform();
        addObject(platform13, 225, 471);
        platform13.setLocation(223, 468);
        platform13.setLocation(222, 470);
        Platform platform14 = new Platform();
        addObject(platform14, 49, 254);
        platform14.setLocation(44, 248);
        platform14.setLocation(102, 248);
        Platform platform15 = new Platform();
        addObject(platform15, 149, 247);
        platform15.setLocation(131, 248);
        Platform platform16 = new Platform();
        addObject(platform16, 163, 250);
        platform16.setLocation(160, 248);
        Platform platform17 = new Platform();
        addObject(platform17, 304, 198);
        Platform platform18 = new Platform();
        addObject(platform18, 335, 205);
        Platform platform19 = new Platform();
        addObject(platform19, 368, 206);
        platform18.setLocation(333, 198);
        platform19.setLocation(362, 198);
        Platform platform20 = new Platform();
        addObject(platform20, 395, 204);
        platform20.setLocation(392, 198);
        Platform platform21 = new Platform();
        addObject(platform21, 22, 50);
        Platform platform22 = new Platform();
        addObject(platform22, 64, 51);
        Platform platform23 = new Platform();
        addObject(platform23, 101, 67);
        platform21.setLocation(94, 51);
        platform23.setLocation(124, 51);
        Platform platform24 = new Platform();
        addObject(platform24, 78, 137);
        Platform platform25 = new Platform();
        addObject(platform25, 110, 134);
        Platform platform26 = new Platform();
        addObject(platform26, 150, 138);
        platform25.setLocation(108, 138);
        platform26.setLocation(137, 136);
        platform25.setLocation(108, 137);
        platform26.setLocation(137, 138);
        platform26.setLocation(138, 138);
        platform24.setLocation(192, 130);
        platform26.setLocation(222, 130);
        platform25.setLocation(251, 130);
        Platform platform27 = new Platform();
        addObject(platform27, 215, 557);
        Platform platform28 = new Platform();
        addObject(platform28, 250, 563);
        Platform platform29 = new Platform();
        addObject(platform29, 281, 566);
        platform28.setLocation(245, 559);
        platform28.setLocation(244, 557);
        platform29.setLocation(273, 558);
        platform13.setLocation(222, 469);
        Platform platform30 = new Platform();
        addObject(platform30, 257, 465);
        platform30.setLocation(252, 469);
        Platform platform31 = new Platform();
        addObject(platform31, 27, 177);
        Platform platform32 = new Platform();
        addObject(platform32, 67, 183);
        Platform platform33 = new Platform();
        addObject(platform33, 109, 185);
        platform31.setLocation(14, 170);
        platform32.setLocation(43, 170);
        platform33.setLocation(72, 170);
        platform30.setLocation(271, 443);
        platform13.setLocation(241, 443);
        platform12.setLocation(212, 443);
    }
}
