package leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class TwoSignals {

    public static int getSignals(List<Integer> signalOne, List<Integer> signalTwo){
        int updates = 0;
        if(signalOne.get(0) == signalTwo.get(0)){
            updates++;
        }
        for(int i = 1; i < signalOne.size(); i++){
            if(updates == 0){
                if(signalOne.get(i) == signalTwo.get(i)){
                    updates++;
                }
            } else if(signalOne.get(i) == signalTwo.get(i) && signalOne.get(i) > signalOne.get(i - 1) && signalTwo.get(i) > signalTwo.get(i - 1)){
                updates++;
            }
        }
        return updates;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,1);
        List<Integer> l2 = Arrays.asList(5,4,3,4,1);
        System.out.println(getSignals2(l1, l2));
    }

    public static int getSignals2(List<Integer> signalOne, List<Integer> signalTwo){
        int one = signalOne.size();
        int two = signalTwo.size();

        int n = one > two ? two : one;
        int updates = -1;
        int count = 0;

        for(int i = 0; i <= n - 1; i++){
            if(signalTwo.get(i) == signalOne.get(i)){
                if(updates < signalOne.get(i)){
                    count += 1;
                    updates = signalOne.get(i);
                }
            }
        }
        return count;
    }
}
