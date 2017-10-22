import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot) 

/**
 * A class that has a scrolling background image
 * 
 * @author Poul Henriksen
 */
public class ScrollWorld extends World 
{ 
    private static final GreenfootImage bgImage = new GreenfootImage("space1.gif");
    private static final int scrollSpeed = 1;
 
    private GreenfootImage scrollingImage;
    private int scrollPosition = 0;
     
    public ScrollWorld()
    {
        super(800, 400, 1);
      
        GreenfootImage background = new GreenfootImage(800, 400);
        scrollingImage = getScrollingImage(800, 400);
        background.drawImage(scrollingImage, 0, 0);
        setBackground(background);
       
        addObject(new SpaceShip(), 350, 200);
    }

    public void act()
    {
        if(scrollSpeed > 0 && scrollPosition <= 0) {
            scrollPosition = getWidth();
        }
        if(scrollSpeed < 0 && scrollPosition >= getWidth()) {
            scrollPosition = 0;
        }
        scrollPosition -= scrollSpeed;
        paint(scrollPosition);
    }
  
    /**
     * Paint scrolling image at given position and make sure the rest of
     * the background is also painted with the same image.
     */
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(scrollingImage, position, 0);
        bg.drawImage(scrollingImage, position - scrollingImage.getWidth(), 0);
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
}
