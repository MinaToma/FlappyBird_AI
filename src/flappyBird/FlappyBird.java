package flappyBird;

import atariCore.Background;
import atariCore.BaseObject;
import atariCore.Game;
import atariCore.Helper;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import static flappyBird.ObjectList.*;
import static flappyBird.flappyHelper.*;
public class FlappyBird extends Game {

    Player player;
    Bird bird;


    public FlappyBird(String title , String namePlayer) {
        super(title);

        setBackground();
        setPlayer(namePlayer);
        setBird();
        setPip();
        running = true;
    }
    private void setBird()
    {
        bird = new Bird(screenWidth/2-birds[0].getWidth(null)/2,
                screenHeight/2-birds[0].getHeight(null)/2,birds[1]);

        handler.addObject(birdList,bird);
    }
    private void setPlayer(String namePlayer)
    {
        player = new Player(namePlayer,panel);
        handler.addObject(playerList,player);
    }
    private void setPip()
    {
        Random rand = new Random();
        int initialX=screenWidth+10;
        int initialY;
        for(int i=0 ; i<6; i++)
        {
            initialY = Math.abs(rand.nextInt()%(screenHeight))+1;
            initialY = Math.min(initialY,screenHeight-heightGap-100);
            initialY = Math.max(initialY,heightGap+100);
            Pip pipD = new Pip(initialX,initialY - pipDown.getHeight(null),pipDown,-1,0);
            Pip pipU = new Pip(initialX,initialY + heightGap,pipUp,-1,0);

            handler.addObject(pipList,pipD);
            handler.addObject(pipList,pipU);

            initialX += widthGap;

        }

    }
    private void setBackground()
    {
        Background back = new Background(0,0,background);
        handler.addObject(backgroundList,back);
    }


    @Override
    protected void sendDataToAI() {

    }

    @Override
    public void setPausedBG() {

    }

    @Override
    public void initKeys() {

    }

    @Override
    public void pressKey() {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE && !startGame)
            startGame =true;
        else if(key == KeyEvent.VK_SPACE)
        {
            ///
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
