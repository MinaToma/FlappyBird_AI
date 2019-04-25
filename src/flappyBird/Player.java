package flappyBird;


import atariCore.BaseObject;
import atariCore.Sound;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static atariCore.Helper.*;
import static flappyBird.ObjectList.*;
import static flappyBird.flappyHelper.*;

public class Player extends BaseObject {

    private int score;
    private String name;

    public boolean start;
    private JPanel panel;

    private int previousScore;

    public Player(String Name, JPanel panel) {
        super(10, 10, null);
        this.name = Name;
        this.panel = panel;

        previousScore = 0;
        score = 0;
        start = true;
    }

    public void die() {
        running = false;
        new Splash();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore(int add) {
        score += add;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void tick() {

        collision();
        modfiyPip();
    }

    private void collision()
    {

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

    public void render(Graphics g) {

    }





    public int getPreviousScore() {
        return previousScore;
    }

    public void setPreviousScore(int previousScore) {
        this.previousScore = previousScore;
    }
}
