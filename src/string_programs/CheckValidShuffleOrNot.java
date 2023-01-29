package string_programs;

import java.util.Arrays;

public class CheckValidShuffleOrNot {

    public static boolean checkForLength(String first, String second, String result){
        if(first.length() + second.length() != result.length())
            return false;
        else
            return true;
    }

    public static String sortString(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String first = "XY";
        String second = "12";
        String[] results = {"1XY2", "Y1X2", "Y21XX"};

        for(String result : results){
            if(checkForLength(first, second, result) && checkForShuffle(first, second, result)){
                System.out.println(result + " valid shuffle of first " + first + " and second " + second);
            } else {
                System.out.println(result + " not valid shuffle of first " + first + " and second " + second);
            }
        }

    }

    private static boolean checkForShuffle(String first, String second, String result) {
        String sortedFirst = sortString(first);
        String sortedSecond = sortString(second);
        String sortedResult = sortString(result);

        int i = 0, j = 0, k = 0;

        while(k != result.length()){

            if(i < first.length() && first.charAt(i) == result.charAt(k))
                i++;
            else if(j < second.length() && second.charAt(j) == result.charAt(k))
                j++;
            else
                return false;

            k++;
        }

        if(i < first.length() || j < second.length())
            return false;

        return true;
    }
}
