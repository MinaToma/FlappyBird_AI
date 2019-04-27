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
    public int distace;
    private String name;
    public int lastScore;
    public boolean start;
    private JPanel panel;
    FlappyBird flappyBird;
    private int previousScore;

    public Player(String Name, JPanel panel, FlappyBird flappyBird) {
        super(10, 10, null);
        this.name = Name;
        this.panel = panel;
        this.flappyBird = flappyBird;
        lastScore = 0;
        distace = 0;
        previousScore = 0;
        score = 0;
        start = true;
    }

    public void die() {
        running = false;

        if (!AIMode) {
            new Splash();
        } else {

            flappyAIEngine.train();
            setScore(0);
            setPreviousScore(0);
            lastScore = 0;
            distace = 0;
            flappyBird.initialize();
        }
    }

    public void setScore(int score) {
        this.score = score + lastScore;
    }

    public void increaseScore(int add) {
        score += add;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void tick() {
        distace+=1;
    }


    public void render(Graphics g) {

    }

    public int getPreviousScore() {
        return previousScore;
    }

    public void setPreviousScore(int previousScore) {
        this.previousScore = previousScore;
    }

    public boolean isGoingToDie() {

        Bird bird = (Bird)birdList.get(0);

        float _X = bird.getDistFromPip();
        float uY = bird.getDistFromUpperPip();
        float dY = bird.getDistFromLowerPip();

        if( _X -10 <= bird.getX()+ bird.getImageWidth()  && ( uY >= bird.getY()  || dY<= bird.getY()-bird.getImageHeight()  ) )
            return true;

        return false;
    }
}

