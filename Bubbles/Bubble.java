import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Bubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends Actor
{
    int deltaX = 3;
    int deltaY = 3;
    GreenfootImage myImage;
    World myWorld;
    BubbleWorld myBW;
    int leftSide;
    int top;
    int rightSide;
    int bottom;
    int myWidth;
    int myHeight;
    public Bubble()
    {
        setImage(new GreenfootImage(100,100));
        myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawOval(0, 0, 100, 100);
        myWidth = myImage.getWidth();
        myHeight = myImage.getHeight();
    }

    public void addedToWorld(World w)
    {
        myWorld = w;
        leftSide = myWidth/2;
        top = myHeight/2;
        rightSide = (myWorld.getWidth() - 1) - myWidth/2;
        bottom = (myWorld.getHeight() - 1) - myHeight/2;
        if (w instanceof BubbleWorld)
            myBW = (BubbleWorld)w;
    }

    /**
     * Act - do whatever the Bubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
        int maxWobbleX = 0;
        int maxWobbleY = 0;
        int wobbleX = 0;
        int wobbleY = 0;
        boolean startWobbling = false;
        setLocation(x + deltaX, y + deltaY);

        if(x<=leftSide && deltaX <0)
        {
            deltaX = deltaX * -1;
            maxWobbleY = deltaY;
            maxWobbleX = -deltaX;
        } 
        if(x>=rightSide && deltaX >0)
        {
            deltaX = deltaX * -1;
            maxWobbleY = deltaY;
            maxWobbleX = -deltaX;
        } 

        if(y<=top && deltaY <0)
        {
            deltaY = deltaY * -1;
            maxWobbleY = -deltaY;
            maxWobbleX = deltaX;
        } 
        if(y>=bottom && deltaY >0)
        {
            deltaY = deltaY * -1;
            maxWobbleY = -deltaY;
            maxWobbleX = deltaX;
        } 
        wobble();
    }    

    public void wobble()
    {
        if(maxWobbleX>0)
        {
            if(startWobbling = true)
            {
                if(wobbleX>0&&wobbleX<maxWobbleX)
                {
                    
                }
            }
        } else if(maxWobbleX<0)
        {

        }
    }
}
