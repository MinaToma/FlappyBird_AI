package flappyBird;

import jaco.mp3.player.MP3Player;

import java.awt.*;

public class flappyHelper {

    public static Image[] birds;
    public static Image background;
    public static Image pipDown;
    public static Image pipUp;
    public static String pathImages  ="src/Resources/Images/";

    public static MP3Player backgroundSound;


    public flappyHelper() {

        setImages();


    }

    private void setImages()
    {
        birds = new Image[4];
    }

}
