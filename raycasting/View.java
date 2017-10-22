import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Write a description of class View here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class View extends Actor
{
    private Player player;

    public View(Player p)
    {
        this.player = p;
    }

    @Override
    protected void addedToWorld(World w)
    {
        redraw();
    }

    /**
     * Act - do whatever the View wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {        
        if (player.hasMoved())
            redraw();
    }    
    
    
    private class Raycaster extends LineFollower
    {
        private double hitX;
        private double hitY;
        private Box box;
        
        public boolean process(int x, int y, double exactX, double exactY)
        {
            List<Box> boxes = getWorld().getObjectsAt(x, y, Box.class);
            if (boxes.isEmpty())
                return true;
            
            box = boxes.get(0);
            hitX = exactX;
            hitY = exactY;
            
            return false;
        }
        
        public double getHitX()
        {
            return hitX;
        }
        
        public double getHitY()
        {
            return hitY;
        }
        
        
        public Box getBox()
        {
            return box;
        }
        
    }
    
    private void redraw()
    {
        GreenfootImage img = new GreenfootImage(getWorld().getWidth() * getWorld().getCellSize(), getWorld().getHeight() * getWorld().getCellSize());
        img.setColor(Color.GRAY);
        img.fill();
        setImage(img);
        
        Raycaster r = new Raycaster();
        
        double eyeX = player.getX() + 0.5;
        double eyeY = player.getY() + 0.5;
        double centreDirRad = Math.toRadians(player.getRotation());
        double perpDirRad = Math.toRadians(player.getRotation() + 90);
                
        double screenCentreDirX = 0.5 * Math.cos(centreDirRad);
        double screenCentreDirY = 0.5 * Math.sin(centreDirRad);
        
        for (double column = 0; column < img.getWidth(); column++)
        {
            double across = (column / (double)img.getWidth() - 0.5);
            double screenDirX = screenCentreDirX + Math.cos(perpDirRad) * across;
            double screenDirY = screenCentreDirY + Math.sin(perpDirRad) * across;
            
            r.followLine(player.getX(), player.getY(), screenDirX, screenDirY);
            
            
            img.setColor(r.getBox().getColor());
            
            int height = img.getHeight()/2;
            
            if (player.showProperView())
            {
                double distX = r.getHitX() - eyeX;
                double distY = r.getHitY() - eyeY;
                double dist = Math.sqrt(distX * distX + distY * distY);
                double planeDist = Math.sqrt(0.5 * 0.5 + across * across);
                
                height = (int)((planeDist / dist) * img.getHeight()/2);
            }
            
            img.drawLine((int)column, img.getHeight()/2 - height, (int)column, img.getHeight()/2 + height);
        }
    }
}
