package leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 0; i <= s.length(); i++){
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> list = Arrays.asList("leet","code");
        System.out.println("Answer is " + wordBreak(str, list));
    }
}
