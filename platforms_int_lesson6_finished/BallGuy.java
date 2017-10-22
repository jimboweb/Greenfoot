import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallGuy extends Actor
{
    boolean inTheAir = false;                       //Whether we're in the air or not
    int fallCount;                                  //Count whether it's time to fall
    int groundHeight = getImage().getHeight()/2;    //Distance from middle of ballguy to ground
    int sideWidth = getImage().getWidth()/2;        //Added
    int deltaX = 0;                                 //How much we're moving left and right
    int deltaY = 0;                                 //How much we're moving up and down

    /**
     * Act - do whatever the BallGuy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(inTheAir)                //If we're in the air                 
        {                           
            fall();                 //we'll fall
        } else                      //If we're not
        {                           
            if(Greenfoot.isKeyDown("left"))         //If they press the left key
            {
                deltaX = -5;                        //deltaX will move us to left
            } else if(Greenfoot.isKeyDown("right")) //If they press the right key
            {
                deltaX = 5;                         //deltaX will move us right
            } else                                  //If neither key is down
            {                               
                deltaX=0;                           //Don't move at all
            }  

            if(Greenfoot.isKeyDown("up"))           //Added
            {                                       //Added
                deltaY+=15;                         //Added
            }                                       //Added
        }                           
        move();
    } 

    public void move()
    {
        int newX = getX() + deltaX;     // Set the new x and y coordinates by adding or subtracting the deltaX

        int newY = getY() - deltaY;     // and deltaY. newX and newY may change if we're on the ground or a platform.
        Actor platformBelow = getOneObjectAtOffset(0, groundHeight+5, Platform.class);  //Look for a platform below us
        Actor platformAbove = getOneObjectAtOffset(0, -groundHeight-5, Platform.class); //Added
        Actor platformToRight = getOneObjectAtOffset(sideWidth+5, 0, Platform.class);
        Actor platformToLeft = getOneObjectAtOffset(-(sideWidth+5), 0, Platform.class);
        if(platformBelow!=null)         //If we find a platform below us
        {                               
            if(deltaY<0)                //If we are falling
            {                           
                deltaY=0;               //Stop falling
                inTheAir = false;       //Declare we're on the ground
                GreenfootImage platformImage = platformBelow.getImage();                //Get the image of the platform
                int topOfPlatform = platformBelow.getY()-platformImage.getHeight()/2;   //Find the top of platform
                newY = topOfPlatform - groundHeight;                                    //Put our feet at the top of the platform
            }                       
        } else                          //If there's no platform below
        {                               
            inTheAir = true;            //Then we will be in the air
        }
        if (platformAbove!=null)        //Added
        {                               //Added
            if(deltaY>0)                //Added
            {                           //Added
                deltaY=0;               //Added
                GreenfootImage platformImage = platformAbove.getImage();                //Added
                int bottomOfPlatform = platformAbove.getY()+platformImage.getHeight()/2;//Added
                newY = bottomOfPlatform + groundHeight;                                 //Added
            }                           //Added
        }   
        if (platformToRight != null)                            //Added
        {                                                       //Added
            deltaX = Math.abs(deltaX)* -1;                      //Added     
        }                                                       //Added
        if (platformToLeft != null)                             //Added
        {                                                       //Added
            deltaX = Math.abs(deltaX);                          //Added
        }                                                       //Added
        

        setLocationWithScroll(newX, newY);   
    }    

    public void fall()
    {
        deltaY--;                     //Decrease our change in Y coordinate to make our actor fall
    }

    public void setLocationWithScroll(int newX, int newY)
    {
        Sky mySky = (Sky)getWorld();                //Get the Sky world and type it to Sky class so we can call its methods
        int shiftX = newX - getX();                 //shiftX will be how much our boundaries move left and right on the map
        int shiftY = newY - getY();                 //ShiftY will be how much we move our boundaries up and down
        mySky.shiftScreen(shiftX, -shiftY);         //ShiftY is negative because y goes top to bottom
    }
}
