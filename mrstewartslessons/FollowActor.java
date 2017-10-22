import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
/**
 * <p>FollowActor makes one actor follow another. </p>
 * 
 * <p>The easier constructor of FollowActor requires as arguments an Actor who's the follower and a Class of 
 * actor to follow. This is the easiest way to do it if you have an "opponent" actor and
 * want it to chase the player's actor. (If there is more than one actor of that class, 
 * the follower will follow whichever one that's closest.) 
 * For example, to make your actor chase the player's Mouse class actor, 
 * use the this Class call from the code of the actor who is the follower:</p>
 * 
 * <p style = "font-weight:bold">FollowActor followactor = new FollowActor(this, Mouse.class);</p>
 * 
 * <p>If you want to specify the actor to be followed, rather than just the class of the actor, you can pass an Actor as the second argument instead
 * of the class. You must already have the actor as an object in the class that is calling FollowActor. For example to construct an actor that will chase an 
 * actor with the variable name 'mouse' you can use the following Class call:
 * 
 * <p style = "font-weight:bold">FollowActor followactor = new FollowActor(this, mouse);</p>
 * 
 * <p>To make the actor actually follow, you must call the followActor() method in the actor's act() method, with an argument for how fast you want it
 * to follow. The method is the same regardless of the constructor you used. So to make the actor follow at a speed of 5, you would put the following
 * code in the act() method:</p>
 * 
 * <p style = "font-weight:bold">followactor.followActor(5);</p>
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class FollowActor  
{
    Actor follower;                                 //The actor doing the following
    Actor actorToFollow = null;                     //The actor being followed
    Class classToFollow = null;                     //The class of the actor you want to follow. Used in the first constructor.
    private List<Actor> actorsIMightFollow = null;

    /**
     * Constructor for FollowActor with an Actor argument for the follower and a Class argument for
     * the class of actor to follow. The follower will follow the closest actor of this class. This
     * also works if you only have one actor of that class to follow, for example if you want
     * an actor that will chase the player and the actor doesn't have the player as an object.
     */
    public FollowActor(Actor follower, Class classToFollow)
    {
        this.follower = follower;
        this.classToFollow = classToFollow;
    }

    /**
     * Constructor for FollowActor with two Actor arguments, the follower and the actor being 
     * followed. This works if you already haee the actor that you want to follow as an object
     * in the class calling this method. 
     */
    public FollowActor(Actor follower, Actor actorToFollow)
    {
        this.follower = follower;
        this.actorToFollow = actorToFollow;
    }

    /*
     * followActor method calls for an integer argument for the speed at which we'll follow the actor. 
     */
    public void followActor(int speed)
    {

        if(classToFollow!=null)     //This only happens if you're using the Actor/Class constructor
        {
            actorsIMightFollow = follower.getWorld().getObjects(classToFollow); //Get all the objects of that class.
            actorToFollow = actorsIMightFollow.get(0);                          //Set the actor to follow as the first one.
            if(actorsIMightFollow.size()>1)                                     //If there is more than one actor of that class
            {                                                                   //we will try to find the closest one.
                int minDeltaX = actorToFollow.getX()-follower.getX();           //First find the x distance and the y distance between the 
                int minDeltaY = actorToFollow.getX()-follower.getX();           //current actor to follow & the follower and
                double minDistance = Math.hypot(minDeltaX, minDeltaY);          //find the distance using pythagorean theorem. Set that as minimum distance. 
                for(int i=0;i<actorsIMightFollow.size();i++)                    //Then we'll go through all the other actors.
                {
                    Actor thisActor = actorsIMightFollow.get(i);                //Assign the current actor a variable.
                    int deltaX = thisActor.getX()-follower.getX();              //Get the x distance and the y distance 
                    int deltaY = thisActor.getX()-follower.getX();              //to the follower.
                    double distance = Math.hypot(deltaX, deltaY);               //We'll find the distance using pythagorean theorem.
                    if(distance<minDistance)                                    //If the distance is less than the minimum.
                        actorToFollow = thisActor;                              //set the current actor as the actor to follow.
                }
            }
        }
        if(actorToFollow!=null)                                                     //This should never happen, but if it does let's fail gracefully!
        {
            int x = actorToFollow.getX();                                           //Now we'll get the x and y coordinatges
            int y = actorToFollow.getY();                                           //of the actor to follow
            follower.turnTowards(x, y);                                             //turn towards it
            follower.move(speed);                                                   //and move at whatever speed we were passed in the argument.
        }
    }
}
