import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * <p>ScoreBoard creates a scoreboard that can be increased, decreased, set and reset. Its basic
 * call requires arguments for the Actor that is calling it, the size of the font, and the x and y
 * start location. For example, to create it in the current world with font size 24
 * at x = 100, y = 20, you would call: </p>
 * 
 * <p style = "font-weight: bold">ScoreBoard sb = new ScoreBoard(this, 24, 100, 20);</p>
 * 
 * <p>Scoreboard automatically adds itself to the world when it is created.</p>
 * 
 * <p>By default the score text is black and the background is white. If you want to set the color of
 * the text and the background, there are two optional Color arguments at the end. For example, to
 * create the ScoreBoard above with white text and black background, type:</p>
 * 
 * <p style = "font-weight: bold">ScoreBoard sb = new ScoreBoard(this, 24, 100, 20, Color.WHITE, Color.BLACK);</p>
 * 
 * <p>To do this you must import java.awt.Color below the import greenfoot.* line on the 
 * class that is calling it. </p>
 * 
 * <p>Scoreboard has several public methods. The two that you will always need to use to make the scoreboard work are
 * the displayScore() method and the increaseScore() method.</p>
 * 
 * <p>displayScore() makes the score actually appear. It needs no arguments. To make it work, simply include the 
 * code:</p>
 * 
 * <p style = "font-weight: bold">sb.displayScore();</p>
 * 
 * <p><strong>increaseScore()</strong> increases the score by 1. When passed with an integer argument it will increase by that amount. For example
 * <strong>increaseScore(5)</strong> will increase the score by 5.</p>
 * 
 * <p><strong>increaseScore()</strong> works with other methods that return the number of objects that have been 
 * collected or removed. For example, if you're using the removeObjectOnCollision method, you can increase the score
 * by 1 for every object that's been removed using the following code:
 * 
 * <p style = "font-weight: bold">sb.increaseScore(rooc.removeObjectOnCollision());</p>
 * 
 * <p>This calls the 'removeObjectOnCollision' class and returns 1 for any object collected to the 'increaseScore' method.
 * When the 1 is returned to the 'increaseScore' method it increases the score by 1. If you want more than one point per
 * object, you can multiply removeObjectOnCollision by how much the score is worth, as in 
 * <strong>rooc.removeObjectOnCollision()*5</strong>.</p>
 * 
 * <p>Other methods that might want to use can get, decrease, set, reset the score, and are as follows:</p>
 * 
 * <p><strong>getScore()</strong> returns the current score. You might use this if you want to see if the score has
 * reached a certain amount. For example if you want something to happen when the player gets 1000 points you might 
 * use the code:</p>
 * 
 * <p style = "font-weight: bold">if(sb.getScore()>=1000)</p>
 * 
 * <p>followed by whatever you want to happen, such as increasing the number of lives the character has. </p>
 * 
 * <p><strong>decreaseScore()</strong> decreases the score by 1. When passed with an integer argument it will decrease by that amount. For example
 * <strong>decreaseScore(5)</strong> will decrease the score by 5. Use this if something makes the character
 * lose points in the game. The score can't go below 0.</p>
 * 
 * <p><strong>resetScore()</strong> resets the score to 0.</p>
 * 
 * <p><strong>setScore(int amount)</strong> sets the score to the given amount. For example, <strong>setScore(100)</strong> sets
 * the score to 100.</p>
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class ScoreBoard extends HelperClasses
{
    Integer score = 0;
    int fontSize;
    Color textColor = Color.BLACK;
    Color bgColor = Color.WHITE;
    int xLocation = 0;
    int yLocation = 0;
    Actor scorer;
    World myWorld;
    
    public ScoreBoard(Actor a, int f, int startX, int startY)
    {
        xLocation = startX;
        yLocation = startY;
        scorer = a;
        fontSize = f;
        update();
    }

    public ScoreBoard(Actor a, int f, int startX, int startY, Color tc, Color bgc)
    {
        xLocation = startX;
        yLocation = startY;
        scorer = a;
        fontSize = f;
        textColor = tc;
        bgColor = bgc;
        update();
    }

    public void displayScore ()
    {
        myWorld = scorer.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            if(getWorld()==null)
            {
                myWorld.addObject(this, xLocation, yLocation);        
                update();
            }
        }
    }

    public void increaseScore ()
    {
        myWorld = scorer.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            score ++;
            update();
        }
    }

    public void increaseScore (int amount)
    {
        myWorld = scorer.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            score += amount;
            if(score<0)
                score = 0;
            update();
        }
    }

    public void decreaseScore()
    {
        myWorld = scorer.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            score --;
            if(score<0)
                score = 0;
            update();
        }
    }

    public void decreaseScore(int amount)
    {
        myWorld = scorer.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            score -=amount;
            if(score<0)
                score = 0;
            update();
        }
    }

    public void resetScore()
    {
        myWorld = scorer.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            score = 0;
            update();
        }
    }

    public void setScore(int amount)
    {
        myWorld = scorer.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            score = amount;
            if(score<0)
                score = 0;
            update();
        }
    }

    public int getScore()
    {
        return score;
    }

    private void update()
    {
        myWorld = scorer.getWorld();
        if(myWorld instanceof ScrollingWorld)
        {
            setImage(new GreenfootImage("Score = " + score, fontSize, textColor, bgColor));        
        }
    }
}
