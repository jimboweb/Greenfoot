/**
 * <p>GameOver contains a boolean static variable that tells whether the game is over or not. 
 * It contains static methods to set and return it.</p>
 * 
 * <p>To use the gameOver variable in actors, modify each of your actors
 * by putting a conditional around everything in their act() method, as follows:</p>
 * 
 * <p style = "font-weight: bold">
 * public void act()<br/>
 * {<br/>
 * if(!GameOver.isGameOver())//add this<br/> 
 * {//add this<br/> 
 *     //whatever was in your act() method before<br/>
 * }//add this <br/>              
 * }<br/>
 * </p>
 * 
 * <p>
 * The endGame() method ends the game. To end the game, use the following method:
 * </p>
 * 
 * <p style = "font-weight: bold">
 * GameOver.endGame();
 * </p>
 * 
 * <p>For example,if you want to end the game when the BadGuy actors are eliminated, you can
 * use the following code in your world's act() method:
 * </p>
 * 
 * <p style = "font-weight: bold">
 * int numberOfBadGuys = getObjects(BadGuy.class).size();<br />
 * if (numberOfBadGuys==0)<br />                              
 *       {<br />                                                           
 *           showText("You won!", getWidth()/2, getHeight()/2);//if this gives you an error, update to the new version of Greenfoot<br />       
 *           GameOver.endGame();<br />                                                             
 *       }<br />
 * </p>
 * 
 * <p>
 * To start the game, put the following code in your world's constructor:
 * </p>
 * 
 * <p style = "font-weight: bold">
 * GameOver.startGame();
 * </p>
 * @author Jim Stewart
 * @version 1.0
 */
public class GameOver  
{
    private static boolean gameOver = false;  //static boolean variable tells if game is over

    public static void startGame()          //sets gameOver to false when the game starts
    {
        gameOver=false;
    }
    
    
    public static void endGame()
    {
        gameOver=true;
    }
    
    public static boolean isGameOver()
    {
        return gameOver;
    }
 }
