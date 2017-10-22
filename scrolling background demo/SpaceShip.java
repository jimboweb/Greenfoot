import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A simple SpaceShip that can move up and down.
 * 
 * @author Poul Henriksen
 */
public class SpaceShip extends Actor
{
    public void act() 
    {
        if (Greenfoot.isKeyDown("up") ) {
            setLocation (getX(), getY() - 2);
        }
        if (Greenfoot.isKeyDown("down") ) {
            setLocation (getX(), getY() + 2);
        }
    }    
}
