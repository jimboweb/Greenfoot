import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Draws a number
 * 
 * @author Jim Stewart
 * @version 5/15/2014
 */
public class Number extends Actor
{
    int maxNumber;
    Bingo bingo;
    LottoBoard lottoboard;

    public Number(int n)
    {
        maxNumber = n;
        setImage(new GreenfootImage(101,101));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, 100, 100);
        Font f = new Font("Courier", Font.PLAIN, 12);
        myImage.setFont(f);
        myImage.drawString("Click here", 7, 50);   
    }

    public void addedToWorld()
    {
        bingo = (Bingo)getWorld();
        lottoboard = bingo.getLottoBoard();
        int firstNumber = pickNumber(maxNumber);
        String numberString = String.valueOf(firstNumber);
        update("25");

    }

    public int pickNumber(int max)
    {
        boolean needANumber=true;
        int tries = 0;
        int number=10;

        while(needANumber)
        {
            number = Greenfoot.getRandomNumber(max);
            tries++;
            bingo = (Bingo)getWorld();
            lottoboard = bingo.getLottoBoard();

            if(!lottoboard.isNumberPicked(number))
            {
                needANumber=false;
            }
            else if (tries>10)
            {
                boolean numbersLeft = false;
                for(int i=1;i<=max;i++)
                {
                    if(!lottoboard.isNumberPicked(number))
                    {
                        numbersLeft = true;
                    }
                }
                if(!numbersLeft)
                {
                    return 0;
                }
            }
        }
        lottoboard.pickNumber(number);
        return number;
    }

    public void update(String numberString)
    {
        setImage(new GreenfootImage(101,101));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, 100, 100);
        Font f = new Font("Courier", Font.PLAIN, 72);
        myImage.setFont(f);
        myImage.drawString(numberString, 7, 72);   
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            int thisNumber = pickNumber(maxNumber);
            String numberString = String.valueOf(thisNumber);
            update(numberString);
        }
    }
}
