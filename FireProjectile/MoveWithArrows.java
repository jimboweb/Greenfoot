import greenfoot.*;

/**
 * Moves the actor with the arrow keys. Expects argument Actor a. 
 * Contains MoveActorWithArrows method, expecting argument int speed.
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
