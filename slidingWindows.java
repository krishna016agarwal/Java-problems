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

    class LengthOfLongestSubstring { //O(n^2)
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

    public static void main(String[] args) {
        slidingWindows a = new slidingWindows();
        slidingWindows.LengthOfLongestSubstring b = a.new LengthOfLongestSubstring();
        System.out.println(b.lengthOfLongestSubstring("pwwkewlp1212"));

    }

}
