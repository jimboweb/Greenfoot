import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallGuy extends Actor
{
    int deltaX = 0;                             //How much we're moving left and right
    int deltaY = 0;                             //How much we're moving up and down

    /**
     * Act - do whatever the BallGuy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocationWithScroll(getX()-5, getY());
        } else if(Greenfoot.isKeyDown("right"))
        {
            setLocationWithScroll(getX()+5, getY());
        } 
        fall();
        move();
    } 

    public void move()
    {
        int newX = getX() + deltaX;     // Set the new x and y coordinates by adding or subtracting the deltaX

        int newY = getY() - deltaY;     // and deltaY. newX and newY may change if we're on the ground or a platform.
        setLocationWithScroll(newX, newY);
    }    

    public void fall()
    {
        deltaY++;                       //Increase our change in Y coordinate to make our actor fall
    }

    public void setLocationWithScroll(int newX, int newY)
    {
        Sky mySky = (Sky)getWorld();            //Get the Sky world and type it to Sky class so we can call its methods
        int shiftX = newX - getX();             //shiftX will be how much our boundaries move left and right on the map
        int shiftY = newY - getY();             //shiftY will be how much our boundaries move up and down on map
        mySky.shiftScreen(shiftX, shiftY);      //The shiftScreen method will move the screen and platforms
    }
}
