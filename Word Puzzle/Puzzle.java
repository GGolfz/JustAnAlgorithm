/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;
/**
 *
 * @author 62130500240
 */
public class Puzzle {
    public static void main(String[] args) {
        char[][] puzzle=
        {
            {'a','b','c','d','e','f','g','h'},
            {'c','p','i','e','g','h','o','j'},
            {'e','f','p','p','i','r','k','l'},
            {'a','b','c','l','s','o','p','o'},
            {'a','e','i','e','e','f','g','h'},
            {'t','m','p','t','m','e','r','t'},
            {'a','a','c','e','e','f','r','h'},
            {'m','t','o','p','q','r','s','t'}
        };
        int[] position=search(puzzle,"apple");
        System.out.println(position[0]+","+position[1]+" "+direction(position[2]));
        position=search(puzzle,"tree");
        System.out.println(position[0]+","+position[1]+" "+direction(position[2]));
        position=search(puzzle,"map");
        System.out.println(position[0]+","+position[1]+" "+direction(position[2]));
        position=search(puzzle,"horse");
        System.out.println(position[0]+","+position[1]+" "+direction(position[2]));
        position=search(puzzle,"pot");
        System.out.println(position[0]+","+position[1]+" "+direction(position[2]));
        position=search(puzzle,"pie");
        System.out.println(position[0]+","+position[1]+" "+direction(position[2]));
        position=search(puzzle,"tame");
        System.out.println(position[0]+","+position[1]+" "+direction(position[2]));
        position=search(puzzle,"deplete");
        System.out.println(position[0]+","+position[1]+" "+direction(position[2]));
        position=search(puzzle,"peel");
        System.out.println(position[0]+","+position[1]+" "+direction(position[2]));
        
    }
    public static int[] search(char[][] a,String key){
        int[] location=new int[3];
        //left2right
        for(int row=0;row<a.length;row++){
            for(int i=0;i<=a[row].length-key.length();i++){
                int j=0;
                for(;j<key.length()&&a[row][i+j]==key.charAt(j);j++){}
                if(j==key.length()){
                    location[0]=row;location[1]=i;location[2]=1;
                    return location;
                }
            }
        }
        //right2left
        for(int row=0;row<a.length;row++){
            for(int i=a[row].length-1;i>=key.length()-1;i--){
                int j=0;
                for(;j<key.length()&&a[row][i-j]==key.charAt(j);j++){}
                if(j==key.length()){
                    location[0]=row;location[1]=i;location[2]=2;
                    return location;
                }
            }
        }
        //up2down
        for(int col=0;col<a[0].length;col++){
            for(int i=0;i<=a.length-key.length();i++){
                int j=0;
                for(;j<key.length()&&a[i+j][col]==key.charAt(j);j++){}
                if(j==key.length()){
                    location[0]=i;location[1]=col;location[2]=3;
                    return location;
                }
            }
        }
        //down2up
        for(int col=0;col<a[0].length;col++){
            for(int i=a.length-1;i>=key.length()-1;i--){
                int j=0;
                for(;j<key.length()&&a[i-j][col]==key.charAt(j);j++){}
                if(j==key.length()){
                    location[0]=i;location[1]=col;location[2]=4;
                    return location;
                }
            }
        }
        //diagonal left2right & up2down
        for(int row=0;row<=a.length-key.length();row++){
            for(int i=0;i<=a[row].length-key.length();i++){
                int j=0;
                for(;j<key.length()&&a[row+j][i+j]==key.charAt(j);j++){}
                if(j==key.length()){
                    location[0]=row;location[1]=i;location[2]=5;
                    return location;
                }
            }
        }
        //diagonal right2left & up2down
        for(int row=0;row<=a.length-key.length();row++){ 
            for(int i=a[row].length-1;i>=key.length()-1;i--){
                int j=0;
                for(;j<key.length()&&a[row+j][i-j]==key.charAt(j);j++){}
                if(j==key.length()){
                    location[0]=row;location[1]=i;location[2]=6;
                    return location;
                }
            }
        }
        //diagonal left2right & down2up
        for(int row=a.length-1;row>=key.length()-1;row--){
            for(int i=0;i<=a[row].length-key.length();i++){
                int j=0;
                for(;j<key.length()&&a[row-j][i+j]==key.charAt(j);j++){}
                if(j==key.length()){
                    location[0]=row;location[1]=i;location[2]=7;
                    return location;
                }
            }
        }
        //diagonal right2left & down2up
        for(int row=a.length-1;row>=key.length()-1;row--){
            for(int i=a[row].length-1;i>=key.length()-1;i--){
                int j=0;
                for(;j<key.length()&&a[row-j][i-j]==key.charAt(j);j++){}
                if(j==key.length()){
                    location[0]=row;location[1]=i;location[2]=8;
                    return location;
                }
            }
        }
        return new int[] {-1,-1,-1};
    }
    public static String direction(int k) {
        String a="";
        switch(k){
            case 1: return "left-to-right";
            case 2: return "right-to-left";
            case 3:return "top-down";
            case 4:return "bottom-up";
            case 5:return "diagonal left-to-right & top-down";
            case 6:return "diagonal right-to-left & top-down";
            case 7:return "diagonal left-to-right & bottom-up";
            case 8:return "diagonal right-to-left & bottom-up";
        }return "Not found";
    }
}
