import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends World
{
    /**
     * Constructor for objects of class Tile.
     * 
     */
    public Tile()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Wall wall = new Wall();
        addObject(wall, 253, 111);
        Wall wall2 = new Wall();
        addObject(wall2, 249, 114);
        Wall wall3 = new Wall();
        addObject(wall3, 181, 160);
        Wall wall4 = new Wall();
        addObject(wall4, 187, 207);
        Wall wall5 = new Wall();
        addObject(wall5, 211, 263);
        Wall wall6 = new Wall();
        addObject(wall6, 318, 275);
        Wall wall7 = new Wall();
        addObject(wall7, 360, 171);
        Wall wall8 = new Wall();
        addObject(wall8, 354, 170);
        Wall wall9 = new Wall();
        addObject(wall9, 330, 170);
        Wall wall10 = new Wall();
        addObject(wall10, 284, 181);
        Wall wall11 = new Wall();
        addObject(wall11, 282, 180);
        Wall wall12 = new Wall();
        addObject(wall12, 281, 179);
        Wall wall13 = new Wall();
        addObject(wall13, 281, 179);
        Wall wall14 = new Wall();
        addObject(wall14, 281, 179);
        Wall wall15 = new Wall();
        addObject(wall15, 281, 179);
        Wall wall16 = new Wall();
        addObject(wall16, 282, 184);
        Wall wall17 = new Wall();
        addObject(wall17, 283, 185);
        Wall wall18 = new Wall();
        addObject(wall18, 316, 290);
        Wall wall19 = new Wall();
        addObject(wall19, 344, 280);
        Wall wall20 = new Wall();
        addObject(wall20, 363, 282);
        Wall wall21 = new Wall();
        addObject(wall21, 397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(397, 285);
        wall21.setLocation(576, 375);
        wall20.setLocation(576, 325);
        wall19.setLocation(527, 326);
        wall18.setLocation(478, 326);
        wall6.setLocation(477, 275);
        wall9.setLocation(476, 225);
        wall6.setLocation(478, 279);
        wall9.setLocation(478, 231);
        wall8.setLocation(526, 231);
        wall7.setLocation(478, 182);
        wall17.setLocation(430, 183);
        wall16.setLocation(380, 183);
        wall15.setLocation(381, 135);
        wall15.setLocation(380, 375);
        wall14.setLocation(380, 326);
        wall13.setLocation(377, 276);
        wall5.setLocation(334, 324);
        wall4.setLocation(286, 324);
        wall12.setLocation(236, 324);
        wall11.setLocation(281, 276);
        wall10.setLocation(281, 228);
        wall3.setLocation(231, 228);
        wall2.setLocation(231, 178);
        wall.setLocation(25, 373);
        Wall wall22 = new Wall();
        addObject(wall22, 86, 88);
        Wall wall23 = new Wall();
        addObject(wall23, 86, 88);
        Wall wall24 = new Wall();
        addObject(wall24, 96, 193);
        Wall wall25 = new Wall();
        addObject(wall25, 96, 193);
        Wall wall26 = new Wall();
        addObject(wall26, 96, 193);
        Wall wall27 = new Wall();
        addObject(wall27, 96, 193);
        Wall wall28 = new Wall();
        addObject(wall28, 96, 193);
        Wall wall29 = new Wall();
        addObject(wall29, 96, 193);
        wall29.setLocation(25, 322);
        wall28.setLocation(25, 274);
        wall27.setLocation(75, 320);
        wall27.setLocation(74, 322);
        wall29.setLocation(25, 325);
        wall28.setLocation(25, 275);
        wall27.setLocation(73, 325);
        wall26.setLocation(122, 325);
        wall25.setLocation(181, 229);
        wall24.setLocation(132, 230);
        wall23.setLocation(132, 181);
        wall22.setLocation(132, 131);
        Wall wall30 = new Wall();
        addObject(wall30, 342, 65);
        Wall wall31 = new Wall();
        addObject(wall31, 392, 56);
        Wall wall32 = new Wall();
        addObject(wall32, 399, 65);
        Wall wall33 = new Wall();
        addObject(wall33, 329, 82);
        Wall wall34 = new Wall();
        addObject(wall34, 248, 69);
        Wall wall35 = new Wall();
        addObject(wall35, 241, 70);
        Wall wall36 = new Wall();
        addObject(wall36, 242, 71);
        Wall wall37 = new Wall();
        addObject(wall37, 254, 73);
        Wall wall38 = new Wall();
        addObject(wall38, 287, 71);
        Wall wall39 = new Wall();
        addObject(wall39, 294, 69);
        wall32.setLocation(399, 65);
        wall32.setLocation(577, 74);
        wall31.setLocation(577, 123);
        wall33.setLocation(528, 75);
        wall30.setLocation(477, 75);
        wall39.setLocation(380, 24);
        wall38.setLocation(332, 22);
        wall37.setLocation(330, 80);
        wall38.setLocation(332, 24);
        wall37.setLocation(332, 72);
        wall36.setLocation(287, 69);
        wall35.setLocation(107, 52);
        wall34.setLocation(237, 69);
        wall36.setLocation(286, 71);
        wall34.setLocation(236, 71);
        wall35.setLocation(24, 25);
        Wall wall40 = new Wall();
        addObject(wall40, 38, 93);
        Wall wall41 = new Wall();
        addObject(wall41, 38, 134);
        Wall wall42 = new Wall();
        addObject(wall42, 33, 147);
        Wall wall43 = new Wall();
        addObject(wall43, 34, 147);
        wall40.setLocation(23, 75);
        wall43.setLocation(74, 24);
        wall42.setLocation(123, 25);
        wall41.setLocation(24, 125);
        Wall wall44 = new Wall();
        addObject(wall44, 33, 177);
        wall44.setLocation(26, 171);
        Mouse mouse = new Mouse();
        addObject(mouse, 103, 84);
        mouse.setLocation(95, 77);
        Cheese cheese = new Cheese();
        addObject(cheese, 534, 284);
        Cheese cheese2 = new Cheese();
        addObject(cheese2, 583, 30);
        Cheese cheese3 = new Cheese();
        addObject(cheese3, 534, 383);
        Cheese cheese4 = new Cheese();
        addObject(cheese4, 333, 382);
        Cheese cheese5 = new Cheese();
        addObject(cheese5, 88, 386);
        Cheese cheese6 = new Cheese();
        addObject(cheese6, 283, 27);
        Cheese cheese7 = new Cheese();
        addObject(cheese7, 187, 183);
        Cheese cheese8 = new Cheese();
        addObject(cheese8, 337, 285);
        Cheese cheese9 = new Cheese();
        addObject(cheese9, 430, 240);   
        Music music = new Music();
        addObject(music, 48, 30);
        music.setLocation(39, 24);

    }


}
