package src;

import java.util.Arrays;

public class Throw {

    private Dice[] dices;
    private Coin[] coins;
    private Knucklebone[] knucklebones;
    private int[] lastRun = new int[]{-1};

    public Throw(Dice[] dices, Coin[] coins, Knucklebone[] knucklebones){
        this.dices = dices;
        this.coins = coins;
        this.knucklebones = knucklebones;
    }

    public int[] run(){
        int nbvalues = dices.length + coins.length + knucklebones.length;
        int[] res = new int[nbvalues];
        if (nbvalues > 5){
            res[0] = -1;
            return res;
        }
        for (int i = 0; i < dices.length; i++){
            res[i] = dices[i].rollDice();
        }

        for (int i = 0; i < coins.length; i++){
            res[i + dices.length] += coins[i].throwCoin();
        }

        for (int i = 0; i < knucklebones.length; i++){
            res[i + dices.length + coins.length] += knucklebones[i].throwKnucklebone();
        }

        Arrays.sort(res);
        this.lastRun = res;

        return res;
    }

    public int[] getLastRun() {
        return lastRun;
    }
}


