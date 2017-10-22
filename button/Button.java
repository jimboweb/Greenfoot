import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Simple button
 * 
 * @author Jim Stewart
 * @version 1.0
 */
public class Button extends Actor
{
    private Color backgroundColor = Color.BLUE;
    private Color textColor = Color.WHITE;
    private int fontSize = 20;
    private String buttonText;
    
    public Button (String buttonText)
    {
        this.buttonText = buttonText;
        setImage(new GreenfootImage(buttonText, fontSize, backgroundColor, textColor));
    }
    
    /**
     * clicked method returns 'true' when button has been clicked.
     * Given object 'Button button = new Button("Click here!")
     * You can check if it's clicked by calling the if statement
     * if(button.clicked)
     * {
     *      //do whatever you want to do   
     *  }
     */
    public boolean clicked()
    {
        boolean clicked = false;
        if(Greenfoot.mouseClicked(this))
        {
            clicked = true;
        }            

        return clicked;
    }
}









