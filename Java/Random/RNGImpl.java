package Random;

import java.util.Random;

public class RNGImpl {
    private static Random r = new Random();

    public int random(int max) {
        return r.nextInt(max) + 1;
    }

    public int randomLoaded(int max, int loadedFace, int loadedWeight) {
        if (loadedWeight != -1) {
            if ((r.nextInt(100) + 1) <= loadedWeight) {
                return loadedFace;
            } else {
                int res;
                do {
                    res = r.nextInt(max) + 1;
                }
                while ((res == loadedFace));

                return res;
            }
        }else {
           return -1;
        }
    }

    public int randomKnucklebone(){
        int result = r.nextInt(4) + 1;
        switch (result){
            case 1 :
                return 1;
            case 2 :
                return 3;
            case 3 :
                return 4;
            case 4 :
                return 6;
            default :
                return -1;
        }
    }
}
