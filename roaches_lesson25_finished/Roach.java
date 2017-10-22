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
        if(GameOver.isGameOver()==false)      //calls the static isGameOver method to see if the game is over. If it's not...
        {
            if(worldWidth==0)                           //if we don't know how wide the world is
                worldWidth=getWorld().getWidth()-1;     //get the width of the world
            if(worldHeight==0)                          //if we don't know how high the world is
                worldHeight=getWorld().getHeight()-1;   //get the height of the world
            move(5);                                    //move
            turn(Greenfoot.getRandomNumber(90)-45);     //turn from -45 to 45 degrees
            if(Greenfoot.getRandomNumber(100)==1)           //one percent chance
            {
                Roach roach = new Roach();                  //to have a baby roach (digital parthenogenisis!)
                getWorld().addObject(roach, getX(), getY());//and add it to the world
            }
            if(getX()<=1||getX()>=worldWidth||getY()<=1||getY()>=worldHeight)   //if we hit the edge of the world
                turn(180);                                                      //turn around
        }    
    }
}
