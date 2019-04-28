package flappyBird;

import static atariCore.Helper.*;
import static flappyBird.flappyHelper.startGame;

import java.util.ArrayList;

public class Splash extends atariCore.Splash {

    public Splash() {
        super("Flappy Bird", "src/Resources/Fonts/joystix monospace.ttf");

        newGameButton.addActionListener(e -> {

            new SelectPlayer();
        });

        AIButton.addActionListener(e -> {
            running = true;
            AIMode = true;
            startGame = true;

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

