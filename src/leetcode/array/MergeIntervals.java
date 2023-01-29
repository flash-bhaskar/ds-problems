package leetcode.array;

import java.util.*;

public class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals){
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        for(int[] interval : intervals){
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]){
                mergedIntervals.add(interval);
                continue;
            }
            mergedIntervals.getLast()[1] = interval[1];
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals obj = new MergeIntervals();
        int[][] ints = obj.mergeIntervals(intervals);
        System.out.println(Arrays.deepToString(ints));
    }
}
