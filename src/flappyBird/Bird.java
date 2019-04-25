package flappyBird;

import atariCore.BaseObject;

import java.awt.*;

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

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.image,(int)x,(int)y,null);
    }
}
