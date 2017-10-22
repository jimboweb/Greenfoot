import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shoe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shoe extends Actor
{
    int pixelsDown=0;
    int counter = 0;
    /**
     * Act - do whatever the Shoe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!GameOver.isGameOver())
        {
            if(counter>0)
                counter++;
            if(counter>5)
            {
                counter=0;
                pixelsDown=0;
            }
            MouseInfo pointer = Greenfoot.getMouseInfo();   //Get the mouse information
            if(pointer != null)                             //If the mouse is on the screen...
            {
                int mouseX = pointer.getX();                //get the mouse x coordinate
                int mouseY = pointer.getY();                //get the mouse y coordinate
                setLocation(mouseX, mouseY+pixelsDown);        //point towards it
                int button = pointer.getButton();           //get the button
                if(button == 1) //if the button is down and not on the actor
                {
                    pixelsDown=30;
                    counter = 1;
                    Actor roach = getOneIntersectingObject(Roach.class);
                    if(roach!=null)
                        getWorld().removeObject(roach);
                }
            }        
        }
    }    
}
