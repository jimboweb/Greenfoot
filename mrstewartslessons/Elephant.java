import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    MoveWithArrows mwa = new MoveWithArrows(this);
    AnimateImage ai = new AnimateImage(this, 100, "elephant.png", "elephant2.png");
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ai.animateAlways();
        mwa.moveActorWithArrows(5);
    }    
}
