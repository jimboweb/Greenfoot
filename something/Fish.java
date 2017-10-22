import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fish extends Actor
{
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean alive = true;
    int score = 0;
    Laser myLaser = new Laser();
    public void act() 
    {
        MouseInfo myMouse = Greenfoot.getMouseInfo();
        World myWorld = getWorld();

        if(alive)
        {
            if(myMouse != null)
            {
                int mouseX = myMouse.getX();
                int mouseY = myMouse.getY();
                int mouseButton = myMouse.getButton();
                turnTowards(mouseX, mouseY);
                if(mouseButton == 1)
                {
                    move(10);
                } else if (mouseButton == 3)
                {

                    myWorld.addObject(myLaser, getX(), getY());
                    myLaser.setLocation(getX(), getY());
                    myLaser.setRotation(getRotation());
                }
            }

            Actor gotFly = getOneIntersectingObject(Fly.class);
            if(gotFly !=null)
            {
                myWorld.removeObject(gotFly);
            }
            Actor gotBee = getOneIntersectingObject(Bee.class);
            if(gotBee !=null)
            {
                setImage("skull.png");
                alive = false;
            }

        }    
    }
}
