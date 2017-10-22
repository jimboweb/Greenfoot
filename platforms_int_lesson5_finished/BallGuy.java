import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallGuy extends Actor
{
    boolean inTheAir = false;       //Added
    int fallCount;                  //Added
    int groundHeight = getImage().getHeight()/2; //Added
    int deltaX = 0;                             //How much we're moving left and right
    int deltaY = 0;                             //How much we're moving up and down

    /**
     * Act - do whatever the BallGuy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(inTheAir)                //Added                    
        {                           //Added
            fall();                 //Moved up
        } else                      //Added
        {                           //Added
            if(Greenfoot.isKeyDown("left"))
            {
                deltaX = -5;          //Changed
            } else if(Greenfoot.isKeyDown("right"))
            {
                deltaX = 5;          //Changed
            } else                  //changed
            {                       //Added
                deltaX=0;           //Added
            }                       //Added
        }                           //Added
        move();
    } 

    public void move()
    {
        int newX = getX() + deltaX;     // Set the new x and y coordinates by adding or subtracting the deltaX

        int newY = getY() - deltaY;     // and deltaY. newX and newY may change if we're on the ground or a platform.
        Actor platformBelow = getOneObjectAtOffset(0, groundHeight+5, Platform.class);
        if(platformBelow!=null)     //Added
        {                           //Added
            if(deltaY<0)            //Added
            {                       //Added
                deltaY=0;               //Added
                inTheAir = false;       //Added
                GreenfootImage platformImage = platformBelow.getImage();    //Added
                int topOfPlatform = platformBelow.getY()-platformImage.getHeight()/2;   //Added
                newY = topOfPlatform - groundHeight;     //Added
            }                       //Added
        } else                          //Added
        {                               //Added
            inTheAir = true;            //Added
        }                               //Added
        setLocationWithScroll(newX, newY);
    }    

    public void fall()
    {
            deltaY--;           //changed            //Increase our change in Y coordinate to make our actor fall
    }

    public void setLocationWithScroll(int newX, int newY)
    {
        Sky mySky = (Sky)getWorld();            //Get the Sky world and type it to Sky class so we can call its methods
        int shiftX = newX - getX();             //shiftX will be how much our boundaries move left and right on the map
        int shiftY = newY - getY();    
        mySky.shiftScreen(shiftX, -shiftY);      //changed
    }
}
