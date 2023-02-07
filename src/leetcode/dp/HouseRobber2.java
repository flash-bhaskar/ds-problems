package leetcode.dp;

public class HouseRobber2 {

    public static int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for(int i = 2; i < nums.length; i++){
            if(nums.length - 1 == i){
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] n = {1,2,3};
        System.out.println(rob(n));
    }
}
