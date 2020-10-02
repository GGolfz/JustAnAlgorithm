import java.util.ArrayList;

class GCD {
    public static void main(String[] args) {
        int m = 120;
        int n = 30;
        System.out.println(euclidGCD(m, n));
        System.out.println(consecutiveGCD(m, n));
        System.out.println(middleSchoolGCD(m, n));
    }

    /**
     * 
     * @param m - first integer to find GCD
     * @param n - second integer to find GCD
     * @return the GCD between two integers
     */
    public static int euclidGCD(int m, int n) {
        if (n == 0) {
            return m;
        }

        int max = Math.max(m, n);
        int min = Math.min(m, n);

        return euclidGCD(min, max % min);
    }

    /**
     * 
     * @param m - first integer to find GCD
     * @param n - second integer to find GCD
     * @return the GCD between two integers
     */
    public static int consecutiveGCD(int m, int n) {
        int min = Math.min(m, n);

        while (min >= 2) {
            if (m % min == 0 && n % min == 0) {
                return min;
            }

            min -= 1;
        }

        return 1;
    }

    /**
     * 
     * @param m - first integer to find GCD
     * @param n - second integer to find GCD
     * @return the GCD between two integers
     */
    public static int middleSchoolGCD(int m, int n) {
        ArrayList<Integer> prime = sieveOfEratosthenes(Math.max(m, n));
        int gcd = 1;

        for (Integer integer : prime) {
            while (m % integer == 0 && n % integer == 0) {
                m /= integer;
                n /= integer;
                gcd *= integer;
            }
        }

        return gcd;
    }

    /**
     * 
     * @param n - find all prime that less than or equal to integer n
     * @return - array list of integer containing all prime nubmers between 2 to n
     *         (inclusive)
     */
    public static ArrayList<Integer> sieveOfEratosthenes(int n) {
        int[] arr = new int[n + 1];
        ArrayList<Integer> prime = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.floor(Math.sqrt(n)); i++) {
            if (arr[i] != 0) {
                int j = i * i;
                while (j <= n) {
                    arr[j] = 0;
                    j += i;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                prime.add(arr[i]);
            }
        }

        return prime;
    }
}
