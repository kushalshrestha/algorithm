import java.util.Arrays;
import java.util.Random;

public class Lab1Q1 {
    private static int[] inputSizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {
        performAlgorithm2();
        performAlgorithm3();

    }

    private static void performAlgorithm2() {
        System.out.println("/* Algorithm: Use a nested loop to solve the problem without creating an extra array */");
        for(int inputSize : inputSizes){
            int[] testArray = generateRandomNumbers(inputSize, true);
            largestDistanceUsingAlgorithm2(testArray);
        }
    }

    private static void performAlgorithm3() {
        System.out.println("/* Use one loop. Find max and min of even integers. Compute max – min. */");
        for(int inputSize : inputSizes){
            int[] testArray = generateRandomNumbers(inputSize, true);
            largestDistanceUsingAlgorithm3(testArray);
        }
    }

    private static void performAlgorithm4() {
        System.out.println("/* Use Streams to find the max and min. Compute max – min. */");
        for(int inputSize : inputSizes){
            int[] testArray = generateRandomNumbers(inputSize, true);
            largestDistanceUsingAlgorithm4(testArray);
        }
    }




    /* Algorithm: Use a nested loop to solve the problem without creating an extra array */
    private static void largestDistanceUsingAlgorithm2(int[] array) {
        preTemplate();
        int maxDistance = 0;
        for(int i=0; i<array.length-1; i++){
            for(int j=i+1; j<array.length; j++){
                int distance = Math.abs(array[i] - array[j]);
                maxDistance = (distance > maxDistance) ? distance : maxDistance;
            }
        }
        postTemplate(array.length);
    }

    private static void largestDistanceUsingAlgorithm3(int[] array) {
        preTemplate();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
            if(array[i] > max) {
                max = array[i];
            }
        }
        int maxDistance = max - min;
        postTemplate(array.length);
    }

    private static void largestDistanceUsingAlgorithm4(int[] array) {
        preTemplate();
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int maxDistance = max-min;
        postTemplate(array.length);
    }



    private static void preTemplate(){
        startTime = System.nanoTime();
    }
    private static void postTemplate(int inputSize) {
        endTime = System.nanoTime();
        System.out.println("Input Size : " + inputSize + " | Total Time in microsecond : " + (double)((endTime - startTime)/1000));
        System.out.println("================");
    }
    private static int[] generateRandomNumbers(int size, boolean isEven) {
        int[] array = new int[size];
        Random random = new Random();
        for(int i=0; i<size; i++) {
            int randomNumber = random.nextInt(10000);
            if(randomNumber % 2 != 0 && isEven) {
                randomNumber++;
            }
            array[i] = randomNumber;
        }
        return array;
    }

}