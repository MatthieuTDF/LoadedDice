package Random;

public class RNG {
    private static RNGImpl impl = new RNGImpl();

    private RNG() {}

    public static void setImpl(RNGImpl impl) {
        RNG.impl = impl;
    }

    public static int random(int max) {
        return impl.random(max);
    }

    public static int randomLoaded(int max, int loadedFace, int loadedWeight) {
        return impl.randomLoaded(max, loadedFace, loadedWeight);
    }

    public static int randomKnucklebone() {
        return impl.randomKnucklebone();
    }
}
