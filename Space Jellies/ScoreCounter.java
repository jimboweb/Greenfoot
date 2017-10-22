import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ScoreCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCounter extends Actor
{
    int score = 0;
    /**
     * Act - do whatever the ScoreCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ScoreCounter()
    {
        setImage(new GreenfootImage("Jellies: " + score, 24,  Color.YELLOW, Color.BLACK));
    }
    
    public void act() 
    {
       setImage(new GreenfootImage("Jellies: " + score, 24,  Color.YELLOW, Color.BLACK));
    }    
    
    public void addScore()
    {
        score++;
    }
}
