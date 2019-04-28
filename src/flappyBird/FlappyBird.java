package flappyBird;

import atariCore.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import static flappyBird.ObjectList.*;
import static flappyBird.flappyHelper.*;

public class FlappyBird extends Game {

    Player player;
    Bird bird;
    public FlappyAIEngine myGeneration;
    int numberOfBirds  = 50;

    public FlappyBird(String title, String playerName) {
        super(title);

        playerList.clear();
        setBackground();
        setPlayer(playerName);
        setPip();
        initialize();
    }

    public void initialize() {
        birdList.clear();
        pipList.clear();
        backgroundList.clear();

        if(!AIMode) {
            setBird();
        }
        else {
            myGeneration = new FlappyAIEngine(numberOfBirds);
        }

        setBackground();
        setPip();
        running = true;
    }

    private void setBird() {
        bird = new Bird(screenWidth / 2 - birds[0].getWidth(null) / 2,
                screenHeight / 2 - birds[0].getHeight(null) / 2, birds[1]);

        handler.addObject(birdList, bird);
    }

    private void setPlayer(String namePlayer) {
        player = new Player(namePlayer, panel, this);
        handler.addObject(playerList, player);
    }

    private void setPip() {
        Random rand = new Random();
        int initialX = screenWidth + 10;
        int initialY;
        for (int i = 0; i < 6; i++) {
            initialY = rand.nextInt(maxHeight)+minHeight;
            Pip pipD = new Pip(initialX, initialY - pipDown.getHeight(null), pipDown, -1, 0);
            Pip pipU = new Pip(initialX, initialY + heightGap, pipUp, -1, 0);

            handler.addObject(pipList, pipD);
            handler.addObject(pipList, pipU);

            initialX += widthGap;

        }

    }

    private void setBackground() {
        Background back = new Background(0, 0, background);
        handler.addObject(backgroundList, back);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void initKeys() {

    }

    @Override
    public void pressKey() {

    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(!AIMode) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_P) {

                pause = !pause;
            } else if (key == KeyEvent.VK_ESCAPE) {

                new Splash();
            } else if (key == KeyEvent.VK_SPACE && !startGame)
                startGame = true;
            else if (key == KeyEvent.VK_SPACE) {
                bird.speedUp();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void setPausedBG() {
    }

    @Override
    protected void sendDataToAI() {
        myGeneration.getAction();
    }
}

