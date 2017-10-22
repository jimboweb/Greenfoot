import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * <p>ScoreBoard creates a scoreboard that can be increased, decreased, set and reset. Its basic
 * call requires arguments for the World it will be in, the size of the font, and the x and y
 * start location. For example, to create it in the current world with font size 24
 * at x = 100, y = 200, you would call: </p>
 * <p style = "font-weight: bold">ScoreBoard sb = new ScoreBoard(getWorld(), 24, 100, 200);</p>
 * 
 * <p>Scoreboard automatically adds itself to the world when it is created. It will not work if you
 * try to create it with an actor before it's added to the world, for example at the beginning of
 * the class. It can be created in the addedToWorld method. </p>
 * 
 * <p>By default the score text is black and the background is white. If you want to set the color of
 * the text and the background, there are two optional Color arguments at the end. For example, to
 * create the ScoreBoard above with white text and black background, type:</p>
 * 
 * <p style = "font-weight: bold">ScoreBoard sb = new ScoreBoard(getWorld(), 24, 100, 200, Color.WHITE, Color.BLACK);</p>
 * 
 * <p>To do this you must import java.awt.Color below the import greenfoot.* line on the 
 * class that is calling it. </p>
 * 
 * <p>Scoreboard has the following public methods:</p>
 * 
 * <p><strong>increaseScore()</strong> increases the score by 1. When passed with an integer argument it will increase by that amount. For example
 * <strong>increaseScore(5)</strong> will increase the score by 5.</p>
 * 
 * <p><strong>decreaseScore()</strong> increases the score by 1. When passed with an integer argument it will decrease by that amount. For example
 * <strong>decreaseScore(5)</strong> will decrease the score by 5. The score can't go below 0.</p>
 * 
 * <p><strong>resetScore()</strong> resets the score to 0.</p>
 * 
 * <p><strong>setScore(int amount)</strong> sets the score to the given amount. For example, <strong>setScore(100)</strong> sets
 * the score to 100.</p>
 * 
 * <p><strong>getScore()</strong> returns the current score.</p>
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    Integer score = 0;
    int fontSize;
    Color textColor = Color.BLACK;
    Color bgColor = Color.WHITE;
    public ScoreBoard(World w, int f, int startX, int startY)
    {
        w.addObject(this, startX, startY);        
        fontSize = f;
        update();
    }

    public ScoreBoard(World w, int f, int startX, int startY, Color tc, Color bgc)
    {
         w.addObject(this, startX, startY);        
        fontSize = f;
        textColor = tc;
        bgColor = bgc;
        update();
    }
    
    public void increaseScore ()
    {
        score ++;
        update();
    }
    
    public void increaseScore (int amount)
    {
        score += amount;
        update();
    }
    
    public void decreaseScore()
    {
        score --;
        if(score<0)
            score = 0;
        update();
        
    }
    
    public void decreaseScore(int amount)
    {
        score -=amount;
        if(score<0)
            score = 0;
        update();
    }
    
    public void resetScore()
    {
        score = 0;
        update();
    }
    
    public void setScore(int amount)
    {
        score = amount;
        if(score<0)
            score = 0;
        update();
    }
    
    public int getScore()
    {
        return score;
    }

    private void update()
    {
         setImage(new GreenfootImage("Score = " + score, fontSize, textColor, bgColor));        
    }
}
