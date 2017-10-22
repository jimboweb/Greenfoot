import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Actor
{
    int speed;
    Class obstacle;
    
    public Mover(Class obstacle)
    {
        this.speed = 5;
        this.obstacle = obstacle;
    }
    
    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveWASD();
    }    

    private void moveWASD()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            setRotation(270);
            obstacleMove();
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setRotation(180);
            obstacleMove();
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setRotation(90);
            obstacleMove();
        }
        if(Greenfoot.isKeyDown("d"))
        {
            setRotation(0);
            obstacleMove();
        }
    }
    private void obstacleMove()
    {
        move(speed);
        if(isTouching(obstacle))
            move(-speed);
    }
}
