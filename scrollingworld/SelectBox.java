import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class SelectBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectBox extends BuildTools
{
    private Class actorClass;
    private Actor icon;
    private GreenfootImage myImage;
    private GreenfootImage iconImage;
    private boolean selected = false;
    private WorldBuilder myWorld;
    public SelectBox(Actor icon)
    {
        this.icon = icon;
        this.actorClass = icon.getClass();
        this.iconImage = icon.getImage();
        setImage(new GreenfootImage(iconImage.getWidth(), iconImage.getHeight()));
        this.myImage = getImage();
        this.myWorld = (WorldBuilder)icon.getWorld();
        myWorld.addObject(this, icon.getX(), icon.getY());
    }

    /**
     * Act - do whatever the SelectBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        if(icon.getWorld()!=null)
        {
            if(getX()!=icon.getX()||getY()!=icon.getY())
                setLocation(icon.getX(), icon.getY());

            if(myImage.getWidth()!=iconImage.getWidth()  || myImage.getHeight()!=iconImage.getHeight())
                myImage.scale(iconImage.getWidth(), iconImage.getHeight());

            clicked();
        }
    }    

    public void select()
    {
        selected = true;
        myImage.setColor(Color.RED);
        myImage.drawRect(0, 0, myImage.getWidth()-1, myImage.getHeight()-1);
    }

    public void deselect()
    {
        selected = false;
        myImage.clear();
    }

    public Class actorClass()
    {
        return actorClass;
    }

    public void clicked()
    {
        if(Greenfoot.mouseClicked(this))
        {
            select();
            myWorld.iconSelected(actorClass);
        }
    }
}
