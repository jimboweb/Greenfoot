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
        createARow(Platform.class,0,100,4);
        System.out.println("there are " + getObjects(Platform.class).size() + " platforms");
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
                System.out.println("adding platform at x = " + thisX + " y = " + thisY);
                addObject(actor, thisX, thisY);
            }
        } catch(InstantiationException e)
        {
            System.out.println(e);
        }catch(IllegalAccessException e)
        {
            System.out.println(e);
        }
    }
}
