import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    List<String> cardText = new ArrayList<String>();
    Random rnd = new Random();
    public Card()
    {
        cardText.add("This is the text of card 1 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        cardText.add("This is the text of card 2 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        cardText.add("This is the text of card 3 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        GreenfootImage cardImg = new GreenfootImage(200, 300);
        cardImg.setColor(Color.WHITE);
        cardImg.fillRect(0,0,cardImg.getWidth(), cardImg.getHeight());
        cardImg.setColor(Color.BLACK);
        cardImg.drawRect(1, 1, cardImg.getWidth()-2, cardImg.getHeight()-2);
        String thisCardText = cardText.get(rnd.nextInt(cardText.size()));
        String[] thisCardSplit = thisCardText.split(" ");
        String thisCardTextFinal = "";
        for(int i=0;i<thisCardSplit.length;i++)
        {
            int lineNumber;
        }
        cardImg.drawString(thisCardText, cardImg.getWidth()/2-50, cardImg.getHeight()/2);
        setImage(cardImg);
    }
    /**
     * Act - do whatever the Card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
