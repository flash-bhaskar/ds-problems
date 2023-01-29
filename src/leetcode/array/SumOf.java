package leetcode.array;

import java.util.HashMap;

public class SumOf {

    public static void main(String[] args) throws Exception{
        int a[] = {7,9,11,13,15,17,21,27,29};
        int sum = 18;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ints = binarySearch(a, 50, 0, a.length, map);
        System.out.println(ints.toString());
        System.out.println(getData(a, 50).toString());
    }

    public static int[] getData(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                return new int[]{hashMap.get(nums[i]), i};
            }
            hashMap.put(target - nums[i], i);
        }
        return new int[]{-1,-1};
    }

    public static int[] binarySearch(int[] nums, int target, int l, int h, HashMap<Integer, Integer> map){
        while(l < h){
            int mid = (l + h) / 2;
            if(map.containsKey(nums[mid])){
                return new int[]{map.get(nums[mid]), mid};
            }

            map.put(target - nums[mid], mid);
            if((target - nums[mid]) < nums[mid]){
                return binarySearch(nums, target, l, mid - 1, map);
            } else {
                return binarySearch(nums, target, mid + 1, h, map);
            }
        }
        return new int[]{-1, -1};
    }
}
