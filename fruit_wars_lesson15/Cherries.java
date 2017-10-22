import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cherries here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cherries extends SpaceActors
{
   /**
     * Act - do whatever the Cherries wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        Actor banana = getOneIntersectingObject(Bananas.class);
        if(banana!=null)
        {
            World myWorld = getWorld();
            myWorld.removeObject(banana);
            Space space = (Space)myWorld;
            Counter counter = space.getCounter();
            counter.addScore();
            myWorld.removeObject(this);
        } else if(hitTheEdge()!=null)
        {
            World myWorld = getWorld();
            Actor mySelf = this;
            myWorld.removeObject(mySelf);
        }
    }

}
