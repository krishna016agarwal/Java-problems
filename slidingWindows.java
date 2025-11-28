import java.util.*;

public class slidingWindows {

    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        if (k == cardPoints.length) {
            for (int i : cardPoints) {
                sum += i;
            }
            return sum;
        }

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        int p = 0;
        for (int i = k - 1; i >= 0; i--) {
            sum -= cardPoints[i];
            sum += cardPoints[cardPoints.length - p - 1];
            p++;
            max = Math.max(max, sum);
        }
        return max;

    }

    class LengthOfLongestSubstring { // O(n^2)
        HashMap<Integer, Integer> k = new HashMap<>();

        public int hash(int a) {
            k.put(a, k.getOrDefault(a, 0) + 1);
            return k.get(a);
        }

        public int lengthOfLongestSubstring(String s) {
            int max = 0;

            for (int i = 0; i < s.length(); i++) {
                k.clear();
                int sum = 0;
                for (int j = i; j < s.length(); j++) {
                    int num = s.charAt(j) - '0';
                    if (hash(num) > 1)
                        break;
                    sum++;
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }

    public int lengthOfLongestSubstring_optimal(String s) { //O(n)
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If repeated character found
            if (map.containsKey(c)) {
                // Move left pointer to the right side of previous occurrence
                left = Math.max(left, map.get(c) + 1);
            }

            // Update last seen index of the character
            map.put(c, right);

            // Window size = right - left + 1
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        slidingWindows a = new slidingWindows();
        slidingWindows.LengthOfLongestSubstring b = a.new LengthOfLongestSubstring();
        System.out.println(b.lengthOfLongestSubstring("pwwkewlp1212"));

    }

}
