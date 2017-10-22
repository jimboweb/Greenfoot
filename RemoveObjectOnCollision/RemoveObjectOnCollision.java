import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RemoveObjectOnCollision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RemoveObjectOnCollision extends Actor
{
    Actor grabber;
    Class targetClass;

    public RemoveObjectOnCollision (Actor a, Class t)
    {
        grabber = a;
        targetClass = t;
        setImage(new GreenfootImage(grabber.getImage().getWidth(), grabber.getImage().getHeight()));
    }
    
    public int removeObjectOnCollision()
    {
        if(getWorld()==null)
        {
            grabber.getWorld().addObject(this, grabber.getX(), grabber.getY());
        }
        setLocation(grabber.getX(), grabber.getY());
        setRotation(grabber.getRotation());
        int objectsRemoved = 0;
        Actor target = getOneIntersectingObject(targetClass);
        if(target!=null)
        {
            objectsRemoved++;
            getWorld().removeObject(target);
        }
        return objectsRemoved;
    }
}
