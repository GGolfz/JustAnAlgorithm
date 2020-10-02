import java.util.Scanner;
public class highScool{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int prime_num=sc.nextInt();
        int count=0;
        for(int i=2;i<=prime_num;i++){
            count=0;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.print(i+" ");
            }
        }
    }
}