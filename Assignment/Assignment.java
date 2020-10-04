import java.util.Set;
import java.util.HashSet;
public class Assignment {
    public static void main(String[] args) {
        
        int[][] assignment = {{9,2,7,8},{6,4,3,7},{5,8,1,8},{7,6,9,4}};
        int count = 0;
        int min = Integer.MAX_VALUE;
        int[] minas = new int[4];
        for(int i = 0 ;i<4;i++){
            for(int j = 0 ;j<4;j++){
                for(int k = 0 ;k<4;k++){
                    for(int l = 0 ;l<4;l++){
                        Set<Integer> s = new HashSet<Integer>();
                        s.add(i);
                        s.add(j);
                        s.add(k);
                        s.add(l);
                        if(s.size()==4){
                            int sum = assignment[0][i] + assignment[1][j]+assignment[2][k]+assignment[3][l];
                            if(sum < min){
                                minas[0]=i;
                                minas[1]=j;
                                minas[2]=k;
                                minas[3]=l;
                                min = sum;
                            }
                            System.out.print(++count+" : ");
                            System.out.print((i+1)+",");
                            System.out.print((j+1)+",");
                            System.out.print((k+1)+",");
                            System.out.print((l+1)+" = ");
                            System.out.println(sum);
                        }
                    }
                }
            }
        }
        System.out.println("Min :" + min);
        System.out.println("People 1 Job "+(minas[0]+1));
        System.out.println("People 2 Job "+(minas[1]+1));
        System.out.println("People 3 Job "+(minas[2]+1));
        System.out.println("People 4 Job "+(minas[3]+1));
    }
}
