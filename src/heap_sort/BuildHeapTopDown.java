package heap_sort;

/*
Implement BuildHeap Top-Down.
Write your code in such a way that given an input, your program will return the number of “data item”
comparisons.
*/
public class BuildHeapTopDown {
    private static final int[] NUMBERS = new int[]{56, 39, 14, 18, 75, 100, 102};

    public static void main(String[] args) {
        heapTopDownComparision(NUMBERS);
    }

    private static void heapTopDownComparision(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int currentIndex = i + 1;
            if (currentIndex > 1) {
                upHeap(currentIndex, numbers);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    private static void upHeap(int i, int[] numbers) {
        if (i < 2) return;
        int currentNodeIndex = i - 1;
        int parentNodeIndex = i / 2;

        Integer parentNodeValue = numbers[parentNodeIndex - 1];
        Integer currentNodeValue = numbers[i - 1];

        if (currentNodeValue > parentNodeValue) {
            swap(parentNodeIndex, currentNodeIndex);
            currentNodeIndex = parentNodeIndex;
            upHeap(currentNodeIndex, numbers);
        }
    }

    private static void swap(int parentNodeIndex, int currentNodeIndex) {
        Integer temp = NUMBERS[parentNodeIndex - 1];
        NUMBERS[parentNodeIndex - 1] = NUMBERS[currentNodeIndex];
        NUMBERS[currentNodeIndex] = temp;
    }
}
