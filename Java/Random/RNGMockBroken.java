package Random;

public class RNGMockBroken extends RNGMock {

    @Override
    public int random(int max) {
        return 1;
    }
}
