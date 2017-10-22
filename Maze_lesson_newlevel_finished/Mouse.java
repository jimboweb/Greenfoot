import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A mouse that's smaller than it's supposed to be
 * 
 * @author Jim Stewart
 * @version 1
 */
public class Mouse extends Actor
{
    GreenfootSound squeak = new GreenfootSound("mousesqueak.wav");
    GreenfootImage myImage;
    public Mouse()
    {
        myImage = getImage();
        int myNewHeight = myImage.getHeight()/2;
        int myNewWidth = myImage.getWidth()/2;
        myImage.scale(myNewWidth, myNewHeight);

    }

    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int numberOfCheeses = getWorld().getObjects(Cheese.class).size();
        if(numberOfCheeses == 0)
            Greenfoot.setWorld(new Tile2());

            
        if(Greenfoot.isKeyDown("right")) { 
            setRotation(0); 
            if(!getWallInFront())
            move(5); 
        } 
        if(Greenfoot.isKeyDown("down")) 
        { 
            setRotation(90); 
            if(!getWallInFront())
            move(5); 
        } 
        if(Greenfoot.isKeyDown("left")) 
        { 
            setRotation(180); 
            if(!getWallInFront())
            move(5); 
        } 
        if(Greenfoot.isKeyDown("up")) 
        { 
            setRotation(270); 
            if(!getWallInFront())
            move(5); 
        } 
        Actor cheese = getOneIntersectingObject(Cheese.class);
        if(cheese!=null)
        {
            World myWorld=getWorld();
            myWorld.removeObject(cheese);
            squeak.play();
        }
        wrapAtEdge();
    }  
    private boolean getWallInFront()
    {
        int distanceToFront = myImage.getWidth()/2;
        int xOffset =(int)Math.ceil(distanceToFront*Math.cos(Math.toRadians(getRotation())));
        int yOffset = (int)Math.ceil(distanceToFront*Math.sin(Math.toRadians(getRotation())));
        Actor wall = getOneObjectAtOffset(xOffset, yOffset, Wall.class);
        return (wall!=null);
        
    }
    private void wrapAtEdge()
    {
        int top = 0;
        int leftSide = 0;
        World myWorld = getWorld();
        int rightSide = myWorld.getWidth() - 1;
        int bottom = myWorld.getHeight() - 1;
        int x = getX();
        int y = getY();
        if(x<=leftSide)
            setLocation(rightSide, y);
        if(x>=rightSide)
            setLocation(leftSide, y);
        if(y<=top)
            setLocation(x, bottom);
        if(y>= bottom)
            setLocation(x, top);
    }


}
