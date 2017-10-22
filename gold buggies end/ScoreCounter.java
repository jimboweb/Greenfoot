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
    public ScoreCounter() {
        setImage(new GreenfootImage("Score = " + score, 30, Color.BLACK, Color.WHITE));
    }
    /**
     * Act - do whatever the ScoreCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Score = " + score, 30, Color.BLACK, Color.WHITE));
    }    
}
