import greenfoot.*; 

public class Turtle extends Animal
{
    public void act()
    {
        move(5);
        if(Greenfoot.isKeyDown("left"))
        {
            turn(5);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            turn(-5);
        }
        if(canSee(Lettuce.class))
        {
            eat(Lettuce.class);
        }
    }
}
