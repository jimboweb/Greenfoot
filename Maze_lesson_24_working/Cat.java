import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    Mouse mouseOnScreen;
    LineOfSight los;
    GreenfootSound meow = new GreenfootSound("cat13.wav");

    public void addedToWorld(World myWorld)
    {
        if(myWorld instanceof Tile)
        {
            Tile tile = (Tile)myWorld;
            los = tile.getLOS();
            mouseOnScreen = tile.getMouse();
        }
    }

    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getWallInFront()==false)
        {
            move(5);
        } else
        {
            int rnd = Greenfoot.getRandomNumber(3);
            if(rnd == 0)
            {
                turn(90);
            } else if(rnd ==1)
            {
                turn(-90);
            } else
            {
                turn(180);
            }
        }
        wrapAtEdge();
        Actor mouseImTouching = getOneIntersectingObject(Mouse.class);
        if(mouseImTouching!=null)
            getWorld().removeObject(mouseImTouching);

        if(los!=null)
        {
            if(los.clearLineOfSight())
            {
                meow.play();
                if(mouseOnScreen != null && mouseOnScreen.getWorld()!=null)
                {
                    turnTowards(mouseOnScreen.getX(), mouseOnScreen.getY());
                    setRotation(90*Math.round(getRotation()/90));
                }
            }
        }
    }    
    private boolean getWallInFront()
    {
        GreenfootImage myImage = getImage();
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
