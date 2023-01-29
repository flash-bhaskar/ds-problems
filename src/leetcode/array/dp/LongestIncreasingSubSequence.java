package leetcode.array.dp;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public static int findLIS(int[] arr){
        System.out.println("length = " + arr.length);
        int lis[] = new int[arr.length + 1];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        Arrays.fill(lis, 1);
        /* Compute optimized LIS values in
           bottom up manner */
        for (i = 1; i < arr.length; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);

        /* Pick maximum of all LIS values */
        for (i = 0; i < arr.length; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,0,3,2,3};
        System.out.println(findLIS(nums));
    }
}
