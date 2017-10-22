import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Link here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Link extends Actor
{
    MoveWithArrows movewitharrows = new MoveWithArrows(this);
    AnimateImage ai = new AnimateImage(this, "link1.png", "link2.png","link3.png");
    /**
     * Act - do whatever the Link wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movewitharrows.moveActorWithArrows(5);
        ai.animateOnMoveLeftRight();
    }    
}
