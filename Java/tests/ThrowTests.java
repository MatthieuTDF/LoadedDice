package tests;

import Random.RNG;
import Random.RNGMock;
import Random.RNGMockBroken;
import org.junit.*;
import src.*;

public class ThrowTests {

    @Before
    public  void mockRNGBefore() {
        RNG.setImpl(new RNGMock());
    }

    //Check getting last run before any throws
    @Test
    public void noLastRun() {
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        Coin coin = new Coin();
        Knucklebone knucklebone1 = new Knucklebone();
        Knucklebone knucklebone2 = new Knucklebone();
        Dice[] dices = {dice1, dice2};
        Coin[] coins = {coin};
        Knucklebone[] knucklebones = {knucklebone1, knucklebone2};
        Throw t = new Throw(dices, coins, knucklebones);
        int[] res = t.getLastRun();
        Assert.assertEquals(-1, res[0]);
    }

    //check if run behaves as expected
    @Test
    public void aThrow() {
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        Coin coin = new Coin();
        Knucklebone knucklebone1 = new Knucklebone();
        Knucklebone knucklebone2 = new Knucklebone();
        Dice[] dices = {dice1, dice2};
        Coin[] coins = {coin};
        Knucklebone[] knucklebones = {knucklebone1, knucklebone2};
        Throw t = new Throw(dices, coins, knucklebones);
        int[] res = t.run();
        Assert.assertEquals(2, res[0]);
        Assert.assertEquals(4, res[1]);
        Assert.assertEquals(4, res[2]);
        Assert.assertEquals(6, res[3]);
        Assert.assertEquals(6, res[4]);
    }

    //Check getting the last result after successful run
    @Test
    public void checkLastRun(){
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        Coin coin = new Coin();
        Knucklebone knucklebone1 = new Knucklebone();
        Knucklebone knucklebone2 = new Knucklebone();
        Dice[] dices = {dice1, dice2};
        Coin[] coins = {coin};
        Knucklebone[] knucklebones = {knucklebone1, knucklebone2};
        Throw t = new Throw(dices, coins, knucklebones);
        t.run();
        int[] res = t.getLastRun();
        Assert.assertEquals(2, res[0]);
        Assert.assertEquals(4, res[1]);
        Assert.assertEquals(4, res[2]);
        Assert.assertEquals(6, res[3]);
        Assert.assertEquals(6, res[4]);
    }

    //Check trying to run with too many objects
    @Test
    public void tooManyObjects(){
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        Coin coin = new Coin();
        Knucklebone knucklebone1 = new Knucklebone();
        Knucklebone knucklebone2 = new Knucklebone();
        Knucklebone knucklebone3 = new Knucklebone();
        Dice[] dices = {dice1, dice2};
        Coin[] coins = {coin};
        Knucklebone[] knucklebones = {knucklebone1, knucklebone2, knucklebone3};
        Throw t = new Throw(dices, coins, knucklebones);
        int[] res = t.run();
        Assert.assertEquals(-1, res[0]);
    }

    //Check trying to create invalid dice
    @Test
    public void valueDiceOutOfRange(){
        Dice myDice = new Dice(21);
        Assert.assertEquals(-1, myDice.getValue());
        Dice myDice2 = new Dice(3);
        Assert.assertEquals(-1, myDice2.getValue());
    }

    //Somewhat checks the loaded logic (unable to mock loaded randomness)
    @Test
    public void loadedRun(){
        Dice dice1 = new LoadedDice(6, 1, 100);
        Dice dice2 = new Dice(6);
        Coin coin = new Coin();
        Knucklebone knucklebone1 = new Knucklebone();
        Knucklebone knucklebone2 = new Knucklebone();
        Dice[] dices = {dice1, dice2};
        Coin[] coins = {coin};
        Knucklebone[] knucklebones = {knucklebone1, knucklebone2};
        Throw t = new Throw(dices, coins, knucklebones);
        int[] res = t.run();
        Assert.assertEquals(1, res[0]);
        Assert.assertEquals(2, res[1]);
        Assert.assertEquals(4, res[2]);
        Assert.assertEquals(6, res[3]);
        Assert.assertEquals(6, res[4]);
    }

    //Checks a run with invalid weight
    @Test
    public void invalidWeight(){
        Dice dice1 = new LoadedDice(6, 1, 110);
        Dice dice2 = new Dice(6);
        Coin coin = new Coin();
        Knucklebone knucklebone1 = new Knucklebone();
        Knucklebone knucklebone2 = new Knucklebone();
        Dice[] dices = {dice1, dice2};
        Coin[] coins = {coin};
        Knucklebone[] knucklebones = {knucklebone1, knucklebone2};
        Throw t = new Throw(dices, coins, knucklebones);
        int[] res = t.run();
        Assert.assertEquals(-1, res[0]);
        Assert.assertEquals(2, res[1]);
        Assert.assertEquals(4, res[2]);
        Assert.assertEquals(6, res[3]);
        Assert.assertEquals(6, res[4]);
    }

    //Checks a run with invalid loaded face
    @Test
    public void invalidFace(){
        Dice dice1 = new LoadedDice(6, 7, 50);
        Dice dice2 = new Dice(6);
        Coin coin = new Coin();
        Knucklebone knucklebone1 = new Knucklebone();
        Knucklebone knucklebone2 = new Knucklebone();
        Dice[] dices = {dice1, dice2};
        Coin[] coins = {coin};
        Knucklebone[] knucklebones = {knucklebone1, knucklebone2};
        Throw t = new Throw(dices, coins, knucklebones);
        int[] res = t.run();
        Assert.assertEquals(-1, res[0]);
        Assert.assertEquals(2, res[1]);
        Assert.assertEquals(4, res[2]);
        Assert.assertEquals(6, res[3]);
        Assert.assertEquals(6, res[4]);
    }

    //Somewhat checks the broken dice and coin logic
    //(uses a special random implementation causing every dice/coin to be broken)
    @Test
    public void invalidLoadedFace(){
        RNG.setImpl(new RNGMockBroken());
        Dice dice1 = new LoadedDice(6, 1, 50);
        Dice dice2 = new Dice(6);
        Coin coin = new Coin();
        Knucklebone knucklebone1 = new Knucklebone();
        Knucklebone knucklebone2 = new Knucklebone();
        Dice[] dices = {dice1, dice2};
        Coin[] coins = {coin};
        Knucklebone[] knucklebones = {knucklebone1, knucklebone2};
        Throw t = new Throw(dices, coins, knucklebones);
        int[] res = t.run();
        Assert.assertEquals(-1, res[0]);
        Assert.assertEquals(-1, res[1]);
        Assert.assertEquals(1, res[2]);
        Assert.assertEquals(6, res[3]);
        Assert.assertEquals(6, res[4]);
    }
}
