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

    public static String frequencySort(String s) {
        // Step 1: Count frequencies
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort characters by frequency using a list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue())); // descending by frequency

        // Step 3: Build output string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static boolean rotateString(String s, String goal) {
        // Step 1: Lengths must be equal
        if (s.length() != goal.length())
            return false;

        // Step 2: Concatenate string with itself
        String doubled = s + s;

        // Step 3: Check if goal exists inside doubled string
        return doubled.contains(goal);

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;

        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // s → t mapping
            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2)
                    return false;
            } else {
                mapST.put(c1, c2);
            }

            // t → s mapping (to ensure one-to-one)
            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1)
                    return false;
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }

    class GenerateParenthesis {

        public List<String> generateParenthesis(int n) {
            ArrayList<String> result = new ArrayList<>();
            generate(result, n, 0, 0, "");
            return result;
        }

        public void generate(ArrayList<String> result, int n, int open, int close, String s) {

            if (open == n && close == n) {
                result.add(s);
                return;
            }

            if (open < n) {
                generate(result, n, open + 1, close, s + "(");
            }

            if (close < open) {
                generate(result, n, open, close + 1, s + ")");
            }
        }
    }

    public static void main(String[] args) {
        // palindrome("abaa");
        // String s = "((()())(()()))";
        // System.out.print(removeOuterParentheses(s));
        // System.out.println(reverseWords(" hello world "));
        // System.out.println(largestOddNumber("52"));
        // System.out.println(frequencySort("etteuiii"));

        // System.out.println(isIsomorphic("egg", "add"));

    }
}
