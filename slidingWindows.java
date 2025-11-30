import java.util.*;

public class slidingWindows {

    public int[] maxSlidingWindow(int[] nums, int k) { // O(n) SC- O(n)

        if (k == 1)
            return nums;
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!s.isEmpty() && nums[s.peekLast()] <= nums[i]) {
                s.removeLast();
            }
            s.addLast(i);
        }
        int arr[] = new int[nums.length - k + 1];
        int j = 0;
        arr[j] = nums[s.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            if (!s.isEmpty() && s.peekFirst() <= i - k) {
                s.removeFirst();
            }
            while (!s.isEmpty() && nums[s.peekLast()] <= nums[i]) {
                s.removeLast();
            }
            s.addLast(i);
            arr[++j] = nums[s.peekFirst()];
        }
        return arr;
    }

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

    public int lengthOfLongestSubstring_optimal(String s) { // O(n)
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

    public int longestOnes(int[] nums, int k) { // O(2n)
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zeroCount++;

            while (zeroCount > k) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public int longestOnes_optimal(int[] nums, int k) { // O(n)
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zeroCount++;

            if (zeroCount > k) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public int totalFruit(int[] fruits) { // O(n) SC-O(n)
        HashMap<Integer, Integer> s = new HashMap<>();
        int max = 0;
        int l = 0;
        for (int r = 0; r < fruits.length; r++) {
            s.put(fruits[r], s.getOrDefault(fruits[r], 0) + 1);

            if (s.size() > 2) {
                s.replace(fruits[l], s.get(fruits[l]) - 1);
                if (s.get(fruits[l]) == 0)
                    s.remove(fruits[l]);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public int Longest_Substring_with_At_Most_K_Distinct_Characters(String s, int k) { // O(n) SC-O(n)

        HashMap<Integer, Integer> p = new HashMap<>();
        int l = 0;
        int max = -1;
        for (int r = 0; r < s.length(); r++) {
            int num = s.charAt(r) - '0';
            int q = s.charAt(l) - '0';
            p.put(num, p.getOrDefault(num, 0) + 1);
            if (p.size() > k) {
                p.replace(q, p.get(q) - 1);
                if (p.get(q) == 0)
                    p.remove(q);
                l++;
            }
            if (p.size() == k) {
                max = Math.max(max, r - l + 1);
            }

        }
        return max;
    }

    public int Number_of_substring_containing_all_three_characters(String s) { // O(2n) SC-O(n)
        HashMap<Integer, Integer> a = new HashMap<>();
        int count = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int num = s.charAt(r) - '0';
            a.put(num, a.getOrDefault(num, 0) + 1);
            while (a.size() == 3) {
                count += s.length() - r;
                a.replace(s.charAt(l) - '0', a.get(s.charAt(l) - '0') - 1);
                if (a.get(s.charAt(l) - '0') == 0)
                    a.remove(s.charAt(l) - '0');
                l++;

            }

        }
        return count;
    }

    public int Number_of_substring_containing_all_three_characters_optimal(String s) { // O(n) SC-O(1)
        int a = -1;
        int b = -1;
        int c = -1;
        int count = 0;

        for (int r = 0; r < s.length(); r++) {

            char q = s.charAt(r);
            if (q == 'a')
                a = r;
            else if (q == 'b')
                b = r;
            else if (q == 'c')
                c = r;
            if (a != -1 && b != -1 && c != -1) {
                count += Math.min(a, Math.min(b, c)) + 1;

            }

        }
        return count;
    }

    public int longest_repeating_character_replacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // shrink window if replacements needed > k
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    class Binary_subarray_with_sum { // O(n) //SC-O(1)

        public int numSubarraysWithSum(int[] nums, int goal) {
            return helper(nums, goal) - helper(nums, goal - 1);
        }

        public int helper(int num[], int goal) {
            if (goal < 0)
                return 0;
            int l = 0;
            int c = 0;
            int s = 0;
            for (int r = 0; r < num.length; r++) {
                s += num[r];
                while (s > goal) {
                    s -= num[l];
                    l++;
                }
                c += r - l + 1;
            }
            return c;
        }
    }

    class Count_number_of_nice_subarrays {
        public int numberOfSubarrays(int[] nums, int k) {

            return helper(nums, k) - helper(nums, k - 1);
        }

        public int helper(int num[], int goal) {
            if (goal < 0)
                return 0;
            int l = 0;
            int c = 0;
            int s = 0;
            for (int r = 0; r < num.length; r++) {
                s += num[r] % 2;
                while (s > goal) {
                    s -= num[l] % 2;
                    l++;
                }
                c += r - l + 1;
            }
            return c;
        }
    }

    class Subarrays_with_K_Different_Integers {

          public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int nums[],int k){
        if(k<0) return 0;
        HashMap<Integer,Integer> a=new HashMap<>();
        int l=0;
        int c=0;
    
        for(int r=0;r<nums.length;r++){
            a.put(nums[r],a.getOrDefault(nums[r],0)+1);
            while(a.size()>k){
                a.replace(nums[l],a.get(nums[l])-1);
                if(a.get(nums[l])==0) a.remove(nums[l]);
                l++;
            }
            c+=r-l+1;
        }
        return c;
    }
    }

    public static void main(String[] args) {
        slidingWindows a = new slidingWindows();
        // slidingWindows.LengthOfLongestSubstring b = a.new LengthOfLongestSubstring();
        // System.out.println(b.lengthOfLongestSubstring("pwwkewlp1212"));
        // System.out.println(a.longestOnes(new int[]{1,0,1,0,1,1,1,0,0,0}, 2));
        // System.out.println(a.totalFruit(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4
        // }));
        // System.out.println(a.Longest_Substring_with_At_Most_K_Distinct_Characters("aaabbccd",
        // 2));

        slidingWindows.Subarrays_with_K_Different_Integers c = a.new Subarrays_with_K_Different_Integers();
        System.out.println(c.subarraysWithKDistinct(new int[] { 1, 2, 1, 3, 4 }, 3));
    }

}
