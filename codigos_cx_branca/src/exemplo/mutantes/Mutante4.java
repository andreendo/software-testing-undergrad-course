package exemplo.mutantes;

/**
 *
 * @author andreendo
 */
public class Mutante4 {

    public float pow(int x, int y) {
        int pow;
        if (y >= 0) {
            pow = y;
        } else {
            pow = -y;
        }

        float res = 1;
        while (pow > 0) {
            res = res + x;  //trocou '*' por '+'
            pow--;
        }

        if (y < 0) {
            res = 1 / res;
        }

        return res;
    }
}
