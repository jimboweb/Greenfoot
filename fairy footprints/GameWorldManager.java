
import java.awt.Graphics;
import java.awt.Point;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class GameWorldManager {

    public int imMoveSize;
    private int TILE_SIZE = 64;
    private BufferedImage im1,  im2,  im3;
    private ArrayList tiles;
    public TileMap tMap;
    private BufferedImage[] tileImage;
    public boolean canMoveRight;
    public boolean canMoveLeft;
    public boolean canScroll = false;
    private ArrayList sprites;
    public int anpcNum;
    public Player player;
    public myWorld gameP;

    public GameWorldManager(myWorld gp) {
        gameP=gp;
    }

    public void init() {
        imMoveSize = 5;
        canMoveRight = false;
        canMoveLeft = false;

        tileImage = new BufferedImage[10];
        tiles = new ArrayList();
        for (int i = 0; i < 9; i++) {
            tileImage[i] = loadImage("images/tile_" + (char) (i + 'A') + ".png");
            tiles.add(tileImage[i]);
        }

        sprites = new ArrayList();

        tMap = loadTileMap("Maps/map"+myWorld.level+".txt");
        for(int i=0;i<sprites.size();i++){
            if(((NPC)sprites.get(i)).npcType==NPC.ANPC)
                anpcNum++;
        }       
    }

    public void setMoveFlag() {
        tMap.tMapMoveRight = canMoveRight;
        tMap.tMapMoveLeft = canMoveLeft;
    }

    public void draw(BufferedImage g) {
        tMap.drawTileMap(g);

        for (int i = 0; i < sprites.size(); i++) {
            NPC eny = (NPC) sprites.get(i);
            eny.draw(g);
        }
    }
    
    public void drawMim(BufferedImage g) {
        tMap.drawMim(g);

        for (int i = 0; i < sprites.size(); i++) {
            NPC eny = (NPC) sprites.get(i);
            eny.drawMim(g);
        }
    }
    
    

    public void update() {

        NPC eny;

        for (int i = 0; i < sprites.size(); i++) {
            eny = (NPC) sprites.get(i);
            if (eny.isActive() == false) {
                if(eny.npcType==NPC.ANPC)anpcNum--;
                sprites.remove(i);
            }
            else eny.update();
        }

        if (canScroll) {
            setMoveFlag();
            tMap.scroll();
        }
    }

   
    public TileMap loadTileMap(String filename) {

        ArrayList lines = new ArrayList();
        int width = 0;
        int height = 0;

        // read every line in the text file into the list
            InputStream istream = getClass().getResourceAsStream(filename);
            Scanner in = new Scanner(
                     new BufferedReader(
                     new InputStreamReader(istream)));
            while (in.hasNextLine()) {
                String line = in.nextLine();

                // add every line except for comments
                if (!line.startsWith("#")) {
                    lines.add(line);
                    width = Math.max(width, line.length());
                }
            }

        // parse the lines to create a TileEngine
        height = lines.size();
        TileMap newMap = new TileMap(width, height);
        for (int y = 0; y < height; y++) {
            String line = (String) lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                char ch = line.charAt(x);

                // check if the char represents tile A, B, C, etc.
                int tile = ch - 'A';
                if (tile >= 0 && tile < tiles.size()) {
                    newMap.setTile(x, y, (BufferedImage) tiles.get(tile));
                } else if ((ch - '0') == 0) {
                    NPC eny = new NPC(x * TILE_SIZE, y * TILE_SIZE,NPC.ANPC ,"npc0", 4, this);
                    sprites.add(eny);
                }
                else if ((ch - '1') == 0) {
                    NPC eny = new NPC(x * TILE_SIZE, y * TILE_SIZE,NPC.ANPC ,"npc1", 4, this);
                    sprites.add(eny);
                }
                else if ((ch - '2') == 0) {
                    NPC eny = new NPC(x * TILE_SIZE, y * TILE_SIZE,NPC.ANPC ,"npc2", 4, this);
                    sprites.add(eny);
                }
                else if ((ch - '3') == 0) {
                    NPC eny = new NPC(x * TILE_SIZE, y * TILE_SIZE,NPC.ANPC ,"npc3", 6, this);
                    sprites.add(eny);
                }
                else if ((ch - '!') == 0) {
                    NPC eny = new NPC(x * TILE_SIZE, y * TILE_SIZE,NPC.SNPC ,"heart", this);
                    sprites.add(eny);
                }
                else if ((ch - '*') == 0) {
                    NPC eny = new NPC(x * TILE_SIZE, y * TILE_SIZE,NPC.SNPC ,"star",this);
                    sprites.add(eny);
                }else if ((ch - '?') == 0) {
                    NPC eny = new NPC(x * TILE_SIZE, y * TILE_SIZE,NPC.SNPC ,"power",this);
                    sprites.add(eny);
                }

            }
        }
        return newMap;
    }

    public BufferedImage loadImage(String fnm) {

        BufferedImage im = new BufferedImage(fnm);
        return im;

    }

    public Point getTileCollision(Sprite sprite,
    int oldX, int oldY, int newX, int newY) {
        Point pointCache = new Point(0, 0);
        int fromX = Math.min(oldX, newX);
        int fromY = Math.min(oldY, newY);
        int toX = Math.max(oldX, newX);
        int toY = Math.max(oldY, newY);

        // get the tile locations
        int fromTileX = tMap.pixelsToTiles(fromX);
        int fromTileY = tMap.pixelsToTiles(fromY);
        int toTileX = tMap.pixelsToTiles(
                toX + sprite.getWidth() - 1);
        int toTileY = tMap.pixelsToTiles(
                toY + sprite.getHeight() - 1);

        // check each tile for a collision
        for (int x = fromTileX; x <= toTileX; x++) {
            for (int y = fromTileY; y <=toTileY; y++) {
                if (x < 0 || x >= tMap.getWidth() ||
                tMap.getTile(x, y) != null) {
                    // collision found, return the tile
                    pointCache.setLocation(x, y);
                    return pointCache;
                }
            }
        }

        // no collision found
        return null;
    }

    public boolean worldCollisionHorizontal(Sprite sprite, Point thisPos, Point nextPos, int offSetX) {

        // change x
        int dx = sprite.getDX();
        int oldX = thisPos.x;
        int newX = nextPos.x;
        int oldY = thisPos.y;
        int newY = oldY;

        Point tile =
            getTileCollision(sprite, oldX, oldY, newX, newY);
        if (tile == null) {
            return false;

        } else {
            // line up with the tile boundary
            if (dx > 0) {

                sprite.setX(
                    tMap.tilesToPixels(tile.x) - offSetX - sprite.getWidth());
            } else if (dx < 0) {
                sprite.setX(
                    tMap.tilesToPixels(tile.x + 1) - offSetX);
            }
            return true;

        }
    }

    public boolean worldCollisionVertical(Sprite sprite, Point thisPos, Point nextPos, int offSetY) {
        // change y
        int dy = sprite.getDY();
        int oldY = thisPos.y;
        int newY = nextPos.y;
        int oldX = thisPos.x;
        int newX = oldX;
        Point tile = getTileCollision(sprite, oldX, oldY, newX, newY);
        if (tile == null) {
            return false;

        } else {

            // line up with the tile boundary
            if (dy > 0) {

                sprite.setY(
                    tMap.tilesToPixels(tile.y) - offSetY -
                    sprite.getHeight());
            } else if (dy < 0) {
                sprite.setY(
                    tMap.tilesToPixels(tile.y + 1) - offSetY);
                sprite.setDY(0);
            }

            return true;
        }

    }
    public boolean spriteCollision(Sprite s1, Sprite s2, boolean isPlayer) {
        // if the Sprites are the same, return false
        if (s1 == s2) {
            return false;
        }

        // get the pixel location of the Sprites
        int s1x, s1y, s2x, s2y;
        s1x = s1.getX();
        s2x = s2.getX();
        s1y = s1.getY();
        s2y = s2.getY();
        if (isPlayer) {
            s1x += getOffsetX();
            s1y += getOffsetY();
        }

        // check if the two sprites' boundaries intersect
        return (s1x < s2x + s2.getWidth() &&
            s2x < s1x + s1.getWidth() &&
            s1y < s2y + s2.getHeight() &&
            s2y < s1y + s1.getHeight());
    }

    public int getOffsetY() {
        return tMap.offsetY;
    }

    public void setOffsetY(int a){
        tMap.offsetY=a;

    }

    public int getOffsetX() {
        return -tMap.getMapHead();
    }

    public ArrayList getSprites() {
        return sprites;
    }

    public boolean isScrollLeft() {
        return tMap.tMapMoveLeft;
    }

    public boolean isScrollRight() {
        return tMap.tMapMoveRight;
    }
}
