/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Bullet extends Sprite {

    private Player player;

    public Bullet(Player man) {
        super(0, 0, "images/bullet.png", 1);

        player = man;
        switch(player.runningState){
        case Player.RUNRT:
            setDX(10);
            setX(player.getX()+player.getWidth());
        break;
        case Player.RUNLT:
            setDX(-10);
            setX(player.getX() - this.getWidth());
            break;
        case Player.STDRT:
            setDX(10);
            setX(player.getX()+player.getWidth());
        break;
        case Player.STDLT:
           setDX(-10);
            setX(player.getX() - this.getWidth());
        break;
        }
        setY(man.getY());
        setDY(0);

        state=MOVE;

    }

    public void update() {
        switch (state) {
            case MOVE:
                move();
                break;

            case DISMISS:
                setActive(false);
                break;
        }
    }

    public void move() {
        if (isActive()) {

            locX += dx;
            if (locX > myWorld.WIDTH || locX < -getWidth()) {
                changeState(DISMISS);
            }


        }

    }


}
