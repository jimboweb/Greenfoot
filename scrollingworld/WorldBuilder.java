import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
/**
 * WorldBuilder class allows you to create a file that will define a scrolling world. 
 * 
 * @author Jim Stewart
 * @version 1.0
 */

/**
 * TODO: 
 * 3) Make the instructions clearer, for example that one must pause to add more actors
 * 
 * 4) Set the boundaries so you can't scroll past that point
 * 
 * 5) Make a button that calls the draw boundary method
 * 
 * 6) Make a line drawing method with boundaries
 * 
 * 7) Add the grid feature(?)
 * 
 * 8) Make a way to put in a background 
 * 
 * 9) We're going to lose precision with the scaling in and out. To make it precise we're going to need 
 * a double-precision location variable. 
 * 
 * 
 * DONE:
 * 1) Make an array of building tools that will be removed at the building of setup mode and
 * that won't be added at the beginning of build mode. Any build tools that are added to the screen
 * will be added to that array as well. 
 * 2) Move the zoomIn button down
 * 
 * 10) Find a way to call the create a new scrolling world with that file
 * 
 * 11) Fix the 'instanceof' problem like I did on moveObstructedByObstacle
 * 
 * 1) Divide the actors into the following classes:
 *          - Actors that will be written to the world (player actor will be [0] of that list)
 *          - Build tools that don't scroll
 *          - Build tools that do scroll
 *          - Build/setup button
 *          - Setup screen objects
 * 
 * 9) Make a function that writes the world stats to a file
 * 
 * 
 */
public class WorldBuilder extends World
{

    /**
     * All world data variables go here:
     */
    private int worldWidth=2000;        //The width of the world in which you can scroll
    private int worldHeight=2000;       //The height of the world in which you can scroll
    private int screenWidth=600;        //The width of the screen you see
    private int screenHeight=400;       //The height of the screen you see
    private int leftX = 700;            //How far to the left the screen is in the world
    private int topY = 800;             //How far down the screen is in the world

    private int screenCenterAbsX;             //This is the x & y ofhte top left corner of the screen we're
    private int screenCenterAbsY;              //viewing in build mode. 
    private int scale = 2;              //The scale you're viewing the world in build mode
    private int topYBuild;              //Where the top of the build world is in the scrolling world
    private int bottomYBuild;           //Where the bottom of the build world is in the scrolling world
    private int leftXBuild;             //Where the left side of the build world is in the scrolling world
    private int rightXBuild;            //Where the right side of the build world is in the scrolling world

    private int lastMouseX = 0;         //The last x the mouse is when you're dragging the world
    private int lastMouseY = 0;         //The last y the mouse is when you're dragging the world
    private Class selectedClass;        //The last class you've selected
    private boolean buildMode = false;  //Whether we're in build mode or setup mode
    private String worldData = "";      //The data that will be written to the world

    /**
     * Build button is its own category right now
     */
    private BuildButton buildButton;

    /**
     * All setup screen objects go here:
     */
    private String instructionString = "";  //The instructions during setup mode
    private StaticText instructions;        //The actor with the instructions in it
    private PlayerBox pb;                   //The box where the player will be placed
    private ArrayList<Actor> setupObjects;  //All the objects that will only be on the setup screen

    /**
     * All non-scrolling build tools will go here:
     */
    private ArrayList<Actor> nonScrollingBuildTools;    //All the build tools that will sty in one place
    private ClassMarker classmarker;                    //The thing that places the actors when you hold down 'shift'
    private ZoomInButton zoomIn;                        //the button that zooms in                
    private ZoomOutButton zoomOut;                      //The button that zooms out
    private SaveButton saveButton;
    private BorderBoundary topBound;
    private BorderBoundary bottomBound;
    private BorderBoundary leftBound;
    private BorderBoundary rightBound;

    /**
     * All scrolling build tools go here:
     */
    private ArrayList<Actor> scrollingBuildTools;       //All the build tools that scroll; mostly the screenbox now
    private ScreenBox sb;

    /**
     * All actors written to world go here:
     */
    private Class playerClass=null;                 //The class of the player actor
    private ArrayList<Class> actorClassesInGame ;      //The classes of the non-player actors
    private ArrayList<SelectBox> selectboxes;       //The boxes allowing the builder to select which actor they're placing
    private ArrayList<Actor> actorsInGame;       //All of the actors that will scroll

