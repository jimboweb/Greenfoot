import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StationButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StationButton extends Actor
{
    TrainSystem system;
    public StationButton(){
        GreenfootImage img = new GreenfootImage(80, 30);
        img.setColor(Color.WHITE);
        img.fillRect(0, 0, img.getWidth()-1, img.getHeight()-1);
        img.setColor(Color.BLACK);
        img.drawString("Add Station", 3, 15);
        img.drawRect(0, 0, img.getWidth()-1, img.getHeight()-1);
        setImage(img);
    }
    
    public void addedToWorld(World myWorld){
        system = (TrainSystem)myWorld;
    }
    /**
     * Act - do whatever the StationButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            MouseInfo mi = Greenfoot.getMouseInfo();
            int mouseX = mi.getX();
            int mouseY = mi.getY();
            system.addStation(mouseX, mouseY);
        }
    }    
}
