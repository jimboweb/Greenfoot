import greenfoot.*;

/**
 * MoveRandomly is a class that causes an actor to move in a random way. 
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class MoveRandomly  
{
    Actor mover;
    int rightSideOfScreen = 0;
    int bottomOfScreen = 0;
    World myWorld = null;
    int turnFrequency=1;
    int turnWidth =360;
    /**
     * Constructor for objects of class MoveRandomly
     */
    public MoveRandomly(Actor mover)
    {
        this.mover = mover;
        this.myWorld = mover.getWorld();
        this.rightSideOfScreen = myWorld.getWidth()-1;
        this.bottomOfScreen=myWorld.getHeight()-1;
    }

    public void moveRandomly(int speed)
    {
        mover.move(10);
        if(Greenfoot.getRandomNumber(20)==1)
        {
            mover.setRotation(Greenfoot.getRandomNumber(360));
        }
        
        int x = mover.getX();
        int y = mover.getY();
        
        if(x<=0 || y<=0 || x >= rightSideOfScreen || y >= bottomOfScreen)
        {
            mover.turn(180);
        }
    }
    public void moveRandomly(int speed, int turnFrequency, int turnWidth)
    {
        if (turnFrequency<=20)
            this.turnFrequency=turnFrequency;
        if(turnWidth<360)
            this.turnWidth=turnWidth;
        mover.move(10);
        if(Greenfoot.getRandomNumber(20)==1)
        {
            mover.setRotation(Greenfoot.getRandomNumber(360));
        }
        
        int x = mover.getX();
        int y = mover.getY();
        
        if(x<=0 || y<=0 || x >= rightSideOfScreen || y >= bottomOfScreen)
        {
            mover.turn(180);
        }
    }
}