    /**
     * All text input variables go here:
     */
    private JTextField worldWidthInput;         //The input for world width
    private JTextField worldHeightInput;        //The input for world height
    private JTextField screenWidthInput;        //input for screen width
    private JTextField screenHeightInput;       //input for screen height
    private JTextField leftXInput;              //input for leftX
    private JTextField topYInput;               //input for top

    /**
     * Constructor for objects of class WorldBuilder.
     * 
     */
    public WorldBuilder()
    {    
        super(800, 600, 1, false); 
        buildButton = new BuildButton(this);
        scrollingBuildTools = new ArrayList<Actor>();
        nonScrollingBuildTools = new ArrayList<Actor>();
        setupObjects = new ArrayList<Actor>();
        actorClassesInGame = new ArrayList<Class>();
        selectboxes = new ArrayList<SelectBox>();
        actorsInGame = new ArrayList<Actor>();
        setPaintOrder(SelectBox.class);
        setup();
    }

    public void setup()
    {
        buildMode = false;
        if(playerClass!=null)
        {
            playerClass = null;

        }
        String instructionString = "To build a world, first add one of each of the \n" +
            "actors you will be using to this page. Place the player \n" +
            "actor in the box marked 'player.'";
        instructions = new StaticText(this, instructionString, 24, getWidth()/2, 50);
        setupObjects.add(instructions);
        pb = new PlayerBox();
        addObject(pb, getWidth()/2, getHeight()/2);
        setupObjects.add(pb);
        if(buildButton.getWorld()==null)
        {
            addObject(buildButton, 40, 20);
        }
    }

    public void build()
    {
        buildMode = true;
        String[] worldSizeArray = getWorldSize();

        this.worldWidth = Integer.parseInt(worldSizeArray[0]);
        this.worldHeight = Integer.parseInt(worldSizeArray[1]);
        this.screenWidth = Integer.parseInt(worldSizeArray[2]);
        this.screenHeight = Integer.parseInt(worldSizeArray[3]);
        this.leftX = Integer.parseInt(worldSizeArray[4]);
        this.topY = Integer.parseInt(worldSizeArray[5]);

        int pbLeft = pb.getX()-pb.getImage().getWidth()/2;
        int pbRight = pb.getX()+pb.getImage().getWidth()/2;
        int pbTop = pb.getY()-pb.getImage().getHeight()/2;
        int pbBottom = pb.getY()+pb.getImage().getHeight()/2;
        saveButton = new SaveButton(this);
        addObject(saveButton, 20, 60);
        nonScrollingBuildTools.add(saveButton);
        zoomIn = new ZoomInButton(this);
        zoomOut = new ZoomOutButton(this);
        addObject(zoomIn, 20, 100);
        addObject(zoomOut, 20, 140);
        nonScrollingBuildTools.add(zoomIn);
        nonScrollingBuildTools.add(zoomOut);
        List<Actor> allActors = getObjects(Actor.class);
        for(Actor a: allActors)
        {
            if(setupObjects.contains(a))
            {
                removeObject(a);
            } else if(!(nonScrollingBuildTools.contains(a)||scrollingBuildTools.contains(a)||a.equals(buildButton)))
                if(a.getX()>pbLeft && a.getX()<pbRight && a.getY()>pbTop && a.getY()<pbBottom)
                {
                    actorClassesInGame.add(0, a.getClass());
                    removeObject (a);
                } else {
                    Class thisClass = a.getClass();
                    if(!actorClassesInGame.contains(thisClass))
                        actorClassesInGame.add(thisClass);
                    removeObject(a);
            }
        }

        sb = new ScreenBox(screenWidth/2, screenHeight/2);
        addObject(sb, getWidth()/2, getHeight()/2);
        scrollingBuildTools.add(sb);
        screenCenterAbsX = leftX + screenWidth/2;
        screenCenterAbsY = topY + screenHeight/2;

        int xLocation=0;
        for(Class c: actorClassesInGame)
        {
            if(actorClassesInGame.indexOf(c)==0)
            {
                try
                {
                    actorsInGame.add(0,(Actor)c.newInstance());
                    Actor player = actorsInGame.get(0);
                    GreenfootImage playerImg = player.getImage();
                    playerImg.scale(playerImg.getWidth()/scale, playerImg.getHeight()/scale);
                    addObject(player, getWidth()/2, getHeight()/2);
                    setPaintOrder(player.getClass());
                } catch(InstantiationException e)
                {
                    System.out.println(e + " when adding player");
                } catch(IllegalAccessException e)
                {
                    System.out.println(e + " when adding player");
                }  finally {
                }

            } else {
                Actor template = null;
                try
                {
                    template = (Actor)c.newInstance();
                    template.getImage().scale(20, (20*template.getImage().getHeight())/template.getImage().getWidth());
                    xLocation = xLocation + 20 + template.getImage().getWidth()/2;
                    int yLocation = getHeight()-template.getImage().getHeight();
                    addObject(template, xLocation, yLocation);
                    nonScrollingBuildTools.add(template);
                    SelectBox newSB = new SelectBox(template);
                    selectboxes.add(newSB);
                    nonScrollingBuildTools.add(newSB);
                    addObject(selectboxes.get(selectboxes.size()-1), xLocation, yLocation);
                } catch(InstantiationException e)
                {
                    System.out.println(e + " when adding non player actor");
                } catch(IllegalAccessException e)
                {
                    System.out.println(e + " when adding non player actor");
                }  finally {
                }

            }
        }        
    }

