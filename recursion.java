import java.util.*;

public class recursion {

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;

        double half = myPow(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else if (n > 0)
            return half * half * x;
        else
            return half * half / x;
    }

    class Sort_Stack {

        public static Stack<Integer> sort(Stack<Integer> st, int a) {
            if (st.isEmpty() || a > st.peek()) {
                st.push(a);
                return st;
            }
            int b = st.pop();
            sort(st, a);
            st.push(b);
            return st;

        }

        public static void sortStack(Stack<Integer> st) {

            if (st.isEmpty())
                return;

            int a = st.pop();
            sortStack(st);
            sort(st, a);

        }
    }

    class Reverse_Stack {

        public static Stack<Integer> reverse(Stack<Integer> st, int a) {
            if (st.isEmpty()) {
                st.push(a);
                return st;
            }
            int b = st.pop();
            reverse(st, a);
            st.push(b);
            return st;

        }

        public static void reverseStack(Stack<Integer> st) {

            if (st.isEmpty())
                return;

            int a = st.pop();
            reverseStack(st);
            reverse(st, a);

        }
    }

    class PowerSet { // O(n × 2ⁿ) SC- O(n × 2ⁿ)
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            generateSubsets(nums, 0, new ArrayList<>(), result);
            return result;
        }

        private static void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
            // Base case: reached end of array
            if (index == nums.length) {
                result.add(new ArrayList<>(current)); // add copy of current subset
                return;
            }

            // 1️⃣ Include current element
            current.add(nums[index]);
            generateSubsets(nums, index + 1, current, result);

