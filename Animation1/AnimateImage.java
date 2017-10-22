import greenfoot.*;

/**
 * <p>AnimateImage allows you to animate an image as it moves, as well as to make the 
 * animation lock vertically (left-right rotation only) or to prevent rotation
 * altogether.</p>
 * 
 * <p>To include AnimateImage in your project, the contructor requires the actor whose
 * image will be animated, and a list of filenames of images the actor will use. These
 * files must be in your projects 'images' folder. For example, if you have three images
 * called "player_run1.png", "player_run2.png" and "player_run1.png" you would put the 
 * following constructor in the Actor's code:</p>
 * 
 * <p style="font-weight:bold">AnimateImage animateimage = new AnimateImage(this, "player_run1.png", "player_run2.png","player_run3.png");</p>
 * 
 * <p>A more advanced constructor allows you to set the delay between animations (default is
 * 25 turns). To set the above situation with a delay of 50 turns (slower animation) use the 
 * following constructor:
 *
 * <p style="font-weight:bold">AnimateImage animateimage = new AnimateImage(this, "player_run1.png", "player_run2.png","player_run3.png");</p>
 * 
 * <p>There are four methods to animate the actor. The simplest, animateAlways(), animates the 
 * actor every turn no matter what. Simply place the following in your act() method:</p>
 * 
 * <p style="font-weight:bold">animateimage.animateAlways()</p>
 * 
 * <p>The animateOnMove() class animates the actor only when you move it. Simply include the following code:</p>
 * 
 * <p style="font-weight:bold">animateimage.animateOnMove()</p>
 * 
 * <p>The animateOnMoveLeftRight() class animates the actor only when you move it, and also makes sure the actor 
 * rotates left and right (equivalent to left-right rotation style in Scratch). Simply include the following code:</p>
 * 
 * <p style="font-weight:bold">animateimage.animateOnMoveLeftRight()</p>
 * 
 * <p>The animateOnMoveNoRotation() class animates the actor only when you move it, and makes your actor not move at all. 
 * (Equivalent to "don't rotate" rotation style in Scratch.) Simply include the following code:</p>
 * 
 * <p style="font-weight:bold">animateimage.animateOnMoveNoRotation()</p>
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class AnimateImage  
{
    // instance variables - replace the example below with your own
    private Actor theActor;
    private String[] imageNames;
    private GreenfootImage actorImage;
    private int xPos = -1;
    private int yPos = -1;
    int currentImage = 0;
    int timer = 0;
    int delay = 25;
    int imageRotation;
    boolean facingLeft = false;
    /**
     * Constructor for objects of class AnimateImage
     */
    public AnimateImage(Actor theActor, String... imageNames)
    {
        this.theActor = theActor;
        this.imageNames = imageNames;
        this.actorImage = theActor.getImage();

    }

    public AnimateImage(Actor theActor, int delay, String... imageNames)
    {
        this.theActor = theActor;
        this.imageNames = imageNames;
        this.delay = delay;
        this.actorImage = theActor.getImage();

    }
    public void animateAlways()
    {
        timer++;
        if(timer%delay==0)
        {
            currentImage++;
            if(currentImage >= imageNames.length)
                currentImage=0;
        }
        GreenfootImage newImage = new GreenfootImage(imageNames[currentImage]);
        theActor.setImage(newImage);
        actorImage = theActor.getImage();

    }

    public void animateOnMove()
    {   
        if(xPos==-1)
        {
            xPos=theActor.getX();
            yPos=theActor.getY();            
        }
        if(theActor.getX()!=xPos|| theActor.getY()!=yPos)
        {
            timer++;
            if(timer%delay==0)
            {
                currentImage++;
                if(currentImage >= imageNames.length)
                    currentImage=0;
            }
            GreenfootImage newImage = new GreenfootImage(imageNames[currentImage]);
            theActor.setImage(newImage);
            actorImage = theActor.getImage();
        }
        xPos=theActor.getX();
        yPos=theActor.getY();

    }

    public void animateOnMoveLeftRight()
    {   
        if(xPos==-1)
        {
            xPos=theActor.getX();
            yPos=theActor.getY();            
        }
        if(theActor.getX()!=xPos|| theActor.getY()!=yPos)
        {
            timer++;
            if(timer%delay==0)
            {
                currentImage++;
                if(currentImage >= imageNames.length)
                    currentImage=0;
            }
            GreenfootImage newImage = new GreenfootImage(imageNames[currentImage]);
            int rot = theActor.getRotation();
            if(rot!=0)
                newImage.rotate(-rot);
            if(theActor.getX()<xPos)
                facingLeft = true;
            if(theActor.getX()>xPos)
                facingLeft = false;
            if(facingLeft)
                newImage.mirrorHorizontally();
            theActor.setImage(newImage);
            actorImage = theActor.getImage();
        }
        xPos=theActor.getX();
        yPos=theActor.getY();
    }

    public void animateOnMoveNoRotation()
    {   
        if(xPos==-1)
        {
            xPos=theActor.getX();
            yPos=theActor.getY();            
        }
        if(theActor.getX()!=xPos|| theActor.getY()!=yPos)
        {
            timer++;
            if(timer%delay==0)
            {            
                currentImage++;
                if(currentImage >= imageNames.length)
                    currentImage=0;
            }
            GreenfootImage newImage = new GreenfootImage(imageNames[currentImage]);
            int rot = theActor.getRotation();
            if(rot!=0)
                newImage.rotate(-rot);

            theActor.setImage(newImage);
            actorImage = theActor.getImage();
        }
        xPos=theActor.getX();
        yPos=theActor.getY();
    }
}
