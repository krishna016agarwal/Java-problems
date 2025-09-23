import java.util.*;

public class string {
    public static void palindrome(String a) {
        int s = a.length();
        for (int i = 0; i < s / 2; i++) {
            if (a.charAt(i) != a.charAt(s - i - 1)) {
                System.out.println("not palindrome");
                return;
            }

        }
        System.out.println("palindrome");
    }

    public static String removeOuterParentheses(String s) {
        int count = 0;
        String p = "";
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char j = s.charAt(i);
            if (j == '(') {
                if (count != 0) {
                    p += j;
                }
                count++;

            } else {
                if (count != 1) {
                    p += j;
                }
                count--;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        // palindrome("abaa");
        String s = "((()())(()()))";
        System.out.print(removeOuterParentheses(s));

    }
}
