package src;

import Random.RNG;

public class LoadedDice extends Dice{
    private int loadedFace;
    private int loadWeight;

    public LoadedDice(int value, int loadedFace, int loadWeight) {
        super(value);
        this.loadedFace = loadedFace;
        if (loadWeight < 50 || loadWeight > 100){
            this.loadWeight = -1;
        }else {
            this.loadWeight = loadWeight;
        }
    }

    public int rollDice() {
        return RNG.randomLoaded(value, loadedFace, loadWeight);
    }
}
