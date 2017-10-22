import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class rayWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rayWorld extends World
{
    private int mapWidth = 24;
    private int mapHeight = 24;

    int[][] worldMap = 
        {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,2,0,0,0,2,2,2,2,2,0,0,0,0,3,0,3,0,3,0,0,0,1},
            {1,0,2,0,0,0,2,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,2,0,0,0,2,0,5,0,2,0,0,0,0,3,0,0,0,3,0,0,0,1},
            {1,0,3,0,0,0,2,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,2,2,0,2,5,0,0,0,0,3,0,3,0,3,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,6,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,3,2,3,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,4,0,4,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,4,0,0,0,0,5,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,4,0,4,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,4,0,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
    double posX = 11, posY = 12;  //x and y start position
    double dirX = -1, dirY = 0; //initial direction vector
    double planeX = 0, planeY = 0.66; //the 2d raycaster version of camera plane

    double time = 0; //time of current frame
    double oldTime = 0; //time of previous frame

    int w;
    int h;
    GreenfootImage myImage;
    /**
     * Constructor for objects of class rayWorld.
     * 
     */
    public rayWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        w = getWidth();
        h = getHeight(); 
        setBackground(new GreenfootImage(w, h));
        myImage = getBackground();
        //System.out.println(worldMap[0][1]);
    }

    public void act()
    {
        setBackground(new GreenfootImage(w,h));
        myImage = getBackground();
        myImage.setColor(Color.WHITE);
        myImage.fillRect(0,0,w-1,h-1);
        for(int x = 0; x < w; x++)
        {
            //calculate ray position and direction 
            double cameraX = 2 * x / (double)(w) - 1; //x-coordinate in camera space
            double rayPosX = posX;
            double rayPosY = posY;
            double rayDirX = dirX + planeX * cameraX;
            double rayDirY = dirY + planeY * cameraX;
            /*System.out.println(" rayPosX = " + rayPosX +  " rayPosY = " 
            + rayPosY +  " rayDirX = " + rayDirX + 
            " rayDirY = " + rayDirY + " cameraX = " + cameraX);*/

            //which box of the map we're in  
            int mapX = (int)(rayPosX);
            int mapY = (int)(rayPosY);

            //length of ray from current position to next x or y-side
            double sideDistX;
            double sideDistY;

            //length of ray from one x or y-side to next x or y-side
            double deltaDistX = Math.sqrt(1 + (rayDirY * rayDirY) / (rayDirX * rayDirX));
            double deltaDistY = Math.sqrt(1 + (rayDirX * rayDirX) / (rayDirY * rayDirY));
            double perpWallDist;
            /*System.out.println("rayDirX = " + rayDirX + 
            " rayDirY = " + rayDirY + " deltaDistX = " + deltaDistX
            + " deltaDistY = " + deltaDistY);*/

            //what direction to step in x or y-direction (either +1 or -1)
            int stepX;
            int stepY;

            int hit = 0; //was there a wall hit?
            int side =0; //was a NS or a EW wall hit?

            //calculate step and initial sideDist
            if (rayDirX < 0)
            {
                stepX = -1;
                sideDistX = (rayPosX - mapX) * deltaDistX;
            }
            else
            {
                stepX = 1;
                sideDistX = (mapX + 1.0 - rayPosX) * deltaDistX;
            }
            if (rayDirY < 0)
            {
                stepY = -1;
                sideDistY = (rayPosY - mapY) * deltaDistY;
            }
            else
            {
                stepY = 1;
                sideDistY = (mapY + 1.0 - rayPosY) * deltaDistY;
            }

            //perform DDA
            while (hit == 0)
            {
                //jump to next map square, OR in x-direction, OR in y-direction
                if (sideDistX < sideDistY)
                {
                    sideDistX += deltaDistX;
                    mapX += stepX;
                    side = 0;
                }
                else
                {
                    sideDistY += deltaDistY;
                    mapY += stepY;
                    side = 1;
                }
                //Check if ray has hit a wall
                if (worldMap[mapX][mapY] > 0) 
                    hit = 1;

            }

            //Calculate distance projected on camera direction (oblique distance will give fisheye effect!)
            if (side == 0)
                perpWallDist = Math.abs((mapX - rayPosX + (1 - stepX) / 2) / rayDirX);
            else
                perpWallDist = Math.abs((mapY - rayPosY + (1 - stepY) / 2) / rayDirY);

            //Calculate height of line to draw on screen
            int lineHeight = Math.abs((int)(h / perpWallDist));

            //calculate lowest and highest pixel to fill in current stripe
            int drawStart = -lineHeight / 2 + h / 2;
            if(drawStart < 0)
                drawStart = 0;
            int drawEnd = lineHeight / 2 + h / 2;
            if(drawEnd >= h)
                drawEnd = h - 1;

            //choose wall color
            Color color;
            switch(worldMap[mapX][mapY])
            {
                case 1:  color = Color.RED;  break; //red
                case 2:  color = Color.GREEN;  break; //green
                case 3:  color = Color.BLUE;   break; //blue
                case 4:  color = Color.GRAY;  break; //white
                default: color = Color.YELLOW; break; //yellow
            }

            //give x and y sides different brightness
            if (side == 1) 
            {
                color = color.darker();
            }

            //draw the pixels of the stripe as a vertical line
            myImage.setColor(color);
            myImage.drawLine(x, drawStart, x, drawEnd);

            //timing for input and FPS counter
            oldTime = time;
            time = System.nanoTime();
            double frameTime = (time - oldTime)/1000000000; //frameTime is the time this frame has taken, in seconds
            //System.out.println(frameTime);
            int fps = (int)Math.round(1.0/frameTime);
            String fpsString = Integer.toString(fps);
            
            //showText(fpsString, getWidth()/2, 20); //FPS counter

            //speed modifiers
            double moveSpeed = frameTime * 5.0; //the constant value is in squares/second
            double rotSpeed = frameTime * 3.0; //the constant value is in radians/second        }

            //move forward if no wall in front of you
            if (Greenfoot.isKeyDown("up"))
            {
                //System.out.println("posX = " + (int)(posX + dirX * moveSpeed) + ", posY = " + (int)posY);
                if(worldMap[(int)(posX + dirX * moveSpeed)][(int)(posY)] == 0) 
                    posX += dirX * moveSpeed;
                if(worldMap[(int)(posX)][(int)(posY + dirY * moveSpeed)] == 0) 
                    posY += dirY * moveSpeed;
            }
            //move backwards if no wall behind you
            if (Greenfoot.isKeyDown("down"))
            {
                if(worldMap[(int)(posX - dirX * moveSpeed)][(int)(posY)] == 0) 
                    posX -= dirX * moveSpeed;
                if(worldMap[(int)(posX)][(int)(posY - dirY * moveSpeed)] == 0) 
                    posY -= dirY * moveSpeed;
            }
            //rotate to the right   
            if (Greenfoot.isKeyDown("right"))
            {
                //both camera direction and camera plane must be rotated
                double oldDirX = dirX;
                dirX = dirX * Math.cos(-rotSpeed) - dirY * Math.sin(-rotSpeed);
                dirY = oldDirX * Math.sin(-rotSpeed) + dirY * Math.cos(-rotSpeed);
                double oldPlaneX = planeX;
                planeX = planeX * Math.cos(-rotSpeed) - planeY * Math.sin(-rotSpeed);
                planeY = oldPlaneX * Math.sin(-rotSpeed) + planeY * Math.cos(-rotSpeed);
            }
            //rotate to the left
            if (Greenfoot.isKeyDown("left"))
            {
                //both camera direction and camera plane must be rotated
                double oldDirX = dirX;
                dirX = dirX * Math.cos(rotSpeed) - dirY * Math.sin(rotSpeed);
                dirY = oldDirX * Math.sin(rotSpeed) + dirY * Math.cos(rotSpeed);
                double oldPlaneX = planeX;
                planeX = planeX * Math.cos(rotSpeed) - planeY * Math.sin(rotSpeed);
                planeY = oldPlaneX * Math.sin(rotSpeed) + planeY * Math.cos(rotSpeed);
            }
        }

    }
}
