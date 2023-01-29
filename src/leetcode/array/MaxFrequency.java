package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {

    public static void main(String[] args) {
        int[] arr = {10,20,40, 10, 20, 10, 20, 10};
        System.out.println(printMostFrequency(arr));
    }

    private static int printMostFrequency(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            if(map.containsKey(a)){
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        int maxFreq = 0, element = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(maxFreq < entry.getValue()){
                maxFreq = entry.getValue();
                element = entry.getKey();
            }
        }
        System.out.println("max freq" + maxFreq);
        return element;
    }
}
