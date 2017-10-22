import greenfoot.*;

/**
 * <p>The MoveWithMouse class causes an actor to chase the mouse pointer when the key is pressed
 * and the mouse is moving. Its only argument is the actor that will be moving.</p>
 * 
 * <p>To use the MoveWithMouse class, create a new MoveWithMouse object, using:</p>
 * 
 * <p style = "font-weight: bold">MoveWithMouse mwm = new MoveWithMouse(this);</p>
 * 
 * <p>'mwm' can be anything, it is a variable that represents the MoveWithMouse object.</p>
 * 
 * <p>Then, in your actor's act() method, use the moveWithMouse method, like so:</p>
 * 
 * <p style = "font-weight: bold">mwm.moveWithMouse();</p>
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class MoveWithMouse extends HelperClasses 
{

    Actor myActor;                      //The actor that will move.
    World myWorld;
    /**
     * Constructor for objects of class MoveWithMouse
     */
    public MoveWithMouse(Actor a)      //a is the actor being moved
    {
        myActor = a;                   //Assign a to myActor.
    }

    //This method moves the actor with the mouse. It takes no arguments.
    public void moveWithMouse()
    {
        myWorld = myActor.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            MouseInfo pointer = Greenfoot.getMouseInfo();   //Get the mouse information
            if(pointer != null)                             //If the mouse is on the screen...
            {
                int mouseX = pointer.getX();                //get the mouse x coordinate
                int mouseY = pointer.getY();                //get the mouse y coordinate
                myActor.turnTowards(mouseX, mouseY);        //point towards it
                int button = pointer.getButton();           //get the button
                if(button == 1 && pointer.getActor()==null) //if the button is down and not on the actor
                {
                    myActor.move(10);                       //move 10.
                }
            }        
        }
    }
}
