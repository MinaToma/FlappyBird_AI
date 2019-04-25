package flappyBird;

import atariCore.Helper;
import jaco.mp3.player.MP3Player;

import java.awt.*;

public class flappyHelper extends Helper {

    public static Image[] birds;
    public static Image background;
    public static Image pipDown;
    public static Image pipUp;
    public static String pathImages  ="src/Resources/Images/";
    public static float gravity = 0.01f;
    public static float pressSpeed = -1;
    public static double currTime = -100;
    public static boolean startGame = false;


    public static int widthGap = 450;
    public static int heightGap = 300;

    public static MP3Player backgroundSound;


    public flappyHelper() {

        setImages();
    }

    private void setImages()
    {
        birds = new Image[4];
        for(int i=1 ; i<=4; i++)
            birds[i-1] = getImage(pathImages+"bird/"+i+".png",9);

        heightGap = birds[0].getHeight(null)*3;
        background = getImage(pathImages+"background.png",1);

        pipDown = getImage(pathImages+"pipDOWN.png",2);

        pipUp = getImage(pathImages+"pipUP.png",2);
    }
}
