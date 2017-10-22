import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A spaceship flies around and shoots fruit
 * 
 * @author Jim Stewart 
 * @version 0.01
 */
public class PieShip extends SpaceActors
{
    boolean touchingBanana = false;
    /*
     * The vertical and horizontal speed
     * of the ships
     */
    private int horizontalSpeed = 0;
    private int verticalSpeed = 0;
    int score = 0;

    /**
     * Act - do whatever the PieShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Cherries[] cherries = new Cherries[3];
    public PieShip()
    {
        for(int i=0; i<cherries.length; i++)
        {
            cherries[i] = new Cherries();
        }
    }

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
        Actor banana = getOneIntersectingObject(Bananas.class);
        if(banana != null)
        {
            World myWorld = getWorld();
            Space space = (Space)myWorld;
            HealthBar healthbar = space.getHealthBar();
            if(touchingBanana == false)
            {
                healthbar.loseHealth();
                touchingBanana = true;
                if(healthbar.health <=0)
                {
                    GameOver gameover = new GameOver();
                    myWorld.addObject(gameover, myWorld.getWidth()/2, myWorld.getHeight()/2);
                    myWorld.removeObject(this);

                }
            }

        } else {
            touchingBanana = false;
        }
    }

    public void fireOnCommand()
    {
        if(Greenfoot.isKeyDown("f"))
        {
            World myWorld = getWorld();
            for (int i=0; i<cherries.length; i++)
            {
                if(cherries[i].getWorld()==null)
                {
                    myWorld.addObject(cherries[i],0,0);
                    cherries[i].setLocation(getX(), getY());
                    cherries[i].setRotation(getRotation());
                    break;
                }
            }
        }
    }
}
