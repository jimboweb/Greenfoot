import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * <p>Projectile is a class that creates a projectile that can be shot. It goes to the end of the 
 * world and destroys whatever it hits. The basic call requires the argument of the actor
 * that is firing the laser.  It creates a simple red laser that fires
 * when you press the space bar, moves at speed 10 and destroys whatever it hits. It looks 
 * like:</p>
 * 
 * <p style = "font-weight: bold">Projectile projectile = new Projectile(this); </p>
 * 
 * <p>A more advanced call requires the additional arguments of the key that fires
 * the projectile and the speed at which it will be shot. For example, to make a projectile
 * that will be fired by the up arrow key and moves at speed 12, you would call:</p>
 * 
 * <p style = "font-weight: bold">Projectile projectile = new Projectile(this, "up", 12); </p>
 * 
 * <p>The advanced optional arguments at the end are an image to represent the projectile and a 
 * specific target to destroy. For example, to create a projectile that used the image "missile.png"
 * and destroyed only the target Asteroid.class, you would call:</p>
 * 
 * <p style = "font-weight: bold">Projectile projectile = new Projectile(this, "up", 12, "missile.png", Asteroid.class); </p>
 * 
 * <p>Either or both of the optional arguments can be used. If you use them both, the image goes first. 
 * The image file must be in the 'images' folder in your Greenfoot project. </p>
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class Projectile extends Actor
{
    Actor shooter;
    GreenfootImage myImage;
    String activationKey= "space";
    World theWorld;
    int startX;
    int startY;
    int rotation;
    int speed = 10;
    Class targetClass = null;

    public Projectile(Actor a) 
    {

        setImage(new GreenfootImage(15,5));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.fillRect(0, 0, 14, 4);
        this.shooter = a;
        this.theWorld = shooter.getWorld();
    }

    public Projectile(Actor a, String key, int s) 
    {

        setImage(new GreenfootImage(15,5));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.fillRect(0, 0, 14, 4);
        this.activationKey = key;
        this.shooter = a;
        this.theWorld = shooter.getWorld();
        speed = s;
    }

    public Projectile(Actor a, String key, int s, Class tc) 
    {
        targetClass = tc;
        setImage(new GreenfootImage(15,5));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.fillRect(0, 0, 14, 4);
        this.activationKey = key;
        this.shooter = a;
        this.theWorld = shooter.getWorld();
        speed = s;
    }

    public Projectile(Actor a, String key, int s, String fileName) throws IllegalArgumentException
    {
        try{
            setImage(new GreenfootImage(fileName));
        } catch (IllegalArgumentException e){ 
            System.out.println("Image File does not exist");
        }finally {
        }
        speed = speed;
        this.activationKey = key;
        this.shooter = a;
    }

    public Projectile(Actor a, String key, int s, String fileName, Class tc) throws IllegalArgumentException
    {
        try{
            setImage(new GreenfootImage(fileName));
        } catch (IllegalArgumentException e){ 
            System.out.println("Image File does not exist");
        }finally {
        }
        speed = speed;
        this.activationKey = key;
        this.shooter = a;
        targetClass = tc;
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
            move(speed);
            World myWorld = getWorld();
            GreenfootImage myImage = getImage();
            int leftBound = myImage.getWidth()/2;
            int rightBound = myWorld.getWidth()-myImage.getWidth()/2;
            int topBound = myImage.getHeight()/2;
            int bottomBound = myWorld.getHeight()-myImage.getHeight()/2;
            int myX = getX();
            int myY = getY();
            Actor target = getOneIntersectingObject(Actor.class);
            if(targetClass == null)
            {
                if(target!=null && !shooter.equals(target))
                {
                    myWorld.removeObject(target);
                    myWorld.removeObject(this);
                }
            } else {
                if(targetClass.isInstance(target))
                {
                    myWorld.removeObject(target);
                    myWorld.removeObject(this);
                }

            }
            if(myX<leftBound||myX>rightBound||myY<topBound||myY>bottomBound)
            {
                myWorld.removeObject(this);
            }
        }
    }    
}
