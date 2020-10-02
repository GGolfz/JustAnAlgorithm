package Sudoku;
import java.util.Arrays;
public class sudoku {
    public static void main(String[] args) {
        int sudoku[][]={
            {7,0,0,  5,8,3,  0,0,6},
            {0,0,6,  0,0,1,  4,0,5},
            {0,5,2,  0,0,6,  0,8,3},
            
            {3,0,0,  2,0,0,  9,5,8},
            {5,0,0,  0,7,8,  0,6,0},
            {6,4,8,  0,1,0,  3,0,0},
            
            {0,6,0,  8,0,2,  5,0,0},
            {0,0,3,  1,5,0,  0,7,2},
            {2,1,5,  6,0,0,  0,3,0}
        };
        int zero=0; //zero - total empty space in sudoku
        //find total empty space in sudoku
        for(int i[]:sudoku){
            for(int j:i){
                if(j==0){
                    zero++;
                }
            }
        }
        //loop until all empty spaces are filled
        while(zero>0){
            //loop area 3x3 of sudoku
            for(int indexR=0;indexR<sudoku.length;indexR+=3){
                for(int indexC=0;indexC<sudoku.length;indexC+=3){
                    String check=""; //check - all number in 3x3 area
                    //finding all number in 3x3 area
                    for(int r=0;r<3;r++){
                        for(int c=0;c<3;c++){
                            if(sudoku[indexR+r][indexC+c]>0){
                                check+=(""+sudoku[indexR+r][indexC+c]);
                            }
                        }
                    }
                    //System.out.println("area ("+indexR+","+indexC+")-("+(indexR+3)+","+(indexC+3)+") have "+check);
                    //try number from 1 to 9
                    for(int i=1;i<=9;i++){
                        //if that number are already in 3x3 area, then skip
                        if(check.contains(""+i)){
                            continue;
                        }
                        int canPlace=0; //canPlace - number of position that the number could be
                        int col=0; //col - keeping the column for replacing number
                        int row=0; //row - keeping the row for replacing number
                        //if that number isn't in 3x3 area, find the empty space in 3x3 area
                        canPlace:
                        for(int r=0;r<3;r++){
                            for(int c=0;c<3;c++){
                                if(sudoku[indexR+r][indexC+c]==0){
                                    boolean found=false; //found - for finding the number in row or column of that position.
                                    //If found empty space, find that number in row or column of that position.
                                    for(int find=0;find<sudoku[0].length&&!found;find++){
                                        if(sudoku[indexR+r][find]==i||sudoku[find][indexC+c]==i){
                                            found=true;
                                        }
                                    }
                                    //if didn't found that number in row or column, that number could be in that position.
                                    if(!found){
                                        canPlace++;
                                        row=indexR+r;
                                        col=indexC+c;
                                        //System.out.println("pos "+(indexR+r)+","+(indexC+c)+" can be "+i);
                                        //if there are more than one possible position, skip that number
                                        if(canPlace>1){
                                            break canPlace;
                                        }
                                    }
                                }
                            }
                        }
                        //if there is exactly one possible position, that number is in that position
                        if(canPlace==1){
                            sudoku[row][col]=i;
                            zero--;
                        }
                    }
                }
            }
        }
        for(int i=0;i<sudoku.length;i++){
            System.out.println(Arrays.toString(sudoku[i]));
        }
    }
}