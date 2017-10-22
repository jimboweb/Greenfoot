import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceActors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceActors extends Actor
{
    /**
     * Act - do whatever the SpaceActors wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