            // 2️⃣ Exclude current element
            current.remove(current.size() - 1);
            generateSubsets(nums, index + 1, current, result);
        }
    }

    class Min_Max_Subsequences {
        static final int MOD = 1000000007;

        void power(int arr[], int n) {
            arr[0] = 1;
            for (int i = 1; i < n; i++) {
                arr[i] = (int) ((arr[i - 1] * 2L) % MOD);
            }
        }

        public int numSubseq(int[] nums, int target) {
            int len = nums.length;
            int[] arr = new int[len];
            power(arr, len);
            Arrays.sort(nums);

            int l = 0, r = len - 1;
            int subsequences = 0;

            while (l <= r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    subsequences = (subsequences + arr[r - l]) % MOD;
                    l++;
                }
            }

            return subsequences;
        }
    }

    class countGoodNumbers { // O(logn)

        static long MOD = 1000000007;

        public long power(long a, long b) {
            long ref = 1;
            while (b > 0) {
                if (b % 2 != 0) {
                    ref = (ref * a) % MOD;

                }
                a = (a * a) % MOD;
                b /= 2;

            }
            return ref;
        }

        public int countGood(long n) {

            return (int) ((power(4, n / 2) * power(5, n - n / 2)) % MOD);
        }

    }

    public static int power(int a, int b) { // O(logn)
        int ref = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                ref = ref * a;

            }
            a = (a * a);
            b /= 2;

        }
        return ref;
    }

    class CheckSubsequenceSum {
        public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
            return helper(0, 0, arr, K);
        }

        private static boolean helper(int i, int sum, int[] arr, int target) {
            // Base Case: reached end of array
            if (i == arr.length) {
                return sum == target;
            }

            // Choose current element
            if (helper(i + 1, sum + arr[i], arr, target))
                return true;

            // Skip current element
            if (helper(i + 1, sum, arr, target))
                return true;

            return false;
        }
    }

    class CombinationSum { // O(2^(T/min(arr))) SC - O(T/min(arr))
        static List<List<Integer>> a;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            a = new ArrayList<>();
            add(0, 0, candidates, target, new ArrayList<>());
            return a;
        }

        public void add(int i, int s, int[] arr, int target, List<Integer> l) {
            if (s == target) {
                a.add(new ArrayList<>(l));
                return;
            }

            if (i >= arr.length || s > target)
                return;

            // Include current element (can be reused)
            l.add(arr[i]);
            add(i, s + arr[i], arr, target, l);
            l.remove(l.size() - 1); // backtrack

            // Exclude current element and move forward
            add(i + 1, s, arr, target, l);
        }
    }

    class CombinationSum2 { // O(2^N×N) SC- O(2^N×N)

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> l = new ArrayList<>();

            Arrays.sort(candidates);
            sum(candidates, target, new ArrayList<>(), 0, l);
            return l;
        }

        public void sum(int[] arr, int target, List<Integer> a, int i, List<List<Integer>> l) {
            if (target == 0) {
                l.add(new ArrayList<>(a));
                return;
            }

            for (int j = i; j < arr.length; j++) {
                if (j > i && arr[j] == arr[j - 1])
                    continue; // skip duplicates
                if (arr[j] > target)
                    break;

                a.add(arr[j]);
                sum(arr, target - arr[j], a, j + 1, l);
                a.remove(a.size() - 1);
            }
        }

    }

    class SubsetSum {
        public ArrayList<Integer> subsetSums(int[] arr) {

            ArrayList<Integer> a = new ArrayList<>();

            sum(0, arr, a, 0);
            return a;
        }

        public void sum(int i, int arr[], List<Integer> a, int s) {
            if (i == arr.length) {
                a.add(s);
                return;
            }

            sum(i + 1, arr, a, s + arr[i]);
            sum(i + 1, arr, a, s);
        }
    }

    class Subset_without_duplicate { // O(n^2 * 2^n)
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Set<List<Integer>> a = new HashSet<>();
            Arrays.sort(nums);
            subset(0, nums, a, new ArrayList<>());
            return new ArrayList<>(a);
        }

        public void subset(int i, int arr[], Set<List<Integer>> a, List<Integer> s) {
            if (i == arr.length) {

                a.add(new ArrayList<>(s));
                return;
            }
            s.add(arr[i]);
            subset(i + 1, arr, a, s);
            s.remove(s.size() - 1);
            subset(i + 1, arr, a, s);
        }
    }

    class Subset_without_duplicate_optimal { // O(n * 2^n) SC- o(2^n)
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> a = new ArrayList<>();
            Arrays.sort(nums);
            subset(0, nums, a, new ArrayList<>());
            return a;
        }

        public void subset(int i, int arr[], List<List<Integer>> a, List<Integer> s) {

            a.add(new ArrayList<>(s));
            for (int j = i; j < arr.length; j++) {
                if (j != i && arr[j] == arr[j - 1])
                    continue;
                s.add(arr[j]);
                subset(j + 1, arr, a, s);
                s.remove(s.size() - 1);

            }
        }
    }

    class CombinationSum_III {
        public static List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> l = new ArrayList<>();
            int arr[] = new int[9];
            for (int i = 1; i < 10; i++) {
                arr[i - 1] = i;
            }
            sum(0, k, arr, n, new ArrayList<Integer>(), 0, l);
            return l;
        }

        public static void sum(int i, int k, int arr[], int n, ArrayList<Integer> a, int s, List<List<Integer>> l) {
            if (a.size() == k && s == n) {
                l.add(new ArrayList<>(a));
                return;
            }
            if (i == arr.length || a.size() > k || s > n)
                return;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] > n)
                    return;
                a.add(arr[j]);
                s += arr[j];
                sum(j + 1, k, arr, n, a, s, l);
                a.remove(a.size() - 1);
                s -= arr[j];
            }
        }
    }

    class CombinationSum_III_optimal {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            findCombination(k, 1, n, new ArrayList<>(), result);
            return result;
        }

        public static void findCombination(int k, int num, int target, ArrayList<Integer> lst,
                List<List<Integer>> result) {
            if (k == 0 && target == 0) {
                result.add(new ArrayList<>(lst));
                return;
            }
            for (int i = num; i < 10; i++) {
                if (i > target || k <= 0)
                    break;
                lst.add(i);
                findCombination(k - 1, i + 1, target - i, lst, result);
                lst.remove(lst.size() - 1);
            }
        }
    }

    class LetterCombinations { //O(4^n * n) SC- O(n)
        public static List<String> letterCombinations(String digits) {
            String arr[] = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
          
            List<String> s = new ArrayList<>();
            print(digits, s, new StringBuilder(""), arr, 0);
            return s;

        }

        public static void print(String d, List<String> s, StringBuilder a, String arr[], int i) {
            if (i >= d.length()) {
                s.add(new String(a));
                return;
            }
            for (int j = 0; j < arr[d.charAt(i) - '2'].length(); j++) {
                a.append(arr[d.charAt(i) - '2'].charAt(j));
                print(d, s, a, arr, i + 1);
                a.deleteCharAt(a.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        // System.out.println(myPow(2, 3));

        // int arr[]={1,2,3};
        // System.out.println(recursion.PowerSet.subsets(arr));

        // System.out.println(power(2, 5));

        // int arr[] = { 5, 1, 2, 7, 6, 1, 5 };
        // System.out.println(recursion.Solution.checkSubsequenceSum(7, arr, 8));

        // System.out.println(recursion.Solution.combinationSum3(3, 9));
        // System.out.println(recursion.LetterCombinations.letterCombinations("23"));

    }
}
