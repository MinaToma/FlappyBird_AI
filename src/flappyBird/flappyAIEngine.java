package flappyBird;

import atariCore.AIEngine;

import static flappyBird.ObjectList.birdList;

public class flappyAIEngine extends AIEngine {

    static public int calculateReward(Player player) {

        Bird bird = (Bird)birdList.get(0);
        double reward = 0;


        if(player.getScore() > player.getPreviousScore()) {

            reward += 10000;
            rewards.forEach(e -> e += 10000);
        }

        reward -= bird.getDist() / 2;
/*
        if (player.isGoingToDie()) {
            reward -= bird.getDist() * bird.getDist();
            for(int i = rewards.size() - 1 , j = 0 ; i >= 0 && j < 300 ; i-- , j++)
                rewards.set(i , rewards.get(i) - 1000000);
        }
*/
        rewards.add(reward);
        System.out.println("the rewerd is " + reward);
        player.setPreviousScore(player.getScore());

        return 0;
    }
}

