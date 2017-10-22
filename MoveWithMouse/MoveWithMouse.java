import greenfoot.*;

/**
 * Write a description of class MoveWithMouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
