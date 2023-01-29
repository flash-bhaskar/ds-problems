package leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class NthMaxOccurredCharacter {

    public static List<Character> getData(String s, int n){
        if(s == null){
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map.entrySet().stream()
                .filter(obj -> obj.getValue() == n)
                .map(obj -> obj.getKey())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String str = "this is a normal string";
        List<Character> data = getData(str, 1);
        System.out.println(data);
    }
}
