import java.util.Scanner;
public class SieveOfErathotenes {
    public static void main(String[] args) {
        listPrimeSieve(20);
    }

    public static void listPrimeSieve(int arraySize){
        arraySize=arraySize+1;
        int[] A = new int[arraySize];
        int i, j;
        
        A[0] = 1;
        A[1] = 1;

        for (i=2;i<arraySize;i++) {
            if(A[i]==1) continue;
            for(j=i;i*j<arraySize;j++){ 
                A[i*j] = 1;
            }
        }
        
        for (i = 2; i < arraySize; i++)
            if(A[i]==0)
            System.out.print(i + " ");
        
        
    }
}


