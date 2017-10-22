import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A spaceship flies around and shoots fruit
 * 
 * @author Jim Stewart 
 * @version 0.01
 */
public class PieShip extends SpaceActors
{

    /*
     * The vertical and horizontal speed
     * of the ships
     */
    private int horizontalSpeed = 0;
    private int verticalSpeed = 0;
    /**
     * Act - do whatever the PieShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Cherries cherry = new Cherries();
    boolean alive = true;
    public void act() 
    {
        //bounceAtEdge();
        if(alive)
        {
            wrapAtEdge();
            turnOnCommand();
            accelOnCommand();
            move(horizontalSpeed, verticalSpeed);
            hitBanana();
            fireOnCommand();
        }
    }    

    public void turnOnCommand()
    {
        if(Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
        }
    }

    public void accelOnCommand()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            int rot=getRotation();
            if(rot == 0)
            {
                horizontalSpeed = horizontalSpeed + 1;
            } else if(rot == 180)
            {
                horizontalSpeed = horizontalSpeed - 1;
            } else if(rot == 270)
            {
                verticalSpeed = verticalSpeed - 1;
            } else if(rot == 90)
            {
                verticalSpeed = verticalSpeed + 1;
            }
        }
    }

    /*
     * A method that bounces at the edge
     */
    public void bounceAtEdge()
    {
        String edge = hitTheEdge();
        if(edge == "top" || edge == "bottom")
        {
            verticalSpeed = verticalSpeed * -1;
        } else if (edge == "left" || edge == "right")
        {
            horizontalSpeed = horizontalSpeed * -1;
        }
    }

    public void hitBanana()
    {
        Actor banana = getOneIntersectingObject(Bananas.class);
        if(banana != null)
        {
            setImage("skull.png");
            setRotation (0);
            alive = false;
 
            // Code Clip 3 ***********************************************************************
            World myWorld = getWorld();                 // Assigns world to myWorld variable.
            GameOver gameover = new GameOver();         // Creates a new GameOver Actor.
            int textX = myWorld.getWidth()/2;           // The x and y coordinates of GameOver actor
            int textY = myWorld.getHeight()/2;          // are half the width and height of screen.
            myWorld.addObject(gameover, textX, textY);  // Places the GameOver actor on screen.
            // ************************************************************************************

        }
    }

    public void fireOnCommand()
    {
        if(Greenfoot.isKeyDown("f"))
        {
            World myWorld = getWorld();
            myWorld.addObject(cherry,0,0);
            cherry.setLocation(getX(), getY());
            cherry.setRotation(getRotation());
        }
    }
}
