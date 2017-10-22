import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo pointer = Greenfoot.getMouseInfo();
        if(pointer != null)
        {
            int mouseX = pointer.getX();
            int mouseY = pointer.getY();
            turnTowards(mouseX, mouseY);
            int button = pointer.getButton();
            if(button == 1)
            {
                move(10);
            }
        }
    }    
}
