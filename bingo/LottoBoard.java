import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class LottoBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LottoBoard extends Actor
{
    int lottoBoardColumns = 10;
    int lottoBoardRows = 9;
    int columnWidth;
    int rowHeight;
    GreenfootImage myImage;
    Font bigFont = new Font("Courier", Font.PLAIN, 72);
    Font smallFont = new Font("Courier", Font.PLAIN, 30);

    boolean[] lottoNumbersPicked = new boolean[lottoBoardColumns*lottoBoardRows+1];
    /**
     * Act - do whatever the LottoBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public LottoBoard()
    {
        for(int i=1;i<lottoNumbersPicked.length;i++)
        {
            lottoNumbersPicked[i] = false;
        }
        setImage(new GreenfootImage(401,401));
        myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, myImage.getWidth()-1, myImage.getHeight()-1);
        myImage.setFont(bigFont);
        columnWidth = myImage.getWidth()/lottoBoardColumns;
        rowHeight = myImage.getHeight()/lottoBoardRows;
        for (int i=1; i<lottoBoardColumns; i++)
        {
            int lineX=i*columnWidth;
            myImage.drawLine(lineX, 0, lineX, myImage.getHeight());
        }
        for (int i=1; i<lottoBoardRows; i++)
        {
            int lineY=i*rowHeight;
            myImage.drawLine(0, lineY, myImage.getWidth(), lineY);
        }
    }

    public int getArrayLength()
    {
        return lottoNumbersPicked.length;
    }
    
    public boolean isNumberPicked(int num)
    {
        return lottoNumbersPicked[num];
    }

    public void pickNumber(int num)
    {
        myImage.setFont(smallFont);
        String numString = String.valueOf(num);
        lottoNumbersPicked[num]=true;
        int numRow = (int)(num-1)/lottoBoardColumns;
        int numColumn = (num-1)%lottoBoardColumns;
        int numX = numColumn * columnWidth+2;
        int numY = numRow*rowHeight+(rowHeight/2+10);
        myImage.drawString(numString, numX, numY);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
