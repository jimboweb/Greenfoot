import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldBuggy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldBuggy extends Vehicle
{
    /**
     * Act - do whatever the GoldBuggy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score = 0;
    public void act() 
    {
        move(10);
        keyTurn();
        getGold();
        getSmiley();

    }    

    private void keyTurn()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            turn(10);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-10);
        }

    }

    private void getGold()
    {
        if(isTouching(Gold.class))
        {
            Greenfoot.playSound("gotcha.wav");
            get(Gold.class);
            score++;
        }

    }
    private void getSmiley()
    {
        if(isTouching(Smiley.class))
        {
            Greenfoot.playSound("gotcha.wav");
            get(Smiley.class);
            score +=5;
            makeSmiley();
        }

    }
    
    private void makeSmiley()
    {
        Smiley newSmiley = new Smiley();
        World myWorld = getWorld();
        int x = Greenfoot.getRandomNumber(myWorld.getWidth());
        int y = Greenfoot.getRandomNumber(myWorld.getHeight());
        myWorld.addObject(newSmiley, x, y);
    }
}
