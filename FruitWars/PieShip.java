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
    Cherries cherries = new Cherries();
    /**
     * Act - do whatever the PieShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //bounceAtEdge();
        wrapAtEdge();
        turnOnCommand();
        accelOnCommand();
        move(horizontalSpeed, verticalSpeed);
        hitBananas();
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
    
    /*
     * Makes the ship disappear if you hit the bananas
     */
    public void hitBananas()
    {
        Actor bananas = getOneIntersectingObject(Bananas.class);
        if(bananas != null)
        {
            World myWorld = getWorld();
            myWorld.removeObject(this);
        }
    }
    public void fireOnCommand()
    {
        if(Greenfoot.isKeyDown("f"))
        {
            World myWorld = getWorld();
            myWorld.addObject(cherries, 0, 0);
            cherries.setLocation(getX(), getY());
            cherries.setRotation(getRotation());
        }
    }
}