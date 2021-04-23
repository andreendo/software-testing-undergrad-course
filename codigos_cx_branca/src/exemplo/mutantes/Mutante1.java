package exemplo.mutantes;

/**
 *
 * @author andreendo
 */
public class Mutante1 {

    public float pow(int x, int y) {
        int pow;
        if (y > 0) {    //onde aplicou a mutacao '>=' -> '>'
            pow = y;
        } else {
            pow = -y;
        }

        float res = 1;
        while (pow > 0) {
            res = res * x;
            pow--;
        }

        if (y < 0) {
            res = 1 / res;
        }

        return res;
    }
}
