public class SelectionSort{
    public static void main(String[]args){
        int [] test = {5555, 22222, 444, 333,-100,7003,234,256,855,325,83};
        selectionSort(test);
        for(int i=0;i<test.length;i++){
            System.out.print(test[i]+" ");
        }
        System.out.println("");
    }
    public static void selectionSort(int[] data){
        for(int i = 0; i< data.length ; i++){
            int least = i;
            for(int j = i + 1; j < data.length; j++){
                if(data[j]<data[least]){
                    least = j;
                }
            }
            int temp = data[i];
            data[i] = data[least];
            data[least] = temp;
        }
    }
}