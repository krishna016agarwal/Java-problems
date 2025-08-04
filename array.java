import java.util.*;

public class array {

    public static int secondLargest(int arr[]) {
        int lar = arr[0];
        int secLar = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lar) {
                secLar = lar;
                lar = arr[i];
            } else if (arr[i] > secLar && arr[i] < lar) {
                secLar = arr[i];
            }
        }
        return secLar;

    }

    public static int remove_duplicate_in_sorted_array(int arr[]) { // O(n)

        int j = 0;
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[j] != arr[i]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1;
    }

    public static void reverseArray(int arr[], int n, int m) { // O(n)
        while (n < m) {
            arr[n] = arr[n] + arr[m];
            arr[m] = arr[n] - arr[m];
            arr[n] = arr[n] - arr[m];
            n++;
            m--;
        }
    }

    public static void rotateArray(int arr[], int k) { // O(n)

        int n = arr.length;
        k = k % n;
        reverseArray(arr, n - k, n - 1);
        reverseArray(arr, 0, n - k - 1);
        reverseArray(arr, 0, n - 1);

    }

    public static void move_zeros_to_end(int arr[]) { // O(n)
        int i = 0;
        int temp;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void union_of_two_arrays(int arr1[], int arr2[]) { // O(n) SC- O(n)
        Deque<Integer> q = new LinkedList<>();
        int i = 0, j = 0;
        int a = 0;
        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] == arr2[j]) {
                a = arr1[i];
                i++;
                j++;
            } else if (arr1[i] != arr2[j]) {
                a = arr1[i] > arr2[j] ? arr2[j++] : arr1[i++];
            }
            if (q.peekLast() == null || q.peekLast() != a) {
                q.addLast(a);
            }
        }
        while (i < arr1.length) {
            if (q.peekLast() == null || q.peekLast() != arr1[i]) {
                q.addLast(arr1[i]);

            }
            i++;

        }
        while (j < arr2.length) {
            if (q.peekLast() == null || q.peekLast() != arr2[j]) {
                q.addLast(arr2[j]);
            }
            j++;

        }
        int union[] = new int[q.size()];
        i = 0;
        while (!q.isEmpty()) {
            union[i++] = q.removeFirst();

        }
        printArray(union);

    }

    public static void intersection_of_two_arrays(int arr1[], int arr2[]) { // O(n) SC- O(n)
        Deque<Integer> q = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                if (q.peekLast() == null || q.peekLast() != arr1[i]) {
                    q.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int union[] = new int[q.size()];
        i = 0;
        while (!q.isEmpty()) {
            union[i++] = q.removeFirst();

        }
        printArray(union);
    }

    public static int missingNumber(int[] nums) {// O(n) SC-O(n)
        HashMap<Integer, Boolean> q = new HashMap<>();
        int a = -1;
        for (int i = 0; i <= nums.length; i++) { // O(n)
            q.put(i, false); // O(1)
        }
        for (int i = 0; i < nums.length; i++) { // O(n)
            q.put(nums[i], true); // O(1)
        }
        for (int i = 0; i <= nums.length; i++) { // O(n)
            if (q.get(i) == false) { // O(1)
                a = i;
                break;
            }
        }
        return a;
    }

    public static int missingNumber_Optimal_Solution(int[] nums) {// O(n) SC-O(1) SUM METHOD
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public static int missingNumber_Optimal_Solution_2(int[] nums) {// O(n) SC-O(1) ZOR METHOD
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i; // xor=(0^1^2^3^4)^ (0^1^2^4) = 3
            xor ^= nums[i];
        }
        return xor ^ nums.length;

    }

    public static int findMaxConsecutiveOnes(int[] nums) {// O(n) SC-O(1)
        int a = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                a++;
                max = Math.max(max, a);
            } else {
                a = 0;
            }
        }
        return max;
    }

    public static int find_Number_appears_one_time_in_array(int[] nums) { // O(n) SC-O(1) ZOR METHOD
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i]; // 1^1^4^6^4= 0^4^6^4 = 4^6^4 = 4^4^6 = 0^6 = 6
        }
        return xor;
    }

    public static int largest_subarray_with_sum_k(int arr[], int k) {// O(n) SC-O(n) //PREFIX SUM //for zeros,positive
                                                                     // and negatives

        HashMap<Integer, Integer> s = new HashMap<>();
        int l = -1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (!s.containsKey(sum)) {
                s.put(sum, i); // store only first occurrence
            }
            if (sum == k) {
                l = Math.max(l, i + 1);
            }

            if (s.containsKey(sum - k)) {
                l = Math.max(l, i - s.get(sum - k));

            }
        }
        return l;

    }

    public static int largest_subarray_with_sum_k_Optimal_Solution(int arr[], int k) {// O(n) SC-O(1) //for positive and
                                                                                      // zeros
        int len = 0;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            sum += arr[j];

            if (sum > k) {
                sum -= arr[i];
                i++;
            }
            if (sum == k) {
                len = Math.max(len, j - i + 1);
            }
            j++;

        }
        return len;
    }

    public static int[] two_sum(int[] nums, int target) { // O(n) SC-O(n)
        HashMap<Integer, Integer> s = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (s.containsKey(sub)) {
                return new int[] { s.get(sub), i };

            }
            s.put(nums[i], i);
        }

        return new int[] {}; // if no solution is found

    }

    public static boolean two_sum_optimal_solution(int[] nums, int target) { // TC - O(nlogn) SC- O(logn)
        Arrays.sort(nums); // TC - O(nlogn) SC- O(logn)

        int i = 0, j = nums.length - 1;
        int l = 0, k = 0;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                l = i;
                k = j;
                return true;
            }
            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }

    public static void swap(int arr[], int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void sort_array_of_0_1_2(int arr[]) { // O(n) SC- O(n)
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {

                swap(arr, low, mid);

                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, high, mid);
                high--;
            }
        }

    }

    public static int majorityElement(int[] nums) { // Hashing //O(n) SC- O(n)
        HashMap<Integer, Integer> s = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!s.containsKey(nums[i])) {
                s.put(nums[i], 1);
            } else {
                s.put(nums[i], (s.get(nums[i])) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> q : s.entrySet()) {
            if (q.getValue() > nums.length / 2) {
                return q.getKey();
            }
        }
        return -1;

    }

    public static int majorityElement_optimal_solution(int[] nums) {// O(n) SC- O(1)
        int fre = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (fre == 0) {
                ans = nums[i];
            }
            if (nums[i] == ans) {
                fre++;
            } else {
                fre--;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return ans;
        }
        return -1;
    }

    public static int maximum_sum_of_subarray(int nums[]) { // O(n)
        int sum = nums[0];
        int helper = 0;

        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            helper += nums[i];

            sum = Math.max(sum, helper);

            if (helper < 0) {
                helper = 0;

            }

        }

        return sum;
    }

    public static int Best_Time_to_Buy_and_Sell_Stock(int nums[]) {
        int buy = nums[0];
        int maxprofit = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > buy) {
                maxprofit = Math.max(maxprofit, nums[i] - buy);
            }

            buy = Math.min(buy, nums[i]);
        }

        return maxprofit;
    }

    public static int[] rearrange_Array_by_sign(int[] nums) { // O(n) SC- O(n)
        int arr[] = new int[nums.length];
        int k = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (nums[i] > 0) {
                arr[2 * k] = nums[i];
                k++;
            } else {
                arr[2 * j + 1] = nums[i];
                j++;
            }
        }
        return arr;
    }

    public static int[] rearrange_Array_by_sign_unequal_positive_and_negatives(int[] nums) { // O(n) SC- O(n)
        Deque<Integer> p = new LinkedList<>();
        Deque<Integer> n = new LinkedList<>();

        for (int num : nums) {
            if (num > 0)
                p.add(num);
            else
                n.add(num);
        }

        int i = 0;

        // Alternate positives and negatives as long as both have elements
        while (!p.isEmpty() && !n.isEmpty()) {
            nums[i++] = p.removeFirst();
            nums[i++] = n.removeFirst();
        }

        // Add remaining elements from either deque
        while (!p.isEmpty()) {
            nums[i++] = p.removeFirst();
        }
        while (!n.isEmpty()) {
            nums[i++] = n.removeFirst();
        }

        return nums;
    }

    public static void permutation(int arr[], int idx) { // O(n*n!) //O(n)
        if (idx == arr.length) {
            printArray(arr);
            System.out.println();
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            permutation(arr, idx + 1);
            swap(arr, idx, i);
        }
    }

    public static int[] next_Permutation(int nums[]) {
        int idx = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverseArray(nums, 0, n - 1);
            return nums;
        }
        for (int i = n - 1; i > idx; i--) { // swap pivot point with the little greater element
            if (nums[i] > nums[idx]) {
                swap(nums, idx, i);
                break;
            }
        }
        reverseArray(nums, idx + 1, n - 1);
        return nums;
    }

    public static void leaders_in_array(int arr[]) {

        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                s.push(arr[i]);
            } else if (arr[i] > s.peek()) {
                s.push(arr[i]);
            }

        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void longest_consecutive_sequence(int arr[]) {// O(nlogn)
        if (arr.length == 0) {
            return;
        }
        Arrays.sort(arr); // O(nlogn)

        int lastsmallest = arr[0];
        int maxlength = 0;
        int length = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 == lastsmallest) {
                length++;
                lastsmallest = arr[i];
            } else if (arr[i] != lastsmallest) {
                length = 1;
                lastsmallest = arr[i];
            }
            maxlength = Math.max(maxlength, length);
        }
        System.out.println(maxlength);
    }

    public static int longest_consecutive_sequence_Optimize_Solution(int arr[]) { // O(n)
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return 1;
        int maxlength = 0;
        HashSet<Integer> s = new HashSet<>();
        for (int i : arr) {
            s.add(i); // O(n)
        }

        for (int i : s) {
            if (!s.contains(i - 1)) {
                int currEle = i;
                int length = 1;
                while (s.contains(currEle + 1)) {
                    length++;
                    currEle++;
                }
                maxlength = Math.max(maxlength, length);
            }
        }
        return maxlength;
    }

    public static void setZeroes(int[][] matrix) { // O(n*m) //SC- O(m+n)
        Set<Integer> r = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {

                    r.add(i);
                    c.add(j);
                }
            }
        }
        for (int i : r) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i : c) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }

        print_2d_array(matrix);

    }

    public static void setZeroes_optimal(int[][] matrix) {// O(n*m) //SC- O(1)
        int r = matrix.length;
        int c = matrix[0].length;
        boolean firstrow = false;
        boolean firstcol = false;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                firstcol = true;
                break;
            }

        }
        for (int i = 0; i < c; i++) {
            if (matrix[0][i] == 0) {
                firstrow = true;
                break;
            }
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < r; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < c; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < r; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (firstrow) {
            for (int i = 0; i < c; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstcol) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
        print_2d_array(matrix);

    }

    public static void subarray_sum_k_brute_case(int arr[], int k) { // O(n^2)
        int maxLength = 0;
        int totalSubarray = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int length = 0;
            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                length++;
                if (sum == k) {
                    totalSubarray++;
                    maxLength = Math.max(maxLength, length);
                }
            }

        }
        System.out.println("Toatal subarray who sum " + k + " is " + totalSubarray);
        System.out.println("longest subarray who sum " + k + " is " + maxLength);
    }

    public static void total_subarray_with_sum_k(int arr[], int k) { // O(n) SC- O(n)
        HashMap<Integer, Integer> s = new HashMap<>();

        int count = 0;

        int sum = 0;
        s.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (s.containsKey((sum - k))) {
                count += s.get(sum - k);
            }
            s.put(sum, s.getOrDefault(sum, 0) + 1);

        }

        System.out.println("Total subarray who sum " + k + " is " + count);

    }

    public static void print_2d_array(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void rotate_array_by_90_degree(int matrix[][]) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix[i], i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            reverseArray(matrix[i], 0, matrix[i].length - 1);
        }
        print_2d_array(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) { // O(m*n) SC- O(m*n)
        ArrayList<Integer> s = new ArrayList<>();
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) { // L -> R
                s.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) { // T -> B
                s.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) { // R -> L
                    s.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {// B -> T
                    s.add(matrix[i][left]);
                }
                left++;
            }

        }

        return s;
    }

    public static int nCr(int n, int r) { // O(r)
        int res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    static class pascalsTriangle {
        public static List<Integer> generateRow(int r) {
            List<Integer> s = new ArrayList<>();
            int res = 1;
            s.add(1);
            for (int i = 1; i < r; i++) {
                res = res * (r - i);
                res = res / (i);
                s.add(res);
            }
            return s;
        }

        public static List<List<Integer>> pascalsTriangle(int numRows) { // O(n*r)
            List<List<Integer>> c = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {

                c.add(generateRow(i));
            }
            return c;
        }

    }

    public static List<Integer> majorityElement_n_by_3(int[] nums) { // O(n)
        ArrayList<Integer> s = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i == ele1)
                count1++;
            else if (i == ele2)
                count2++;
            else if (count1 == 0) {
                ele1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                ele2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == ele1)
                count1++;
            if (i == ele2)
                count2++;
        }

        if (count1 > nums.length / 3)
            s.add(ele1);
        if (count2 > nums.length / 3)
            s.add(ele2);
        return s;

    }

    public static List<List<Integer>> three_sum(int nums[]) { // O(n^2) SC- O(n^2)
        List<List<Integer>> s = new ArrayList<>();
        HashMap<Integer, Integer> q = new HashMap<>();
        HashSet<List<Integer>> l = new HashSet<>(); // SC- O(n^2)

        for (int i = 0; i < nums.length; i++) { // O(n)
            q.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) { // o(n^2)
            for (int j = i + 1; j < nums.length; j++) {
                int thirdnum = -(nums[i] + nums[j]);
                if (q.containsKey(thirdnum) && q.get(thirdnum) != i && q.get(thirdnum) != j) { // O(1)

                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[j]);

                    a.add(thirdnum);

                    Collections.sort(a); // (nlogn)

                    l.add(a); // O(1)

                }
            }
        }
        for (List<Integer> i : l) {
            s.add(i);
        }
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        return s;
    }

    public static List<List<Integer>> three_sum_optimal_solution(int nums[]) { // O(nlogn + n^2) SC- O(n^2)
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[j]);
                    a.add(nums[k]);
                    l.add(a);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }

            }

        }
        if (l.isEmpty()) {
            return new ArrayList<>();
        }
        return l;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> p = new ArrayList<>();
        Arrays.sort(nums); // O(nlogn)
        if (nums.length < 4) {
            return p;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];

                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        ArrayList<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[k]);
                        a.add(nums[l]);
                        p.add(a);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }

        }

        return p;
    }

    public static int largest_subarray_with_sum_zero(int arr[]) { // O(n) SC - O(n)
        if (arr.length == 0) {
            return 0;
        } else if (arr.length == 1 && arr[0] != 0)
            return 0;
        HashMap<Integer, Integer> s = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (!s.containsKey(sum)) {
                s.put(sum, i);
            }

            if (arr[i] == 0) {
                length = 1;
            } else if (s.containsKey(sum)) {
                length = i - s.get(sum);

            }

            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static int Count_number_of_subarrays_with_given_xor_K(int arr[], int target) {
        int xor = 0;
        int count = 0;
        HashMap<Integer, Integer> s = new HashMap<>();
        s.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            int x = xor ^ target;

            s.put(xor, s.getOrDefault(s.get(xor), 0) + 1);
            if (s.containsKey(x)) {
                count+=s.get(x);
            }


        }
        return count;
    }

    public static void main(String[] args) {

        // int arr[] = { 1,1,2,2,2, 2, 7, 7 };
        // System.out.println(secondLargest(arr));

        // int arr[] = { 1, 1, 2, 2, 2, 2, 7, 7, 8, 8, 9, 10, 10 };
        // System.out.println(remove_duplicate_in_sorted_array(arr));

        // printArray(arr);

        // int arr[] = { 1,2,3,4 };
        // rotateArray(arr, 6);
        // // reverseArray(arr, 0, arr.length-1);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // int arr[] = { 0, 1, 0, 3, 12 };
        // move_zeros_to_end(arr);
        // printArray(arr);

        // int arr1[] = { 1, 1, 2, 3, 4, 5 };
        // int arr2[] = { 1, 1, 1, 2, 3, 4, 4, 5, 6, 7, 7 };
        // union_of_two_arrays(arr1, arr2);

        // int arr1[] = { 1, 2, 2, 3, 3, 4, 5, 6 };
        // int arr2[] = { 2, 3, 3, 5, 6, 6, 7 };
        // intersection_of_two_arrays(arr1, arr2);

        // int arr[]={0,1,2,4};
        // System.out.println(missingNumber(arr));
        // System.out.println(missingNumber_Optimal_Solution(arr));
        // System.out.println(missingNumber_Optimal_Solution_2(arr));

        // int arr[] = { 1, 0, 1, 1, 0, 1, 1, 1 };
        // System.out.println(findMaxConsecutiveOnes(arr));

        // int arr[] = { 1, 1, 4, 6, 7, 2, 6, 2, 7 };
        // System.out.println(find_Number_appears_one_time_in_array(arr));

        // int arr[] = { 3,3,1,0,-2,1,5};
        // System.out.println(largest_subarray_with_sum_k(arr, 3));

        // int arr[] = { 1,2,3,1,1,1,0,1,3,3};
        // System.out.println(largest_subarray_with_sum_k_Optimal_Solution(arr, 6));

        // int arr[] = { 3,3,8,1};
        // int nums[]=two_sum(arr, 4);
        // printArray(nums);
        // System.out.println(two_sum_optimal_solution(arr, 4));

        // int arr[]={0,1,1,0,1,2,1,2,0,0,0};
        // sort_array_of_0_1_2(arr);
        // printArray(arr);

        // int arr[] = { 2, 2, 1, 2,2,1, 1, 2, 2, 1,1 };
        // System.out.println(majorityElement(arr));
        // System.out.println(majorityElement_optimal_solution(arr));

        // int arr[] = { -2, -3, 1, 2, -1 };
        // System.out.println(maximum_sum_of_subarray(arr));

        // int arr[] = { 7, 2, 3, 5 };
        // System.out.println(Best_Time_to_Buy_and_Sell_Stock(arr));

        // int arr[] = { -1, 1 };
        // int nums[] = rearrange_Array_by_sign(arr);
        // printArray(nums);

        // int arr[]={1,2,-4,-5,3,6,-3,9};
        // rearrange_Array_by_sign_unequal_positive_and_negatives(arr);
        // printArray(arr);

        // int arr[]={1,2,3,4};
        // permutation(arr, 0);

        // next_Permutation(arr);
        // printArray(arr);

        // int arr[]={10,22,12,0,3,6};
        // leaders_in_array(arr);

        // int arr[]={100,4,200,1,3,2,101,1,103,5};
        // longest_consecutive_sequence(arr);
        // System.out.println(longest_consecutive_sequence_Optimize_Solution(arr));

        // int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        // setZeroes(matrix);
        // setZeroes_optimal(matrix);

        // int arr[] = { 1 };
        // subarray_sum_k_brute_case(arr, 0);
        // total_subarray_with_sum_k(arr, 0);

        // int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
        // 15, 16 } };
        // rotate_array_by_90_degree(arr);

        // int arr[][] = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } };
        // System.out.println(spiralOrder(arr));

        // System.out.println(pascalsTriangle.pascalsTriangle(5));

        // System.out.println(nCr(3, 1));

        // int arr[] = { 1, 1, 1, 3, 3, 2, 2, 2 };
        // List<Integer> s = majorityElement_n_by_3(arr);
        // System.out.println(s);

        // int arr[] = { -2,0,2,1,-1};
        // List<List<Integer>> a = three_sum(arr);
        // List<List<Integer>> a = three_sum_optimal_solution(arr);
        // System.out.println(a);

        // int arr[] = { 1000000000,1000000000,1000000000,1000000000};
        // List<List<Integer>> s = fourSum(arr, -294967296);
        // System.out.println(s);

        // int arr[]={15,-2,2,1,-8,7,10,23};
        // System.out.println(largest_subarray_with_sum_zero(arr));

        // int arr[]={4,2,2,6,4};
        // System.out.println(Count_number_of_subarrays_with_given_xor_K(arr, 6));
    }
}
