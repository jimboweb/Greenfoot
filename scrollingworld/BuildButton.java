import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class BuildButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuildButton extends BuildTools
{
    private WorldBuilder myWorld;
    private GreenfootImage buildImg;
    private GreenfootImage setupImg;
    private int startX;
    private int startY;
    public BuildButton(World w)
    {
        buildImg = new GreenfootImage("Build", 24, Color.BLACK, Color.YELLOW);
        buildImg.drawRect(0, 0, buildImg.getWidth()-1, buildImg.getHeight()-1);
        setupImg = new GreenfootImage("Setup", 24, Color.RED, Color.YELLOW);
        setupImg.drawRect(0, 0, setupImg.getWidth()-1, setupImg.getHeight()-1);
        this.myWorld = (WorldBuilder)w;
        setImage(buildImg);
        this.startX = startX;
        this.startY = startY;

    }
    /**
     * Act - do whatever the BuildButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(myWorld.buildModeIsOn())
        {
            if(!getImage().equals(setupImg))
                setImage(setupImg);
        } else {
            if(!getImage().equals(buildImg))            
                setImage (buildImg);
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            if(!myWorld.buildModeIsOn())
                myWorld.build();
            else
                myWorld.setup();
        }
    
    }    
}
