public class GadgetTest {
    public static void main(String[] args) {
        int maxFloor = 100;
        int minFloor = 1;
        boolean phone = true;
        int current = 1;
        int target = (int) (Math.random()*maxFloor);
        test(current,minFloor,maxFloor,phone,target);
    }
    public static void test(int current,int min,int max,boolean phone,int target){
        int pos = -1;
        if(current == target + 1){
            pos = current - 1;
        }
        if(current > target){
            phone = false;
            max = current;
            current = min;
        }
        if(current <= target){
            min = current;
        }
        if(phone){
            current = (int)(min + (max-min)/2);
            test(current,min,max,phone,target);
        } else {
            for(int i = current+1;i<=max;i++){
                if(i == target+1){
                    pos = i-1;
                } 
            }
        }
        if(pos != -1){
            System.out.println(pos);
        }
    }
}
