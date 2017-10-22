import greenfoot.*;

/**
 * Write a description of class RemoveObjectOnCollision here.
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class RemoveObjectOnCollision  
{
    Actor grabber;
    Class targetClass;
    World myWorld;
    /**
     * Constructor for objects of class RemoveObjectOnCollision
     */
    public RemoveObjectOnCollision(Actor g, Class t)
    {
        grabber = g;
        targetClass = t;
    }
    
    public int removeObjectOnCollision()
    {
        int objectsRemoved = 0;
        myWorld = grabber.getWorld();
        int grabberRotation = grabber.getRotation();
        int grabberHalfWidth = grabber.getImage().getWidth()/2;
        int grabberHalfHeight = grabber.getImage().getHeight()/2;
        int grabberRealWidth = (int)(grabberHalfWidth*Math.abs(Math.cos(Math.toRadians(grabberRotation))) + grabberHalfHeight*Math.abs(Math.sin(Math.toRadians(grabberRotation))));
        int grabberRealHeight = (int)(grabberHalfWidth*Math.abs(Math.sin(Math.toRadians(grabberRotation))) + grabberHalfHeight*Math.abs(Math.cos(Math.toRadians(grabberRotation))));
        for(int i=0; i<myWorld.getObjects(Target.class).size(); i++)
        {
            Actor thisTarget = (Actor)myWorld.getObjects(targetClass).get(i);
            int thisTargetXMin = thisTarget.getX();
            int thisTargetXMax = thisTarget.getX();
            int thisTargetYMin = thisTarget.getY();
            int thisTargetYMax = thisTarget.getY();
            int grabberXMin = grabber.getX() - grabberRealWidth;
            int grabberXMax = grabber.getX() + grabberRealWidth;
            int grabberYMin = grabber.getY() - grabberRealHeight;
            int grabberYMax = grabber.getY() + grabberRealHeight;
            if(grabberXMax>thisTargetXMin && grabberXMin < thisTargetXMax && grabberYMax>thisTargetYMin && grabberYMin <thisTargetYMax)
            {
                myWorld.removeObject(thisTarget);
                objectsRemoved++;
            }
        }
        return objectsRemoved;
    }

}