    public void iconSelected(Class classSelected)
    {
        for(SelectBox sb: selectboxes)
        {

            if(!sb.actorClass().equals(classSelected))
            {
                sb.deselect();
            }
            this.selectedClass = classSelected;
            classmarker = new ClassMarker(this, classSelected);
        }
    }

    public void addActorsInGame(Actor newScrollingActor)
    {
        actorsInGame.add(newScrollingActor);
    }

    public Class selectedClass()
    {
        return selectedClass;
    }

    public void shiftScrollingWorld(int deltaX, int deltaY)
    {
        //System.out.println("screenCenterAbsY = " + screenCenterAbsY);
        for(Actor a: actorsInGame)
        {
            a.setLocation(a.getX()+deltaX, a.getY()+deltaY);
        }
        for(Actor a: scrollingBuildTools)
        {
            //System.out.println("Setting location for actor: " + a.toString() + " at location x = + " + a.getX() + " y = " + a.getY());
            a.setLocation(a.getX()+deltaX, a.getY()+deltaY);
        }
        screenCenterAbsX = screenCenterAbsX - (deltaX*scale);
        screenCenterAbsY = screenCenterAbsY - (deltaY*scale);
        //System.out.println("screenCenterAbsX = " + screenCenterAbsX + " screenCenterAbsY = " + screenCenterAbsY);

    }

