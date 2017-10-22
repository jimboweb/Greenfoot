import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Roach here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Roach extends Actor
{
    int worldWidth = 0;
    int worldHeight=0;
    /**
     * Act - do whatever the Roach wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!GameOver.isGameOver())
        {
            if(worldWidth==0)
                worldWidth=getWorld().getWidth()-1;
            if(worldHeight==0)
                worldHeight=getWorld().getHeight()-1;
            move(5);
            turn(Greenfoot.getRandomNumber(90)-45);
            if(Greenfoot.getRandomNumber(100)==1)
            {
                Roach roach = new Roach();
                getWorld().addObject(roach, getX(), getY());
            }
            if(getX()<=1||getX()>=worldWidth||getY()<=1||getY()>=worldHeight)
                turn(180);
        }    
    }
}
