package string_programs;

public class CheckStringRotationOfAnotherString {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "edeba";
        CheckStringRotationOfAnotherString obj = new CheckStringRotationOfAnotherString();
        System.out.println(obj.checkIfStringRotationOfAnother(s1, s2));
    }

    public boolean checkIfStringRotationOfAnother(String s1, String s2){
        if(s1.length() == s2.length() && (s1 + s2).indexOf(s2) != -1){
            return true;
        } else {
            return false;
        }
    }
}
