import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    World myWorld;
    public void addedToWorld(World world)
    {
        myWorld = world;
        setRotation(180);
    }

    public void Cat()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = myImage.getHeight()/3;
        int myNewWidth = myImage.getWidth()/3;
        myImage.scale(myNewWidth, myNewHeight);


    }
    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if(!findWall("front"))
        {
                    move(5);
        } else 
        {
            int rnd = Greenfoot.getRandomNumber(3);
            if(rnd==0)
            {
                turn(90);
            } else if(rnd ==1)
            {
                turn(-90);
            } else 
            {
                turn(180);
            }
        }
        if(!findWall("left"))
        {
            if(Greenfoot.getRandomNumber(20)==0)
            {
                turn(-90);
            }
        }
        if(!findWall("right"))
        {
            if(Greenfoot.getRandomNumber(20)==0)
            {
                turn(90);
            }
        }
        wrapAtEdge();
    }
    public boolean findWall(String direction)
    {
        Actor wall = getOneObjectAtOffset(getXOffset(direction), getYOffset(direction), Wall.class);
        return(wall!=null);
    }
    private int getXOffset(String direction)
    {
        int rotationOffset = 0;
        if(direction == "front")
        {
            rotationOffset =0;
        } else if(direction == "left")
        {
            rotationOffset = -90;
        } else if(direction == "right")
        {
            rotationOffset = 90;
        }
        int dir = getRotation() + rotationOffset;
        return (int)Math.ceil((40*Math.cos(Math.toRadians(dir))));
    }

    private int getYOffset(String direction)
    {
        int rotationOffset = 0;
        if(direction == "front")
        {
            rotationOffset =0;
        } else if(direction == "left")
        {
            rotationOffset = -90;
        } else if(direction == "right")
        {
            rotationOffset = 90;
        }
        int dir = getRotation() + rotationOffset;
        return (int)Math.ceil((40*Math.sin(Math.toRadians(dir))));
    }
    public void randomTurn(int xOffset, int yOffset, int turnDirection)
    {
        Actor wallToSide = getOneObjectAtOffset(xOffset, yOffset, Wall.class);
        if(wallToSide == null)
        {
            if(Greenfoot.getRandomNumber(20)==1)
            {
                turn(turnDirection);
            }
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
    }
}

