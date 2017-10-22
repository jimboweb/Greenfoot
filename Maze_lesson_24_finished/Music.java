import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music extends Actor
{
    GreenfootSound myMusic = new GreenfootSound("Goto80_-_aaf.mp3");
    private boolean firstTurn = true;
    /**
     * Act - do whatever the Music wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
       if(firstTurn)
       {
           //myMusic.playLoop();
           firstTurn = false;
       }
       if(Greenfoot.mouseClicked(this))
       {
           if(myMusic.isPlaying())
           {
               myMusic.pause();
               setImage("play_button.gif");
           } else
           {
               myMusic.playLoop();
               setImage("pause_button.gif");
           }
       }
    }    
}
