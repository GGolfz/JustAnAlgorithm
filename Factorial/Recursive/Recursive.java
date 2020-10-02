import java.util.Scanner;

public class Recursive {
   public static long factorial(long n) {
      if (n <= 1)
         return 1;
      else
         return n * fact(n - 1);
   }
   
   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      System.out.println("The factorial of 6 is: " + factorial(n));
      System.out.println("The factorial of 0 is: " + factorial(n));
   }
}