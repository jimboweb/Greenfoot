import greenfoot.*;

/**
 * Write a description of class AnimateImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    int delay = 10;
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
            if(theActor.getX()<xPos)
                facingLeft = true;
            else if(theActor.getX()>xPos)
                facingLeft = false;
            if(facingLeft)
                newImage.mirrorHorizontally();
            if(rot!=0)
                newImage.rotate(-rot);
            
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
