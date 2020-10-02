import java.util.Scanner;

public class Knapsack {
    public static int solve(int[] value,int[] weight,int w,int index) {
        if (w == 0 || index < 0)
            return 0;
        int a = 0,b = 0;
        if(w-weight[index] >= 0){
            a = solve(value, weight, w - weight[index],index-1) + value[index];
        }
        b = solve(value, weight, w, index - 1);
        return Math.max(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] value = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        int ans = solve(value, weight, w, n - 1);
        System.out.println(ans);
    }
}
/*
5 10
3 4
5 3
3 2
10 7
2 1
*/