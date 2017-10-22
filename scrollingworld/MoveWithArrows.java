
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
public class MoveWithArrows extends HelperClasses
{

    /**
     * Constructor for objects of class MoveWithArrows
     */
    Actor myActor = null;           //This will be the actor that is being moved
    World myWorld;
    public MoveWithArrows(Actor a)
    {
        myActor = a;                //Assign the actor being moved
    }

    public void moveActorWithArrows(int speed)      //'speed' is how fast you're going
    {
        myWorld = myActor.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            if(Greenfoot.isKeyDown("right"))        //If they're pressing the right key
            {
                myActor.setRotation(0);             //turn right
                myActor.move(speed);                //and move speed cells or pixels.
            }
            if(Greenfoot.isKeyDown("down"))         //If they're pressing the down key
            {
                myActor.setRotation(90);            //turn down
                myActor.move(speed);                //and move speed cells or pixels.
            }
            if(Greenfoot.isKeyDown("left"))         //If they're pressing the left key
            {
                myActor.setRotation(180);           //turn left
                myActor.move(speed);                //and move speed cells or pixels.
            }
            if(Greenfoot.isKeyDown("up"))           //If they're pressing the up key
            {
                myActor.setRotation(270);           //turn up
                myActor.move(speed);                //and move speed cells or pixels.
            }
        }
    }
}
