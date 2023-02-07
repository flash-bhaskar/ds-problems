package leetcode.dp;

public class FrogJumping {

    public int findPossibleFrogJumps(int[] blocks){
        int possibleJump = 0;
        if(blocks.length == 0){
            return possibleJump;
        }
        int[] leftList = new int[blocks.length];
        int[] rightList = new int[blocks.length];
        int length = blocks.length - 1;
        for(int i = 1; i <= blocks.length - 1; i++){
            if(blocks[i] <= blocks[i - 1]){
                leftList[i] = leftList[i - 1] + 1;
            } else {
                leftList[i] = 0;
            }
            if(blocks[length - i] <= blocks[length - i + 1]){
                rightList[length - i] = rightList[length - i + 1] + 1;
            } else {
                rightList[length - i] = 0;
            }
        }

        for(int i = 0; i < blocks.length; i++){
            possibleJump = Math.max(possibleJump, leftList[i] + rightList[i]  + 1);
        }
        return possibleJump;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,7,5};
        FrogJumping obj = new FrogJumping();
        int possibleFrogJumps = obj.findPossibleFrogJumps(arr);
        System.out.println(possibleFrogJumps);
    }
}
