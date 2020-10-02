import java.util.Arrays;
public class SelectionSort{
	
	public static void main(String[] args) {
        int[] data = {30, 5, 60, 11, 4, 200, 99, 6, 81, 3};
        int[] b = {30, 5555, 460, 1111, 4, 200, 99, 606, 3781, 3, 1167, 543, 22, 5632, 876};
        MergeSort(b);
        System.out.println(Arrays.toString(b));
    }
	
    public static void MergeSort(int[] data, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            MergeSort(data, first, mid);
            MergeSort(data, mid + 1, last);
            merge(data, first, last);
        } else {

        }
    }

    public static void merge(int[] data, int first, int last) {
        int[] result = new int[last - first + 1];
        int mid = (first + last) / 2;
        int left = first, right = mid + 1;
        int i = 0;
        while (left <= mid && right <= last) {
            if (data[left] < data[right]) {
                result[i] = data[left];
                left++;
            } else {
                result[i] = data[right];
                right++;
            }
            i++;
        }
        while (left <= mid) {
            result[i] = data[left];
            left++;
            i++;
        }
        while (right <= last) {
            result[i] = data[right];
            right++;
            i++;
        }
        for (int j = 0; j <= last - first; j++) {
            data[first + j] = result[j];
        }
    }
	
}