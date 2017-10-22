import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * <p>MoveObstructedByObstacle moves another Actor in a way that keeps it from going through an obstacle
 * of a certain class. </p>
 * 
 * <p>To call MoveObstructedByObstacle you must pass the Actor who will be moving and the Class of the
 * obstacle that will stop it. For example, to make your actor so it will move but be stopped by actors
 * of the class Wall, you would call it like this:</p>
 * 
 * <p style = "font-weight:bold">MoveObstructedByObstacle moveobstructedbyobstacle = new MoveObstructedByObstacle(this, Wall.class);</p>
 * 
 * <p>If you want more than one kind of obstacle to stop the actor, just make them all subclasses of
 * another class. So for example you could right-click on the Wall class and create subclasses
 * RedWall and BlueWall. </p>
 * 
 * <p>MoveObstructedByObstacle has two methods to move your actor.</p>
 * 
 * <p>To move your actor in the direction you press your arrow keys, call the moveWithArrowsObstructed() class, 
 * passing the speed you want to move. So to move at speed 5, add the following to the act method:</p>
 * 
 * <p style = "font-weight:bold">moveobstructedbyobstacle.moveWithArrowsOb(5);</p>
 * 
 * <p>To move your actor toward the mouse when you press the mouse button, call the moveWithMouseObstructed()
 * class, passing the speed you want to move. So to move with the mouse at speed 5, add the following to 
 * your act() method:</p>
 * 
 * <p style = "font-weight:bold">moveobstructedbyobstacle.moveWithMouseOb(5);</p>
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class MoveObstructedByObstacle extends Actor
{
    
    /*
     * MoveObstructedByObstacle works by being an invisible actor in front of the moving actor to sense
     * if there is an obstacle in the way using the getOneIntersectingObject() method. The diagnostic
     * commented out section below allows you to see the sensor.
     */
    Actor mover;                    //The actor that is moving.
    Class obstacleClass;            //The class of the object that will be the obstacle.
    int distanceToFront;            //The distance from the middle of the moving actor to the front of it.
    int width;                      //The width of the invisible actor that senses for obstacles
    int height;                     //The length of the invisible actor that senses for obstacles
    public MoveObstructedByObstacle(Actor m, Class o)
    {
        mover = m;                                          // Set the actor that's moving
        obstacleClass = o;                                  // Set the class of the obstacle
        width = 10;                                         // Set the width of the invisible sensor. This is the distance in front of the moving actor that we will look
        height = mover.getImage().getHeight();              // Set the height of the invisible sensor. This is the width of the moving actor. 
        distanceToFront = mover.getImage().getWidth()/2;    // Set the distance to front. Half the size of the image.
        
    }

    public void moveWithArrowsOb(int speed)                 // This method moves us with the arrow keys. Speed is how fast we move.
    {
        
        if(getWorld()==null)                                // If we're not in the world yet...
        {
            mover.getWorld().addObject(this, 0, 0);         // put us in the world
            setImage(new GreenfootImage(width, height));    // and set our height and width.
        /*
         * The commented out code below can be uncommented if you want to see your sensing 
         * actor for some reason. 
         */
        //getImage().setColor(Color.RED);
        //getImage().fillRect(0, 0, width-1, height-1);
        }
        
        Actor obstacle = senseObstacle();
        if(Greenfoot.isKeyDown("right"))                                                            //If we are pressing the 'right' key
        {
            mover.setRotation(0);                                                                   //point right
            if(obstacle == null)                                                                    //and if there's no obstacles
            {
                mover.move(speed);                                                                  //we move.
            }
        }
        if(Greenfoot.isKeyDown("down"))                                                             //If we're pressing the 'down' key
        {
            mover.setRotation(90);                                                                  //point down
            if(obstacle == null)                                                                    //if there are no obstacles
            {
                mover.move(speed);                                                                  //we move.
            }
        }
        if(Greenfoot.isKeyDown("left"))                                                             //If we're pressing the 'left' key
        {
            mover.setRotation(180);                                                                  //point left
            if(obstacle == null)                                                                    //if there are no obstacles
            {
                mover.move(speed);                                                                  //we move.
            }
        }
        if(Greenfoot.isKeyDown("up"))                                                             //If we're pressing the 'up' key
        {
            mover.setRotation(270);                                                                  //point up
            if(obstacle == null)                                                                    //if there are no obstacles
            {
                mover.move(speed);                                                                  //we move.
            }
        }
    }
    
    public void moveWithMouseOb(int speed)                          //This method moves us with the mouse keys. Speed is how fast we move. 
    {
        if(getWorld()==null)                                        //If we're not yet in the world
        {
            mover.getWorld().addObject(this, 0, 0);                 //Add us to the world.
            setImage(new GreenfootImage(width, height));            //Set our height and width
        /*
         * The commented out code below can be uncommented if you want to see your sensing 
         * actor for some reason. 
         */
        //getImage().setColor(Color.RED);
        //getImage().fillRect(0, 0, width-1, height-1);
         }
        Actor obstacle = senseObstacle();
        
        MouseInfo pointer = Greenfoot.getMouseInfo();   //Get the mouse information
        if(pointer != null)                             //If the mouse is on the screen...
        {
            int mouseX = pointer.getX();                //get the mouse x coordinate
            int mouseY = pointer.getY();                //get the mouse y coordinate
            mover.turnTowards(mouseX, mouseY);        //point towards it
            int button = pointer.getButton();           //get the button
            if(button == 1 && obstacle == null) //if the button is down and not on the actor
            {
                mover.move(10);                       //move 10.
            }
        }        
        

    }
    private Actor senseObstacle()
    {
        setRotation(mover.getRotation());                                                           //point the same direction as the mover
        int xOffset =(int)Math.ceil(distanceToFront*Math.cos(Math.toRadians(mover.getRotation()))); //These three lines find a location directly in frontof the mover
        int yOffset = (int)Math.ceil(distanceToFront*Math.sin(Math.toRadians(mover.getRotation())));//using trigonometry and assigns them to xOffset & yOffset variables
        setLocation(mover.getX() + xOffset, mover.getY()+yOffset);                                  //then places the actor there so it can sense for obstacles in front.
        Actor obstacle = getOneIntersectingObject(obstacleClass);                                   //This line actually finds an obstacle obstructing the mover.
        return obstacle;
    }
    
}
