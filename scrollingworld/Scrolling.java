import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scrolling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scrolling extends ScrollingWorld
{

    /**
     * Constructor for objects of class Scrolling.
     * 
     */
    public Scrolling()  
    {
        prepare();
    }
    
    public void prepare()
    {
        try{
             Greenfoot.setWorld(ScrollingWorld.makeScrollingWorld("MyScrollingWorld.txt"));
        } catch(java.io.IOException e) {
            System.out.println(e);   
        } catch (ClassNotFoundException cn) {
            System.out.println(cn + " in new scrolling world");
        } catch (InstantiationException ie) {
            System.out.println(ie + " in new scrolling worl");
        }catch (IllegalAccessException ie) {
            System.out.println(ie + " in new scrolling worl");
        } finally {

        }
    }
}
