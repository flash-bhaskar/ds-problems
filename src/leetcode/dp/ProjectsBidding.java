package leetcode.dp;

import java.util.*;

public class ProjectsBidding {

    public static long minCost(int numProjects, List<Integer> projectId, List<Integer> bid){
        if(projectId.isEmpty()){
            return -1;
        }
        Set<Integer> set = new HashSet<>(projectId);
        if(set.size() != numProjects){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < projectId.size(); i++){
            if(map.containsKey(projectId.get(i))){
                map.put(projectId.get(i), Math.min(map.get(projectId.get(i)), bid.get(i)));
            } else {
                map.put(projectId.get(i), bid.get(i));
            }
        }
        return map.entrySet().stream().mapToLong(obj ->obj.getValue().longValue()).sum();
    }

    public static void main(String[] args) {
        int n = 2;
        List<Integer> l1 = Arrays.asList(1,1,1,1,1);
        List<Integer> l2 = Arrays.asList(4,74,47, 744, 7);
        System.out.println(minCost(n, l1, l2));
    }
}
