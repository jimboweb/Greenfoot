import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Pick a random number when you click on it
 * 
 * @author Jim Stewart
 * @version 5/15/2004
 */
public class Number extends Actor
{
    int maxNumber;              //The biggest number we can draw
    int height = 101;           //the height of the image
    int width = 101;            //the width of the image
    public Number(int n)        //expects a maximum number we can draw
    {
        maxNumber = n;          //assigns max number to varible
        update("Click here!", 12);  //creates the initial instructions
    }

    /**
     * Act - do whatever the Number wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))    //When this actor is clicked by the mouse
        {
            Bingo bingo = (Bingo)getWorld();                                //Get world and type it to Bingo class so we can use its getLottoBoard method
            LottoBoard lottoboard = bingo.getLottoBoard();                  //Get the lottoboard so we can use its methods
            int thisNumber=0;                                               //create and assign the number we will draw
            boolean needUnusedNumber = true;                                //At first we need a number that hasn't been used yet
            int tries = 0;                                                  //The number of times we've tried to draw a number
            while(needUnusedNumber)                                         //Keep drawing numbers until we've found one we haven't used yet
            {
                thisNumber = pickNumber();                                  //pick the number
                tries++;                                                    //add one to the number of tries
                needUnusedNumber = lottoboard.isNumberPicked(thisNumber);   //If the number hasn't been used then needUnusedNumber = false and loop will end
                /*
                 * In retrospect everything inside the if statement
                 * should probably be its own method. 
                 */
                if(tries>12)                                                //but if we've tried more than 12 times and still haven't gotten an unused number...
                {
                    boolean numbersLeft = false;                            //...let's first assume that all the numbers have been used...
                    for(int i=1;i<=maxNumber;i++)                           //...then go through all the numbers...
                    {
                        if(!lottoboard.isNumberPicked(i))                   //...and see if they were used...
                        {
                            numbersLeft = true;                             //..if one hasn't been used then it's true numbers are left and we can keep pulling numbers...
                        }
                    }
                    /*
                     * Actually, this doesn't need to be a separate if statement. I could have just put it in the previous if statement. 
                     * This whole section could be prettier.
                     * There's some opportunities to improve the code!
                     */
                    if(!numbersLeft)                                        //...but if there are no numbers left
                    {
                        thisNumber = 0;                                     //...then we'll set the number to 0
                        needUnusedNumber = false;                           //...and say we don't need a number anymore which will break the loop
                    }
                }
            }
            lottoboard.placeNumber(thisNumber);                             //Once we've got an unused number, place it on the board
            String numberString = String.valueOf(thisNumber);               //Declare the number a string because the update method expects a string argument
            update(numberString, 72);                                       //and use the update method to draw the number in the square of this actor 

        }
    }    

    /*
     * This method is pretty obvious. It picks a random number and returns it. 
     */
    public int pickNumber()
    {
        int number = Greenfoot.getRandomNumber(maxNumber)+1;
        return number;
    }

    /*
     * The update method draws the number or string on the actor after we've clicked it. 
     */
    public void update(String numberString, int fontSize)   //expects a string and a font size. That's so we can write "click here" in a smaller font at the beginning. 
    {
        setImage(new GreenfootImage(height, width));        //sets the image to the right size
        GreenfootImage myImage = getImage();                //assigns the image to a variable
        myImage.setColor(Color.BLACK);                      //assigns the drawing color to black
        myImage.drawRect(0,0,width -1,height -1);           //draws the square around the image
        Font f = new Font("Courier", Font.PLAIN, fontSize); //creates the font
        myImage.setFont(f);                                 //sets the font
        myImage.drawString(numberString,7,72);              //draws the number or the string on the square
    }
}
