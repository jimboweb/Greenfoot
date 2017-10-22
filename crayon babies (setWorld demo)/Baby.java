import greenfoot.*;
import java.awt.Color;

public class Baby extends Actor
{
    static int babyCount = 0; // rotation counter (0 to 5)
    int direction = Greenfoot.getRandomNumber(4); // set a random movement direction
    Color color = null; // the crayon color

    public Baby()
    {
        babyCount = (babyCount + 1) % 6; // increments rotational counter
        int r = 0, g = 0, b = 0; // initialized color parts variables
        // sets the color parts for the baby being created
        switch (babyCount)
        {
            case 0: b = 255; break;
            case 1: g = 255; break;
            case 2: r = 255; break;
            case 3: g = 255; b = 255; break;
            case 4: r = 255; b = 255; break;
            case 5: r = 255; g = 255; break;
        }
        color = new Color(r, g, b); // sets the crayon color for this baby
    }
    
    public void act() 
    {
        move(); // control baby movement
        getWorld().getBackground().setColorAt(getX(), getY(), color); // make crayon mark on background image
    }
    
    private void move()
    {
        int dx = ((3 - direction) % 2) * (1 - direction); // the x direction of movement
        int dy = ((4 - direction) % 2) * (2 - direction); // the y direction of movement
        // execute move and test for turning
        setLocation(getX() + dx, getY() + dy); // make the move
        if (getX() == 0 || 
            getY() == 0 || 
            getX() == getWorld().getWidth() - 1 || 
            getY() == getWorld().getHeight() - 1 ||
            Greenfoot.getRandomNumber(100) < 5)
        { // either at edge of world or chance turn triggered (5%)
            setLocation(getX() - dx, getY() - dy); // undo the move
            direction = (direction + 3 + Greenfoot.getRandomNumber(2) * 2) % 4; // random turn (left or right)
        }
    }
}
