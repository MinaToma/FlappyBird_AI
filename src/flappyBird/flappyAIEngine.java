package flappyBird;

import atariCore.AIEngine;

import static atariCore.Helper.cursorScale;
import static atariCore.Helper.screenHeight;
import static flappyBird.ObjectList.birdList;
import static flappyBird.flappyHelper.currTime;

public class flappyAIEngine extends AIEngine{

    static public int calculateReward(Player player ) {
        float f = ((Bird)birdList.get(0)).getDistFromLowerPip();
        float s = ((Bird)birdList.get(0)).getDistFromUpperPip();

        rewards.add((double)((Bird)birdList.get(0)).getY() -screenHeight / 2f);
        System.out.println("the rewerd is " + (-(double)((Bird)birdList.get(0)).getY() -screenHeight / 2f));
        player.setPreviousScore(player.getScore());

        return 0;
    }
}

