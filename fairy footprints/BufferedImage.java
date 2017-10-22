import greenfoot.*; 
/**
 * Write a description of class BufferedImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BufferedImage extends GreenfootImage 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class BufferedImage
     */
    public BufferedImage(String filename)
    {
        super(filename);
    }
    public BufferedImage(int x,int y)
    {
        super(x,y);
    }
    public BufferedImage(BufferedImage bim)
    {
        super(bim);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
