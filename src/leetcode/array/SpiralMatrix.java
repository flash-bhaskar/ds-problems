package leetcode.array;

import java.util.ArrayList;

public class SpiralMatrix {

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length == 0){
            return list;
        }

        int rowBeg = 0;
        int rowEnd = r;
        int colBeg = 0;
        int colEnd = c;

        while(rowBeg >= rowEnd && colBeg>= colEnd){
            for(int i = colBeg; i <= colEnd; i++){
                list.add(matrix[rowBeg][i]);
            }
            rowBeg++;

            for(int i = rowBeg; i <= rowEnd; i++){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBeg <= rowEnd){
                for(int i = colEnd; i >= colBeg; i--){
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(colBeg <= colEnd){
                for(int i = rowEnd; i >= rowBeg; i--){
                    list.add(matrix[i][colBeg]);
                }
            }
            colBeg++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        System.out.println(spirallyTraverse(matrix, 4,4));
    }
}
