package leetcode.array;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String str)
    {
        int n = str.length();
        int res = 0;

        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[256];
            for(int j = i; j < n; j++) {
                if (visited[str.charAt(j)] == true)
                    break;
                else {
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }
            visited[str.charAt(i)] = false;
        }
        return res;
    }

    public static void main(String args[]) {
            // Your code goes here
        String s = "Hellommmm";
        LongestSubstring ob = new LongestSubstring();
        System.out.println(ob.lengthOfLongestSubstring(s));
    }
}
