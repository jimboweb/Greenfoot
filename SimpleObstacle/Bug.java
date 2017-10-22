import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bug extends Actor
{
    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveWASDObstacle(Wall.class);
    }    
        private void moveWASDObstacle(Class obstacle)
    {
        if(Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            move(5);
            if(isTouching(obstacle))
                move(-5);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            move(5);
            if(isTouching(obstacle))
                move(-5);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            move(5);
            if(isTouching(obstacle))
                move(-5);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            move(5);
            if(isTouching(obstacle))
                move(-5);
        }

}
}
