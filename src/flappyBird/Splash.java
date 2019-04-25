package flappyBird;

import atariCore.AIEngine;

import static atariCore.AIEngine.initializeReward;
import static atariCore.Helper.*;
import static flappyBird.flappyHelper.startGame;

import java.io.IOException;
import java.util.ArrayList;

public class Splash extends atariCore.Splash {

    public Splash() {
        super("Flappy Bird", "src/Resources/Fonts/joystix monospace.ttf");

        newGameButton.addActionListener(e -> {

            new FlappyBird("Flappy Bird","AI");
        });

        AIButton.addActionListener(e -> {
            running = true;
            AIMode = true;

            //setinput
            //setouput
            /*try {
                AIEngine.startAI();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }*/
            ArrayList<String> actions = new ArrayList<>();
            actions.add("press");
            actions.add("none");
            AIEngine.initializeReward(actions);
            flappyHelper.currTime = 0;
            startGame = true;
//            try {
//                AIEngine.startAI();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
            new FlappyBird("Flappy Bird" , "AI-Player");
        });


    }

    public static void main(String ...args)
    {
       /* new LoadingScreen();
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e)
        {

        }*/
        new ObjectList();
        new flappyHelper();
        new Splash();
    }
}

