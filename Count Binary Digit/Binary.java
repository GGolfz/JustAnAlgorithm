public class Binary {
    public static void main(String[] args) {
        for(int i =0;i<=64;i++){
            System.out.println(count(i));
        }
    }
    public static int count(int n){
        if(n==0||n ==1) return 1;
        return 1+ count((int) (n/2));
    }
}
