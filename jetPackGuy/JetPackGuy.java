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
        bottomOfWorld = 600;
        rightSideOfWorld = 400;
        myImage = getImage();
        myHeight = myImage.getHeight();
        oldX = 0;
        oldY = 0;

    }
        
    
    public void move(){
        /**
        if((getX() + deltaX)<=20 || (getX() + deltaX)>=380){
            deltaX = 0;
        }
        if((getY() + deltaY)<=20){
            deltaY = 0;
        }
        isOnTheGround = isHeOnTheGround((getY() + deltaY));

        */
       isOnTheGround = false;
       int newX = getX() + deltaX;
       int newY = getY() + deltaY;
       
       String boundary = checkBoundaries(newX, newY);
       
       if (boundary!="none"){
           if(boundary == "bottom"){
               isOnTheGround = true;
               deltaY = 0;
               deltaX = 0;
               newX = getX();
               newY = bottomOfWorld - 20;
            } else if(boundary == "top"){
                deltaY = 0;
                newY = 20;
            } else {
                deltaX =0;
                newX = getX();
            }
        }
        String platform = checkPlatform(oldX, oldY);
        if(platform == "top"){
            deltaX = 0;
            deltaY = 0;
            stop();
            newY = oldY;
            isOnTheGround = true;
        } else if(platform == "right"){
            deltaX = +2;
            newX = oldX;
        } else if(platform == "left"){
            deltaX = -2;
            newX = oldX;
        } else if(platform == "bottom"){
            newY = getY() + 10;
            deltaY = deltaY* -1;
        } 
        oldX = getX();
        oldY = getY();
        
        setLocation(newX, newY);
        
    }
    public String checkPlatform (int oldX, int oldY){
        Actor intersectingPlatform;
        if(isOnTheGround == true)
        {
            intersectingPlatform = getOneObjectAtOffset(0, 20, Platform.class);
        } else {
            intersectingPlatform = getOneObjectAtOffset(deltaX, deltaY, Platform.class);
        }
        if(intersectingPlatform!=null){
            int theTop = intersectingPlatform.getY();
            if(oldY<theTop){
                
                return "top";

            } else if (oldY>intersectingPlatform.getY()+ 20){
                return "bottom";
            } else if (oldX<intersectingPlatform.getX()) {
                return "left";
            }else if (oldX>intersectingPlatform.getX()) {
                return "right";
            }
        }
        return null;
    }
    public String checkBoundaries(int newX, int newY){
        if(newX<=20){
            return "left";
        } else if(newX >=rightSideOfWorld-10){
            return "right";
        } else if (newY<=20){
            return "top";
        } else if (newY>=bottomOfWorld - 20 ){
            return "bottom";
        }
        return "none";
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
    }
    
    public void stop(){
            deltaY = 0;
            deltaX = 0;

    }
    /**
    public boolean isHeOnTheGround(int nextY){
        int bottomOfFeet = nextY - myHeight;
        int feetOnTheGround = bottomOfWorld - myHeight;
        Actor thisPlatform = getOneObjectAtOffset(0, myHeight+120, Platform.class);
        if(nextY >= feetOnTheGround){
            setLocation(getX(), feetOnTheGround);
            stop();
            return true;
        } else if(thisPlatform != null) {
            // stop();
            GreenfootImage pImage = thisPlatform.getImage();
            int topOfPlatform = thisPlatform.getY() - pImage.getHeight();
            feetOnTheGround = topOfPlatform - myHeight;
            if(nextY <=  feetOnTheGround){
                setLocation(getX(), feetOnTheGround);
                stop();
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    */
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
