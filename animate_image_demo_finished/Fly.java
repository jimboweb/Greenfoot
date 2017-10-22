import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Actor
{
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //Code Clip 1***********************************************************
    //sets a timer variable that will increase every turn
    int timer = 0;
    //**********************************************************************
    
    int rightSideOfScreen;
    int bottomOfScreen;
    
    public void addedToWorld(World water)
    {      
        rightSideOfScreen = water.getWidth() - 1;
        bottomOfScreen = water.getHeight() - 1;
    }
    public void act() 
    {
        move(10);
        
        //Code clip 2 ***********************************************************
        timer++;
        if(timer%6==0)
        {
            setImage("fly_01.png");
        } else if (timer%3==0)
        {
            setImage("fly.png");
        }
        //***********************************************************************
        
        if(Greenfoot.getRandomNumber(20)<2)
        {
            setRotation(Greenfoot.getRandomNumber(359));
        }
        int x = getX();
        int y = getY();
        if(x<=0 || y <= 0 || x >= rightSideOfScreen || y >= bottomOfScreen)
        {
            turn(180);
        }
        
    }    
}
