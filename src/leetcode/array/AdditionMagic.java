package leetcode.array;

import java.text.DecimalFormat;

public class AdditionMagic {


    public double add(double a, String b){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(a + Double.valueOf(b)));
    }

    public double add(double a, double b){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(a + b));
    }

    public double add(String a, String b){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(Double.valueOf(a) + b));
    }

    public static void main(String[] args) {
        AdditionMagic obj = new AdditionMagic();
        System.out.println(obj.add(12.344546, 13.13245));
        System.out.println(obj.add(1, "2.4"));
//        System.out.println(obj.add("Hi", "Boss"));
    }
}
