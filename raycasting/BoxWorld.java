import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Write a description of class BoxWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class BoxWorld
{
/*
    private ExactLineOverlay lineOverlay;
    private ImpactOverlay impactOverlay;
    private Player player;

    public BoxWorld()
    {    
        // Image should be odd in both dimensions for exact overlay to work:
        super(31, 19, 20);
        
        setPaintOrder(ExactLineOverlay.class, ImpactOverlay.class, Box.class);
        
        lineOverlay = new ExactLineOverlay(getWidth() * getCellSize(), getHeight() * getCellSize());
        addObject(lineOverlay, getWidth() / 2, getHeight() / 2);
        impactOverlay = new ImpactOverlay(getWidth() * getCellSize(), getHeight() * getCellSize());
        addObject(impactOverlay, getWidth() / 2, getHeight() / 2);
        
        for (int x = 0; x < getWidth(); x++)
        {
            for (int y = 0; y < getHeight(); y++)
            {
                Color c = getBackground().getColorAt(x, y);
                if (x == 0 || y == 0 || x == getWidth() - 1 || y == getHeight() - 1)
                    c = Color.BLACK;
                if (c.getBlue() < 64)
                {
                    addObject(new Box(c), x, y);
                    setOccupied(x, y, true);
                }
            }
        }
        
        getBackground().setColor(Color.WHITE);
        getBackground().fill();
        
        player = new Player();
        addObject(player, 15, 9);

        int numOpponents = 0;
        while (numOpponents < 10)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            if (getObjectsAt(x, y, Box.class).isEmpty() && getObjectsAt(x, y, Player.class).isEmpty()
                && getObjectsAt(x, y, Opponent.class).isEmpty())
            {
                addObject(new Opponent(), x, y);
                numOpponents += 1;
            }
        }
        
        calculatePaths();
        recalculateVisible(false);
    }
    
    public int toMiddle(int grid)
    {
        return (getCellSize() * grid) + (getCellSize() / 2); 
    }
    
    public int toExact(double grid)
    {
        return (int)(getCellSize() * grid); 
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public void opponentActions()
    {
        for (Object o : getObjects(Opponent.class))
        {
            ((Opponent)o).doAction();
        }
        
        recalculateVisible(false);
    }
    
    public void drawExactPath(int x1, int y1, int x2, int y2, Color c)
    {
        lineOverlay.clear();
        lineOverlay.drawExactLine(x1, y1, x2, y2, c);
        impactOverlay.drawImpact(x2, y2, c);
    }
    
    private class Visibility extends LineFollower
    {
        private boolean drawLines;
        
        public Visibility(boolean drawLines)
        {
            this.drawLines = drawLines;
        }
        
        public boolean process(int x, int y, double exactX, double exactY)
        {
            if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())
                return false;
            
            List<Visible> objs = getObjectsAt(x, y, Visible.class);
            
            for (Visible obj : objs)
            {
                obj.setVisible(true);
            }
            
            if (!objs.isEmpty() && drawLines)
            {
                lineOverlay.drawExactLine(toMiddle(getPlayer().getX()), toMiddle(getPlayer().getY()), toExact(exactX), toExact(exactY), Color.BLUE);
            }
            
            return objs.isEmpty();
        }        
    }
    
    public void setAllVisible(boolean visible)
    {
        List<Visible> objs = getObjects(Visible.class);
            
        for (Visible obj : objs)
        {
            obj.setVisible(visible);
        }
    }
    
    public void recalculateVisible(boolean drawLines)
    {
        setAllVisible(false);
        
        Visibility v = new Visibility(drawLines);
        
        for (int angle = 0; angle < 360; angle += 5)
        {
            double dirX = Math.cos(Math.toRadians(angle));
            double dirY = Math.sin(Math.toRadians(angle));
            v.followLine(getPlayer().getX(), getPlayer().getY(), dirX, dirY);
        }
    }
    */
}
