package flappyBird;

import atariCore.BaseObject;

import java.awt.*;

public class Pip extends BaseObject {



    public Pip(float x, float y, Image image, float velX, float velY) {
        super(x, y, image, velX, velY);
    }

    public Pip(float x, float y, Image image) {
        super(x, y, image);
    }

    @Override
    public void tick() {

        if(flappyHelper.startGame)
        x+=velX;

    }

    @Override
    public void render(Graphics g) {
        if(flappyHelper.startGame)
        g.drawImage(image,(int)x,(int)y,null);
    }
}
