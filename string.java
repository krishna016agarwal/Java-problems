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

    public static String reverseWords(String s) {
        // Trim the string and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        // Traverse from the end
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0)
                sb.append(" "); // add space between words
        }

        return sb.toString();
    }

    public static String largestOddNumber(String num) {
        // Start from the end of the string
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the digit is odd
            if ((num.charAt(i) - '0') % 2 != 0) {
                // Return substring from start to this index (inclusive)
                return num.substring(0, i + 1);
            }
        }
        // No odd digit found
        return "";
    }

    public static void main(String[] args) {
        // palindrome("abaa");
        // String s = "((()())(()()))";
        // System.out.print(removeOuterParentheses(s));
        // System.out.println(reverseWords(" hello world "));
        // System.out.println(largestOddNumber("52"));

    }
}
