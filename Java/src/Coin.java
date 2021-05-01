package src;

import Random.RNG;

public class Coin {

    public int throwCoin() {
        if (RNG.random(100) <= 5) {
            return -1;
        }
        return RNG.random(2);
    }
}
