public class MaxElement{
    public static void main(String[]args){
        int[] test = {10,7,23,56,82190,123,642,34,72,8934,20043,43,1,-1,43};
        int max= 0;
        for(int i=0;i<test.length;i++){
            if(test[i] > max){
                max = test[i];
            }
        }
        System.out.println(max);

    }
}