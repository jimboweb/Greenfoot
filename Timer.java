import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/**
 * <p>Timer is a class that creates a timer that can be started, paused and reset.</p>
 * 
 * <p>The simple timer simply calls for a timer that automatically shows the time in 
 * seconds, and automatically places itself in the upper left hand of the screen when you. 
 * show the time. To use this constructor, call the following in the start of your world's \
 * class:</p>
 * 
 * <p style = "font-weight:bold">Timer timer = new Timer(this);</p>
 * 
 * <p>A more advanced constructor allows you to place the timer where you want it.  
 * To place the timer at 100,200, call the following in the start of your world's class:</p>
 * 
 * <p style = "font-weight:bold">Timer timer = new Timer(this, 100, 200);</p>
 * 
 * <p>A third constructor also allows you to specify how many decimal places will show.  
 * To place the timer at 100,200, and show two decimal places call the following 
 * in the start of your world's class:</p>
 * 
 * <p style = "font-weight:bold">Timer timer = new Timer(this, 100, 200, 2);</p>
 * 
 * <p>To start the timer, you must use the startTime() method, like so:</p>
 * 
 * <p style = "font-weight:bold">timer.startTime();</p>
 * 
 * <p>To start the time when the game begins, you can place the following code in your
 * world:</p>
 * 
 * <p style = "font-weight:bold">
 * public void started()<br />
 *  {<br />
 *      timer.startTime();<br />
 *  }
 *  </p>
 *  
 * <p>To show the time, you must use the showTime() method, like so:</p>
 * 
 * <p style = "font-weight:bold">timer.showTime();</p>
 * 
 * <p>To pause the timer, you must use the pauseTime() method, like so:</p>
 * 
 * <p style = "font-weight:bold">timer.pauseTime();</p>
 * 
 * <p>To get the time passed, you may use the getTimePassed() method, like so:</p>
 * 
 * <p style = "font-weight:bold">timer.getTimePassed();</p>
 * 
 * <p>To reset the timer, you must use the resetTime() method, like so:</p>
 * 
 * <p style = "font-weight:bold">timer.resetTime();</p>
 * 
 * <p>The clickToStartAndStop() method makes the timer start and pause when clicked, like so:</p>
 * 
 * <p style = "font-weight:bold">timer.clickToStartAndStop();</p>
 * 
 * <p>Other methods are resetTime() which resets the timer to 0, hide(), which hides the timer, and show(),
 * which shows the timer if hidden.</p>
 * 
 * 
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class Timer extends Actor
{
    World myWorld;
    long startTime=0;
    GreenfootImage myImage;
    boolean running = false;
    int places = 0;
    double pauseTime = 0;
    boolean visible = true;
    int x = 60;
    int y = 20;
    public Timer(World myWorld)
    {
        setImage(new GreenfootImage("0", 24, Color.RED, Color.YELLOW));
        myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.drawRect(0,0, myImage.getWidth()-1, myImage.getHeight()-1);
        this.myWorld = myWorld;
    }

    public Timer(World myWorld, int x, int y)
    {
        setImage(new GreenfootImage("0", 24, Color.RED, Color.YELLOW));
        myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.drawRect(0,0, myImage.getWidth()-1, myImage.getHeight()-1);
        this.myWorld = myWorld;
        this.x = x;
        this.y = y;
    }

    public Timer(World myWorld, int x, int y, int places)
    {
        setImage(new GreenfootImage("0", 24, Color.RED, Color.YELLOW));
        myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.drawRect(0,0, myImage.getWidth()-1, myImage.getHeight()-1);
        if(places<0)
            places =0;
        this.x = x;
        this.y = y;
        this.places=places;
        this.myWorld = myWorld;
    }

    public Timer(World myWorld, boolean visible, int places)
    {
        setImage(new GreenfootImage("0", 24, Color.RED, Color.YELLOW));
        myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.drawRect(0,0, myImage.getWidth()-1, myImage.getHeight()-1);
        this.visible = visible;
        this.x = x;
        this.y = y;
        this.places = places;
        this.myWorld = myWorld;
    }
 
    public void startTime()
    {
        startTime = System.nanoTime();
        running = true;
    }

    public double getTimePassed()
    {
        double timePassed = (double)((System.nanoTime()-startTime)/1000000000.0+pauseTime);
        return timePassed;
    }

    public void showTime()
    {
        if(getWorld() == null)
            myWorld.addObject(this, x, y);
        if(running)
        {
            double timePassed=getTimePassed();
            String decFormatString = "#";
            if(places>0)
            {
                decFormatString+=".";
                for(int i=0;i<places;i++)
                {
                    decFormatString+="0";
                }
            }
            DecimalFormat df = new DecimalFormat(decFormatString);
            String timePassedString = df.format(timePassed);
            if(visible)
            {
            setImage(new GreenfootImage(timePassedString, 24, Color.RED, Color.YELLOW));
            myImage = getImage();
            myImage.setColor(Color.RED);
            myImage.drawRect(0,0, myImage.getWidth()-1, myImage.getHeight()-1);
        } else{
            setImage(new GreenfootImage(1,1));
        }
        }

    }

    private double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void pauseTime()
    {
        running = false;
        pauseTime+=getTimePassed();

    }

    public void hide()
    {
        visible = false;
        
    }

    public void show()
    {
        visible = true;
    }

    public void clickToStartAndStop()
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(running)
                pauseTime();
            else
                startTime();
        }
    }

    public void resetTime()
    {
        pauseTime=0;
    }

}
