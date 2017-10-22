import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Man extends Actor
{
    int runSpeed=1;
    float gravity = 0.1f;
    int jumpSpeed = 5;
    float deltaX;
    float deltaY;
    float floatX;
    float floatY;
    boolean inTheAir;
    int groundHeight=getImage().getHeight()/2;
    int ground;
    public void addedToWorld(World w)
    {
        ground = w.getHeight();
    }

    /**
     * Act - do whatever the Man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        inTheAir = checkForLanding();
        if(inTheAir)
        {
            fall();
            bounceOffSide();
            bounceOffTop();
        } else {
            land();
            getKey();
        }
        move();
    }  

    public boolean checkForLanding()
    {
        if(
        (
            bricksBelow()
            ||groundBelow()
        )
        && falling()
        )
        {
            return false;
        }else{
            return true;
        }
    }

    public boolean bricksBelow()
    {
        return getOneObjectAtOffset(0, (groundHeight+5), Bricks.class)!=null;
    }

    public boolean groundBelow()
    {
        return getY()>ground-groundHeight;
    }

    public boolean falling()
    {
        return deltaY>0;
    }

    public void land()
    {
        deltaY=0;
    }

    public void move()
    {
        floatX=getX()+deltaX;
        floatY=getY()+deltaY;
        setLocation((int)floatX,(int)floatY);        
    }

    public void fall()
    {      
        if(deltaY<3)
        {
            deltaY+=gravity;
        } 
    }

    public void getKey()
    {
        if(Greenfoot.isKeyDown("right"))
            deltaX=runSpeed;
        else if(Greenfoot.isKeyDown("left"))
            deltaX=-runSpeed;
        else
            deltaX=0;

        if(Greenfoot.isKeyDown("up"))
            deltaY=-jumpSpeed;
    }

    public void bounceOffSide()
    {
        Actor collidePlatform = getOneIntersectingObject(Bricks.class);
        if(collidePlatform!=null)
        {
            if(
            collidePlatform.getX()<getX()
            && deltaX<0
            )
                deltaX*=-1;
            else if (
            collidePlatform.getX()>getX()
            && deltaX>0
            )
                deltaX*=-1;
        }
    }

    public void bounceOffTop()
    {
        Actor topPlatform = getOneObjectAtOffset(0, -(groundHeight+5), Bricks.class);
        if(
        topPlatform!=null
        && deltaY<0
        )
        {
            deltaY*=-1;
        }
    }
    }
