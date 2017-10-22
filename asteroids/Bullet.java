import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
        checkEdge();
    }    

    public void checkEdge()
    {
            int myX = getX();
            int myY = getY();
            World myWorld = getWorld();
            int width = myWorld.getWidth()-5;
            int height = myWorld.getHeight()-5;
            Actor mySelf = this;
            if(myX<=0 || myX >= width || myY <= 0 || myY >= height)
            {
                myWorld.removeObject(mySelf);
            }


    }
}