    public void act() 
    {
        if(Greenfoot.mouseDragged(this))
        {
            if(lastMouseX==0)
            {
                greenfoot.MouseInfo startMouse = Greenfoot.getMouseInfo();
                lastMouseX = startMouse.getX();
                lastMouseY = startMouse.getY();
            } else {
                greenfoot.MouseInfo currentMouse = Greenfoot.getMouseInfo();
                if(screenCenterAbsX>=0 && screenCenterAbsY>=0 && screenCenterAbsX <= worldWidth && screenCenterAbsY <= worldHeight)
                {    
                    shiftScrollingWorld(currentMouse.getX()-lastMouseX, currentMouse.getY()-lastMouseY);
                }
                else
                {
                    if(screenCenterAbsX<0)
                    {
                        shiftScrollingWorld(screenCenterAbsX, 0);
                    } else if(screenCenterAbsY<0)
                    {
                        shiftScrollingWorld(0, screenCenterAbsY);
                    }
                    /**
                     * The two below here might not work. 
                     */

                    else if (screenCenterAbsX > worldWidth)
                    {
                        shiftScrollingWorld(screenCenterAbsX-worldWidth, 0);
                    } else if (screenCenterAbsY > worldHeight)
                    {
                        shiftScrollingWorld(0, screenCenterAbsY-worldHeight);
                    }
                }
                lastMouseX = currentMouse.getX();
                lastMouseY = currentMouse.getY();
            }
        }
        if(Greenfoot.mouseDragEnded(this))
        {
            lastMouseX=0;
            lastMouseY=0;
        }
        //topYBuild is where the top of the screen is in the top of the world. 
        topYBuild = screenCenterAbsY - ((getHeight()/2)*scale);
        leftXBuild = screenCenterAbsX - ((getWidth()/2)*scale);
        bottomYBuild = screenCenterAbsY + ((getHeight()/2)*scale);
        rightXBuild = screenCenterAbsX + ((getWidth()/2)*scale);
        //System.out.println("topYBuild = " + topYBuild + " leftXBuild = " + leftXBuild +  " bottomYBuild =  " + bottomYBuild + " rightXBuild =  " + rightXBuild);
        if(buildMode)
        {
            //System.out.println ("topYBuild = " + topYBuild + ", screenCenterAbsY = " + screenCenterAbsY);
            if(topYBuild < 0)
            {

                if(topBound==null)
                {
                    topBound = new BorderBoundary(worldWidth/scale);
                } /*else {
                    leftBound.getImage().scale(worldWidth/scale, 1);
                }*/
                if(topBound.getWorld()==null)
                {
                    addObject(topBound, 0 - leftXBuild/scale + topBound.getImage().getWidth()/2, 0 - topYBuild/scale);
                    scrollingBuildTools.add(topBound);
                }
            } else{
                if(topBound!=null && topBound.getWorld()!=null)
                {
                    removeObject(topBound);
                    scrollingBuildTools.remove(scrollingBuildTools.indexOf(topBound));
                }
            }
            //System.out.println("leftXBuild = " + leftXBuild + " screenCenterAbsX = " + screenCenterAbsX);
            if(leftXBuild < 0)
            {

                if(leftBound==null)
                {
                    leftBound = new BorderBoundary(worldHeight/scale);
                } /*else {
                    leftBound.getImage().scale(worldHeight/scale, 1);
                }*/
                
                if(leftBound.getWorld()==null)
                {
                    addObject(leftBound, 0 - leftXBuild/scale, 0 - topYBuild/scale + leftBound.getImage().getWidth()/2);
                    leftBound.setRotation(90);
                    scrollingBuildTools.add(leftBound);
                }
            } else{
                if(leftBound!=null && leftBound.getWorld()!=null)
                {
                    removeObject(leftBound);
                    scrollingBuildTools.remove(scrollingBuildTools.indexOf(leftBound));
                }
            }
            /**
             * <<START HERE: now add bottombound and rightbound and make sure that the part in 
             * the drag method works on the bottom and right. 
             */
            if(bottomYBuild > worldHeight)
            {

                if(bottomBound==null)
                {
                    bottomBound = new BorderBoundary(worldWidth/scale);
                } /*else {
                    leftBound.getImage().scale(worldWidth/scale, 1);
                }*/
                if(bottomBound.getWorld()==null)
                {
                    addObject(bottomBound, getWidth() - (rightXBuild-worldWidth)/scale - bottomBound.getImage().getWidth()/2, getHeight() - (bottomYBuild-worldHeight)/scale);
                    scrollingBuildTools.add(bottomBound);
                }
            } else{
                if(bottomBound!=null && bottomBound.getWorld()!=null)
                {
                    removeObject(bottomBound);
                    scrollingBuildTools.remove(scrollingBuildTools.indexOf(bottomBound));
                }
            }
            if(rightXBuild > worldWidth)
            {

                if(rightBound==null)
                {
                    rightBound = new BorderBoundary(worldHeight/scale);
                }/* else {
                    leftBound.getImage().scale(worldHeight/scale, 1);
                }*/
                if(rightBound.getWorld()==null)
                {
                    addObject(rightBound, getWidth() - (rightXBuild-worldWidth)/scale, getHeight() - (bottomYBuild-worldHeight)/scale - rightBound.getImage().getWidth()/2);
                    rightBound.setRotation(90);
                    scrollingBuildTools.add(rightBound);
                }
            } else{
                if(rightBound!=null && rightBound.getWorld()!=null)
                {
                    removeObject(rightBound);
                    scrollingBuildTools.remove(scrollingBuildTools.indexOf(rightBound));
                }
            }
        }
    }

