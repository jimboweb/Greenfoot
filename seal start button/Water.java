import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends World
{
    Button button = new Button(this, "Start");
    boolean gamePlaying = false;
    GreenfootSound song = new GreenfootSound("song.mp3");
    /**
     * Constructor for objects of class Water.
     * 
     */
    public Water()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }
    public void act()
    {
        song.play();
        
    }
    public boolean isGamePlaying()
    {
        return gamePlaying;
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Seal2 seal2 = new Seal2();
        addObject(seal2, 245, 153);
        Fish fish = new Fish();
        addObject(fish, 363, 270);
        Fish fish2 = new Fish();
        addObject(fish2, 166, 275);
        Fish fish3 = new Fish();
        addObject(fish3, 93, 100);
        Fish fish4 = new Fish();
        addObject(fish4, 382, 82);
        Fish fish5 = new Fish();
        addObject(fish5, 68, 222);
        Fish fish6 = new Fish();
        addObject(fish6, 238, 47);
        Fish fish7 = new Fish();
        addObject(fish7, 261, 333);
        PolarBear polarbear = new PolarBear();
        addObject(polarbear, 371, 207);
    }
}
