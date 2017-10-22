import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class ScrollingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollingWorld extends World
{
    int moverX = 0;
    int moverY = 0;
    int scale = 1;
    Button play= new Button(this, "Wall.jpg", 100, 200);
    public boolean playing = false;
    /**
     * Constructor for objects of class ScrollingWorld.
     * 
     */
    public ScrollingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        Lobster lobster = new Lobster();
        addObject(lobster, getWidth()/2, getHeight()/2);

        prepare();
    }

    public void moveWorld(Actor mover, int deltaX, int deltaY)
    {

        List<Actor> allActors = getObjects(Actor.class);
        for(Actor a : allActors)
        {
            if(!a.equals(mover))
            {
                a.setLocation(a.getX()+deltaX, a.getY()+deltaY);
            }
        }
    }

    public void scrollAround(Actor mover)
    {
        if(moverX == 0)
        {
            moverX = mover.getX();
            moverY = mover.getY();
        } else if (mover.getX()!=moverX || mover.getY()!=moverY)
        {
            int dX = moverX - mover.getX() ;
            int dY =  moverY - mover.getY();
            moveWorld(mover, dX, dY);
            mover.setLocation(moverX, moverY);
        }

    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        fish fish = new fish();
        addObject(fish, 396, 85);
        redbug redbug = new redbug();
        addObject(redbug, 82, 308);
    }

    public void zoomOut()
    {
        scale = scale*2;
        List<Actor> allActors = getObjects(Actor.class);
        for(Actor a : allActors)
        {
            GreenfootImage actorImage = a.getImage();
            actorImage.scale((int)actorImage.getHeight()/2, (int)actorImage.getWidth()/2);
            a.setLocation(a.getX()/2, a.getY()/2);
        }

    }

    public void zoomIn()
    {
        if(scale>1)
        {
            scale = scale/2;
            List<Actor> allActors = getObjects(Actor.class);
            for(Actor a : allActors)
            {
                String actorClassName = a.getClass().toString().split("class ")[1];
                try {
                Actor proto = (Actor)Class.forName(actorClassName).newInstance();          
                GreenfootImage protoImage = proto.getImage();
                protoImage.scale((int)protoImage.getHeight()/scale, (int)protoImage.getWidth()/scale);
                a.setImage(protoImage);
                a.setLocation(a.getX()*2, a.getY()*2);
            } catch (ClassNotFoundException cn) {
                System.out.println("that actor " + actorClassName + " doesn't exist!");
            } catch (InstantiationException ie) {
                System.out.println("instantiation exception! whatever that is.");
            }catch (IllegalAccessException ie) {
                System.out.println("illegal access exception! whatever that is.");
            }
            }
        }
    }

    public void act()
    {
        if(play.buttonClicked())
        {
            playing = true;
            System.out.println(playing);
            play.hide();
        }
    }
}
