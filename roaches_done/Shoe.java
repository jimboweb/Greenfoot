import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shoe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shoe extends Actor
{
    int pixelsDown=0;           //this will be set to 30 when it's time to 'stomp'
    int counter = 0;            //counts the time the shoe will be down when you stomp
    int stompDepth = 30;        //this will be how far you stomp
    int stompTime = 5;          //this will be how long you stomp for
    /**
     * Act - do whatever the Shoe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!GameOver.isGameOver())
        {
            if(counter>0)               //if the shoe was down
                counter++;              //count another turn
            if(counter>stompTime)               //if it's been down for five turns
            {
                counter=0;              //reset the counter
                pixelsDown=0;           //and move the shoe back up
            }
            MouseInfo pointer = Greenfoot.getMouseInfo();   //Get the mouse information
            if(pointer != null)                             //If the mouse is on the screen...
            {
                int mouseX = pointer.getX();                //get the mouse x coordinate
                int mouseY = pointer.getY();                //get the mouse y coordinate
                setLocation(mouseX, mouseY+pixelsDown);        //move to mouse location plus the depth of the stomp if you're stomping
                int button = pointer.getButton();           //get the button
                if(button == 1) //if the button is down and not on the actor
                {
                    pixelsDown=stompDepth;      //stomp the shoe down
                    counter = 1;                //start counting
                    Actor roach = getOneIntersectingObject(Roach.class);        //look for a roach
                    if(roach!=null)                                             //if one is there
                        getWorld().removeObject(roach);                         //squish it
                }
            }
            if(countRoaches()==0)
            {
                GameOver.endGame();
                
            } else if (countRoaches()>100)
            {
                GameOver.endGame();
                
            }
        }    
    }

    private int countRoaches()
    {
        World myWorld = getWorld();
        int numberOfRoaches = myWorld.getObjects(Roach.class).size();
        return numberOfRoaches;
    }
}






