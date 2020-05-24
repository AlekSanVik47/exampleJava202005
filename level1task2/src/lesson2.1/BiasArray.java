import java.util.Arrays;

public class BiasArray {
    static void BiasNumber(int[] numberArray, int n) {
        int currentIndex = 0, offsetIndex, buffer = 0;
        n = shift(numberArray, n);
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                buffer = numberArray[i];
                currentIndex = i;
                while (true) {
                    offsetIndex = currentIndex + n;
                    if (offsetIndex >= numberArray.length) {
                        offsetIndex = offsetIndex - numberArray.length;
                        if (offsetIndex == i) {
                            break;
                        }
                    }
                    numberArray[currentIndex] = numberArray[offsetIndex];
                    currentIndex = offsetIndex;
                }
                numberArray[currentIndex] = buffer;
            }

        } else if (n < 0) {
            for (int i = numberArray.length - 1; i < -n; i--) {
                while (true) {
                    offsetIndex = currentIndex - n;
                    if (offsetIndex <= numberArray.length) {
                        offsetIndex = offsetIndex + numberArray.length;
                        if (offsetIndex == i) {
                            break;
                        }
                    }
                    numberArray[currentIndex] = numberArray[offsetIndex];
                    currentIndex = offsetIndex;
                }
                numberArray[currentIndex] = buffer;
            }
        }
        System.out.println(Arrays.toString(numberArray));

    }


    private static int shift(int[] numberArray, int n) {

        if (n > numberArray.length || (n + numberArray.length) < 0) {
            n = n % numberArray.length;
        }
        return n;
    }


    public static void main(String[] args) {
        BiasNumber(new int[]{1, 5, 7, 2, 8, 3},-3);
        //shift(new int[]{1, 5, 7, 2, 8, 3},  -16);
    }
}
