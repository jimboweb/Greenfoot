import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private GreenfootImage myImage = getImage();
    private String[] imageNames = {"player_run1.png","player_run2.png","player_run3.png"};
    private int currentImage = 0;
    int xPos;
    int yPos;
    public void addedToWorld(World w)
    {
        xPos = getX();
        yPos = getY();
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-10);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+10);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-10, getY());
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+10, getY());
        }
        animateOnMove();
    }    

    private void animateOnMove()
    {   if(getX()!=xPos|| getY()!=yPos)
        {
            currentImage++;
            if(currentImage >= imageNames.length)
                currentImage=0;
            GreenfootImage newImage = new GreenfootImage(imageNames[currentImage]);
            if(getX()<xPos)
                newImage.mirrorHorizontally();
            setImage(newImage);
            myImage = getImage();
        }
        xPos=getX();
        yPos=getY();

    }
}
