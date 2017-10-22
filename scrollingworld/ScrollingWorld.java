import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Write a description of class ScrollingWorld here.
 * 
 * @author Jim Stewart 
 * @version 1.0
 */
public class ScrollingWorld extends World
{
    private static int screenWidth = 600;
    private static int screenHeight = 400;
    private static int worldWidth = 2000;
    private static int worldHeight= 2000;
    private static int leftX = 700;
    private static int topY = 800; 
    private int playerX = -1;
    private int playerY = -1;
    private int screenCenterAbsX;
    private int screenCenterAbsY;
    Player p;
    BuildButton buildButton;
    boolean buildMode = false;
    int lastMouseX=0;
    int lastMouseY=0;
    String worldBuilderFile = "ScrollingWorld.txt";
    private static ArrayList<String> actorList =new ArrayList<String>();
    private Actor player;
    private ArrayList<Actor> scrollingActors = new ArrayList<Actor>();;
    private ArrayList<Actor> fixedActors = new ArrayList<Actor>();;
    public static World makeScrollingWorld(String worldBuilderFile) throws IOException, InstantiationException, ClassNotFoundException, IllegalAccessException
    {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(worldBuilderFile));
            String l;
            int worldWidth;
            int worldHeight;
            int screenWidth;
            int screenHeight;
            int leftX;
            int topY;
            while((l=br.readLine())!=null)
            {
                if(l.startsWith("worldWidth"))
                    worldWidth = Integer.parseInt(l.split(":")[1]);
                else if(l.startsWith("worldHeight"))
                    worldHeight = Integer.parseInt(l.split(":")[1]);
                else if(l.startsWith("screenWidth"))
                    screenWidth = Integer.parseInt(l.split(":")[1]);
                else if(l.startsWith("worldWidth"))
                    worldWidth = Integer.parseInt(l.split(":")[1]);
                else if(l.startsWith("leftX"))
                    leftX = Integer.parseInt(l.split(":")[1]);
                else if(l.startsWith("topY"))
                    topY = Integer.parseInt(l.split(":")[1]);
                else if(l.contains("Actor"))
                {
                    actorList.add(l);
                }
            }
        } finally {
            if(br!=null)
                br.close();
        }
        return new ScrollingWorld(worldWidth, worldHeight, screenWidth, screenHeight, leftX, topY);
    }

    /**
     * Constructor for objects of class ScrollingWorld.
     * 
     */
    public ScrollingWorld() 
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
    }

    private ScrollingWorld(int worldWidth, int worldHeight, int screenWidth, int screenHeight, int leftX, int topY) throws InstantiationException, ClassNotFoundException, IllegalAccessException
    {    
        super(screenWidth, screenHeight, 1, false); 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.leftX = leftX;
        this.topY = topY;
        placeActors();
    }

    /*
    public ScrollingWorld(int worldWidth, int worldHeight, int screenWidth, int screenHeight)
    {    
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    super(screenWidth, screenHeight, 1, false); 
    this.worldWidth = worldWidth;
    this.worldHeight = worldHeight;
    }
     */
    public void act()
    {
    }

    public void shiftWorld(Actor player, int deltaX, int deltaY)
    {
        for(Actor a: scrollingActors)
        {
            a.setLocation(a.getX()+deltaX, a.getY()+deltaY);
        }
        leftX-=deltaX;
        topY-=deltaY;
        screenCenterAbsX = leftX + screenWidth/2;
        screenCenterAbsY = topY + screenHeight/2;
        //System.out.println("leftX = "+ leftX + ", topY = "+ topY + ", screenCenterAbsX = " + screenCenterAbsX + ", screenCenterAbsY = " + screenCenterAbsY);
    }

    public void scrollAround (Actor player)
    {
            if(playerX == -1)
            {
                playerX = player.getX();
                playerY = player.getY();
            } else if (playerX!=player.getX()||playerY!=player.getY())
            {
                int deltaX = playerX - player.getX();
                int deltaY = playerY - player.getY();
                player.setLocation(playerX, playerY);
                if(screenCenterAbsX - deltaX > 0 && screenCenterAbsX-deltaX < worldWidth)
                    shiftWorld(player, deltaX, 0);
                
                if(screenCenterAbsY - deltaY >0 && screenCenterAbsY - deltaY < worldHeight)
                    shiftWorld(player, 0, deltaY);
            }
    }

    private void placeActors() throws InstantiationException, ClassNotFoundException, IllegalAccessException
    {
        for(String a : actorList)
        {
            String key = a.split(":")[0];
            String value = a.split(":")[1];
            String className = value.split(",")[0];
            int x = Integer.parseInt(value.split(",")[1]);
            int y = Integer.parseInt(value.split(",")[2]);
            try{                         
                Class actorClass = Class.forName(className);
                Actor addedActor = (Actor)actorClass.newInstance();
                addObject(addedActor, x, y);
                if (key =="playerActor")
                    player = addedActor;
                else if(key.contains("scrollingActor"))
                {
                    scrollingActors.add(addedActor);
                }
                else if(key.contains("fixedActor"))
                    fixedActors.add(addedActor);
            } catch (ClassNotFoundException e) {
                System.out.println(e + " when creating actor " + key );
            } catch(InstantiationException e)
            {
                System.out.println(e + " when creating actor " + key );
            } catch(IllegalAccessException e)
            {
                System.out.println(e + " when creating actor " + key );
            }  finally {

            }
        }
        

    }


}
