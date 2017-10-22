/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver  
{
    private static boolean gameOver = false;
    
    public static boolean isGameOver()
    {
        return gameOver;
    }
    
    public static void endGame()
    {
        gameOver = true;
    }
    
    public static void startGame()
    {
        gameOver = false;
    }
}
