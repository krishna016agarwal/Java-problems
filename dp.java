import java.util.*;

public class dp {

    class Fibonacci { // O(n) time and O(n) space
        int fibonacci(int n) {
            int dp[] = new int[n + 1];
            Arrays.fill(dp, -1);

            return helper(n, dp);
        }

        int helper(int n, int[] dp) {
            if (n <= 1)
                return n;
            if (dp[n] != -1)
                return dp[n];
            return dp[n] = helper(n - 1, dp) + helper(n - 2, dp);

        }
    }

    int fibonacci(int n) { // O(n) time and O(1) space
        int a = 0, b = 1;
        if (n <= 1)
            return n;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    int climbStairs(int n) { // O(n) time and O(1) space
        int a = 0;
        int b = 1;
        if (n <= 1)
            return n;
        for (int i = 1; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    int maxJump_frog_jump_II(int[] stones) {
        int n = stones.length;
        int maxJump = 0;
        if (n == 2)
            return stones[1];
        for (int i = 2; i < n; i++) {
            maxJump = Math.max(maxJump, stones[i] - stones[i - 2]);
        }

        return maxJump;
    }

    class Maximum_Sum_of_Non_Adjacent_Elements { // O(n) SC-O(n)

        public int rob(int[] nums) {
            int arr[] = new int[nums.length];
            Arrays.fill(arr, -1);
            return helper(nums, nums.length - 1, arr);

        }

        public int helper(int[] nums, int i, int[] arr) {

            if (i == 0)
                return nums[i];
            if (i < 0)
                return 0;
            if (arr[i] != -1)
                return arr[i];
            int ls = nums[i] + helper(nums, i - 2, arr);
            int rs = 0 + helper(nums, i - 1, arr);
            return arr[i] = Math.max(ls, rs);

        }
    }

    public int Maximum_Sum_of_Non_Adjacent_Elements_optimal(int[] nums) { // O(n) SC-O(1)
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if (i > 1)
                take += prev2;
            int nottake = 0 + prev;
            int curr = Math.max(take, nottake);
            prev2 = prev;
            prev = curr;
        }
        return prev;

    }

    class House_Robber_2 {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1)
                return nums[0];

            return Math.max(
                    robLinear(nums, 0, n - 2), // exclude last
                    robLinear(nums, 1, n - 1) // exclude first
            );
        }

        private int robLinear(int[] nums, int start, int end) {
            int prev1 = 0;
            int prev2 = 0;

            for (int i = start; i <= end; i++) {
                int take = nums[i] + prev2;
                int notTake = prev1;

                int curr = Math.max(take, notTake);
                prev2 = prev1;
                prev1 = curr;
            }

            return prev1;
        }
    }

    public static void main(String[] args) {
        dp a = new dp();
        dp.Fibonacci b = a.new Fibonacci();
        // System.out.println(b.fibonacci(7));
        System.out.println(a.fibonacci(7));
    }
}
