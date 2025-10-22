import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        executedMeth();
    }

    //===============create the array=====================
    public static int[] createRandomArray(int noOfElements) {
        Random rand = new Random();
        int[] array = new int[noOfElements];

        for (int i = 0; i < noOfElements; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }
    //=======================================

    //===============Merge sort recusive===========================
    public static void mergeSort(int[] array) {
        if (array.length > 1) {

            int mid = array.length / 2;
            int[] leftHalf = new int[mid];
            int[] rightHalf = new int[array.length - mid];

            for (int i = 0; i < mid; i++) {
                leftHalf[i] = array[i];
            }
            for (int i = mid; i < array.length; i++) {
                rightHalf[i - mid] = array[i];
            }

            mergeSort(leftHalf);
            mergeSort(rightHalf);

            int i = 0, j = 0, k = 0;

            while (i < leftHalf.length && j < rightHalf.length) {
                if (leftHalf[i] <= rightHalf[j]) {
                    array[k] = leftHalf[i];
                    i++;
                } else {
                    array[k] = rightHalf[j];
                    j++;
                }
                k++;
            }

            while (i < leftHalf.length) {
                array[k] = leftHalf[i];
                i++;
                k++;
            }

            while (j < rightHalf.length) {
                array[k] = rightHalf[j];
                j++;
                k++;
            }
        }
    }
    //==================================================

    //===================== merge sort in iteration way ================================
    public static void mergeSortIterative(int[] array) {
        int n = array.length;
        int size = 1;

        while (size < n) {
            int left = 0;

            while (left < n) {
                int mid = Math.min(n, left + size);
                int right = Math.min(n, left+ 2*size);

                merge(array, left, right, mid);
                left += 2*size;

            }
            size *= 2;
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] leftSubarray = Arrays.copyOfRange(array, left, mid);
        int[] rightSubarray = Arrays.copyOfRange(array, mid, right);

        int i = 0, j = 0, k = left;

        while (i < leftSubarray.length && j < rightSubarray.length) {
            if (leftSubarray[i] <= rightSubarray[j]) {
                array[k] = leftSubarray[i];
                i++;
            } else {
                array[k] = rightSubarray[j];
                j++;
            }
            k++;
        }

        while (i < leftSubarray.length) {
            array[k] = leftSubarray[i];
            i++;
            k++;
        }

        while (j < rightSubarray.length) {
            array[k] = rightSubarray[j];
            j++;
            k++;
        }
    }
    // ==============================================================

    // ======================= Quick sort in recursive way =================
    public static List<Integer> quickSort(List<Integer> arr) {
        // Base case: if the list has 1 or fewer elements, return it as is
        if (arr.size() <= 1) {
            return arr;
        }

        // Select the pivot as the last element
        int pivot = arr.get(arr.size() - 1);

        // Create lists to hold elements less than or equal to the pivot and greater than the pivot
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Partition the array around the pivot
        for (int i = 0; i < arr.size() - 1; i++) { // Exclude the pivot
            if (arr.get(i) <= pivot) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }

        // Recursively sort the left and right sublists, and concatenate the results with the pivot
        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(quickSort(left)); // Add sorted left sublist
        sorted.add(pivot);             // Add the pivot
        sorted.addAll(quickSort(right)); // Add sorted right sublist

        return sorted;
    }

    // ==================== quick sort in iterative way ===========================

    public static void quickSortIterative(int[] arr) {
        // Initialize an empty stack
        Stack<int[]> stack = new Stack<>();

        // Push the initial range onto the stack
        stack.push(new int[]{0, arr.length - 1});

        // Process ranges in the stack until it is empty
        while (!stack.isEmpty()) {
            // Pop the current range from the stack
            int[] range = stack.pop();
            int low = range[0];
            int high = range[1];

            if (low < high) {
                // Partition the array and get the pivot index
                int pivotIndex = partition(arr, low, high);

                // Push the left subarray onto the stack
                stack.push(new int[]{low, pivotIndex - 1});

                // Push the right subarray onto the stack
                stack.push(new int[]{pivotIndex + 1, high});
            }
        }
    }

    // Helper method to perform partitioning
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1;       // Pointer for the smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Place pivot in the correct position
        swap(arr, i + 1, high);

        return i + 1; // Return the pivot index
    }

    // Helper method to swap elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //====================================================================

    public static void executedMeth(){
        int element_count = 2000;

        for (int i = 0; i < 6; i++) {
            int[] array = createRandomArray(element_count);
            long starttime = System.currentTimeMillis();
            mergeSort(array);
            long endtime = System.currentTimeMillis();
            long duration = endtime - starttime;
            System.out.println("Element count: " + element_count + "\n" + "Duration: " + duration + " milliseconds");
            System.out.println("-------------------------------");
            element_count +=3000;
        }
        element_count = 2000;

        for (int i = 0; i < 6; i++) {
            int[] array = createRandomArray(element_count);
            long starttime = System.currentTimeMillis();
            mergeSortIterative(array);
            long endtime = System.currentTimeMillis();
            long duration = endtime - starttime;
            System.out.println("Element count: " + element_count + "\n" + "Duration: " + duration + " milliseconds");
            System.out.println("-------------------------------");
            element_count +=3000;
        }
        element_count = 2000;

        for (int i = 0; i < 6; i++) {
            List<Integer> array = new ArrayList<>(element_count);
            long starttime = System.currentTimeMillis();
            quickSort(array);
            long endtime = System.currentTimeMillis();
            long duration = endtime - starttime;
            System.out.println("Element count: " + element_count + "\n" + "Duration: " + duration + " milliseconds");
            System.out.println("-------------------------------");
            element_count +=3000;
        }
        element_count = 2000;

        for (int i = 0; i < 6; i++) {
            int[] array = createRandomArray(element_count);
            long starttime = System.currentTimeMillis();
            quickSortIterative(array);
            long endtime = System.currentTimeMillis();
            long duration = endtime - starttime;
            System.out.println("Element count: " + element_count + "\n" + "Duration: " + duration + " milliseconds");
            System.out.println("-------------------------------");
            element_count +=3000;
        }
    }
}