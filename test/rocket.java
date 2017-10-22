import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rocket extends Actor
{
    /**
     * Act - do whatever the rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int deltaX = 0;
    int deltaY = 0;
    int newX;
    int newY;
    int dir;
    public void move(){
        if((getX() + deltaX)<=0 || (getX() + deltaX)>=600){
            deltaX = deltaX * -1;
        }
        if((getY() + deltaY)<=0 || (getY() + deltaY)>=400){
            deltaY = deltaY * -1;
        }

        newX = getX() + deltaX;
        newY = getY() + deltaY;
        
        setLocation(newX, newY);
        

    }

    public void act() 
    {
        // Add your action code here.

        move();
         if(Greenfoot.isKeyDown("space")){
            dir = getRotation();
            deltaX+=2*(Math.cos(Math.toRadians(dir)));
            deltaY+=2*(Math.sin(Math.toRadians(dir)));
            
        }
            
        if(Greenfoot.isKeyDown("left"))
            turn(-5);
        
        if(Greenfoot.isKeyDown("right"))
            turn(5);
    }    
}
