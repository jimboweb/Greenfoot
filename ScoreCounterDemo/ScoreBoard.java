import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    private static int score;
    
    public ScoreBoard() 
    {
        GreenfootImage scoreText = new GreenfootImage("Score: " + score, 24, Color.RED,Color.WHITE);
        setImage(scoreText);
    }
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage scoreText = new GreenfootImage("Score: " + score, 24, Color.RED,Color.WHITE);
        setImage(scoreText);
        // Add your action code here.
    }    
    
    public static void addScore(int amount)
    {
        score += amount;
    }
}
