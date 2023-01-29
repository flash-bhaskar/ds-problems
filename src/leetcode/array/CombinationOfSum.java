package leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationOfSum {

    public static List<List<Integer>> combinationOfSum(List<Integer> arr, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<Integer> arrSet = new HashSet<>(arr);
        arr.clear();
        arr.addAll(arrSet);
        Collections.sort(arr);
        findCombinationSum(ans, arr, 0, target, temp);
        return ans;
    }

    private static void findCombinationSum(List<List<Integer>> ans, List<Integer> arr, int index, int target, List<Integer> temp) {
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < arr.size(); i++){
            if((target - arr.get(i)) >= 0){
                temp.add(arr.get(i));
                findCombinationSum(ans, arr, i, target - arr.get(i), temp);
                temp.remove(arr.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(2);
        arr.add(3);
        arr.add(5);


        int sum = 8;
        int[] a = {2,3,5};
        int[] nums = {1,2,3};
        combinationSum4(nums, 4);

        List<List<Integer>> ans = combinationSum(a, sum);
        List<List<Integer>> an = combinationSum2(a, sum);

        // If result is empty, then
        if (ans.size() == 0) {
            System.out.println("Empty");
            return;
        }

        // print all combinations stored in ans

        System.out.println("printing combination of sum 1----");
        for (int i = 0; i < ans.size(); i++) {

            System.out.print("(");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print(") ");
        }
        System.out.println("--------------------------------------");

        System.out.println("printing combination of sum 2----");
        System.out.println(an);

        System.out.println("--------------------------------------");
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        findCombination(candidates, target, 0, temp, result);
        return result;
    }

    public static void findCombination(int[] arr, int target, int index, List<Integer> temp,
                                 List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < arr.length - 1; i++){
            if(target - arr[i] >= 0){
                temp.add(arr[i]);
                findCombination(arr, target - arr[i], i, temp, result);
                temp.remove(new Integer(arr[i]));
            }
        }
    }

    //Combination of sum 2

    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        List<Integer> arr = new ArrayList<>(a.length);
        for(int i : a){
            arr.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Collections.sort(arr);
        findCombinationSum2(ans, arr, 0, s, temp);
        return ans;
    }

    private static void findCombinationSum2(List<List<Integer>> ans, List<Integer> arr, int index, int target, List<Integer> temp) {
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < arr.size(); i++){
            if(i > index && arr.get(i) == arr.get(i-1)) continue;

            temp.add(arr.get(i));
            findCombinationSum2(ans, arr, i+1, target - arr.get(i), temp);
            temp.remove(arr.get(i));

        }
    }

    //Combination of sum 3

    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        comboHelper(1, target, k, new ArrayList<Integer>(), ans);

        return ans;
    }

    private void comboHelper(int start, int target, int k, List<Integer> combo, List<List<Integer>> ans) {
        if (target == 0) {
            if (combo.size() == k) {
                ans.add(new ArrayList<Integer>(combo));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            combo.add(i);
            comboHelper(i + 1, target - i, k, combo, ans);
            combo.remove(combo.size() - 1);
        }
    }

    /*
    sub problem: permutation(target) is defined as all permutaions of number in nums array that can sum up to target
    state transition: permuation(target) = for each of permutaions in permuations(target – nums[i]), plus element nums[i]
    base case: permutation(0) = {} // let nums = [1, 2, 3]. permutation(1) = permutation(0) add 1 = {1}.
    permuation(2) = permutation(1) add 1 + permuation(0) add 2 = {1, 1} + {2}
     */



    public static int combinationSum4(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 1; i < target + 1; i++) {
            map.put(i, 0);
            for(int n : nums){
                map.put(i, map.get(i) + map.getOrDefault((i - n), 0));
            }
        }
        return map.get(target);
    }


}