    private String[] getWorldSize()
    {
        JTextField worldWidth = new JTextField(String.valueOf(this.worldWidth),5);
        JTextField worldHeight = new JTextField(String.valueOf(this.worldHeight),5);
        JTextField screenWidth = new JTextField(String.valueOf(this.screenWidth),5);
        JTextField screenHeight = new JTextField(String.valueOf(this.screenHeight),5);
        JTextField leftX = new JTextField(String.valueOf(this.leftX),5);
        JTextField topY = new JTextField(String.valueOf(this.topY),5);
        String[] worldStats = new String[6];

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        myPanel.add(new JLabel("Width of entire world:"));
        myPanel.add(worldWidth);
        myPanel.add(new JLabel("Height of entire world:"));
        myPanel.add(worldHeight);
        myPanel.add(new JLabel("Width of visible screen:"));
        myPanel.add(screenWidth);
        myPanel.add(new JLabel("Height of visible screen:"));
        myPanel.add(screenHeight);
        myPanel.add(new JLabel("x location of screen in world:"));
        myPanel.add(leftX);
        myPanel.add(new JLabel("y location of screen in world:"), BorderLayout.LINE_START);
        myPanel.add(topY);

        int result = JOptionPane.showConfirmDialog(null, myPanel, 
                "Define the size of world and screen", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            worldStats[0] = worldWidth.getText();
            worldStats[1] = worldHeight.getText();
            worldStats[2] = screenWidth.getText();
            worldStats[3] = screenHeight.getText();
            worldStats[4] = leftX.getText();
            worldStats[5] = topY.getText();

        }
        return worldStats;
    }

    public void zoomOut()
    {
        scale*=2;
        if(scale<=16)
        {
            for(Actor a: actorsInGame)
            {
                GreenfootImage img = a.getImage();
                img.scale(img.getWidth()/2, img.getHeight()/2);
                int centerX = getWidth()/2;
                int centerY = getHeight()/2;
                int aX = a.getX();
                int aY = a.getY();
                int aCenterX = centerX - aX;
                int aCenterY = centerY - aY;
                a.setLocation(centerX-aCenterX/2, centerY-aCenterY/2);
            }      
            for(Actor a: scrollingBuildTools)
            {
                if(!(a instanceof BorderBoundary))
                {
                    GreenfootImage img = a.getImage();
                    img.scale(img.getWidth()/2, img.getHeight()/2);
                    int centerX = getWidth()/2;
                    int centerY = getHeight()/2;
                    int aX = a.getX();
                    int aY = a.getY();
                    int aCenterX = centerX - aX;
                    int aCenterY = centerY - aY;
                    a.setLocation(centerX-aCenterX/2, centerY-aCenterY/2);
                }
            }      
            sb.reScale(screenWidth/scale, screenHeight/scale);
        } else {
            scale = 16;
        }
    }

    public void zoomIn()
    {
        scale/=2;
        if(scale>=1)
        {
            for(Actor a: actorsInGame)
            {
                String actorClassName = a.getClass().toString().split("class ")[1];
                try {
                    Actor proto = (Actor)Class.forName(actorClassName).newInstance();          
                    GreenfootImage protoImage = proto.getImage();
                    protoImage.scale((int)protoImage.getHeight()/scale, (int)protoImage.getWidth()/scale);
                    a.setImage(protoImage);

                } catch (ClassNotFoundException cn) {
                    System.out.println(cn + " in zoomIn function");
                } catch (InstantiationException ie) {
                    System.out.println(ie + " in zoomIn function");
                }catch (IllegalAccessException ie) {
                    System.out.println(ie + " in zoomIn function");
                }            
                int centerX = getWidth()/2;
                int centerY = getHeight()/2;
                int aX = a.getX();
                int aY = a.getY();
                int aCenterX = centerX - aX;
                int aCenterY = centerY - aY;
                a.setLocation(centerX-aCenterX*2, centerY-aCenterY*2);
            }        
            for(Actor a: scrollingBuildTools)
            {
                if(!(a instanceof BorderBoundary) && !(a instanceof ScreenBox))
                {
                    String actorClassName = a.getClass().toString().split("class ")[1];
                    try {
                        Actor proto = (Actor)Class.forName(actorClassName).newInstance();          
                        GreenfootImage protoImage = proto.getImage();
                        protoImage.scale((int)protoImage.getHeight()/scale, (int)protoImage.getWidth()/scale);
                        a.setImage(protoImage);

                    } catch (ClassNotFoundException cn) {
                        System.out.println(cn + " in zoomIn function");
                    } catch (InstantiationException ie) {
                        System.out.println(ie + " in zoomIn function");
                    }catch (IllegalAccessException ie) {
                        System.out.println(ie + " in zoomIn function");
                    }            
                    int centerX = getWidth()/2;
                    int centerY = getHeight()/2;
                    int aX = a.getX();
                    int aY = a.getY();
                    int aCenterX = centerX - aX;
                    int aCenterY = centerY - aY;
                    a.setLocation(centerX-aCenterX*2, centerY-aCenterY*2);
                }
            }        
            sb.reScale(screenWidth/scale, screenHeight/scale);
        } else {
            scale =1;
        }
    }

