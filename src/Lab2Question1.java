import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lab2Question1 {
    public static final Random random = new Random();
    private static final int[] inputSizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
    private static long startTime;
    private static long endTime;
    private static List<Integer> inputArray;

    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.println("Comparing Algorithms: Find the THIRD largest in an array");
        System.out.println("========================================================");
        performAlgorithm1();
        performAlgorithm2();
    }

    private static void performAlgorithm1() {
        System.out.println("\n## Algorithm 1: Use three loops one after another");
        System.out.println("-------------------------------------------------");
        for (int inputSize : inputSizes) {
            List<Integer> testArray = createInputArray(inputSize);
            applyAlgorithm1(testArray);
        }
    }

    private static void performAlgorithm2() {
        System.out.println("\nAlgorithm 2: ## Use one loop. Maintain three variable max, preMax and prePreMax such that max\n" + "will have the maximum value, preMax will have the second largest and prePreMax will have the third\n" + "largest value.");
        System.out.println("-------------------------------------------------");
        for (int inputSize : inputSizes) {
            List<Integer> testArray = createInputArray(inputSize);
            applyAlgorithm2(testArray);
        }
    }


    private static void applyAlgorithm1(List<Integer> inputArray) {
        preTemplate();
        int max = Integer.MIN_VALUE;
        int removalIndex = 0;
        for (int i = 0; i < inputArray.size(); i++) {
            if (inputArray.get(i) > max) {
                max = inputArray.get(i);
                removalIndex = i;
            }
        }
        inputArray.remove(removalIndex);

        for (int i = 0; i < inputArray.size(); i++) {
            if (inputArray.get(i) > max) {
                max = inputArray.get(i);
                removalIndex = i;
            }
        }
        inputArray.remove(removalIndex);

        for (int i = 0; i < inputArray.size(); i++) {
            if (inputArray.get(i) > max) {
                max = inputArray.get(i);
            }
        }
        postTemplate(inputArray.size());
    }

    private static void applyAlgorithm2(List<Integer> inputArray) {
        preTemplate();
        int max = Integer.MIN_VALUE;
        int preMax = Integer.MIN_VALUE;
        int prePreMax = Integer.MIN_VALUE;

        for (int i = 0; i < inputArray.size(); i++) {
            if (inputArray.get(i) >= max) {
                prePreMax = preMax;
                preMax = max;
                max = inputArray.get(i);
            } else if (inputArray.get(i) >= preMax) {
                prePreMax = preMax;
                preMax = inputArray.get(i);
            } else if (inputArray.get(i) >= prePreMax) {
                prePreMax = inputArray.get(i);
            }
        }
        postTemplate(inputArray.size());
    }

    private static List<Integer> createInputArray(int size) {
        inputArray = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(10000);
            inputArray.add(randomNumber);
        }
        return inputArray;
    }

    private static void preTemplate() {
        startTime = System.nanoTime();
    }

    private static void postTemplate(int inputSize) {
        endTime = System.nanoTime();
        System.out.println("Input Size : " + inputSize + " | Total Time in microsecond : " + (double) ((endTime - startTime) / 1000));
        System.out.println("================");
    }
}
