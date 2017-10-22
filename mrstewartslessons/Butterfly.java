import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Butterfly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Butterfly extends Actor
{
    //FollowActor followactor;
    MoveRandomly moverandomly= new MoveRandomly(this, Wall.class);
    Actor a;
    public Butterfly (Actor a)
    {
        this.a = a;
        //followactor = new FollowActor(this, a);
    }
    /**
     * Act - do whatever the Butterfly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moverandomly.moveRandomly(4, 25, 30);
        //followactor.followActor(10);
    }    
}
