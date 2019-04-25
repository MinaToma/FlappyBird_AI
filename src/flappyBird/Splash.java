package flappyBird;

import atariCore.LoadingScreen;

import java.util.concurrent.TimeUnit;

public class Splash extends atariCore.Splash {

    public Splash() {
        super("Flappy Bird", "src/Resources/Fonts/joystix monospace.ttf");

        newGameButton.addActionListener(e -> {

            new FlappyBird("Flappy Bird","AI");
        });


    }

    public static void main(String ...args)
    {
        new LoadingScreen();
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e)
        {

        }
        new ObjectList();
        new flappyHelper();
        new Splash();
    }
}

