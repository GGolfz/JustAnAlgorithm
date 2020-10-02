public class QuickSort {
    public static void main(String[] args) {
        int [] test = {70,22,35,45,27,100,35,68,57,243};
        quicksort(test, 0, test.length-1);
        for(int i=0;i<test.length;i++){
            System.out.print(test[i]+" ");
        }
        System.out.println("");
    }

    public static void quicksort(int[] data, int first, int last) {
        if (first >= last)
            return;
        int pivot = first;
        int lower = first + 1, upper = last;
        while (lower <= upper) {
            while (lower < data.length && data[lower] < data[pivot]) {
                lower++;
            }
            while (upper >= 0 && data[upper] > data[pivot]) {
                upper--;
            }
            if (lower < upper) {
                swap(data, lower, upper);
                lower++;
                upper--;
            }
        }
        swap(data, pivot, upper);
        quicksort(data, first, upper - 1);
        quicksort(data, upper + 1, last);
    }

    public static void swap(int[] data, int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
}