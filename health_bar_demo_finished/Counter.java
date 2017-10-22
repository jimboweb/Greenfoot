import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;


public class Counter extends Actor
{
    //*******************************************************************************
    //Code Clip 3:
    int score = 0; //This variable represents the score. 

    public Counter()
    {
        //By calling the update in the constructor we make sure we see a score counter instead
        //of a generic "Green foot" image. 
        update(); 
    }
    
    
    public void act() 
    {
         update();//Updates every turn so the score is always correct. 
    }    
    
    
    //Creates a new image. First argument of new GreenfootImage is the text, second
    //argument is the text size, third and fourth are foreground and background colors.
    //Text is created by concatenating the fixed string with the score variable. 
    public void update()
    {
        setImage(new GreenfootImage("Score : " + score, 24, Color.GREEN, Color.BLACK));        
    }
    
    
    public void addScore()
    {
        score++;    //Add one to the score counter.
    }
    //End Code Clip 3
    //*******************************************************************************
}
