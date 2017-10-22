import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JetPackGuy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JetPackGuy extends Actor
{
    int deltaX;
    int deltaY;
    boolean isOnTheGround;
    World myWorld;
    int bottomOfWorld;
    int rightSideOfWorld;
    GreenfootImage myImage;
    int myHeight;
    String dir;
    int oldX;
    int oldY;
    public JetPackGuy(){
        dir = "right";
        deltaX = 0;
        deltaY = 0;
        isOnTheGround = false;
        myWorld = getWorld();
        bottomOfWorld = 580;
        rightSideOfWorld = 400;
        myImage = getImage();
        myHeight = myImage.getHeight();
        oldX = 0;
        oldY = 0;

    }

    public void move(){
        int oldX=getX();
        int oldY=getY();
        int newX = getX() + deltaX;
        int newY = getY() + deltaY;

        setLocation(newX, getY());
        Actor platformX=getOneIntersectingObject(Platform.class);
        if(newX<=0 || newX>=rightSideOfWorld||platformX!=null)
        {
            setLocation(oldX,getY());
            deltaX=0;
        }
        setLocation(getX(), newY);
        Actor platformY=getOneIntersectingObject(Platform.class);
        if(newY<=0 || newY>=bottomOfWorld||platformY!=null)
        {
            setLocation(getX(),oldY);
            if(deltaY>0)
            {
                deltaX = 0;
                isOnTheGround = true;
                if(newY>=bottomOfWorld)
                {
                    setLocation(getX(),bottomOfWorld);
                } else if(platformY!=null)
                {
                    Platform thePlatform = (Platform)platformY;
                    myImage = getImage();
                    int topOfPlatform = thePlatform.getY()-thePlatform.myImage.getHeight()/2-myImage.getHeight()/2;
                    setLocation(getX(),topOfPlatform);
                }
            }

            deltaY=0;
        }
 
    }

    public void run(String direction){
        if(direction=="left"){
            setImage("images/jpguy_run_left.gif");
            Greenfoot.delay(1);
            setLocation(getX()-10, getY());
            setImage("images/jpguy_left.gif");
            Greenfoot.delay(1);
        } else {
            setImage("images/jpguy_run_right.gif");
            Greenfoot.delay(1);
            setLocation(getX()+10, getY());
            setImage("images/jpguy_right.gif");
            Greenfoot.delay(1);
        }
        if(getY()<bottomOfWorld)
        {
            Actor platformY=getOneObjectAtOffset(0, 5, Platform.class);
            if(platformY==null)
            {
                isOnTheGround = false;
            }
        }
    }

    public void turn(String direction){
        if(direction=="left"){
            dir = "left";
            setImage("images/jpguy_left.gif");            
        } else {
            dir = "right";
            setImage("images/jpguy_right.gif");
        }
        if(isOnTheGround){    
            run(direction);
        }
    }

    public void fireJet(String direction){
        if(direction =="left"){
            setImage("images/jpguy_jet_left.gif");
            deltaY-=2;
            deltaX -=2;
            Greenfoot.delay(1);
            setImage("images/jpguy_left.gif");
            isOnTheGround = false;
        } else {
            setImage("images/jpguy_jet_right.gif");
            deltaY -=2;
            deltaX +=2;
            Greenfoot.delay(1);
            setImage("images/jpguy_right.gif");
            isOnTheGround = false;
        }

    }

    /**
     * Act - do whatever the JetPackGuy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left")){
            turn("left");
        }

        if(Greenfoot.isKeyDown("right")){
            turn("right");
        }

        if(Greenfoot.isKeyDown("space")){
            fireJet(dir);
        }
        move();
        if(isOnTheGround == false){
            deltaY += 1;
        }
    }    
}
