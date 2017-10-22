import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * A lottoboard we can place numbers on
 * 
 * @author Jim Stewart
 * @version 5/17/14
 */
public class LottoBoard extends Actor
{
    int lottoBoardColumns;  //Number of columns in the board
    int lottoBoardRows;     //Number of rows in the board
    int columnWidth;        //Width of a column
    int rowHeight;          //Height of a column
    GreenfootImage myImage; //the image of the board
    Font bigFont = new Font("Courier", Font.PLAIN, 72); //Font for big numbers. Actually I never use this. 
    Font littleFont = new Font("Courier",Font.PLAIN,30);    //Font for little numbers
    boolean[] lottoNumbersPicked;   //Boolean variable for whether each number has been
                                    //picked or not. So if number 37 has been picked, then  
                                    //lottoNumbersPicked[37] = true.
    public LottoBoard(int columns, int rows)    //expects columns and rows argument
    {
        lottoBoardColumns = columns;        //Assigns columns to variable
        lottoBoardRows = rows;              //Assigns rows to variable
        setImage(new GreenfootImage(401,401));  //create the image of 401 pixels wide and high
        myImage = getImage();                   //gets the image so I can work with it
        myImage.setColor(Color.BLACK);          //Set the drawing color to black
        myImage.drawRect(0, 0, myImage.getWidth()-1,myImage.getHeight()-1); //Draw the square
        myImage.setFont(bigFont);               //unnecessary line left over from earlier version of program
        columnWidth = myImage.getWidth()/lottoBoardColumns; //Width of column = width of image divided by number of columns
        rowHeight = myImage.getHeight()/lottoBoardRows;     //Width of row = height of image divided by number of rows
        lottoNumbersPicked = new boolean[lottoBoardColumns*lottoBoardRows+1];   //Set the size of the array to number of numbers to pick
        for(int i=1;i<lottoNumbersPicked.length;i++)    //Go through each number
        {
            lottoNumbersPicked[i]=false;                //and declare it hasn't been picked yet
        }
        for(int i=1; i<lottoBoardColumns;i++)                       //Go through each column
        {
            int lineX =i*columnWidth;                               //set the x location of the line
            myImage.drawLine(lineX, 0, lineX, myImage.getHeight()); //and draw a line to right of column
        }
        for(int i=1; i<lottoBoardRows;i++)                          //go through each row
        {
            int lineY =i*rowHeight;                                 //set y location of row
            myImage.drawLine(0, lineY, myImage.getWidth(), lineY);  //and draw a line at bottom of row
        }
    }
    /*
     * isNumberPicked method returns true if a number has been picked
     */
    public boolean isNumberPicked(int num)  //Expects the number to check
    {
        return lottoNumbersPicked[num];
    }
    /*
     * placeNumber method places a number on the board.
     */
        public void placeNumber(int num)            //Expects the number to place
        {
      myImage.setFont(littleFont);                  //This is actually the only font I use
      String numString = String.valueOf(num);       //Sets the number to a string type so we can use drawString method below
      lottoNumbersPicked[num]= true;                //Declares it's true the number has been picked 
      int numRow = (int)(num-1)/lottoBoardColumns;  //Finds the correct row by dividing by the number of columns. "-1" is so that numbers ending in 0 will be on the previous row.
      int numColumn = (num-1)%lottoBoardColumns;    //Finds the correct column by using modular division and placing it in the column of the remainder.
      int numX = numColumn * columnWidth + 2;       //Finds the x coordinate on the image where the number goes by multiplying by column width
      int numY = numRow * rowHeight+(rowHeight/2+10);//Finds the y coord on image by multiplying by row height
      myImage.drawString(numString, numX, numY);    //draws the number in the right place
    }
    public void act() 
    {
        // I could have cut this out; there is no act method for this
    }    
}
