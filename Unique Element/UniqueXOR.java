import java.util.Scanner;

public class UniqueXOR {
    public static void main(String[] args) {
        //Assume there is guarantee only one unique element in the list
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (n > 0) {
            int curUnique = arr[0];
            for (int i = 1; i < n; i++) {
                curUnique = curUnique ^ arr[i];
            }
            System.out.println(curUnique);
        }
    }
}
