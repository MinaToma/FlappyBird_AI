package flappyBird;

import atariCore.Sound;

import static atariCore.Helper.*;
import static flappyBird.flappyHelper.clickSound;
import static flappyBird.flappyHelper.startGame;

import java.util.ArrayList;

public class Splash extends atariCore.Splash {

    public Splash() {
        super("Flappy Bird", "src/Resources/Fonts/joystix monospace.ttf");

        newGameButton.addActionListener(e -> {
            Sound.Play(clickSound, false);
            new SelectPlayer();
        });

        AIButton.addActionListener(e -> {
            running = true;
            AIMode = true;
            startGame = true;
            Sound.Play(clickSound, false);
            new FlappyBird("Flappy Bird", "AI-Player");
        });

        exitButton.addActionListener(e -> {
                    frame.dispose();
                    Sound.Play(clickSound, false);
                }

        );


    }

    public static void main(String... args) {
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

