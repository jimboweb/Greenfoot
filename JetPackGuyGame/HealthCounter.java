import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthCounter extends Actor
{
    int health = 10;
    /**
     * Act - do whatever the HealthCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage(102,22));
        int rectWidth = health * 10;
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0,0,101,21);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, rectWidth, 20);
    }    
    public void loseHealth()
    {
        health-=1;
    }
}
