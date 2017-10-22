import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Actor
{
    World myWorld;
    public void addedToWorld(World thisWorld)
    {
        GreenfootImage myImage = getImage();
        int myHeight = myImage.getHeight()/2;
        int myWidth = myImage.getWidth()/2;
        myImage.scale(myWidth, myHeight);
        myWorld = thisWorld;
    }
    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getMoveCommand();
        getCheese();
    }   

    public void getMoveCommand()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move("left");
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move("right");
        }
        if(Greenfoot.isKeyDown("up"))
        {
            move("up");
        }
        if(Greenfoot.isKeyDown("down"))
        {
            move("down");
        }
    }

    public void move(String direction)
    {
        if(direction=="left")
        {
            setRotation(180);
            move(5);
            checkObstacle();
        }
        if(direction=="right")
        {
            setRotation(0);
            move(5);
            checkObstacle();
        }
        if(direction=="up")
        {
            setRotation(270);
            move(5);
            checkObstacle();
        }
        if(direction=="down")
        {
            setRotation(90);
            move(5);
            checkObstacle();
        }
    }

    public void checkObstacle()
    {
        Actor wallInTheWay = getOneIntersectingObject(Wall.class);
        if(wallInTheWay!=null)
        {
            move(-5);
        }
    }
    public void getCheese()
    {
        Actor cheese = getOneIntersectingObject(Cheese.class);
        if(cheese!=null)
        {
            myWorld.removeObject(cheese);
        }
    }
}
