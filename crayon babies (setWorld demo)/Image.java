import greenfoot.*;

/**
 * Class Image: creates from the image recieved one panel of the wallpaper image
 *                      and holds the panel image in a field
 */
public class Image
{
    GreenfootImage image = null; // will hold the created image
    
    /**
     * Image Constructor: creates one panel of the wallpaper image
     *
     * @param _img A parameter to recieve the image to use to create the image for the wallpaper
     */
    public Image(GreenfootImage _img)
    {
        GreenfootImage img = new GreenfootImage(_img); // create a new copy of the image to use
        img.scale(MainWorld.WIDE / 2, MainWorld.HIGH / 2); // scale to a quarter of the size of the world
        image = new GreenfootImage(MainWorld.WIDE, MainWorld.HIGH); // create a new image of world size
        // draw the quarter-size image on the new image so that all touching edges are equivalent
        // (like flipping the image: first across, then down, then back across)
        image.drawImage(img, 0, 0); 
        img.mirrorHorizontally();
        image.drawImage(img, MainWorld.WIDE / 2 - 1, 0);
        img.mirrorVertically();
        image.drawImage(img, MainWorld.WIDE / 2 - 1, MainWorld.HIGH / 2 - 1);
        img.mirrorHorizontally();
        image.drawImage(img, 0, MainWorld.HIGH / 2 - 1);
    }
}
