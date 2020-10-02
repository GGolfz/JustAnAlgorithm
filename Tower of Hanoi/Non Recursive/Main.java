import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();
        Stack<Integer> pole1 = new Stack<>();
        Stack<Integer> pole2 = new Stack<>();
        Stack<Integer> pole3 = new Stack<>();
        for (int i = size; i >= 1 ; i--) {
            pole1.push(i);
        }
        int steps = (int) (Math.pow(2, size) - 1);
        Stack<Integer> aux, dest;
        int auxN, destN;
        if(size%2 !=0){
            aux = pole2;
            auxN = 2;
            dest = pole3;
            destN = 3;
        } else{
            aux = pole3;
            auxN = 3;
            dest = pole2;
            destN = 2;
        }
        for (int i = 1; i <= steps; i++) {
            System.out.print(i+ " ");
            if (i%3 == 1){
                move(pole1, dest);
                System.out.println("Pole 1 between Pole "+ destN);
            } else if (i%3 == 2){
                move(pole1, aux);
                System.out.println("Pole 1 between Pole " + auxN);
            } else {
                move(aux, dest);
                System.out.println("Pole " +auxN+ " between Pole " + destN);
            }
        }
        while (!pole3.isEmpty()){
            int i = pole3.pop();
            System.out.print(i + " ");
            System.out.println(" DEST");
        }

    }

    public static void move(Stack<Integer> src, Stack<Integer> dest){
        int src1 = src.isEmpty() ? 0: src.peek();
        int dest1 = dest.isEmpty() ? 0 : dest.peek();
        if (src1 == 0){
            dest1 = dest.pop();
            src.push(dest1);
            System.out.print("Right to left ");
        } else if (dest1 == 0){
            src1 = src.pop();
            dest.push(src1);
            System.out.print("Left to Right ");
        } else if (src1 > dest1){
            dest.pop();
            src.push(dest1);
            System.out.print("Right to left ");
        } else {
            src.pop();
            dest.push(src1);
            System.out.print("Left to Right ");
        }
    }
}
