import greenfoot.*;
import java.awt.Color;
/**
 * <p>MoveRandomly is a class that causes an actor to move in a random way.</p> 
 * 
 * <p>The simple constructor simply calls for the actor who is moving. To use this constructor, use the 
 * following code at the beginning of your class:</p> 
 * 
 * <p style = "font-weight: bold">MoveRandomly moverandomly = new MoveRandomly(this);</p> 
 * 
 * <p>The advanced constructor calls for two arguments, the actor who's moving and a class that the actor
 * can't move past. For example to make your actor move randomly but be stopped by the class Wall, 
 * use the following code: </p> 
 * 
 * <p style = "font-weight: bold">MoveRandomly moverandomly= new MoveRandomly(this, Wall.class);</p> 
 * 
 * <p>MoveRandomly has one method, moveRandomly(). This method actually causes your actor to move in a 
 * random way. The basic argument for moveRandomly calls for just the speed at which you want to move. 
 * For example, to move randomly at a speed of 5, use the following code:</p> 
 * 
 * <p style = "font-weight: bold">moverandomly.moveRandomly(5);</p> 
 * 
 * <p>The more advanced version of the moveRandomly method calls for the speed argument, an integer argument
 * for turn percentage and an integer argument for turn width. The turn percentage should be a number between 
 * 1 and 100, and is the percent chance that the mover will change direction on any given turn. The higher
 * the number, the frequently the mover will turn. The turn width is the narrowest turn the mover will take  
 * in degrees, so should be less than or equal to 180 (A turn width of 180 will mean the actor can only turn
 * left and right; a turn width of 90 will mean the actor can only move up, down, left and right). 
 * To make your actor have a speed of five with 10 percent chance 
 * of turning and a minimum turn width of 90 degrees, use this code:</p> 
 * 
 * <p style = "font-weight: bold">moverandomly.moveRandomly(4, 10, 90);</p> 
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class MoveRandomly extends Actor
{
    Actor mover;
    int rightSideOfScreen = 0;
    int bottomOfScreen = 0;
    World myWorld = null;
    int turnPercentage=1;
    int turnWidth =360;
    Class obstacleClass = null;
    int width;
    int height;
    int distanceToFront;
    boolean blocked = false;
    /**
     * Constructor for objects of class MoveRandomly
     */
    public MoveRandomly(Actor mover)
    {
        this.mover = mover;
    }
    
    public MoveRandomly(Actor mover, Class obstacleClass)
    {
        this.mover = mover;
        this.obstacleClass = obstacleClass;
    }

    public void moveRandomly(int speed)
    {
        if(myWorld == null)
        {
            setWorld();
        }
        if(Greenfoot.getRandomNumber(100)<=5)
        {
            turnRandom(1);
        }
        
        int x = mover.getX();
        int y = mover.getY();
        
        if(x<=0 || y<=0 || x >= rightSideOfScreen || y >= bottomOfScreen)
        {
            mover.turn(180);
        }

        if(obstacleClass!=null)
        {
           
            if(findObstacle())
                blocked =true;            
            else
                blocked = false;
        }
        
        if(!blocked)
            mover.move(speed); 
        else
            turnRandom(1);
    }
    public void moveRandomly(int speed, int turnPercentage, int turnWidth)
    {
        if(myWorld == null)
        {
            setWorld();
        }
        if (turnPercentage<=100)
            this.turnPercentage=turnPercentage;
            
        if(turnWidth<360)
            this.turnWidth=turnWidth;
            
        if(Greenfoot.getRandomNumber(100)<=turnPercentage)
        {
            turnRandom(this.turnWidth);
        }
        
        int x = mover.getX();
        int y = mover.getY();
        
        if(x<=0 || y<=0 || x >= rightSideOfScreen || y >= bottomOfScreen)
        {
            mover.turn(180);
        }
        
        if(obstacleClass!=null)
        {
           
            if(findObstacle())
                blocked =true;            
            else
                blocked = false;
        }
         
        if(!blocked)
            mover.move(speed);
        else
            turnRandom(turnWidth);
           
    }
    private boolean findObstacle()
    {
        if(getWorld()==null)                                // If we're not in the world yet...
        {
            width = 10;
            height = mover.getImage().getHeight();              // Set the height of the invisible sensor. This is the width of the moving actor. 
            distanceToFront = mover.getImage().getWidth()/2;    // Set the distance to front. Half the size of the image.
            mover.getWorld().addObject(this, 0, 0);         // put us in the world
            setImage(new GreenfootImage(width, height));    // and set our height and width.
            /*
             * The commented out code below can be uncommented if you want to see your sensing 
             * actor for some reason. 
             */
            //getImage().setColor(Color.RED);
            //getImage().fillRect(0, 0, width-1, height-1);
        }
        setRotation(mover.getRotation());                                                           //point the same direction as the mover
        int xOffset =(int)Math.ceil(distanceToFront*Math.cos(Math.toRadians(mover.getRotation()))); //These three lines find a location directly in frontof the mover
        int yOffset = (int)Math.ceil(distanceToFront*Math.sin(Math.toRadians(mover.getRotation())));//using trigonometry and assigns them to xOffset & yOffset variables
        setLocation(mover.getX() + xOffset, mover.getY()+yOffset);                                  //then places the actor there so it can sense for obstacles in front.
        Actor obstacle = getOneIntersectingObject(obstacleClass);                                   //This line actually finds an obstacle obstructing the mover.
        return obstacle!=null;
    }
    private void setWorld()
    {
        this.myWorld = mover.getWorld();
        this.rightSideOfScreen = myWorld.getWidth()-1;
        this.bottomOfScreen=myWorld.getHeight()-1;
    }
    public void turnRandom(int turnWidth)
    {
        int newRot = Greenfoot.getRandomNumber(360/turnWidth)*turnWidth;
        mover.turn(newRot);  
        
    }
}
