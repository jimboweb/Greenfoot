import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BallGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallGuy extends Actor
{
    String controlString = "keyboard";
    boolean inTheAir = false;                   //If we are in the air or not
    int mapX;                                   //Where we start out on the map
    int mapY;                                   //x and y coordinates.
    int screenX;                                //Where we start on the screen
    int screenY;                                //x and y coordinates
    double deltaX = 0;                             //How much we're moving left and right
    double deltaY = 0;                             //How much we're moving up and down
    double doubleX = 0;
    double doubleY = 0;
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

    public BallGuy (int startMapX, int startMapY, int leftBound, int topBound)  //Constructor calls for x and y location
    {                                                                           //on map and left and top bounds.
        this.mapX = startMapX;                                                       //assign the variables for 
        this.mapY = startMapY;                                                       //map x and y and 
        this.screenX = mapX - leftBound;                                             //the variables for screen
        this.screenY = mapY - topBound;                                              //x and y.
        this.setLocation(screenX, screenY);                                          //Place BallGuy in correct x and y coords.

    }

    /**
     * Act method just gets the mouse or keyboard input then calls the move() method.
     */
    public void act() 
    {
        if(inTheAir)
        {               //If we are in the air...
            fall(0.4);     //...we can't move, we can just fall
        }else {
            getCommand(controlString);
        }
        move();                                         //Call the modified move command below
    }

    /**
     * Gets the mouse or keyboard input
     */
    public void getCommand(String controls)
    {
            /*
             * These lines are for mouse control. 
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
                        jump(15);                         //then jump.
                    } else if(mouseX>getX() + 50)       //If the cursor is to the right
                    {
                        run("right", 5);                    //then move right. 
                    } else if (mouseX < getX() - 50)    //If the cursor is to the left
                    {
                        run("left", 5);                    //then move left.
                    } else {
                        stop();                         //If the cursor is neither, then stop.
                    }
                }
                /*
                 * These lines are for keyboard control.
                 */
            } else if (controls == "keyboard")          //If we have keyboard command.
            {
                if(Greenfoot.isKeyDown("left"))
                {                                       //If they have the left key down
                    run("left", 5);                        //then run left. 
                } else if (Greenfoot.isKeyDown("right"))
                {                                       //If they have the right key down
                    run("right", 5);                       //then run right.
                } else{ 
                    stop();
                }

                if (Greenfoot.isKeyDown("up"))
                {                                       //If they have the up key down
                    jump(15);                             //then jump.
                }
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

        setLocationWithScroll(newX, newY);      //Calls a method that does the same as the setLocation() 
        //but scrolls the screen when necessary.

    }

    /*
     * setLocationWithScroll() does the same thing as setLocation() but scrolls the screen when the actor
     * goes outside certain boundaries around the screen. This way I can move inside the screen but the screen
     * will move when I get near the top, bottom, left and right. Also it will stop scrolling when I get
     * to the end of the map. setLocationWithScroll() will call the shiftScreen() method in the Platforms world.
     */
    public void setLocationWithScroll(double newX, double newY)   //Just like setLocation calls for an x and y coordinate
    {
        Platforms myPlatforms = (Platforms)myWorld; //Types the world so I can call the shiftScreen() method. 
        //First we'll have a conditional to see if we've gone within 200 pixels of the top or bottom of the screen, 
        //but we are not at the top or bottom of the map.
        if((newY<200&&myPlatforms.topBound>0) || (newY>worldHeight-200&&myPlatforms.bottomBound<myPlatforms.MAPHEIGHT))
        {                                           //If we're near the top or bottom of the screen, but not the map
            double yShift = getY()-newY;               //then we'll find out how much to shift the screen in the y direction
            myPlatforms.shiftScreen(0, (int)yShift);     //and shift the screen in the y direction only. 
        } else {                                    //if we're not near the top or bottom of the screen or are near the
            if(newX<=sideWidth)                     //If we're about to go off the left side of screen...
            {
                newX=sideWidth;                     //...stop us at the edge of the screen.
            }
            if(newX>worldWidth-sideWidth)           //If we're about to go off right side of screen...
            {
                newX=worldWidth-sideWidth;          //...stop us at right side of screen
            }
            setLocation(getX(),(int)newY);               //top or bottom of the map we'll set the Y without scrolling.
        }
        //Now we'll have a conditional that will see if we're within 200 pixels of the left and right of the screen,
        //but not at the left or right of the map. 
        if((newX<200&&myPlatforms.leftBound>0) || (newX>worldWidth-200&&myPlatforms.rightBound<myPlatforms.MAPWIDTH))
        {                                       //If we're within 200 pixels of the left or right of the screen but
            double xShift = newX-getX();           //not at the end of the map we will find out how much to shift the x
            myPlatforms.shiftScreen((int)xShift, 0); //and shift in the x direction only. 
        } else {                                //If we're not within 200 pixels of the left or right of the screen
            setLocation((int)newX,getY());           //we'll set the x coordinate normally without scrolling. 
        }
    }

}
