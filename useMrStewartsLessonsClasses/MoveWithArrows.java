 
import greenfoot.*;

/**
 * <p>Moves the actor with the arrow keys. It expects the argument of the actor that is moving.</p>
 * 
 * <p>To use MoveWithArrows, create a MoveWithArrows object, using the code:</p>
 * 
 * <p style = "font-weight: bold">MoveWithArrows mwm = new MoveWithArrows(this);</p>
 * 
 * <p>Then, in the actor's Act method, call the moveActorWithArrows method, with the argument
 * of how fast you want the actor to go. For example, to move at speed 10, call:</p>
 * 
 * <p style = "font-weight: bold">mwm.moveActorWithArrows(10);</p>
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class MoveWithArrows  
{

    /**
     * Constructor for objects of class MoveWithArrows
     */
    Actor myActor = null;
    public MoveWithArrows(Actor a)
    {
        myActor = a;
    }

    public void moveActorWithArrows(int speed)
    {
        if(Greenfoot.isKeyDown("right"))
        {
            myActor.setRotation(0);
            myActor.move(speed);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            myActor.setRotation(90);
            myActor.move(speed);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            myActor.setRotation(180);
            myActor.move(speed);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            myActor.setRotation(270);
            myActor.move(speed);
        }
    }
}
