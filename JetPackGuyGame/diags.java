import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class diags here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class diags extends Actor
{
    /**
     * Act - do whatever the diags wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Cliffs myWorld;
    JetPackGuy theGuy;
    public void diags(){
    }

    public void act() 
    {
        myWorld = (Cliffs)getWorld();
        theGuy = myWorld.getGuy();
        setImage(new GreenfootImage("  ", 20, Color.BLACK, Color.WHITE));        
        int deltaX = theGuy.deltaX;
        int deltaY = theGuy.deltaY;
        int absY = theGuy.absY;
        int y = theGuy.getY();
        boolean isOnTheGround = theGuy.isOnTheGround;
        setImage(new GreenfootImage("deltaX = "+ deltaX + " deltaY = " + deltaY + " y =" + y + " absY = " + absY, 20,  Color.WHITE, Color.BLACK));
    }    
}
