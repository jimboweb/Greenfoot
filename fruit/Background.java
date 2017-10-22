import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    int count = 0;
    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }

    public void act()
    {
        count++;
        if(count%100 == 0)
        {
            dropFruit();
        }
        
    }

    public void dropFruit()
    {
        int fruitNumber = Greenfoot.getRandomNumber(4);
        int xCoord = Greenfoot.getRandomNumber(getWidth());
        switch(fruitNumber) {
            case 0: Grapes grapes = new Grapes();
            addObject(grapes, xCoord, 0);
            break;
            case 1: Apple apple = new Apple();
            addObject(apple, xCoord, 0);
            break;
            case 2: Banana banana = new Banana();
            addObject(banana, xCoord, 0);
            break;
            case 3: Cherry cherry = new Cherry();
            addObject(cherry, xCoord, 0);
            break;
        }
    }
}