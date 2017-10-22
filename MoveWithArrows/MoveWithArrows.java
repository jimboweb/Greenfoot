import greenfoot.*;

/**
 * <p>MoveWithArrows class moves the actor you pass it in the direction of the 
 * arrow key you press. It expects an actor argument. If you are calling it
 * from an actor, use the format:</p>
 * 
 * <p style = "font-weight: bold">MoveWithArrows movewitharrows = new MoveWithArrows(this);</p>
 * 
 * <p>To move the actor, call the MoveActorWithArrows method in your act() method, 
 * giving the argument of how fast you want to move. For example, to move
 * 5 cells in the direction you press the arrow key, you would use the format:</p>
 * 
 * <p>'movewitharrows' in lower case is a variable that represents the class.</p>
 * 
 * <p style = "font-weight: bold">movewitharrows.MoveActorWithArrows(5);</p>
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

    public void MoveActorWithArrows(int speed)
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
