import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int deltaX;
    float deltaY;
    float gravity = 0.1f;
    boolean inTheAir;
    int halfHeight = getImage().getHeight()/2;
    int ground;
    int jumpSpeed = 5;
    int runSpeed = 1;
    public void addedToWorld(World w)
    {
        ground = w.getHeight();
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(checkForLanding()==false)
        {
            fall();
            bounceOffSide();
            bounceOffTop();
        } else {
            deltaY = 0;
            getKey();
        }
        move();
    }    

    private void fall()
    {
        if(deltaY<3)
            deltaY+=gravity;
    }

    private void move()
    {
        int newX = getX() + deltaX;
        float newY = getY() + deltaY;
        setLocation(newX, (int)newY);
    }

    private boolean groundBelow()
    {
        return getY()>ground-halfHeight;
    }

    private boolean checkForLanding()
    {
        return (groundBelow()||platformBelow())&&deltaY>0;
    }
    
    private void getKey()
    {
        if(Greenfoot.isKeyDown("right"))
            deltaX = runSpeed;
        else if(Greenfoot.isKeyDown("left"))
            deltaX = -runSpeed;
        else
            deltaX = 0;
            
        if(Greenfoot.isKeyDown("space"))
            deltaY -= jumpSpeed;
   }
   
   public boolean platformBelow()
   {
       return getOneObjectAtOffset(0, (halfHeight+5), Platform.class)!=null;
    }
  

   public void bounceOffSide()
   {
        Actor collidePlatform = getOneIntersectingObject(Platform.class);   
        if(collidePlatform!=null)
        {
            float collideDirection = Math.signum(collidePlatform.getX()-getX());
            if(collideDirection == Math.signum(deltaX))
                deltaX*=-1;
        }
   }
   
   public void bounceOffTop()
   {
        Actor topPlatform = getOneObjectAtOffset(0, -(groundHeight+5), Platform.class);
        if(
        topPlatform!=null
        && deltaY<0
        )
        {
            deltaY*=-1;
        }       
   }
}
