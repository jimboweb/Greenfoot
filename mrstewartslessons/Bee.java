import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    MoveWithArrows mwa = new MoveWithArrows(this);
    ScoreBoard scoreboard = new ScoreBoard(this, 48, 100,50);
    Projectile projectile = new Projectile(this, "space", 12, Balloon.class);
    MoveObstructedByObstacle moveobstructedbyobstacle = new MoveObstructedByObstacle(this, Wall.class);
    MoveWithMouse mwm = new MoveWithMouse(this);
    HealthBar healthbar = new HealthBar(this, 20, 80, 40, Color.BLACK, Color.BLUE, 50, 20);
    
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //mwa.moveActorWithArrows(5);
        //mwm.moveWithMouse();
        scoreboard.displayScore();
        scoreboard.increaseScore(projectile.fireProjectile());
        moveobstructedbyobstacle.moveWithArrowsOb(5);
        healthbar.displayHealth();

        
        Actor bomb = getOneIntersectingObject(Bomb.class); // See if you hit a bomb.
        if(bomb!=null) // If you did...
        {
            healthbar.loseHealth(); // ...subtract one from your health...
            getWorld().removeObject(bomb); // ...then remove the bomb so it won't take the rest of it.
        }
        if(healthbar.getHealth()==0) // If all your health is gone
            getWorld().removeObject(this);// remove your actor from the game.
            
    }    

}
