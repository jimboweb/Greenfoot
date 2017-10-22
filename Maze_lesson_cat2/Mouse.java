import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A mouse that's smaller than it's supposed to be
 * 
 * @author Jim Stewart
 * @version 1
 */
public class Mouse extends Actor
{
    GreenfootSound squeak = new GreenfootSound("mousesqueak.wav");
    public Mouse()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = myImage.getHeight()/2;
        int myNewWidth = myImage.getWidth()/2;
        myImage.scale(myNewWidth, myNewHeight);
    }

    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("right")) { 
            setRotation(0); 
            move(5); 
            checkObstacle();
        } 
        if(Greenfoot.isKeyDown("down")) 
        { 
            setRotation(90); 
            move(5); 
            checkObstacle();
        } 
        if(Greenfoot.isKeyDown("left")) 
        { 
            setRotation(180); 
            move(5); 
            checkObstacle();
        } 
        if(Greenfoot.isKeyDown("up")) 
        { 
            setRotation(270); 
            move(5); 
            checkObstacle();
        } 
        Actor cheese = getOneIntersectingObject(Cheese.class);
        if(cheese!=null)
        {
            World myWorld=getWorld();
            myWorld.removeObject(cheese);
            squeak.play();
        }
        wrapAtEdge();
    }   
    public void checkObstacle()
    {
        Actor wall = getOneIntersectingObject(Wall.class);
        if(wall!=null)
        {
            move(-5);
        }
    }
    private void wrapAtEdge()
    {
        World myWorld = getWorld();
        int rightSide = myWorld.getWidth()-1;
        int bottom = myWorld.getHeight()-1;
        int x = getX();
        int y = getY();
        if(x<=0)
        {
            setLocation(rightSide,y);
        }
        if (x>=rightSide)
        {
            setLocation(0,y);
        }
        if (y<=0)
        {
            setLocation(x,bottom);
        }
        if(y>=bottom)
        {
            setLocation(x,0);
        }
    }}
