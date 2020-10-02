import java.util.Scanner;

public class BinarySearch {
    public static int bsearch(int[] arr, int value) {
        int left = 0, right = arr.length - 1;
        int idx = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > value) {
                left = mid + 1;
            } else {
                if (arr[mid] == value) {
                    idx = mid;    
                }
                right = mid;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = bsearch(arr, 5);
        System.out.println(ans);
    }
}

/*
10
3 4 5 5 5 5 5 7 12 13
*/
