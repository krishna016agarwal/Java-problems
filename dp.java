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

    public static void main(String[] args) {
        dp a = new dp();
        dp.Fibonacci b = a.new Fibonacci();
        // System.out.println(b.fibonacci(7));
        System.out.println(a.fibonacci(7));
    }
}
