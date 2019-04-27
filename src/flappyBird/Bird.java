package flappyBird;

import atariCore.BaseObject;

import java.awt.*;

import static flappyBird.ObjectList.*;
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

        getReward();
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

        Rectangle rec = getRectangle();
        if(rec.y<=0 || rec.y+rec.height>=screenHeight)
            ((Player)playerList.get(0)).die();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.image,(int)x,(int)y,null);
    }

    public Float getDistFromPip() {
        float dist = 1e9f;
        for(BaseObject o : pipList){
            if(o.getX() >= getX())
                dist = Math.min(dist , o.getX() );}

        return dist;
    }
    public void getReward()
    {
        int cnt = 0;
        for(BaseObject o : pipList)
        {
            if(o.getY()>0 && o.getX()+o.getImageWidth() <x)
                cnt++;
        }
        ((Player)playerList.get(0)).setScore(cnt);
    }

    public Float getDistFromUpperPip() {

        float dist = 1e9f;
        for(BaseObject o : pipList){
            if(o.getX() >= getX())
                dist = Math.min(dist , o.getX() );}

        float re = 1e9f;
        for(BaseObject o : pipList) {
            if(dist == o.getX() && o.getY() < 0) {

                re = Math.min(re , o.getY() + o.getImageHeight());
            }
        }

        return re;
    }

    public Float getDistFromLowerPip() {
        float dist = 1e9f;
        for(BaseObject o : pipList){
            if(o.getX() >= getX())
                dist = Math.min(dist , o.getX() );}


        float re = -1e9f;
        for(BaseObject o : pipList) {
            if(dist == o.getX() && o.getY() > 0) {

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

        float center = ((uY + dY) / 2);


        return (int)Math.abs(center - ((getY()+(getImageHeight()/2))));
    }
    @Override
    public Rectangle getRectangle()
    {
        Bird bird = (Bird) birdList.get(0);
        //System.out.println(          Math.min( Math.abs((bird.getY() + bird.getImageWidth()/2) - bird.getDistFromLowerPip() ) , Math.abs((bird.getY() + bird.getImageWidth()/2) - bird.getDistFromUpperPip())  ));
        return new Rectangle((int)x+10,(int)y+5,imageWidth-20,imageHeight-10);
    }
}

