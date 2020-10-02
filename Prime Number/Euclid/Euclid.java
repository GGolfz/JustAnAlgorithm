public class Euclid {
    public static void main(String[] args) {
        EuclidNumbers(listPrimeSieve(20));
    }
    public static int[] listPrimeSieve(int arraySize){ //powered by Mr.Thetkpark
        arraySize=arraySize+1;
        int[] A = new int[arraySize];
        int i, j, k=2;
        
        A[0] = 1;
        A[1] = 1;

        for (i=2;i<arraySize;i++) {
            if(A[i]==1) continue;
            for(j=i;i*j<arraySize;j++){ 
                if(A[i*j]==1) continue;
                A[i*j] = 1;
                k++;
            }
        }
        
        int ans[]=new int[arraySize-k];
        k=0;
        for (i = 2; i < arraySize; i++)
            if(A[i]==0)
                ans[k++]=i;
        return ans;
    }
    public static void EuclidNumbers(int[] primes) {
        int i=1;
        for(int j:primes){
            i*=j;
            System.out.print((i+1)+" ");
        }
    }
}
