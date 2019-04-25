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
    FlappyBird flappyBird;
    private int previousScore;

    public Player(String Name, JPanel panel , FlappyBird flappyBird) {
        super(10, 10, null);
        this.name = Name;
        this.panel = panel;
        this.flappyBird = flappyBird;

        previousScore = 0;
        score = 0;
        start = true;
    }

    public void die() {
        running = false;

        if (!AIMode) {
            new Splash();
        } else {

            currTime = -10000;
            flappyBird.sendDataToAI();
            flappyAIEngine.train();
            setScore(0);
            setPreviousScore(0);
            flappyBird.initialize();
        }
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
