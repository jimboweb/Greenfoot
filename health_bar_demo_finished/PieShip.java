import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A spaceship flies around and shoots fruit
 * 
 * @author Jim Stewart 
 * @version 0.01
 */
public class PieShip extends SpaceActors
{

    // ************************************************************************
    // Code Clip 5
    boolean touchingBanana = false; //Determines if we've been touching a banana last turn
    // End Code Clip 5
    // ************************************************************************
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
    int score = 0;
    public void act() 
    {
        //bounceAtEdge();
        wrapAtEdge();
        turnOnCommand();
        accelOnCommand();
        move(horizontalSpeed, verticalSpeed);
        hitBanana();
        fireOnCommand();
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
        // ************************************************************************
        // Code Clip 6
        Actor banana = getOneIntersectingObject(Bananas.class);
        if(banana != null)
        {
            if(touchingBanana == false) // If we weren't already touching a banana
            {
                Space space = (Space)getWorld(); // Assign Space world to variable 'space'
                // Then call getHealthCounter variable to access HealthCounter object
                HealthBar healthbar = space.getHealthBar();
                healthbar.loseHealth(); // call the loseHealth method to reduce health
                touchingBanana = true;
                if(healthbar.health<=0)                 //if we are out of health
                {                                       
                    GameOver gameover = new GameOver(); // then show game over screen 
                    space.addObject(gameover, space.getWidth()/2, space.getHeight()/2);
                    space.removeObject(this);         // and remove the PieShip
                }

            } 
        } else {
            touchingBanana = false;
        }
        // End Code Clip 6
        // ************************************************************************
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
