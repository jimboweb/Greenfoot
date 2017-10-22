import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jumper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformJumper extends Actor
{    

    int jumpHeight = 10;
    int walkSpeed = 5;
    double fallSpeed = 0.4;

    
    
    
    boolean inTheAir = false;                   //If we are in the air or not
    double deltaX = 0;                             //How much we're moving left and right
    double deltaY = 0;                             //How much we're moving up and down
    int groundHeight = getImage().getHeight()/2;//How far it is from the middle of the actor to the bottom
    int sideWidth = getImage().getWidth()/2;    //How far from middle of actor to side
    World myWorld;                              //Variable for the world
    int worldHeight;                            //Variable for height of world
    int worldWidth;                             //Variable for width of world
    MouseInfo myMouse;                          //Variable for the mouse if we use it

    public void addedToWorld(World myWorld)    //When we get added to world
    {
        this.myWorld = myWorld;                     //assign the world to variable
        this.worldHeight = myWorld.getHeight();      //and get the width and the height
        this.worldWidth = myWorld.getWidth();        //of the world. 
    }

    public void act() 
    {
        if(inTheAir)
        {               //If we are in the air...
            fall(fallSpeed);     //...we can't move, we can just fall
        }else {
            getCommand();
        }
        move();                                         //Call the modified move command below
    }

    public void getCommand()
    {
        if(Greenfoot.isKeyDown("left"))
        {                                       //If they have the left key down
            run("left", walkSpeed);                        //then run left. 
        } else if (Greenfoot.isKeyDown("right"))
        {                                       //If they have the right key down
            run("right", walkSpeed);                       //then run right.
        } else{ 
            stop();
        }

        if (Greenfoot.isKeyDown("up"))
        {                                       //If they have the up key down
            jump(jumpHeight);                             //then jump.
        }

    }

    /*
     * The run command simply changes the deltaX and deltaY variables for the move command below.
     * Obviously change the 5 to run faster or slower.
     * Calls for the string "left" or "right" when it is called. 
     */
    public void run(String direction, int speed)
    {
        if(direction == "left")
        {
            deltaX = speed*-1;
        } else {
            deltaX = speed;
        }

    }

    /*
     * The stop command simply changes the deltaX to 0 to stop running. 
     * Right now it only works if you're using the mouse command. 
     */
    public void stop()
    {
        deltaX = 0;
    }

    /*
     * The jump sets the deltaY to 30 for the move command. Obviously change the 30 to make
     * BallGuy jump higher or lower.
     */
    public void jump(int jumpHeight)
    {
        deltaY += jumpHeight;
        inTheAir = true;
    }

    /*
     * fall() will be called whenever BallGuy is in the air. Decreases the deltaY by 1, creating
     * gravity.
     */
    public void fall(double fallSpeed)
    {
        deltaY-=fallSpeed;
    }

    /*
     * Modified move command that depends on changing x and y coordinates based on an
     * deltaX and deltaY variable, which will be modified by the run(), jump() and fall() 
     * methods above.
     */
    public void move()
    {
        double newX = getX() + deltaX;     // Set the new x and y coordinates by adding or subtracting the deltaX

        double newY = getY() - deltaY;     // and deltaY. newX and newY may change if we're on the ground or a platform.
        /*
         * The five lines below check to see if there is a platform above us, below us, to the left or right
         * or one that we are intersecting. This , along with the conditionals afterward, will
         * keeps us from going through platforms or being on top of them.
         */
        Actor platformBelow = getOneObjectAtOffset(0, groundHeight+5, Platform.class);
        Actor platformAbove = getOneObjectAtOffset(0, -(groundHeight+5), Platform.class);
        Actor platformToRight = getOneObjectAtOffset(sideWidth+5, 0, Platform.class);
        Actor platformToLeft = getOneObjectAtOffset(-(sideWidth+5), 0, Platform.class);
        Actor platformIntersecting = getOneIntersectingObject(Platform.class);
        if(platformBelow!=null)         //If there's a platform below us...
        {
            if(deltaY<0)                    //...check to see if we're falling.                                           
            {                               //If we are, then 
                deltaY=0;                   //stop us from falling, and declare 
                inTheAir = false;           //we're on the ground so we won't fall next turn.
                GreenfootImage platformImage = platformBelow.getImage();                //Get the platform's image
                int topOfPlatform = platformBelow.getY()-platformImage.getHeight()/2;   //find the top of it
                newY = topOfPlatform - groundHeight;                                    //and put BallGuy there.
            }
        } else if(getY() >= worldHeight - groundHeight) {   //If we're at the bottom of the map
            if(deltaY<0)                                    //and we're falling...
            {
                deltaY=0;                                   //make us stop falling
                inTheAir = false;                           //declare we're on the ground
                newY = worldHeight - groundHeight;          //and put us on the bottom of the map.
            }
        } else {                                            //if there's nothing below us declare we're in the air
            inTheAir = true;                                //so we will start falling again.
        }
        if (platformAbove!=null)        //If there is a platform above us...
        {
            if(deltaY>0)                //...and we're going up...
            {
                deltaY=0;               //...then we should stop going up.
                GreenfootImage platformImage = platformAbove.getImage();                //Find the bottom
                int bottomOfPlatform = platformAbove.getY()+platformImage.getHeight()/2;//of the platform
                newY = bottomOfPlatform + groundHeight;                                 //and put us there.
            }
        }   
        if(getX()<=sideWidth)           //If we hit the left side of the screen...
        {
            deltaX=Math.abs(deltaX);    //...bounce by reversing vertical direction
        }
        if(getX()>worldWidth-sideWidth) //If we hit the right side of the screen...
        {
            deltaX=Math.abs(deltaX)*-1; //...bounce by reversing vertical direction
        }

        if (platformToRight != null)                            //If there is a platform to left or right
        {                                                       //of us we should "bounce" off of it.
            deltaX = Math.abs(deltaX)* -1;                                
        }   
        if (platformToLeft != null)                             //If there is a platform to left or right
        {                                                       //of us we should "bounce" off of it.
            deltaX = Math.abs(deltaX);                                
        }   

        setLocation((int)newX, (int)newY);      //Moves to the new coordinates

    }
}