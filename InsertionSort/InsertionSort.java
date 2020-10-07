import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();

        insertSort(array);

        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void insertSort(int[] array) {    
        int temp = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = i-1; j > 0; j--) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                } else {
                    break;
                }
            }
        }
    }
    
}
