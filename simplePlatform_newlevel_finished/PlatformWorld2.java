import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformWorld2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformWorld2 extends World
{

    /**
     * Constructor for objects of class PlatformWorld2.
     * 
     */
    public PlatformWorld2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        //createARow(Platform.class,0,100,4);
        //createARow(Platform.class, 400, 100, 4);
        createARow(Platform.class, 0, 125, 1);
        createARow(Platform.class, 200, 125,6);
        createARow(Platform.class, 0,250,3);
        createARow(Platform.class, 400,250,4);
        createARow(Platform.class, 150, 375, 4);
        createARow(Platform.class, 600, 375, 3);
        createARow(Platform.class, 0,500,4);
        createARow(Platform.class, 500,500,4);
        addObject(new PlatformJumper(), 50,575);
        //System.out.println("there are " + getObjects(Platform.class).size() + " platforms");

        prepare();
    }

    public void createARow (Class thisClass, int x, int y, int length)
    {
        try
        {
            Actor actorTemplate = (Actor)thisClass.newInstance();
            GreenfootImage actorImage = actorTemplate.getImage();
            int actorWidth = actorImage.getWidth();
            int actorHeight = actorImage.getHeight();
            for(int i=0;i<length;i++)
            {
                Actor actor = (Actor)thisClass.newInstance();
                int thisX = x + actorWidth/2 + actorWidth*i;
                int thisY = y + actorHeight/2;
                //System.out.println("adding platform at x = " + thisX + " y = " + thisY);
                addObject(actor, thisX, thisY);
            }
        } catch(InstantiationException e)
        {
            System.out.println("You can't create an instance of that class! Error: " + e);
        }catch(IllegalAccessException e)
        {
            System.out.println("No access to that class. Error: " + e);
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        PlatformOpponent platformopponent = new PlatformOpponent();
        addObject(platformopponent, 39, 466);
        PlatformOpponent platformopponent2 = new PlatformOpponent();
        addObject(platformopponent2, 162, 468);
        platformopponent.setLocation(39, 460);
        platformopponent2.setLocation(163, 460);
        PlatformOpponent platformopponent3 = new PlatformOpponent();
        addObject(platformopponent3, 541, 466);
        PlatformOpponent platformopponent4 = new PlatformOpponent();
        addObject(platformopponent4, 722, 466);
        platformopponent3.setLocation(541, 460);
        platformopponent4.setLocation(722, 463);
        platformopponent4.setLocation(722, 460);
        PlatformOpponent platformopponent5 = new PlatformOpponent();
        addObject(platformopponent5, 654, 363);
        platformopponent5.setLocation(654, 359);
        PlatformOpponent platformopponent6 = new PlatformOpponent();
        addObject(platformopponent6, 300, 364);
        platformopponent6.setLocation(299, 307);
        platformopponent5.setLocation(653, 307);
        platformopponent5.setLocation(653, 334);
        platformopponent6.setLocation(298, 331);
        PlatformOpponent platformopponent7 = new PlatformOpponent();
        addObject(platformopponent7, 428, 337);
        PlatformOpponent platformopponent8 = new PlatformOpponent();
        addObject(platformopponent8, 53, 207);
        PlatformOpponent platformopponent9 = new PlatformOpponent();
        addObject(platformopponent9, 179, 209);
        PlatformOpponent platformopponent10 = new PlatformOpponent();
        addObject(platformopponent10, 540, 213);
        PlatformOpponent platformopponent11 = new PlatformOpponent();
        addObject(platformopponent11, 635, 88);
        PlatformOpponent platformopponent12 = new PlatformOpponent();
        addObject(platformopponent12, 293, 89);
        platformopponent11.setLocation(633, 84);
        platformopponent12.setLocation(289, 83);
        platformopponent10.setLocation(540, 209);
        Door door = new Door();
        addObject(door, 43, 93);
        door.setLocation(40, 89);
        door.setLocation(450, 87);
    }
}
