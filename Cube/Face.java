import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Face here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Face  
{
    World myWorld; 
    int topX;
    int topY;
    Center center; 
    Corner top; 
    Side topRight; 
    Corner right;
    Side bottomRight;
    Corner bottom;
    Side bottomLeft;
    Corner left;
    Side topLeft;
    int squareShift;
    int squareGap = 3;
    public Face(World myWorld, 
                int topX,
                int topY,
                Center center, 
                Corner top, 
                Side topRight, 
                Corner right,
                Side bottomRight,
                Corner bottom,
                Side bottomLeft,
                Corner left,
                Side topLeft)
    {
        this.myWorld = myWorld;
        this.topX = topX;
        this.topY = topY;
        this.center = center;
        this.top = top;
        this.topRight = topRight;
        this.right = right;
        this.bottomRight = bottomRight;
        this.bottom = bottom;
        this.bottomLeft = bottomLeft;
        this.left = left;
        this.topLeft = topLeft;
        this.squareShift = center.getImage().getWidth()/2 + squareGap;
    }

    public void draw()
    {
        myWorld.addObject(top, topX - squareShift, topY);
        myWorld.addObject(topRight, topX, topY + squareShift);
        myWorld.addObject(right, topX + squareShift, topY + squareShift * 2);
        myWorld.addObject(bottomRight, topX, topY + squareShift * 3);
        myWorld.addObject(bottom, topX - squareShift, topY + squareShift * 4);
        myWorld.addObject(bottomLeft, topX - squareShift * 2, topY + squareShift * 3);
        myWorld.addObject(left, topX - squareShift * 3, topY + squareShift * 2);
        myWorld.addObject(topLeft, topX - squareShift * 2, topY + squareShift);
        myWorld.addObject(center, topX - squareShift, topY + squareShift * 2);
    }
    
    public void clear()
    {
        
    }
}
