
/**
 * BubbleSort
 */
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before sorting");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        bubbleSort(arr);
        System.out.println("Array after sorting");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = data.length - 1; j > i; j--) {
                if (data[j] < data[j - 1]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                }
            }
        }
    }
}