import greenfoot.*;

/**
 * <p>The MoveWithMouse class causes an actor to chase the mouse pointer when the key is pressed
 * and the mouse is moving. Its only argument is the actor that will be moving.</p>
 * 
 * <p>To use the MoveWithMouse class, create a new MoveWithMouse object, using:</p>
 * 
 * <p style = "font-weight: bold">MoveWithMouse mwm = new MoveWithMouse(this);</p>
 * 
 * <p>Then, in your actor's act() method, use the moveWithMouse method, like so:</p>
 * 
 * <p style = "font-weight: bold">mwm.moveWithMouse();</p>
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class MoveWithMouse  
{

    Actor myActor;
    /**
     * Constructor for objects of class MoveWithMouse
     */
    public MoveWithMouse(Actor a)
    {
        myActor = a;
    }

    public void moveWithMouse()
    {
        MouseInfo pointer = Greenfoot.getMouseInfo();
        if(pointer != null)
        {
            int mouseX = pointer.getX();
            int mouseY = pointer.getY();
            myActor.turnTowards(mouseX, mouseY);
            int button = pointer.getButton();
            if(button == 1 && pointer.getActor()==null)
            {
                myActor.move(10);
            }
        }        
    }
}
