package src;

import Random.RNG;

public class LoadedDice extends Dice{
    private int loadedFace = -1;
    private int loadWeight = -1;

    public LoadedDice(int value, int loadedFace, int loadWeight) {
        super(value);

        if (loadedFace > 0 && loadedFace <= value) {
            this.loadedFace = loadedFace;
        }

        if (loadWeight >= 50 && loadWeight <= 100) {
            this.loadWeight = loadWeight;
        }
    }

    public int rollDice() {
        return RNG.randomLoaded(value, loadedFace, loadWeight);
    }
}
