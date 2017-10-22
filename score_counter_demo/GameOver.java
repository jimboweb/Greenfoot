import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GameOver()
    {
        setImage(new GreenfootImage("Game Over", 48, Color.WHITE, Color.BLACK));
        // Uses setImage to draw text. The first argument is the text to draw, 
        // the second argument is the size (48 pixels), the third is the foreground
        // color (WHITE) and the fourth is the background color (BLACK). 
        // **********************************************************************
    }
}
