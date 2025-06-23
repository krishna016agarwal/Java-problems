public class FirstMissingPositive {

    public static int firstMissing(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 &&
                    nums[i] <= n &&
                    nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with its correct position
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Find first place where index + 1 != value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;

    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 9, 1, 7, 5, 6, 2, 8 };

        System.out.println(firstMissing(arr));
    }
}
