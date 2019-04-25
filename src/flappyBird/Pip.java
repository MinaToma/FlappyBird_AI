package flappyBird;

import atariCore.BaseObject;

import java.awt.*;
import java.util.Random;

import static atariCore.BaseObjectList.handler;
import static atariCore.Helper.screenHeight;
import static flappyBird.ObjectList.pipList;
import static flappyBird.flappyHelper.*;

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

        modfiyPip();
    }

    private void modfiyPip()
    {
        boolean needPip = false;
        for(BaseObject o:pipList)
        {
            if(o.getX()+ pipDown.getWidth(null)<0) {
                handler.removeObject(pipList, o);
                needPip = true;
            }
        }
        int lastPosPip=0;
        for(BaseObject o:pipList)
        {
            lastPosPip =  Math.max((int)o.getX(),lastPosPip);
        }

        if(needPip)
        {
            Random rand  = new Random();
            int  initialY = Math.abs(rand.nextInt()%(screenHeight))+1;
            initialY = Math.min(initialY,screenHeight-heightGap-100);
            initialY = Math.max(initialY,heightGap+100);
            Pip pipD = new Pip(lastPosPip + widthGap ,initialY - pipDown.getHeight(null),pipDown,-1,0);
            Pip pipU = new Pip(lastPosPip + widthGap  ,initialY + heightGap,pipUp,-1,0);

            handler.addObject(pipList,pipD);
            handler.addObject(pipList,pipU);
        }
    }

    @Override
    public void render(Graphics g) {
        if(flappyHelper.startGame)
        g.drawImage(image,(int)x,(int)y,null);
    }
}
