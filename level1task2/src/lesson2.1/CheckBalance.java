import java.util.Arrays;

public class CheckBalance {

    static boolean checkBalance  (int[] arr){
       int fullSum = 0, leftSum = 0;
       for (int i : arr) fullSum +=i;
       for (int i = 0; i < arr.length; i++) {
           leftSum += arr[i];
           if (fullSum == 2 * leftSum) {
               int[] left = new int[i + 1],
                       right = new  int[arr.length - i - 1];
               for (int j = 0; j <= i ; j++) {
                        left[j] = arr[j];
               }
               for (int j = i + 1; j < arr.length; j++) {
                    right[j - i - 1] = arr[j];
               }
               System.out.printf("Весь массив = %s\n"
               + "левая часть = %s\n" + "правая часть = %s\n"
               + "сумма = %d\n", Arrays.toString(arr),
                       Arrays.toString(left), Arrays.toString(right), leftSum);
               return true;
           }
        }
        System.out.println();
        System.out.println("Левая и правая часть массива" + " " + Arrays.toString(arr) + " не равны");
       return false;
    }

    public static void main(String[] args) {
        checkBalance(new int[]{12, 15, 5, 6, 7, 9});
        checkBalance(new int[]{1, 15, 5, 6, 7, 9});
    }
}
