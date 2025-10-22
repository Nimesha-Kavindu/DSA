import java.text.DecimalFormat;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int len = 30000;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len+20000];
        int[] arr3 = new int[len+40000];
        int[] arr4 = new int[len+120000];
        int[] arr5 = new int[len+170000];

        for (int i = 0; i < len; i++) {
            arr1[i] = random.nextInt(len);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(len);
        }
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = random.nextInt(len);
        }
        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = random.nextInt(len);
        }
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt(len);
        }

        insertionSort(arr1);
        insertionSort(arr2);
        insertionSort(arr3);
        insertionSort(arr4);
        insertionSort(arr5);

    }

    public static void insertionSort(int[] arr) {

        long startTime = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = 0;
            while (j >= 0 && arr[j] > arr[j - 1]) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("Insertion Sort elements: " + arr.length);
        System.out.println("Insertion Sort: " + time + "ms");
    }
}