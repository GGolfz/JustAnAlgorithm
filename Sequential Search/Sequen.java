import java.util.Scanner;
public class Sequen{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int [n];
        int count=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int number_check=sc.nextInt();
        for(int i=0;i<n;i++){
            count=0;
            if(arr[i]==number_check){
                System.out.println("Number: "+arr[i]+" has in arrays");
                break;
            }else{
                count++;
            }
        }
        if(count!=0){
            System.out.println("Number: "+number_check+" hasn't in arrays");
        }
    }
}