    private void buildBoundaries(Class obstacleClass) throws InstantiationException, IllegalAccessException
    {
        Actor obstacleTemplate=null;
        if(obstacleClass.getSuperclass().equals(Actor.class))
        {
            try {
                obstacleTemplate = (Actor)obstacleClass.newInstance();
            } catch(InstantiationException e)
            {
                System.out.println(e + " in Build boundaries function" );
            } catch(IllegalAccessException e)
            {
                System.out.println(e + " in Build boundaries function" );
            }  finally {

            }
            if(obstacleTemplate!=null)
            {
                int obWidth = obstacleTemplate.getImage().getWidth();
                int obHeight = obstacleTemplate.getImage().getHeight();

                //This loop draws the top boundary
                for(int i=obWidth; i<worldWidth; i+=obWidth)
                {
                    Actor thisObstacle = (Actor)obstacleClass.newInstance();
                    addObject(thisObstacle, 0-leftX+i+obWidth/2, 0-topY+obHeight/2);
                }

                //This loop draws the right boundary
                for(int i=obHeight; i<worldHeight; i+=obHeight)
                {
                    Actor thisObstacle = (Actor)obstacleClass.newInstance();
                    addObject(thisObstacle, worldWidth-leftX-obWidth/2, 0-topY+i+obHeight/2);
                }

                for(int i=0; i<worldWidth-obWidth; i+=obWidth)
                {
                    Actor thisObstacle = (Actor)obstacleClass.newInstance();
                    addObject(thisObstacle, 0-leftX+i+obWidth/2, worldHeight-topY-obHeight/2);
                }
                for(int i=0; i<worldHeight-obHeight; i+=obHeight)
                {
                    Actor thisObstacle = (Actor)obstacleClass.newInstance();
                    addObject(thisObstacle, 0-leftX+obWidth/2, 0-topY+i+obHeight/2);
                }
            }
        }
    }

    public int getScale()
    {
        return scale;
    }

    public boolean buildModeIsOn()
    {
        return buildMode;
    }

    public void createWorldData()
    {
        int originX = sb.getX()-sb.getImage().getWidth()/2; 
        int originY = sb.getY()-sb.getImage().getHeight()/2;
        worldData += "worldWidth:" + worldWidth + "\n";
        worldData += "worldHeight:" + worldHeight + "\n";
        worldData += "screenWidth:" + screenWidth + "\n";
        worldData += "screenHeight:" + screenHeight + "\n";
        worldData += "leftX:" + leftX + "\n";
        worldData += "topY:" + topY + "\n";
        for(Actor a : actorsInGame)
        {
            if(actorsInGame.indexOf(a)==0)
            {
                String actorName = "playerActor";
                worldData += actorName + ":"  + a.getClass().toString().split("class ")[1] + ",";
                worldData += ((a.getX() - originX) * scale) + ",";
                worldData += ((a.getY() - originY) * scale) + "\n";
            } else {
                String actorName = "scrollingActor" + (actorsInGame.indexOf(a)-1);
                worldData += actorName + ":"  + a.getClass().toString().split("class ")[1] + ",";
                worldData += ((a.getX() - originX) * scale) + ",";
                worldData += ((a.getY() - originY) * scale) + "\n";
            }

        }

    }

    public void writeWorld()
    {
        createWorldData();
        String fileName = "MyScrollingWorld";
        JTextField fileNameBox = new JTextField(fileName, 12);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        myPanel.add(fileNameBox);

        int result = JOptionPane.showConfirmDialog(null, myPanel, 
                "Enter a name for the world file:", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            if(fileNameBox.getText().length()>0)
                fileName = fileNameBox.getText() + ".txt";
        }        

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"));
            writer.write(worldData);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {writer.close();} catch (Exception ex) {System.out.println(ex);}
        }
    }

}
