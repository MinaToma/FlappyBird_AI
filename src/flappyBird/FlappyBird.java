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


    public FlappyBird(String title, String playerName) {
        super(title);

        playerList.clear();

        setBackground();
        setPlayer(playerName);
        setBird();
        setPip();
        running = true;

        initialize();
    }

    public void initialize() {
        birdList.clear();
        pipList.clear();

        backgroundList.clear();

        setBackground();
        setBird();
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
            initialY = Math.abs(rand.nextInt() % (screenHeight)) + 1;
            initialY = Math.min(initialY, screenHeight - heightGap - 100);
            initialY = Math.max(initialY, heightGap + 100);
            initialY = screenHeight / 2;
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

        if (player.getScore() == 0)
            player.setPreviousScore(0);

        running = false;

        ArrayList<Float> inputData = new ArrayList<>();
        inputData.add(bird.getDistFromPip());
        inputData.add(bird.getDistFromUpperPip());
        inputData.add(bird.getDistFromLowerPip());

        AIEngine.initializeInput(inputData);
      //  System.out.println("out Dir");
        String dir = AIEngine.getDIR();

     //   System.out.println("after Dir");
        if (dir.equals("press")) {

            bird.speedUp();
        }

        if (player.getPreviousScore() - player.getScore() == 0)
            AIEngine.slack += 0.01;
        else
            AIEngine.slack = 0;

        flappyAIEngine.calculateReward(player);
        running = true;
    }
}
