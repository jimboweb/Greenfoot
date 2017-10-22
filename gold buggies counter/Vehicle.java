import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vehicle extends Actor
{
   
    public boolean offTheMap()
        {
            if(getX() < 10 || getX() > getWorld().getWidth() - 10)
                return true;
            if(getY() < 10 || getY() > getWorld().getHeight() - 10)
                return true;
            else
                return false;
        }
    public boolean isTouching(Class clss)
        {
            Actor actor = getOneObjectAtOffset(5, 5, clss);
            return actor != null;        
        }
    public void get(Class clss)
        {
            Actor actor = getOneObjectAtOffset(0, 0, clss);
            if(actor != null) {
                getWorld().removeObject(actor);
                GoldBuggyWorld myWorld = (GoldBuggyWorld)getWorld();
                ScoreCounter counter = myWorld.getCounter();
                counter.score++;

            }
        }


}
