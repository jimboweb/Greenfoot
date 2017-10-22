import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ninja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ninja extends Actor
{
    MoveWithArrows movewitharrows = new MoveWithArrows(this);
    AnimateImage animateimage = new AnimateImage(this, "player_run1.png", "player_run2.png","player_run3.png");
    /**
     * Act - do whatever the Ninja wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movewitharrows.moveActorWithArrows(5);
        animateimage.animateOnMoveLeftRight();
   }    
}





























