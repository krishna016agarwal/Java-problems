import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    class CombinationSum2 {

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

    public static void main(String[] args) {

        // System.out.println(myPow(2, 3));

        // int arr[]={1,2,3};
        // System.out.println(recursion.PowerSet.subsets(arr));

        // System.out.println(power(2, 5));

        // int arr[] = { 5, 1, 2, 7, 6, 1, 5 };
        // System.out.println(recursion.Solution.checkSubsequenceSum(7, arr, 8));

    }
}
