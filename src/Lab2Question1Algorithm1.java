import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lab2Question1Algorithm1 {
    static Random random = new Random();
    static List<Long> times = new ArrayList<>();

    public static void main(String[] args) {
        int[] inputSizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        for (int inputSize : inputSizes) {
            long start = System.nanoTime();
            int[] arr = generateRandomNumbers(inputSize);
            System.out.println("Third Max no in array of " + inputSize + " : " + getThirdMax(arr));

            long end = System.nanoTime();
            long d = end - start;
            System.out.println("Execution Time (In nano-second) : " + d + "\n");
            times.add(d);
        }

        times.forEach(t -> System.out.print(t + " "));
    }

    private static int getThirdMax(int[] arr) {
        int maxIndex = 0, preMaxIndex = 0;
        int max = arr[0], preMax = arr[0], prePreMax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == maxIndex) continue;
            if (arr[i] > preMax) {
                preMax = arr[i];
                preMaxIndex = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == maxIndex || i == preMaxIndex) continue;
            if (arr[i] > prePreMax) {
                prePreMax = arr[i];
            }
        }

        return prePreMax;
    }

    public static int[] generateRandomNumbers(int size) {
        int[] arr = new int[size];
        int ind = 0;
        while (ind < size) {
            arr[ind] = random.nextInt(10000);
            ind++;
        }
        return arr;
    }
}
