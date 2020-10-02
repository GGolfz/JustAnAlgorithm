public class SelectionSort{
	
	public static void main(String[] args) {
        int[] data = {30, 5, 60, 11, 4, 200, 99, 6, 81, 3};
        int[] b = {30, 5555, 460, 1111, 4, 200, 99, 606, 3781, 3, 1167, 543, 22, 5632, 876};
        SelectionSort(b);
        System.out.println(Arrays.toString(b));
    }
	
	public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int least = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }
            }
            // swap betwwen least and i
            if (i != least) {
                int temp = arr[i];
                arr[i] = arr[least];
                arr[least] = temp;
            }
        }
    }
	
}