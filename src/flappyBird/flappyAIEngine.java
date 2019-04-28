package flappyBird;

import atariCore.AIEngine;

import static flappyBird.ObjectList.birdList;

public class flappyAIEngine extends AIEngine {

    static public int calculateReward(Player player) {

        Bird bird = (Bird)birdList.get(0);
        double reward = 0;

        reward = player.distace;
        reward -= (bird.getDist() * bird.getDist());
        /*for(int i = rewards.size() - 1 , j = 0 ;i >= 0 && j < 200 ; i-- , j++) {
            reward += 1;
            rewards.set(i , rewards.get(i) + 1);
        }*/

        if(player.getScore() > player.getPreviousScore()) {

            reward += 10000000;
        }
        /*
        System.out.println(player.getScore());
        if(bird.withen())
        reward += (100000);
        else
            reward -= (bird.getDist() * bird.getDist());
        */

        /*if(player.isGoingToDie()) {
            for(int i = rewards.size() - 1 , j = 0 ;i >= 0 && j < 400 ; i-- , j++) {
                reward -= 100;
                rewards.set(i , rewards.get(i) - 100);
            }
        }*/

        rewards.add(reward);
        System.out.println("the rewerd is " + reward);
        player.setPreviousScore(player.getScore());

        return 0;
    }
}


