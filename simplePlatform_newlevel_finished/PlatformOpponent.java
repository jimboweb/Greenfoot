import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformOpponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformOpponent extends Actor
{
    int speed = 1;
    int imageHeight = getImage().getHeight();
    int imageWidth = getImage().getWidth();
    int worldWidth;
    int worldHeight;
    World myWorld;
    public void addedToWorld(World w)
    {
        myWorld = w;
        worldWidth = w.getWidth();
        worldHeight = w.getHeight();
    }
    /**
     * Act - do whatever the PlatformOpponent wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(checkForPlatform(0)==false)
        {
            setLocation(getX(), getY()+5);
        } else {
            setLocation(getX()+speed,getY());        
            if(Greenfoot.getRandomNumber(100)==5)
            {
            speed = speed * -1;
            }
        }
        
        if(getX()<imageWidth/2 || getX()>worldWidth-imageWidth/2)
            speed*=-1;
        /*
        if(getY()>worldHeight-imageHeight/2)
            setLocation(Greenfoot.getRandomNumber(worldWidth),0);
        */
        Actor player = getOneIntersectingObject(PlatformJumper.class);
        if(player!=null)
        {
            int playerHeight = player.getY();
            int opponentTop = getY()-20;
            if(playerHeight<opponentTop)
            {
                getWorld().removeObject(this);
            } else {
                getWorld().removeObject(player);
                StaticText st = new StaticText(getWorld(), "Game Over!"); 
            }
        }
    } 

    private void turnAtEdge()
    {
            if(!checkForPlatform(-1)) {
                speed = Math.abs(speed);
            }
            if(!checkForPlatform(1)) {
                speed = Math.abs(speed) * -1;   
            }            

    }
    private boolean checkForPlatform(int xDirection)
    {
        int xOffset = (imageWidth/2+5)*xDirection;
        int yOffset = (imageHeight/2+5);
        Actor platform = getOneObjectAtOffset(xOffset, yOffset, Platform.class);
        return platform!=null;
    }
    

}
