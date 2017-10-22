import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MoveWithArrows moves an actor with the arrow keys. To use:
 *  -- Include class in your Greenfoot project
 *  -- At the beginning of your actor class type:
 *          MoveWithArrows mwa = new MoveWithArrows;
 *  -- In your act method type:
 *          MoveWithArrows.MoveWithArrows(this, Int speed);
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class MoveWithArrows  
{
    // instance variables - replace the example below with your own
 
    /**
     * Constructor for objects of class MoveWithArrows
     */
    Actor myActor=null;
    int speed = 0;

    public MoveWithArrows(Actor a, int s)
    {
        myActor = a;
        speed = s;
    }

    public void moveWithArrows(){
        if(Greenfoot.isKeyDown("up"))
        {
            myActor.setRotation(270);
            myActor.move(speed);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            myActor.setRotation(90);
            myActor.move(speed);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            myActor.setRotation(0);
            myActor.move(speed);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            myActor.setRotation(180);
            myActor.move(speed);
        }
    }
}

