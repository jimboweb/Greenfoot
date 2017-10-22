import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jellyfish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jellyfish extends Actor
{

    int timer = 0;
    int direction = 1;
    public void act() 
    {
        World myWorld = getWorld();
        int rightSideOfWorld = myWorld.getWidth()-40;
        int leftSideOfWorld = 40;
        timer++;
        if(timer%6 == 0)
        {
            setImage("jellyfish2.gif");
        } else if(timer%3 ==0)
        {
            setImage("jellyfish1.gif");
        }
        setRotation(0);
        if(Greenfoot.getRandomNumber(20)<2||getX()<=leftSideOfWorld||getX()>=rightSideOfWorld)
        {
             direction = direction * -1;
        }
        move(10 * direction);
    }    
}
