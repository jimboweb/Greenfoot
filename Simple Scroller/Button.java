import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * <p>Button creates a simple button that returns 'true' when clicked.
 * The basic call, when done by an Actor, looks like:</p>
 * 
 * <p style = "font-weight: bold">Button button = new Button(getWorld(), "My text here"); . </p>
 * 
 * 
 * <p>The intermediate call of Button specifies font size and x and y location of the text. For example to get
 * 16 point text at x = 100, y = 200, you would call:</p>
 * <p style = "font-weight: bold">Button button= new Button(getWorld(), "label", 16, 100, 200); </p>
 * 
 * <p>'button' could be anything. It is the name of the variable that represents the Button object.</p>
 * 
 * <p>By default Button gives black text on a white background. The advanced call of Button 
 * specifies the color and background color of the text. To get white text on a black background call:</p>
 * <p style = "font-weight: bold">Button button = new Button(getWorld(), "label", 16, 100, 200, Color.WHITE, Color.BLACK); </p>
 * 
 * <p>To use the advance call which specifies color, you must import java.awt.Color at the beginning of the class that calls 
 * Button, right below import greenfoot.*, as in:<p>
 * 
 * <p style = "font-weight: bold">import java.awt.Color;</p>
 * 
 * <p>If you want to create Button at the beginning of a game, you can call it from your World, using:</p>
 * <p style = "font-weight: bold">Button button = new Button(this, "label"); . </p>
 *
 * <p>To use an image for your button, you can specify the name of an image file that
 * is in your 'images' folder, along with an x and y coordinate. To use the file "start.png" you would call:</p>
 * 
 * <p style = "font-weight: bold">Button button= new Button(getWorld(), "start.png", 100, 200); </p>
 * 
 * 
 * <p>To use Button you must use the buttonClicked() method. It will return a boolean value.
 * for example, if you have a boolean variable called startGame that starts the game, in the
 * act() method of your World or Actor you can use the code:
 * 
 * <p style = "font-weight: bold">if(button.buttonClicked())<br />
 * {<br />
 *      startGame = true;    <br />
 * }<br />
 * </p>
 * 
 * <p>You can change the text of the button using the changeText() method. To change the text</p>
 * 
 * <p style = "font-weight: bold">button.changeText("new label");</p>
 * 
 * <p>You can change the image of a button using the changeImage() method, with an argument
 * of the filename of an image in your images folder. For example, to change the image to 
 * the file "stop.png" you can use the code:</p>
 * 
 * <p style = "font-weight: bold">changeImage("stop.png")</p>
 * 
 * <p>You can hide the button using the hide() method. To hide your button simply use:</p>
 * 
 * <p style = "font-weight: bold">button.hide()</p>
 * @author Jim Stewart
 * @version 1.0
 */
public class Button extends Actor
{
    World theWorld;
    Color textColor = Color.BLACK;
    Color bgColor = Color.WHITE;
    public Button(World myWorld, String text)
    {
        setImage(new GreenfootImage(text, 48, textColor, bgColor));
        int startX = myWorld.getWidth()/2;
        int startY = myWorld.getHeight()/2;
        myWorld.addObject(this, startX, startY);
    }

    public Button(World myWorld, String text, int fontSize, int startX, int startY)
    {
        setImage(new GreenfootImage(text, fontSize, textColor, bgColor));
        myWorld.addObject(this, startX, startY);
    }

    public Button(World myWorld, String text, int fontSize, int startX, int startY, Color textColor, Color bgColor)
    {
        this.textColor = textColor;
        this.bgColor = bgColor;
        setImage(new GreenfootImage(text, fontSize, textColor, bgColor));
        myWorld.addObject(this, startX, startY);
    }

    public Button(World myWorld, String fileName, int startX, int startY)
    {
        setImage(new GreenfootImage(fileName));
        myWorld.addObject(this, startX, startY);
    }

    public boolean buttonClicked()
    {
        boolean clicked = false;
        if(Greenfoot.mouseClicked(this))
        {
            clicked = true;
        }            

        return clicked;
    }
    
    public void changeText(String newText)
    {
        setImage(new GreenfootImage(newText, 48, textColor, bgColor));        
    }
    
    public void changeImage(String fileName)
    {
        setImage(new GreenfootImage(fileName));
    }

    public void hide()
    {
        setImage(new GreenfootImage(1,1));
    }
}
