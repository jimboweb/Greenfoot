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
 * <p>'projectile' in lower case can be anything. It is the name of the variable that represents
 * the Projectile object.</p>
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
 * <p>To fire a projectile, use the 'fireProjectile()' method, like so:
 * 
 * <p style = "font-weight: bold">projectile.fireProjectile()</p>
 * 
 * <p>The 'fireProjectile() method returns the number of objects it hit, 1 or 0. 
 * To increase your 'score' variable when you hit something, you can write:
 * 
 * <p style = "font-weight: bold">score += projectile.fireProjectile()</p>
 * 
 * [Future versions will allow you to fire more than one projectile at a time and maybe have an ammo counter.]
 *
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class Projectile extends Actor
{
    Actor shooter;                  //This variable representst the Actor shooting the projectile
    GreenfootImage myImage;         //The variable for the image of the projectile
    String activationKey= "space";  //The String variable that represents the key that will be pressed
    World theWorld;                 //The variable for the world the shooter and projectile are in
    int startX;                     //The x coord of where the projectile will start
    int startY;                     //The y coord of where the projectile will start
    int rotation;                   //The variable for the rotation of the projectile
    int speed = 10;                 //The variable for the speed of the projectile
    Class targetClass = null;       //The class that the projectile will destroy

    /*
     * The simple constructor that takes no argument except the shooter Actor. This creates
     * a red laser shape. 
     */
    public Projectile(Actor a) 
    {

        setImage(new GreenfootImage(15,5));     //Make the 15x5 blank image
        GreenfootImage myImage = getImage();    //Get the image so we can work with it
        myImage.setColor(Color.RED);            //Set the color to red
        myImage.fillRect(0, 0, 14, 4);          //Draw a red rectangle
        this.shooter = a;                       //Assign the shootera variable
        this.theWorld = shooter.getWorld();     //get the world and assign it to a variable
    }

    /*
     * A more advance constructor that calls for the Actor who shoots the projectile, the key that
     * makes it shoot, and the speed of the projectile. 
     */
    public Projectile(Actor a, String key, int s) 
    {

        setImage(new GreenfootImage(15,5));     //Make the 15x5 blank image
        GreenfootImage myImage = getImage();    //Get the image so we can work with it
        myImage.setColor(Color.RED);            //Set the color to red
        myImage.fillRect(0, 0, 14, 4);          //Draw a red rectangle
        this.activationKey = key;               //Assign the key that shoots the projectile
        this.shooter = a;                       //Assign the shooter a variable
        this.theWorld = shooter.getWorld();     //Get the world and assign it a variable
        speed = s;                              //Assign a the speed variable
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


    public int fireProjectile() 
    {
        int objectHit = 0;
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
                    objectHit ++;
                }

            }
            if(myX<leftBound||myX>rightBound||myY<topBound||myY>bottomBound)
            {
                myWorld.removeObject(this);
            }
        }
        return objectHit;
    }    
}
