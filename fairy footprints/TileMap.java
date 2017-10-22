
import java.awt.*;
// import java.awt.image.BufferedImage;
import java.util.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class TileMap {

    private BufferedImage[][] tiles;
    private int xMapHead;
    public int TILE_SIZE = 64;
    private int offsetX;
    public int offsetY;
    private int screenWidth;
    private int screenHeight;
    private int mapWidth;
    private int mapMoveSize;
    public boolean tMapMoveRight = false;
    public boolean tMapMoveLeft = false;

    /**
    Creates a new TileMap with the specified width and
    height (in number of tiles) of the map.
     * @param width
     * @param height
     */
    public TileMap(int width, int height) {
        tiles = new BufferedImage[width][height];
        xMapHead = 0;
        screenWidth = myWorld.WIDTH;
        screenHeight = myWorld.HEIGHT;
        mapMoveSize = 5;

        mapWidth = tilesToPixels(getWidth());
        offsetY = tilesToPixels(getHeight())-screenHeight ;
    
    }

    public int getMapHead() {
        return xMapHead;
    }

    /**
    Gets the width of this TileMap (number of tiles across).
     * @return
     */
    public int getWidth() {
        return tiles.length;
    }

    /**
    Gets the height of this TileMap (number of tiles down).
     */
    public int getHeight() {
        return tiles[0].length;
    }

    /**
    Gets the tile at the specified location. Returns null if
    no tile is at the location or if the location is out of
    bounds.
     */
    public BufferedImage getTile(int x, int y) {
        if (x < 0 || x >= getWidth() ||
                y < 0 || y >= getHeight()) {
            return null;
        } else {
            return tiles[x][y];
        }
    }

    /**
    Sets the tile at the specified location.
     */
    public void setTile(int x, int y, BufferedImage tile) {
        tiles[x][y] = tile;
    }

    public int tilesToPixels(int numTiles) {
        int pixelSize = numTiles * TILE_SIZE;
        return pixelSize;
    }

    public int pixelsToTiles(int pixelCoord) {
        int numTiles = pixelCoord / TILE_SIZE;
        return numTiles;
    }

    public void scroll() {

        if (tMapMoveLeft) {
            xMapHead = (xMapHead - mapMoveSize);
            myWorld.backX=(myWorld.backX-(int)(0.5*mapMoveSize))%myWorld.WIDTH;
        } else if (tMapMoveRight) {
            xMapHead = (xMapHead + mapMoveSize);
            myWorld.backX=(myWorld.backX+(int)(0.5*mapMoveSize))%myWorld.WIDTH;
        }
        xMapHead = Math.min(xMapHead, 0);
        xMapHead = Math.max(xMapHead, screenWidth - mapWidth);
    }

    public void drawTileMap(BufferedImage g) {

        offsetX = xMapHead;
        int firstTileY = pixelsToTiles(offsetY);
        int lastTileY = pixelsToTiles(offsetY + screenHeight);
        int firstTileX = pixelsToTiles(-offsetX);
        int lastTileX = pixelsToTiles(-offsetX + screenWidth);
        for (int y = firstTileY; y <= lastTileY; y++) {
            for (int x = firstTileX; x <= lastTileX; x++) {
                BufferedImage image = getTile(x, y);
                if (image != null) {
                    g.drawImage(image,
                            tilesToPixels(x) + offsetX,
                            tilesToPixels(y) - offsetY);
                }
            }
        }
    }

     public void drawMim(BufferedImage g) {

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x <= getWidth(); x++) {
                BufferedImage image = getTile(x, y);
                if (image != null) {
                    g.drawImage(image,
                            tilesToPixels(x) ,
                            tilesToPixels(y) );
                }
            }
        }
    }

}

