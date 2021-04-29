package src;

import Random.RNG;

public class Coin {

    public int throwCoin() {
        return RNG.random(2);
    }
}
