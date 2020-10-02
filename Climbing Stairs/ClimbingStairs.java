public class ClimbingStairs{
    public static int climb(int n) {
        if (n < 2)
            return n;
        return climb(n - 1) + climb(n - 2);
    }

    public static void main(String[] args) {
        int ans = climb(5);
        System.out.println(ans);
        
        ans = climb(3);
        System.out.println(ans);
    }
}