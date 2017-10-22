import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * <p>RemoveObjectOnCollision removes an object of a certain class, called the
 * 'targetClass' when an actor, or the 'grabber' moves onto it. It also returns the
 * number of objects being removed to the grabber. It calls for two arguments,
 * the Actor that is doing the grabbing, and the Class of the thing to be 
 * grabbed. For example, an actor that wants to grab an actor of the class
 * Star could create it using the method:</p>
 * 
 * <p style = "font-weight:bold">RemoveObjectOnCollision rooc = new RemoveObjectOnCollision(this, Star.class);</p>
 * 
 * <p>'rooc' can be anything. It is a variable name that represents the RemoveObjectOnCollision object.<p>
 * 
 * <p>In the actor's act() method, you would include the code:</p>
 * 
 * <p style = "font-weight:bold">rooc.removeObjectOnCollision()</p>
 * 
 * <p>This will remove the object, but not return anything. If you want to add one to a variable called 'score' every time
 * you grab an object, you could instead write:</p>
 * 
 * <p style = "font-weight:bold">score += rooc.removeObjectOnCollision()</p>
 * 
 * <p>This will remove the object and add to the score both.</p>
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class RemoveObjectOnCollision extends Actor
{
    Actor grabber;                              //The Actor that will grab or remove the object.
    Class targetClass;                          //The class of the object that will be removed.
    public RemoveObjectOnCollision(Actor a, Class t)
    {
        grabber = a;                            //Assign the grabber variable
        targetClass = t;                        //Assign the actor variable
        setImage(new GreenfootImage(grabber.getImage().getWidth(), grabber.getImage().getHeight()));    //Make the RemoveObjectOnCollision actor the same size as the grabber
    }

    public int removeObjectOnCollision()        //Gets the object if it is touching the grabber.
    {
        if(getWorld()==null)                                                        //If we this actor is not yet in the world 
        {
            grabber.getWorld().addObject(this, grabber.getX(),grabber.getY());      //then put it in the world.
        }
        setLocation(grabber.getX(), grabber.getY());            //Put the RemoveObjectOnCollision actor where the grabber actor is
        setRotation(grabber.getRotation());                     //and rotates it to face the same direction. 
        int objectsRemoved = 0;                                 //Sets the variable for the objects removed this turn.
        Actor target = getOneIntersectingObject(targetClass);   //Gets an object of the target class if we're touching it.
        if(target!=null)                                        //If we got something...
        {
            objectsRemoved++;                                   //add 1 to the objectsRemoved variable
            getWorld().removeObject(target);                    //and remove the object from the world. 
        }
        return objectsRemoved;                                  //return the number of objects removed, 1 or 0. 
    }
}
