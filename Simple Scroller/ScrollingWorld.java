import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class ScrollingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollingWorld extends World
{
    int moverX = 0;             // x & y coords where the player will stay on the screen. normally
    int moverY = 0;             // these will change to 300, 200 or wherever the middle of screen is.
    int scrollX = 0;            // keeps track of how much the screen has scrolled. 
    int scrollY = 0;            // change this to start 
    GreenfootImage scrollingImage;
    GreenfootImage bgImage = new GreenfootImage("bathroom-tile.jpg");
    int bgImageWidth = bgImage.getWidth();
    int bgImageHeight = bgImage.getHeight();
    /**
     * Constructor for objects of class ScrollingWorld.
     * 
     */
    public ScrollingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        scrollingImage = getScrollingImage(800, 600);
        prepare();
    }

    public void moveWorld(Actor mover, int deltaX, int deltaY)
    {

        List<Actor> allActors = getObjects(Actor.class);
        for(Actor a : allActors)
        {
            if(!a.equals(mover))
            {
                a.setLocation(a.getX()+deltaX, a.getY()+deltaY);
            }
        }
    }

    public void scrollAround(Actor mover)
    {
        if(moverX == 0)
        {
            moverX = mover.getX();
            moverY = mover.getY();
        } else if (mover.getX()!=moverX || mover.getY()!=moverY)
        {
            int dX = moverX - mover.getX() ;
            int dY =  moverY - mover.getY();
            moveWorld(mover, dX, dY);
            mover.setLocation(moverX, moverY);
            scrollX += dX;
            scrollY += dY;
            
            if(scrollX>bgImageWidth || scrollX<(-bgImageWidth))
                scrollX = scrollX % bgImage.getWidth() * -1;
            if(scrollY>bgImageHeight || scrollY<(-bgImageHeight))
                scrollY = scrollY % bgImage.getHeight() * -1;
            
            paint(scrollX, scrollY);
        }

    }


 
    /**
     * Paint scrolling image at given position and make sure the rest of
     * the background is also painted with the same image.
     */
    private void paint(int x, int y)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(scrollingImage, x, y);
        bg.drawImage(scrollingImage, x - scrollingImage.getWidth(), y);
        bg.drawImage(scrollingImage, x + scrollingImage.getWidth(), y);
        bg.drawImage(scrollingImage, x, y - scrollingImage.getHeight());
        bg.drawImage(scrollingImage, x, y + scrollingImage.getHeight());
        bg.drawImage(scrollingImage, x - scrollingImage.getWidth(), y - scrollingImage.getHeight());
        bg.drawImage(scrollingImage, x + scrollingImage.getWidth(), y + scrollingImage.getHeight());
        bg.drawImage(scrollingImage, x - scrollingImage.getWidth(), y + scrollingImage.getHeight());
        bg.drawImage(scrollingImage, x + scrollingImage.getWidth(), y - scrollingImage.getHeight());
    }
 
    /**
     * Returns an image with the given dimensions.
     */
    private GreenfootImage getScrollingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x, y);
            }
        }
        return image;
    } 
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);

        fish fish = new fish();
        addObject(fish, 396, 85);
        redbug redbug = new redbug();
        addObject(redbug, 82, 308);
    }



    public void act()
    {
    }
}
