import java.util.ArrayList;
import java.util.List;

public class Lab2Question1 {
    private static List<Integer> inputArray;

    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.println("Comparing Algorithms: Find the THIRD largest in an array");
        System.out.println("========================================================");
        applyAlgorithm1();
        applyAlgorithm2();
    }


    private static void applyAlgorithm1() {
        createInputArray();
        System.out.println("\n## Algorithm 1: Use three loops one after another");
        System.out.println("-------------------------------------------------");
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
                removalIndex = i;
            }
        }
        System.out.println("THIRD MAX : " + max);

    }

    private static void applyAlgorithm2() {
        createInputArray();
        System.out.println("\nAlgorithm 2: ## Use one loop. Maintain three variable max, preMax and prePreMax such that max\n" + "will have the maximum value, preMax will have the second largest and prePreMax will have the third\n" + "largest value.");
        System.out.println("-------------------------------------------------");
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


        System.out.println("max: " + max);
        System.out.println("preMax: " + preMax);
        System.out.println("prePreMax: " + prePreMax);
    }

    private static void createInputArray() {
        inputArray = new ArrayList<>();
        inputArray.add(7);
        inputArray.add(20);
        inputArray.add(18);
        inputArray.add(4);
        inputArray.add(20);
        inputArray.add(19);
        inputArray.add(20);
        inputArray.add(3);
    }
}
