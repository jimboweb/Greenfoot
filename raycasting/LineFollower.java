/**
 * Write a description of class LineFollower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class LineFollower  
{
    protected void followLine(int lineStartX, int lineStartY, double dirX, double dirY)
    {   
        if (!doSquare(lineStartX, lineStartY, lineStartX + 0.5, lineStartY + 0.5, true))
            return;
        
        if (dirX == 0 && dirY == 0)
            return;
            
        if (Math.abs(dirX) >= Math.abs(dirY))
            doSquares(lineStartX, (int)Math.signum(dirX), lineStartY, dirY / dirX, true);
        else
            doSquares(lineStartY, (int)Math.signum(dirY), lineStartX, dirX / dirY, false);
    }
    
    private void doSquares(int start, int advance, int startMinor, double slope, boolean horizontal)
    {
        double curMinor = startMinor + 0.5 + (0.5 * advance * slope);
        for (int curMajor = start + advance; ; curMajor += advance)
        {
            double newMinor = curMinor + (advance * slope);
            if (!doSquare(curMajor, (int)Math.floor(curMinor), advance == 1 ? curMajor : curMajor + 1, curMinor, horizontal))
                return;
            
            if (Math.floor(newMinor) != Math.floor(curMinor) /* && Math.abs(slope) != 1 */)
            {
                double hitMajor;
                double hitMinor;
                if (newMinor > curMinor)
                {
                    hitMinor = Math.floor(newMinor);
                    
                }
                else
                {
                    hitMinor = Math.floor(curMinor);
                }
                hitMajor = curMajor + (advance < 0 ? -advance : 0) + ((double)advance * ((hitMinor - curMinor) / (newMinor - curMinor)));
                
                if (!doSquare(curMajor, (int)Math.floor(newMinor), hitMajor, hitMinor, horizontal))
                    return;
            }
            curMinor = newMinor;
        }
    }
    
    private boolean doSquare(int major, int minor, double impactMajor, double impactMinor, boolean horizontal)
    {
        if (horizontal) // X is major
            return process(major, minor, impactMajor, impactMinor);
        else // Y is major
            return process(minor, major, impactMinor, impactMajor);
    }
    
    /**
     * Return true to continue with the line, false to stop
     * 
     * @param x The x coordinate of the grid cell to check
     * @param y The y coordinate of the grid cell to check
     * @param impactX The exact x coordinate where the square was entered by the line
     * @param impactY The exact x coordinate where the square was entered by the line     * 
     */
    protected abstract boolean process(int x, int y, double impactX, double impactY);
}
