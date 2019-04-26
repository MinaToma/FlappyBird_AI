package flappyBird;

import atariCore.BaseObject;

import java.awt.*;

import static flappyBird.ObjectList.pipList;
import static flappyBird.ObjectList.playerList;
import static flappyBird.flappyHelper.*;

public class Bird extends BaseObject {

    private int numOfPic;

    public Bird(float x, float y, Image image) {
        super(x, y, image);
        numOfPic = 0;
    }

    public Bird(float x, float y, Image image, float velX, float velY) {
        super(x, y, image, velX, velY);
        numOfPic = 0;
    }

    @Override
    public void tick() {

        setImage(flappyHelper.birds[numOfPic++/20]);
        numOfPic%=80;

        move();
        collision();
        clamp();
    }

    private void move() {
        if(startGame)
            y += velY;

        velY += gravity;
    }

    public void speedUp() {

        velY = Math.max(-4 , velY + pressSpeed);
    }

    private void collision() {
        for(BaseObject p : pipList)
            if(p.getRectangle().intersects(getRectangle()))
                ((Player)playerList.get(0)).die();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.image,(int)x,(int)y,null);
    }

    public Float getDistFromPip() {
        float dist = 1e9f;
        for(BaseObject o : pipList)
            if(o.getX() >= getX())
                dist = Math.min(dist , Math.abs(o.getX() - (getX() + getImageWidth())));
         if(dist == 0) ((Player)playerList.get(0)).setScore((((Player) playerList.get(0)).getScore() + 1));
        return dist;
    }

    public Float getDistFromUpperPip() {
        float dist = 1e9f;
        for(BaseObject o : pipList)
            dist = Math.min(dist , Math.abs(o.getX() - getX()));

        float re = 1e9f;
        for(BaseObject o : pipList) {
            if(dist == Math.abs(o.getX() - getX())) {

                re = Math.min(re , o.getY() + o.getImageHeight());
            }
        }
        return re;
    }

    public Float getDistFromLowerPip() {
        float dist = 1e9f;
        for(BaseObject o : pipList)
            dist = Math.min(dist , Math.abs(o.getX() - getX()));

        float re = -1e9f;
        for(BaseObject o : pipList) {
            if(dist == Math.abs(o.getX() - getX())) {

                re = Math.max(re , o.getY());
            }
        }
        return re;
    }

    public boolean withen() {
        float uY = getDistFromUpperPip();
        float dY = getDistFromLowerPip();

        if(getY() > uY && getY() + getImageHeight() < dY) return true;
        return false;

    }

    public int getDist() {
        float uY = getDistFromUpperPip();
        float dY = getDistFromLowerPip();

        float center = (uY + dY / 2);

        return (int)Math.abs(center - getY());
    }
}
