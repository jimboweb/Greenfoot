import greenfoot.*;  
import java.awt.Color; 

/**
 * <p>HealthBar class Creates a Health Bar that counts down the actor's health as he loses it. It can also add to the health, set the health or
 * return the value.</p>
 * 
 * <p>The basic constructor calls for two arguments, the actor and the health of the actor to be counted.By default it is located at the coordinates 
 * 100, 20. The default bar color is red and the border color is white. To use the health bar for an actor whose health is 20, use 
 * the following code:</p>
 * 
 * <p style = "font-weight: bold">HealthBar healthbar = new HealthBar(this, 20);</p>
 * 
 * <p>The intermediate constructor calls for the actor, the health and the x and y coordinates. To create the same health bar at the location x = 80,
 * y = 40, use the following code:</p>
 * 
 * <p style = "font-weight: bold">HealthBar healthbar = new HealthBar(this, 20, 80, 40);</p>
 * 
 * <p>The advanced constructor calls for the actor, the health, the x and y coordinates, the border color, the bar color, the width of the health bar
 * and the height of the health bar. To use the health bar above with a black border, a blue bar, a width of 100 and a height of 20, use the following
 * code: </p>
 * 
 * <p style = "font-weight: bold">HealthBar healthbar = new HealthBar(this, 20, 80, 40, Color.BLACK, Color.BLUE, 100, 20);</p>
 * 
 * <p>HealthBar has a number of public methods. The ones you will need to use the health bar are displayHealth() and loseHealth().</p>
 * 
 * <p>The <strong>displayHealth()</strong> method is necessary to show the health of your actor. It takes no arguments. When you use the HealthBar class, you must use
 * the following code in your act() method:</p>
 * 
 * <p style = "font-weight: bold">healthbar.displayHealth();</p>
 * 
 * <p>The <strong>loseHealth()</strong> method makes your actor lose health when it is damaged by another actor. For example, if your actor loses health when it is hit by
 * the Bomb class, you would use the following code:</p>
 * 
 * <p>
 *       <div style = "font-weight: bold">Actor bomb = getOneIntersectingObject(Bomb.class); // See if you hit a bomb.</div>
 *       <div style = "font-weight: bold">if(bomb!=null) // If you did...</div>
 *       <div style = "font-weight: bold">{</div>
 *          <div style = "font-weight: bold; text-indent: 20px;"> healthbar.loseHealth(); // ...subtract one from your health...</div>
 *          <div style = "font-weight: bold; text-indent: 20px;"> getWorld().removeObject(bomb); // ...then remove the bomb so it won't take the rest of it. </div>
 *       <div style = "font-weight: bold">}</div>
 * </p>
 *  <p>You can put an integer argument in the <strong>loseHealth()</strong> method. For example, <strong>losehealth(5)</strong> will make you lose 5 health.</p> 
 *  
 *  <p>There are several other public methods: <strong>getHealth()</strong>, <strong>addHealth()</strong>, <strong>setHealth()</strong> and 
 *  <strong>fullHealth()</strong>.</p> 
 *  
 *  
 *  <p>The <strong>getHealth()</strong> method returns your health. You might use this to remove your actor when it loses all its health. For example, to remove your
 *  actor when all its health is gone, you could use the code:</p>
 *      <p>
 *      <div style = "font-weight: bold">if(healthbar.getHealth()<=0)// If all your health is gone</div>
 *      <div style = "font-weight: bold; text-indent: 20px;">getWorld().removeObject(this);// remove your actor from the game. </div>
 *      </p>
 *  <p>The <strong>addHealth()</strong> method increases your health by one. It can also have an integer argument. So <strong>addHealth(5)</strong> increases your health by 5. </p>
 *  
 *  <p>The <strong>setHealth()</strong> method sets your health to the given integer argument. So <strong>setHealth(10)</strong> sets your health to 10. </p>
 *  
 *  <p>The <strong>fullHealth()</strong> method sets your health back to the maximum health. </p>
 *  
 *  <p>HealthBar won't let your health go below 0 or above the passed maximum amount. </p>
 *  
 * @author Jim Stewart
 * @version 1
 */
