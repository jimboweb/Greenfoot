import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A mouse that's smaller than it's supposed to be
 * 
 * @author Jim Stewart
 * @version 1
 */
public class Mouse extends Actor
{
    public Mouse()
    {
         GreenfootImage myImage = getImage();
        int myNewHeight = myImage.getHeight()/2;
        int myNewWidth = myImage.getWidth()/2;
        myImage.scale(myNewWidth, myNewHeight);
       
    }
    
    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }   
}
