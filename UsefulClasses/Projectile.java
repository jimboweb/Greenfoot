import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    Actor shooter;
    GreenfootImage myImage;
    String activationKey;
    World theWorld;
    int startX;
    int startY;
    int rotation;
    public Projectile(Actor a) 
    {
        
        setImage(new GreenfootImage(15,5));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.fillRect(0, 0, 14, 4);
        this.activationKey = "space";
        this.shooter = a;
        this.theWorld = shooter.getWorld();
    }
    public Projectile(Actor a, String key) 
    {
        
        setImage(new GreenfootImage(15,5));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.fillRect(0, 0, 14, 4);
        this.activationKey = key;
        this.shooter = a;
        this.theWorld = shooter.getWorld();
    }
    public Projectile(Actor a, String key, String fileName) throws IllegalArgumentException
    {
        try{
            setImage(new GreenfootImage(fileName));
        } catch (IllegalArgumentException e){ 
            System.out.println("Image File does not exist");
        }finally {
        }
        this.activationKey = key;
        this.shooter = a;
     }

    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void fireProjectile() 
    {
        if(getWorld()==null)
        {

            if(Greenfoot.isKeyDown(activationKey))
            {
                theWorld = shooter.getWorld();
                startX=shooter.getX();
                startY=shooter.getY();
                rotation=shooter.getRotation();
                theWorld.addObject(this, startX, startY);
                setRotation(rotation);
            } 
        } else 
        {
            move(10);
            World myWorld = getWorld();
            GreenfootImage myImage = getImage();
            int leftBound = myImage.getWidth()/2;
            int rightBound = myWorld.getWidth()-myImage.getWidth()/2;
            int topBound = myImage.getHeight()/2;
            int bottomBound = myWorld.getHeight()-myImage.getHeight()/2;
            int myX = getX();
            int myY = getY();
            Actor target = getOneIntersectingObject(Actor.class);
            if(target!=null && !shooter.equals(target))
            {
                myWorld.removeObject(target);
                myWorld.removeObject(this);
            }
            if(myX<leftBound||myX>rightBound||myY<topBound||myY>bottomBound)
            {
                myWorld.removeObject(this);
            }
        }
    }    
}
