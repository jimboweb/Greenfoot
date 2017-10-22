import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The platform will know where its x and y coordinate is
 * 
 * @author Jim Steart
 * @version 1
 */
public class Platform extends Actor
{
    int mapX;   //This will be the X coordinate of this platform on the map
    int mapY;   //This will be the Ycoordinate of this platform on the map
    public Platform(int getMapX, int getMapY) //Constructor calls for x and y map coordinate
    {
        mapX = getMapX; // Assign the mapX coordinate
        mapY = getMapY; // Assign the mapY coordinate
    }
}

