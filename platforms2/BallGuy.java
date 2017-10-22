import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallGuy extends Actor
{
    String controls = "keyboard";               //keyboard controls
    boolean inTheAir = false;                   //If we are in the air or not
    int mapX;                                   //Where we start out on the map
    int mapY;                                   //x and y coordinates.
    int screenX;                                //Where we start on the screen
    int screenY;                                //x and y coordinates
    int deltaX = 0;                             //How much we're moving left and right
    int deltaY = 0;                             //How much we're moving up and down
    int groundHeight = getImage().getHeight()/2;//How far it is from the middle of the actor to the bottom
    int sideWidth = getImage().getWidth()/2;    //How far from middle of actor to side
    World myWorld;                              //Variable for the world
    int worldHeight;                            //Variable for height of world
    int worldWidth;                             //Variable for width of world
    MouseInfo myMouse;                          //Variable for the mouse if we use it

    public void addedToWorld(World theWorld)    //When we get added to world
    {
        myWorld = theWorld;                     //assign the world to variable
        worldHeight = myWorld.getHeight();      //and get the width and the height
        worldWidth = myWorld.getWidth();        //of the world. 
    }

    public BallGuy (int startMapX, int startMapY, int leftBound, int topBound)  //Constructor calls for x and y location
    {                                                                           //on map and left and top bounds.
        mapX = startMapX;                                                       //assign the variables for 
        mapY = startMapY;                                                       //map x and y and 
        screenX = mapX - leftBound;                                             //the variables for screen
        screenY = mapY - topBound;                                              //x and y.
        setLocation(screenX, screenY);                                          //Place BallGuy in correct x and y coords.

    }

    /**
     * Act method just gets the mouse or keyboard input then calls the move() method.
     */
    public void act() 
    {
        if(inTheAir)
        {               //If we are in the air...
            fall();     //...we can't move, we can just fall
        }else {
            /*
             * The commented-out lines below allow for mouse movements if that's what you want.
             * To use mouse movement remove these comments and move them to the keyboard commands
             * instead.
             */
            if(controls == "mouse")                     //If we have mouse controls
            {
                myMouse = Greenfoot.getMouseInfo();     //Get the mouss info
                if(myMouse!=null)                       //If the mouse is on the screen
                {
                    int mouseX = myMouse.getX();        //Get the x coordinate of the mouse
                    int button = myMouse.getButton();   //Get the button that's down
                    int guyX = getX();                  //Get the x coordinate of the guy
                    if(button ==1)                      //If they're pressing the button
                    {
                        jump();                         //then jump.
                    } else if(mouseX>getX() + 50)       //If the cursor is to the right
                    {
                        run("right");                    //then move right. 
                    } else if (mouseX < getX() - 50)    //If the cursor is to the left
                    {
                        run("left");                    //then move left.
                    } else {
                        stop();                         //If the cursor is neither, then stop.
                    }
                }
            } else if (controls == "keyboard")          //If we have keyboard command.
            {
                if(Greenfoot.isKeyDown("left"))
                {                                       //If they have the left key down
                    run("left");                        //then run left. 
                } else if (Greenfoot.isKeyDown("right"))
                {                                       //If they have the right key down
                    run("right");                       //then run right.
                } else if (Greenfoot.isKeyDown("up"))
                {                                       //If they have the up key down
                    jump();                             //then jump.
                }
            }
        }
        move();                                         //Call the modified move command below
    }

    /*
     * The run command simply changes the deltaX and deltaY variables for the move command below.
     * Obviously change the 5 to run faster or slower.
     * Calls for the string "left" or "right" when it is called. 
     */
    public void run(String direction)
    {
        if(direction == "left")
        {
            deltaX = -5;
        } else {
            deltaX = 5;
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
    public void jump()
    {
        deltaY += 30;
        inTheAir = true;
    }

    /*
     * fall() will be called whenever BallGuy is in the air. Decreases the deltaY by 1, creating
     * gravity.
     */
    public void fall()
    {
        deltaY--;
    }

    /*
     * Modified move command that depends on changing x and y coordinates based on an
     * deltaX and deltaY variable, which will be modified by the run(), jump() and fall() 
     * methods above.
     */
    public void move()
    {
        int newX = getX() + deltaX;     // Set the new x and y coordinates by adding or subtracting the deltaX
        int newY = getY() - deltaY;     // and deltaY. newX and newY may change if we're on the ground or a platform.
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

        /*
         * The conditional below should be improved by putting it into two different conditionals, one for
         * platformRight and one for platformLeft. In certain conditions when I hit a platform from the right
         * or left from above and below I can bounce "into" the platform instead of away from it.
         */
        if (platformToRight != null || platformToLeft != null)  //If there is a platform to left or right
        {                                                       //of us we should "bounce" off of it.
            deltaX = deltaX* -1;                                
        }                                                       
        setLocationWithScroll(newX, newY);      //Calls a method that does the same as the setLocation() 
        //but scrolls the screen when necessary.

    }

    /*
     * setLocationWithScroll() does the same thing as setLocation() but scrolls the screen when the actor
     * goes outside certain boundaries around the screen. This way I can move inside the screen but the screen
     * will move when I get near the top, bottom, left and right. Also it will stop scrolling when I get
     * to the end of the map. setLocationWithScroll() will call the shiftScreen() method in the Platforms world.
     */
    public void setLocationWithScroll(int newX, int newY)   //Just like setLocation calls for an x and y coordinate
    {
        Platforms myPlatforms = (Platforms)myWorld; //Types the world so I can call the shiftScreen() method. 
        //First we'll have a conditional to see if we've gone within 200 pixels of the top or bottom of the screen, 
        //but we are not at the top or bottom of the map.
        if((newY<200&&myPlatforms.topBound>0) || (newY>worldHeight-200&&myPlatforms.bottomBound<myPlatforms.MAPHEIGHT))
        {                                           //If we're near the top or bottom of the screen, but not the map
            int yShift = getY()-newY;               //then we'll find out how much to shift the screen in the y direction
            myPlatforms.shiftScreen(0, yShift);     //and shift the screen in the y direction only. 
        } else {                                    //if we're not near the top or bottom of the screen or are near the
            setLocation(getX(),newY);               //top or bottom of the map we'll set the Y without scrolling.
        }
        //Now we'll have a conditional that will see if we're within 200 pixels of the left and right of the screen,
        //but not at the left or right of the map. 
        if((newX<200&&myPlatforms.leftBound>0) || (newX>worldWidth-200&&myPlatforms.rightBound<myPlatforms.MAPWIDTH))
        {                                       //If we're within 200 pixels of the left or right of the screen but
            int xShift = newX-getX();           //not at the end of the map we will find out how much to shift the x
            myPlatforms.shiftScreen(xShift, 0); //and shift in the x direction only. 
        } else {                                //If we're not within 200 pixels of the left or right of the screen
            setLocation(newX,getY());           //we'll set the x coordinate normally without scrolling. 
        }
    }

    public void switchControls(String c)
    {
        if(c=="keyboard")
        {
            controls="keyboard";
        } else if(c=="mouse")
        {
            controls = "mouse";
        }
    }
}
