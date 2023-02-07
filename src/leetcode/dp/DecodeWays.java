package leetcode.dp;

public class DecodeWays {

    public static int decodeWays(String s) {
        int n = s.length();
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        if(s.charAt(0) =='0')   //for base condition "01123" should return 0
            return 0;
        for (int i = 2; i <= n; i++)
        {
            count[i] = 0;

            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (s.charAt(i - 1) > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2' &&
                            s.charAt(i - 1) < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }

    public static void main(String[] args) {
        String str = "06";
        System.out.println(decodeWays(str));
        System.out.println(decodeWays2(str));
    }

    public static int decodeWays2(String s) {
        int n = s.length();
        int count1 = 1;
        int count2 = 1;
        if(s.charAt(0) =='0')
            return 0;
        for (int i = 2; i <= n; i++)
        {
            int temp = 0;
            if (s.charAt(i - 1) > '0')
                temp = count2;

            if (s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2' &&
                            s.charAt(i - 1) < '7'))
                temp += count1;

            count1 = count2;
            count2 = temp;
        }
        return count2;
    }

}
