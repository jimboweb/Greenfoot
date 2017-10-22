import greenfoot.*;
import java.awt.Color;
/**
 * <p>DriftMove allows an actor to move in a drifting way and accelerate in different directions. It allows
 * turning and acceleration using the arrows or the mouse. It also includes a method to wrap and bounce 
 * at the edge of the screen. It also includes a fall method, causing the actor to fall. It has a possible
 * maxSpeed argument, which can keep your actor from accelerating to an out-of-control speed. (Future versions
 * will include methods allowing the actor to land on an object and reflect off an object.</p>
 * 
 * <p>To use the DriftMove class, create a DriftMove object in the beginning of your actor class, using the 
 * following code:</p>
 * 
 * <p style = "font-weight:bold">DriftMove driftmove = new DriftMove(this);</p>
 * 
 * <p>By default your actor can go any speed, so if you keep accelerating in the same direction your actor 
 * will soon be moving so fast you can't see it. To keep this from happening you can include the optional 
 * maxSpeed argument. For example, if you don't want your actor to be able to go faster than 6 pixels per  
 * turn, use the code:</p>
 * 
 * <p style = "font-weight:bold">DriftMove driftmove = new DriftMove(this, 6);</p>
 * 
 * <p>(Technically, the maxSpeed is the maximum speed in the x and y direction. So at a perfect diagonal the
 * actor can go twice the maxSpeed.)</p>
 * 
 * <p>To cause your actor to drift, you must call the drift() method in your act() method, using the 
 * following code:</p>
 * 
 * <p style = "font-weight:bold">driftmove.drift();</p>
 * 
 * <p>To cause your actor to turn and accelerate using the arrows, use the turnAccelArrows() method. 
 * The simple version of this method has no arguments and turns five degrees every time you press
 * the arrows and accelerates at a rate of 0.2 pixels per turn every time you press the up arrow. To use this
 * method use the code:</p>
 * 
 * <p style = "font-weight:bold">dm.turnAccelArrows();</p>
 * 
 * <p>The more advanced version of turnAccelArrows calls a decimal (double) argument for 
 * acceleration and an integer argument for turn speed. Left and right 
 * arrows rotate your actor and the up arrow accelerates it. For example, to make your 
 * actor accelerate at a rate of 0.1 pixels per turn when you press the up arrow and turn at a rate of 2 degrees
 * per turn, you would use the code:</p>
 * 
 * <p style = "font-weight:bold">dm.turnAccelArrows(0.1, 2);</p>
 * 
 * <p>To cause your actor to turn and accelerate using the mouse, use the turnAccelMouse() method. This
 * causes your actor to point towards the mouse at all times and accelerate whenever you press the mouse
 * button. The simple version calls for no arguments and accelerates at a rate of 0.2 pixels per turn
 * every time you press the mouse button. To use this, type the code:</p>
 * 
 * <p style = "font-weight:bold">dm.turnAccelMouse();</p>
 * 
 * <p>The more advanced version of turnAccelMouse() calls for a double argument to represent acceleration. 
 * For example, to make your actor accelerate 0.1 px/turn when you press the mouse, use the code:</p>
 * 
 * <p style = "font-weight:bold">dm.turnAccelMouse(0.1);</p>
 * 
 * <p>DriftMove features a fall() method that causes your actor to accelerate downward at the rate of the 
 * double argument you pass it. For example, to make your actor accelerate downward 0.05 pixels per turn
 * per turn you can pass the argument:</p>
 * 
 * <p style = "font-weight:bold">dm.fall(0.05);</p>
 * 
 * <p>The bounceAtEdge() method makes you bounce when you hit the edge of the screen. It needs no
 * arguments. To make your actor bounce at the edge of the screen use the code:</p>
 * 
 * <p style = "font-weight:bold">dm.bounceAtEdge();</p>
 * 
 * <p>The wrapAtEdge() method makes you wrap to the other side of the screen when you hit 
 * the edge of the screen. It needs noarguments. To make your actor bounce at the edge of the 
 * screen use the code:</p>
 * 
 * <p style = "font-weight:bold">dm.wrapAtEdge();</p>
 * 
 * <p>DriftMove also features the setSpeed() method, which allows you to set the ship's absolute speed in
 * the x and y direction. This is useful if you want an object to be moving at the beginning of the 
 * game. So to make an object move at a rate of 5 upward and 3 to the right, you would use the code:</p>
 * 
 * <p style = "font-weight:bold">dm.setSpeed(-5, 3)</p>
 * 
 * <p>The setRandomSpeed() method sets the object at a random speed up to a maximum x and y speed you pass.
 * For example, to set a random speed with a maximum of 4 in either direction, you would use the code:</p>
 * 
 * <p style = "font-weight:bold">dm.setRandomSpeed(4, 4);</p>
 * 
 * <p>The bounceOffObject() method is experimental and doesn't work perfectly. It will make an object bounce
 * off another object of a certain class. It may bounce before it touches, and it may not bounce in 
 * certain circumstances. To make your actor bounce off an actor of class Balloon, use the code:</p>
 * 
 * <p style = "font-weight:bold">dm.bounceOffObject(Balloon.class);</p>
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class DriftMove extends Actor
{
    Actor mover;        //The actor who will be drifting
    int maxSpeed = 0;   //The maximum x and y speed. If it's set at 0 it will be ignored.
    double deltaX = 0;  //Your speed in the horizontal direction
    double deltaY = 0;  //Your speed in the vertical direction
    int leftBound = 0;  //The left boundary of the screen. Should stay at 0.
    int topBound = 0;   //The top boundary of the screen. Should stay at 0.
    int rightBound = 0; //The right boundary of the screen. Will be reset to the width of the world.
    int bottomBound = 0;    //The bottom boundary of the screen. Will be reset to the height of the world.
    double incrX = -1;
    double incrY = -1;
    /**
     * The simple constructor only needs one argument, which is the actor who will be drifting.
     */
    public DriftMove(Actor mover)
    {
        this.mover = mover;
    }

    /**
     * The more advanced constructor allows you to set a maximum speed at which the object will drift. This
     * is the maximum speed in the x and y direction. 
     */
    public DriftMove(Actor mover, int maxSpeed)
    {
        this.mover = mover;
        this.maxSpeed = maxSpeed;
    }

    /**
     * The accelerate() method is the basic method for acceleration. Usually it won't be used, but it's made 
     * public because you might want to control the acceleration directly from another object. It takes
     * two arguments, the amount of acceleration and the direction. The amount will automatically be 
     * converted to the correct deltaX and deltaY to match the direction.
     */
    public void accelerate(double amount, int direction)
    {
        deltaX += amount * Math.cos(Math.toRadians(direction));     //deltaX increased by amount times the cosine of direction
        deltaY += amount * Math.sin(Math.toRadians(direction));     //deltaY increased by amount times the sine of direction
        //System.out.println("deltaY = " + deltaY);
        if(maxSpeed>0)                                              //If there is a max speed set
        {
            if(Math.abs(deltaX) > maxSpeed)                         //See if the deltaX is more than the max speed
                deltaX = maxSpeed * Math.signum(deltaX);      //and if so set it to max speed. The part being multiplied by maxSpeed is the sign of the deltaX. 
            if(Math.abs(deltaY) > maxSpeed)                         //See if the deltaY is more than the max speed
                deltaY = maxSpeed * Math.signum(deltaY);      //and if so set it to the max speed. The part being multiplied by maxSpeed is the sign of the deltaY.
        } 
    }

    /**
     * To use the DriftMove object, you must call the drift() method in your act() method. It needs no arguments.
     */
    public void drift()
    {
        if(incrX == -1)
        {
            incrX = mover.getX();
            incrY = mover.getY();
        }
        //int x = mover.getX();                                   //get the x of the mover
        //int y = mover.getY();                                   //and the y
        incrX += deltaX;
        incrY += deltaY;
        mover.setLocation((int)Math.round(incrX), (int)Math.round(incrY));
    }

    /**
     * The bounceAtEdge() method makes you bounce when you hit the edge of the screen. It needs no
     * arguments.
     */
    public void bounceAtEdge()
    {
        if(rightBound == 0)                                 //If the right bound hasn't been set yet
            rightBound = mover.getWorld().getWidth() - 1;   //set it to the width of the world

        if(bottomBound == 0)                                //if the bottom bound hasn't been set yet
            bottomBound = mover.getWorld().getHeight() - 1; //set it to the height of the world

        int x = mover.getX();
        int y = mover.getY();

        if(x <= leftBound || x >= rightBound)
            deltaX = deltaX * -1;

        if(y <= topBound || y >= bottomBound)
            deltaY = deltaY * -1;
    }

    /**
     * The wrapAtEdge() method makes you wrap to the other side of the screen when you hit 
     * the edge of the screen. It needs no arguments. 
     */
    public void wrapAtEdge()
    {
        if(rightBound == 0)
            rightBound = mover.getWorld().getWidth() - 1;

        if(bottomBound == 0)
            bottomBound = mover.getWorld().getHeight() - 1;

        int x = mover.getX();
        int y = mover.getY();

        if(x <= leftBound)
            mover.setLocation(rightBound, y);

        if(x >= rightBound)
            mover.setLocation(leftBound, y);   

        if(y <= topBound)
            mover.setLocation(x, bottomBound);

        if(y >= bottomBound)
            mover.setLocation(x, topBound);
    }
    
    /**
     * The simple version calls for no arguments and accelerates at a rate of 0.2 pixels per turn
     * every time you press the mouse button.
     */
    public void turnAccelMouse()
    {
        double accelAmount = 0.2;
        MouseInfo pointer = Greenfoot.getMouseInfo();   //Get the mouse information
        if(pointer != null)                             //If the mouse is on the screen...
        {
            int mouseX = pointer.getX();                //get the mouse x coordinate
            int mouseY = pointer.getY();                //get the mouse y coordinate
            mover.turnTowards(mouseX, mouseY);        //point towards it
            int button = pointer.getButton();           //get the button
            if(button == 1) //if the button is down and not on the actor
            {
                accelerate(accelAmount, mover.getRotation());                       //move 10.
            }
        }                
    }

    /**
     * The more advanced version of this includes an argument for how much the actor will accelerate when the mouse is pressed. 
     */
    public void turnAccelMouse(double accelAmount)
    {
        MouseInfo pointer = Greenfoot.getMouseInfo();   //Get the mouse information
        if(pointer != null)                             //If the mouse is on the screen...
        {
            int mouseX = pointer.getX();                //get the mouse x coordinate
            int mouseY = pointer.getY();                //get the mouse y coordinate
            mover.turnTowards(mouseX, mouseY);        //point towards it
            int button = pointer.getButton();           //get the button
            if(button == 1) //if the button is down and not on the actor
            {
                accelerate(accelAmount, mover.getRotation());                       //accelerate
            }
        }                
    }
    /**
     * The simple version of this method has no arguments and turns five degrees every time you press
     * the arrows and accelerates at a rate of 0.2 pixels per turn every time you press the up arrow.
     */
    public void turnAccelArrows()
    {
        int turnSpeed = 5;
        double accelAmount = 0.2;
        if(Greenfoot.isKeyDown("left"))
            mover.turn(turnSpeed * -1);

        if(Greenfoot.isKeyDown("right"))
            mover.turn(turnSpeed);

        if(Greenfoot.isKeyDown("up"))
            accelerate(accelAmount, mover.getRotation());

    }
    /**
     * The more advanced version of turnAccelArrows calls a decimal (double) argument for 
     * acceleration and an integer argument for turn speed.
     */
    public void turnAccelArrows(double accelAmount, int turnSpeed)
    {
        if(Greenfoot.isKeyDown("left"))
        {
            mover.turn(turnSpeed * -1);
            //System.out.println(getRotation());
        }
            

        if(Greenfoot.isKeyDown("right"))
            mover.turn(turnSpeed);

        if(Greenfoot.isKeyDown("up"))
            accelerate(accelAmount, mover.getRotation());

    }
    /**
     * The fall() method causes your actor to accelerate downward at the rate of the 
     * double argument you pass it.
     */
    public void fall(double rate)
    {
        accelerate(rate, 90);
    }
    /**
     * The setSpeed() method allows you to set the ship's absolute speed in
     * the x and y direction.
     */
    public void setSpeed(double deltaX, double deltaY)
    {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        if(maxSpeed>0)
        {
            if(Math.abs(deltaX) > maxSpeed)
                deltaX = maxSpeed * (deltaX/Math.abs(deltaX));
            if(Math.abs(deltaY) > maxSpeed)
                deltaY = maxSpeed * (deltaY/Math.abs(deltaY));
        } 
    }

    /**
     * Sets a random x and y speed up to maxDeltaX and maxDeltaY arguments in a random direction.
     */
    public void setRandomSpeed(double maxDeltaX, double maxDeltaY)
    {
        int xSign = (Greenfoot.getRandomNumber(2) > 0) ? -1:1;
        int ySign = (Greenfoot.getRandomNumber(2) > 0) ? -1:1;

        this.deltaX = Math.random()*maxDeltaX * xSign;
        this.deltaY = Math.random()*maxDeltaY * ySign;
        if(maxSpeed>0)
        {
            if(Math.abs(deltaX) > maxSpeed)
                deltaX = maxSpeed * (deltaX/Math.abs(deltaX));
            if(Math.abs(deltaY) > maxSpeed)
                deltaY = maxSpeed * (deltaY/Math.abs(deltaY));
        } 

    }

    /**
     * Stops all x and y motion
     */
    public void stopMoving()
    {
        this.deltaX = 0;
        this.deltaY = 0;
    }


    /**
     * Bounces off another actor of reflectorClass. Doesn't work perfectly.
     */
    public void bounceOffObject(Class reflectorClass)
    {
        if(getWorld()==null)
        {
            setImage(new GreenfootImage(mover.getImage().getWidth()+10, mover.getImage().getHeight()+10));
            mover.getWorld().addObject(this, mover.getX(), mover.getY());
            //getImage().setColor(Color.RED);
            //getImage().drawRect(0, 0, getImage().getWidth()-1, getImage().getHeight()-1);
        }
        setLocation(mover.getX()+(int)deltaX, mover.getY()+(int)deltaY);
        setRotation(mover.getRotation());
        Actor reflector = getOneIntersectingObject(reflectorClass);
        if(reflector!=null)
        {
            int reflectorX = reflector.getX();
            int reflectorY = reflector.getY();
            int angleOfReflection = (int)Math.toDegrees(Math.atan2(reflectorY-getY(), reflectorX-getX()));
            //System.out.println(angleOfReflection);
            if(angleOfReflection >-45 && angleOfReflection <= 45 && deltaX > 0)
                deltaX = deltaX*-1;
                
            if(angleOfReflection>135 || angleOfReflection <= -135 && deltaX < 0)
                deltaX = deltaX*-1;
            
            if(angleOfReflection > 45 && angleOfReflection <= 135 & deltaY > 0)
                deltaY = deltaY*-1;
 
            if(angleOfReflection <= -45 && angleOfReflection > -135 && deltaY < 0)
                deltaY = deltaY*-1;
        }
    }
}
