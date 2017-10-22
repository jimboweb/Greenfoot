import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platforms here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platforms extends World
{

    /**
     * Constructor for objects of class Platforms.
     * 
     */
    public Platforms()
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
        Bricks bricks = new Bricks();
        addObject(bricks, 38, 305);
        Bricks bricks2 = new Bricks();
        addObject(bricks2, 128, 287);
        Bricks bricks3 = new Bricks();
        addObject(bricks3, 314, 294);
        Bricks bricks4 = new Bricks();
        addObject(bricks4, 198, 196);
        Bricks bricks5 = new Bricks();
        addObject(bricks5, 506, 234);
        Bricks bricks6 = new Bricks();
        addObject(bricks6, 491, 368);
        Bricks bricks7 = new Bricks();
        addObject(bricks7, 443, 132);
        Bricks bricks8 = new Bricks();
        addObject(bricks8, 244, 101);
        bricks7.setLocation(477, 234);
        bricks6.setLocation(344, 294);
        bricks4.setLocation(215, 101);
        bricks.setLocation(100, 287);
        bricks.setLocation(100, 321);
        bricks2.setLocation(129, 321);
        bricks.setLocation(95, 349);
        bricks2.setLocation(124, 349);
        bricks3.setLocation(199, 325);
        bricks6.setLocation(229, 325);
        Bricks bricks9 = new Bricks();
        addObject(bricks9, 383, 330);
        Bricks bricks10 = new Bricks();
        addObject(bricks10, 409, 334);
        bricks10.setLocation(411, 330);
        bricks3.setLocation(258, 325);
        Bricks bricks11 = new Bricks();
        addObject(bricks11, 137, 268);
        Bricks bricks12 = new Bricks();
        addObject(bricks12, 169, 271);
        bricks12.setLocation(163, 268);
        Bricks bricks13 = new Bricks();
        addObject(bricks13, 291, 239);
        Bricks bricks14 = new Bricks();
        addObject(bricks14, 316, 243);
        bricks14.setLocation(320, 239);
        Bricks bricks15 = new Bricks();
        addObject(bricks15, 72, 201);
        Bricks bricks16 = new Bricks();
        addObject(bricks16, 102, 205);
        bricks16.setLocation(102, 201);
        Bricks bricks17 = new Bricks();
        addObject(bricks17, 66, 121);
        Bricks bricks18 = new Bricks();
        addObject(bricks18, 102, 121);
        bricks18.setLocation(95, 121);
        Bricks bricks19 = new Bricks();
        addObject(bricks19, 216, 188);
        Bricks bricks20 = new Bricks();
        addObject(bricks20, 249, 194);
        bricks20.setLocation(245, 188);
        Bricks bricks21 = new Bricks();
        addObject(bricks21, 370, 141);
        Bricks bricks22 = new Bricks();
        addObject(bricks22, 406, 149);
        bricks22.setLocation(400, 141);
        Bricks bricks23 = new Bricks();
        addObject(bricks23, 465, 103);
        Bricks bricks24 = new Bricks();
        addObject(bricks24, 503, 108);
        bricks24.setLocation(494, 103);
        Bricks bricks25 = new Bricks();
        addObject(bricks25, 519, 330);
        Bricks bricks26 = new Bricks();
        addObject(bricks26, 552, 336);
        bricks26.setLocation(547, 330);
        Man man = new Man();
        addObject(man, 318, 381);
        man.setLocation(318, 373);
        bricks20.setLocation(264, 238);
        bricks20.setLocation(264, 239);
        bricks19.setLocation(238, 239);
        bricks23.setLocation(429, 142);
        bricks23.setLocation(429, 141);
        bricks24.setLocation(456, 141);
        bricks25.setLocation(450, 234);
        bricks26.setLocation(427, 235);
        bricks3.setLocation(356, 330);
        bricks6.setLocation(327, 330);
        bricks26.setLocation(424, 234);
        bricks12.setLocation(154, 349);
        bricks11.setLocation(183, 349);
        bricks18.setLocation(131, 201);
        bricks17.setLocation(47, 201);
        Bricks bricks27 = new Bricks();
        addObject(bricks27, 194, 107);
        bricks27.setLocation(187, 101);
        Bricks bricks28 = new Bricks();
        addObject(bricks28, 188, 180);
        bricks28.setLocation(160, 101);
        bricks8.setLocation(284, 101);
        bricks4.setLocation(255, 101);
        bricks4.setLocation(255, 101);
        bricks4.setLocation(255, 101);
        bricks27.setLocation(226, 101);
        bricks28.setLocation(197, 100);
        bricks28.setLocation(197, 101);
        bricks19.setLocation(206, 241);
        bricks20.setLocation(233, 241);
        bricks13.setLocation(260, 241);
        bricks14.setLocation(288, 242);
        bricks14.setLocation(288, 241);
    }
}
