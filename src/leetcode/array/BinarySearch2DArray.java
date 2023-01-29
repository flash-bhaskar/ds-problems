package leetcode.array;

public class BinarySearch2DArray {

    public static void main(String[] args) {

        int n = 4, m = 5, target = 122;
        int matrix[][] = {{0, 6, 8, 9, 11},
                {20, 22, 28, 29, 31},
                {36, 38, 50, 61, 63},
                {64, 66, 100, 122, 128}};

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int rowMid;
                int colMid;
                if(i == 0){
                    rowMid = (i + matrix.length - 1) / 2;
                    colMid = (j + matrix[i].length - 1) / 2;
                } else {
                    rowMid = i;
                    colMid = j;
                }
                if(matrix[rowMid][colMid] == target){
                    System.out.println("element found");
                    break;
                } else if((matrix[rowMid][colMid] > target)){
                    i = rowMid - 1;
                } else if((matrix[rowMid][colMid] < target) && (matrix[rowMid][matrix[i].length - 1] < target)){
                    i = rowMid + 1;
                }
            }
        }

    }
}
