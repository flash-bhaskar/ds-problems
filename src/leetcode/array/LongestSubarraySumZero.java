package leetcode.array;

import java.util.HashMap;

public class LongestSubarraySumZero {

    public static int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            sum = sum + arr[i];

            if(sum == 0){
                maxLen = i + 1;
            }

            Integer prevLen = map.get(sum);
            if(prevLen == null){
                map.put(sum, i);
            } else {
                Math.max(maxLen, i - prevLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        int n = 8;
        System.out.println(maxLen(arr, n));
    }
}
