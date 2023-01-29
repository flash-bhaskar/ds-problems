package leetcode.array.dp;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount, int[] dp) {
        if(amount == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int ans = 0;
            if(amount - coins[i] >= 0){
                if(dp[amount - coins[i]] != -1){
                    ans = dp[amount - coins[i]];
                } else {
                    ans = coinChange(coins, amount - coins[i], dp);
                }
                if(ans != Integer.MAX_VALUE && ans + 1 < min){
                    min = ans + 1;
                }
            }
        }
        return dp[amount] = min;
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] nums = {1,2,5};
        int amount = 3;

        System.out.println("coin change normal " + coinChange(nums, amount));
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int min = obj.coinChange(nums, amount, dp);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static int coinChange(int[] coins, int amount){
        if(amount == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            if(amount - coins[i] >= 0){
                int ans = coinChange(coins, amount - coins[i]);
                if(ans != Integer.MAX_VALUE){
                    min = Math.min(min, ans + 1);
                }
            }

        }
        return min;
    }
}
