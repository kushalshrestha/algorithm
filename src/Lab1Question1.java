import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lab1Question1 {
    private static final int[] inputSizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
    private static long startTime;
    private static long endTime;
    public static final Random random = new Random();


    public static void main(String[] args) {
        performAlgorithm1();
        performAlgorithm2();
        performAlgorithm3();
        performAlgorithm4();
    }

    private static void performAlgorithm1() {
        System.out.println("/* Algorithm: Use a nested loop to solve the problem without creating an extra array */");
        for (int inputSize : inputSizes) {
            int[] testArray = generateRandomNumbers(inputSize);
            largestDistanceUsingAlgorithm1(testArray);
        }
    }

    private static void performAlgorithm2() {
        System.out.println("/* Algorithm: Use a nested loop to solve the problem without creating an extra array */");
        for (int inputSize : inputSizes) {
            int[] testArray = generateRandomNumbers(inputSize);
            largestDistanceUsingAlgorithm2(testArray);
        }
    }

    private static void performAlgorithm3() {
        System.out.println("/* Use one loop. Find max and min of even integers. Compute max – min. */");
        for (int inputSize : inputSizes) {
            int[] testArray = generateRandomNumbers(inputSize);
            largestDistanceUsingAlgorithm3(testArray);
        }
    }

    private static void performAlgorithm4() {
        System.out.println("/* Use Streams to find the max and min. Compute max – min. */");
        for (int inputSize : inputSizes) {
            int[] testArray = generateRandomNumbers(inputSize);
            largestDistanceUsingAlgorithm4(testArray);
        }
    }

    /* Algorithm: Create a new array consisting of even numbers only. Then use nested loops to solve the problem using
    the newly created array of even numbers only. */
    private static void largestDistanceUsingAlgorithm1(int[] array) {
        preTemplate();
        int maxDistance = 0;
        List evenArrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenArrayList.add(array[i]);
            }
        }

        for (int i = 0; i < evenArrayList.size() - 1; i++) {
            for (int j = i + 1; j < evenArrayList.size(); j++) {
                int distance = Math.abs((int) evenArrayList.get(i) - (int) evenArrayList.get(j));
                maxDistance = (distance > maxDistance) ? distance : maxDistance;
            }
        }
        postTemplate(array.length);
    }


    /* Algorithm: Use a nested loop to solve the problem without creating an extra array */
    private static void largestDistanceUsingAlgorithm2(int[] array) {
        preTemplate();
        int maxDistance = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] % 2 == 0 && array[j] % 2 == 0) {
                    int distance = Math.abs(array[i] - array[j]);
                    maxDistance = (distance > maxDistance) ? distance : maxDistance;
                }

            }
        }
        postTemplate(array.length);
    }

    private static void largestDistanceUsingAlgorithm3(int[] array) {
        preTemplate();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] < min) {
                    min = array[i];
                }
                if (array[i] > max) {
                    max = array[i];
                }
            }
        }
        int maxDistance = max - min;
        postTemplate(array.length);
    }


    private static void largestDistanceUsingAlgorithm4(int[] array) {
        preTemplate();
        int max = Arrays.stream(array).filter(x -> x % 2 == 0).max().getAsInt();
        int min = Arrays.stream(array).filter(x -> x % 2 == 0).min().getAsInt();
        int maxDistance = max - min;
        postTemplate(array.length);
    }


    private static void preTemplate() {
        startTime = System.nanoTime();
    }

    private static void postTemplate(int inputSize) {
        endTime = System.nanoTime();
        System.out.println("Input Size : " + inputSize + " | Total Time in microsecond : " + (double) ((endTime - startTime) / 1000));
        System.out.println("================");
    }

    private static int[] generateRandomNumbers(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(10000);
            array[i] = randomNumber;
        }
        return array;
    }

}