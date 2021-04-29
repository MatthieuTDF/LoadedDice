package Random;

public class RNGMock extends RNGImpl {

    @Override
    public int random(int max) {
        return max > 0 ? max / 2 + 1 : 0;
    }
    public int randomKnucklebone(){
        return 6;
    }

    public int randomLoaded(int max, int loadedFace, int loadedWeight) {
        if (loadedWeight != -1){
            return 1;
        }
        return -1;
    }
}
