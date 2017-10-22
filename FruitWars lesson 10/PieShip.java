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
    public void act() 
    {
        //bounceAtEdge();
        wrapAtEdge();
        turnOnCommand();
        accelOnCommand();
        move(horizontalSpeed, verticalSpeed);
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
     * A modified version of the move command
     * allowing an actor to "drift" while it turns
     */
    public void move(int changeX, int changeY)
    {
        int x = getX();
        int y = getY();
        int newX = x + changeX;
        int newY = y + changeY;
        setLocation(newX, newY);
    }

    /*
     * A method that tells if I hit the edge and what edge I hit
     */
    public String hitTheEdge()
    {
        int x = getX();
        int y = getY();
        World myWorld = getWorld();
        int rightSide = myWorld.getWidth() - 1;
        int bottomSide = myWorld.getHeight() - 1;
        if(y == 0)
        {
            return "top";
        } else if (x == 0)
        {
            return "left";
        } else if(x == rightSide){
            return "right";
        } else if(y == bottomSide)
        {
            return "bottom";
        } else {
            return null;
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
     * A method that wraps at the edge
     */
    public void wrapAtEdge()
    {
        String edge = hitTheEdge();
        int x = getX();
        int y = getY();
        World myWorld = getWorld();
        int rightSide = myWorld.getWidth() - 1;
        int bottomSide = myWorld.getHeight() - 1;
        if(edge == "bottom")
        {
            setLocation(x, 0);
        } else if(edge == "top")
        {
            setLocation(x, bottomSide);
        } else if(edge == "left")
        {
            setLocation(rightSide, y);
        } else if(edge == "right")
        {
            setLocation(0, y);
        }
    }

}
