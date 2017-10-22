import greenfoot.GreenfootImage;

/**
 * Animation class returns an animated image from a sprite sheet. A sprite sheet should have
 * a number of animations of a sprite laid out in rows and columns.
 * 
 * @author Jim Stewart 
 * @version 4/14/2016
 */
public class Animation
{
    private int rows;               // The rows of sprites in the sprite sheet
    private int columns;            // The columns of sprites in the sprite sheet
    private int celHeight;       // The height of a single sprite cel
    private int celWidth;        // The width of a single sprite cel
    private GreenfootImage sheet;   // The image of the sprite sheet
    private GreenfootImage myImage; // The image that will be returned
    private int turnCount = 0;      // The count of the turns that have passed
    private int cels;               // The total number of sprite cels
    /**
     * To use Animation class, you must pass the name of the image (which is in your 
     * images folder) and the number of rows and columns in your sprite. For example,
     * to use the sprite sheet named "animation.gif" with three rows and five columns, use
     * the following code at the beginning 
     * of your class:<br />
     * <br />
     * <strong>Animation anim = new Animation("animation.gif", 3, 5);</strong>
     */
    public Animation(String imageName, int columns, int rows)
    {
        this.rows = rows;             
        this.columns = columns;
        this.cels = rows * columns;     // total cels is the product of rows and columns
        this.sheet = new GreenfootImage(imageName); 
        this.celHeight = sheet.getHeight()/rows; // Height of cel is sheet height / rows
        this.celWidth = sheet.getWidth()/columns; // With of cel is sheet width / cols
        this.myImage = new GreenfootImage(celWidth, celHeight); // return image is height of one cel
    }

    /**
     * Use the animate image method to replace the GreenfootImage object when you call setImage
     * in your act method. For example, to make an animation that advances every four turns, 
     * use the following code:
     * 
     * <br />
     *    setImage(anim.animate(4)); <br /> 
     * <br />
     * 
     * To start with the first image, you can just same line in your constructor, as in:<br />
     * <br />
     *     <strong>public MyActor()<br />
     *         {<br />
     *             setImage(anim.animate(4));<br />
     *         }</strong>
     * 
     * But it is better to use the getCel method in your constructor.
     */
    public GreenfootImage animate(int turnDelay)
    {
        turnCount++;    //Add one to the turn count
        int celNumber = (int)Math.floor(turnCount/turnDelay);   //Divide by delay
        if(celNumber>cels)      // At end of cels 
            turnCount = 0;      // go back to beginning
        int col = celNumber % columns;      // column of the cel
        int row = (int)Math.floor(celNumber/columns);   // row of the cel
        myImage = getCel(row, col); // get the cel
        return myImage;             // return the image
    }
    
    /**
     * getCel method gets a particular cel based on the row or column. For example to get the 
     * cel at row 3, column 5, write:<br />
     * <br />
     *     anim.getCel(3, 5)<br />
     *     
     * To start your sprite with the first cel in the animation, you can set it in your 
     * constructor as follows:<br />
     *     <strong>public MyActor()<br />
     *         {<br />
     *             setImage(anim.getCel(0,0));<br />
     *         }</strong>
     */
    
    public GreenfootImage getCel(int row, int col)
    {
        int shiftLeft = col * celWidth * -1;    // shift left byt the columns
        int shiftUp = row * celHeight * -1;     // shift down by the rows
        myImage.clear();    // start with fresh image
        myImage.drawImage(sheet, shiftLeft, shiftUp); //show part of image we need
        return myImage;     // return the image
    }
    
    /**
     * The advanced constructor of animate allows you to start and end with a particular cel. 
     * For example to animate from the fourth to the seventh cel that advances every three 
     * turns, use the following code: 
     * <br />
     *    setImage(anim.animate(3, 4, 7));      
     * 
     */
    public GreenfootImage animate(int turnDelay, int startSprite, int endSprite)
    {
        turnCount++;        
        int celNumber = startSprite + (int)Math.floor(turnCount/turnDelay) -1 ;
        if(celNumber>(endSprite - 1))
            turnCount = 0;
        int col = celNumber % columns;
        int row = (int)Math.floor(celNumber/columns);
        myImage = getCel(row, col);
        return myImage;
    }    
}
