import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformOpponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformOpponent extends Actor
{
    int speed = 3;
    int imageHeight = getImage().getHeight();
    int imageWidth = getImage().getWidth();
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
            if(!checkForPlatform(-1)) {
                speed = Math.abs(speed);
            }
            if(!checkForPlatform(1)) {
                speed = Math.abs(speed) * -1;   
            }            
            if(Greenfoot.getRandomNumber(100)==5)
            {
            speed = speed * -1;
            }
             
        }

Actor player = getOneIntersectingObject(PlatformJumper.class); //Try to touch a player
if(player!=null) //If there is a player
    {
        int playerHeight = player.getY(); //get the height of the player
        int opponentTop = getY()-20; //Get the height of the top of the opponent
        if(playerHeight<opponentTop) //If the player's height is above the top of the opponent
            {
                 getWorld().removeObject(this); //Remove the opponent
            } else { //Otherwise
                 getWorld().removeObject(player); //Remove the player
                 StaticText st = new StaticText(getWorld(), "Game Over!"); // and say the game is over
            }
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
