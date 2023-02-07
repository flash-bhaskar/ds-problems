package leetcode.dp;

import java.util.Arrays;

public class LongestCommonSubSequence {

    public static int find(String s1, String s2, int[][] dp, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s1.charAt(m - 1) == s2.charAt(n - 1)){
            return dp[m][n] = find(s1, s2, dp, m - 1, n - 1) + 1;
        } else {
            return dp[m][n] = Math.max(find(s1, s2, dp, m - 1, n), find(s1,s2, dp, m, n-1));
        }
    }

    public static void main(String[] args) {
        String text1= "bhaskar";
        String text2 = "occar";
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        System.out.println(find(text1, text2, dp, text1.length(), text2.length()));
    }
}
