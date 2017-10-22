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
    int moverX = 0;
    int moverY = 0;
    GreenfootImage scrollingImage;
    GreenfootImage bgImage = new GreenfootImage("bigWorldMap.png");
    int bgImageWidth = bgImage.getWidth();
    int bgImageHeight = bgImage.getHeight();
    int mapHeight = bgImage.getWidth();
    int mapWidth = bgImage.getHeight();
    int screenWidth = getWidth();
    int screenHeight = getHeight();
    int scrollX = screenWidth/2 + 100;
    int scrollY = screenHeight/2 + 100;
    /**
     * Constructor for objects of class ScrollingWorld.
     * 
     */
    public ScrollingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        Lobster lobster = new Lobster();
        addObject(lobster, getWidth()/2, getHeight()/2);
        //scrollingImage = getScrollingImage(773, 544);
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
            int dX = 0;
            int dY = 0;
            if(scrollX > screenWidth / 2 && scrollX < mapWidth - screenWidth/2)
                dX = moverX - mover.getX() ;
            if(scrollY > screenHeight / 2 && scrollY < mapWidth - screenHeight/2)                
                dY =  moverY - mover.getY();
            moveWorld(mover, dX, dY);
            mover.setLocation(moverX, moverY);
            scrollX -= dX;
            scrollY -= dY;
            GreenfootImage bg = getBackground();
            bg.drawImage(bgImage, -scrollX, -scrollY);
        
        }

    }

        private void paint(int x, int y)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgImage, x, y);
        bg.drawImage(bgImage, x - bgImage.getWidth(), 0);
        bg.drawImage(bgImage, x + bgImage.getWidth(), 0);
        bg.drawImage(bgImage, 0, y - bgImage.getHeight());
        bg.drawImage(bgImage, 0, y + bgImage.getHeight());
        bg.drawImage(bgImage, x - bgImage.getWidth(), y - bgImage.getHeight());
        bg.drawImage(bgImage, x + bgImage.getWidth(), y + bgImage.getHeight());
        bg.drawImage(bgImage, x - bgImage.getWidth(), y + bgImage.getHeight());
        bg.drawImage(bgImage, x - bgImage.getWidth(), y + bgImage.getHeight());
    }
 
    /**
     * Paint scrolling image at given position and make sure the rest of
     * the background is also painted with the same image.
     */
/*    private void paint(int x, int y)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(scrollingImage, x, y);
        bg.drawImage(scrollingImage, x - scrollingImage.getWidth(), 0);
        bg.drawImage(scrollingImage, x + scrollingImage.getWidth(), 0);
        bg.drawImage(scrollingImage, 0, y - scrollingImage.getHeight());
        bg.drawImage(scrollingImage, 0, y + scrollingImage.getHeight());
        bg.drawImage(scrollingImage, x - scrollingImage.getWidth(), y - scrollingImage.getHeight());
        bg.drawImage(scrollingImage, x + scrollingImage.getWidth(), y + scrollingImage.getHeight());
    }
 
    /**
     * Returns an image with the given dimensions.
     *
    private GreenfootImage getScrollingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x, y);
            }
        }
        return image;
    } */
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        fish fish = new fish();
        addObject(fish, 396, 85);
        redbug redbug = new redbug();
        addObject(redbug, 82, 308);
    }



    public void act()
    {
        }
    }

