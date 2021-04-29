package src;

import Random.RNG;

public class Dice {
    protected int value;

    public Dice(int value) {
        if (value >= 4 && value <= 20) {
            this.value = value;
        }else {
            this.value = -1;
        }
    }

    public int rollDice() {
        return RNG.random(value);
    }

    public int getValue() {
        return value;
    }
}