public class HealthBar extends Actor
{
    int health;                         // Change this to give the ship more or less health.
    int maxHealth;                      //Maximum health you can have   
    int width = 80;                     //Default width is 82px
    int height = 15;                    //Default height is 17 px
    Color borderColor = Color.WHITE;    //Default border color
    Color barColor = Color.RED;         //Default bar color
    float pxPerPoint;                   //"Width" of each point, in fractional pixels. Will be rounded off when drawn.
    Actor theActor;                     //Whoever's health we're counting
    int xLocation = 100;                //Default x location is 100 pixels over
    int yLocation = 20;                 //Default y location is 20 pixels over
    
    public HealthBar (Actor theActor, int health)        // Simple constructor calls only for the actor and the health of the actor
    {                                   
        this.theActor = theActor;       // Set the actor whose health it is
        this.health = health;           // Set the health passed
        this.maxHealth = health;        // Set the maximum health for the fullHealth() reset method
        pxPerPoint = ((float)width)/health;  //This will give me decimal pixel amounts. It'll be rounded when we draw the bar in update()  
    }

    public HealthBar (Actor theActor, int health, int xLocation, int yLocation)
    {
        this.theActor = theActor;       // Set the actor whose health it is
        this.health = health;           // Set the health passed
        this.maxHealth = health;        // Set the maximum health for the fullHealth() reset method
        this.xLocation = xLocation;     // Set the x location
        this.yLocation = yLocation;     // Set the y location
        pxPerPoint = ((float)width)/health;  //This will give me decimal pixel amounts. It'll be rounded when we draw the bar in update()  
    }
    
    public HealthBar (Actor theActor, int health, int xLocation, int yLocation, Color borderColor, Color barColor, int width, int height)
    {
        this.theActor = theActor;       // Set the actor whose health it is
        this.health = health;           // Set the health passed
        this.maxHealth = health;        // Set the maximum health for the fullHealth() reset method
        this.xLocation = xLocation;     // Set the x location
        this.yLocation = yLocation;     // Set the y location
        this.borderColor = borderColor; // Set the border color
        this.barColor = barColor;       // Set the bar color
        this.width = width;             // Set the width
        this.height = height;           // Set the height
        pxPerPoint = ((float)width)/health;  //This will give me decimal pixel amounts. It'll be rounded when we draw the bar in update()  
    }
    
    /**
     * Shows the health of the actor. Must be put in the act() method of the actor calling health bar.
     */
    public void displayHealth() 
    {
        update(); // Updates the image every turn as the health changes. 
        if(getWorld()==null)                                            //If we're not in the world...
        {
            theActor.getWorld().addObject(this, xLocation, yLocation);  //...add ourselves to it
        }
    } 

    private void update()
    {
        setImage(new GreenfootImage(width + 2, height + 2));            //Makes blank image of assigned width and height
        GreenfootImage myImage = getImage();                    //Assigns the image to the variable myImage
        myImage.setColor(borderColor);                          // Sets the drawing color to white
        myImage.drawRect(0, 0, width + 1, height + 1);          // Draws an empty white 81x16 rectangle
        myImage.setColor(barColor);                             // Sets the drawing color to red
        int rectWidth = (int)Math.round(health * pxPerPoint);   // rectWidth will be 20 pixels per health bar
        myImage.fillRect(1, 1, rectWidth, height);          //Draws a filled red rectangle 15 pixels high
                                                                // and a width of rectWidth variable 
    }

    public void loseHealth()
    {
        health--;           // Reduce the health by one 
        if(health<0)        //health can't be less than 0.
            health =0;
    }
    
    public void loseHealth(int amount)
    {
        health-=amount;     // Reduce the health by passed amount
        if(health<0)        //health can't be less than 0.
            health =0;
    }
    
    public void addHealth()
    {
        health++;                   // Increase the health by one 
        if(health > maxHealth)     //Health can't be greater than max health
            health = maxHealth;
    }
    
    public void addHealth(int amount)
    {
        health+=amount;             // Increase the health by passed amount
        if(health > maxHealth)     //Health can't be greater than max health
            health = maxHealth;
    }
    
    public void setHealth(int amount)
    {
        if(health>=0)               //health can't be less than 0.
        {
            if(health<=maxHealth)   // If the health amount is less than the maximum health
                health=amount;      // set the health to the passed amount.
            else                    // If not
                health = maxHealth; // set it to the max. 
        }
    }
    
    public void fullHealth()
    {
        health=maxHealth;   //Set the health to the maximum
    }
    
    public int getHealth()
    {
        return health;      //Return the health
    }
}
