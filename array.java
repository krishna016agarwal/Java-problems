import java.sql.Time;
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

    public static int remove_duplicate_in_sorted_array(int arr[]) {
        // Deque<Integer> q = new LinkedList<>();
        // for (int i = 0; i < arr.length; i++) {

        // if (q.peek()!=null && q.peekLast() != arr[i]) {
        // q.add(arr[i]);
        // }else if(q.peek()==null){
        // q.add(arr[i]);
        // }

        // }
        // int size=q.size();
        // for (int i = 0; i < arr.length; i++) {
        // if (!q.isEmpty()) {
        // arr[i] = q.remove();
        // } else {
        // arr[i] = 0;
        // }

        // }
        // for (int i = 0; i < size; i++) {
        // System.out.print(arr[i]+" ");
        // }
        // return size;

        // ------------------------------------------

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

        // if (arr.length == 0 || arr.length == 1 || k == 0) {
        // return;
        // }
        // int n = arr.length;
        // k = k % n;

        // int j = 0;
        // for (int i = n - k; i <= (n - 1 + n - k) / 2; i++) {
        // int temp = arr[i];
        // arr[i] = arr[n - (++j)];
        // arr[n - (j)] = temp;
        // }

        // for (int i = 0; i <= (n - k - 1) / 2; i++) {
        // int temp = arr[i];
        // arr[i] = arr[n - k - 1 - i];
        // arr[n - k - 1 - i] = temp;
        // }

        // for (int i = 0; i < n / 2 ; i++) {
        // int temp = arr[i];
        // arr[i] = arr[n - i-1];
        // arr[n - i-1] = temp;
        // }

        // ----------------------------------------------------------
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

    public static int missingNumber_Optimal_Solution(int[] nums) {// O(n) SC-O(1)
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public static int missingNumber_Optimal_Solution_2(int[] nums) {// O(n) SC-O(1)
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

    public static int find_Number_appears_one_time_in_array(int[] nums) { // O(n) SC-O(1)
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i]; // 1^1^4^6^4= 0^4^6^4 = 4^6^4 = 4^4^6 = 0^6 = 6
        }
        return xor;
    }

    public static int largest_subarray_with_sum_k(int arr[], int k) {// O(n) SC-O(n) //for zeros,positive and negatives
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
        int max = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                max++;
            } else {
                max--;
            }
            if (max == 0 && i != nums.length - 1) {
                num = nums[i + 1];
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            return num;
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
        int profit = 0;
        for (int i = 1; i < nums.length; i++) {
            int selling = nums[i] - buy;
            profit = Math.max(profit, selling);
            buy = Math.min(buy, nums[i]);
        }

        return profit;
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
        if (num > 0) p.add(num);
        else n.add(num);
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

    public static void permutation(int arr[],int idx){
        if (idx==arr.length) {
            printArray(arr);
            System.out.println();
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            permutation(arr, idx+1);
            swap(arr, idx, i);
        }
    }
   
    public static int[] next_Permutation(int nums[]){
        int idx=-1;
        int n=nums.length;
        for (int i = n-2; i >=0; i--) {
            if (nums[i]<nums[i+1]) {
                idx=i;
                break;
            }
        }
        if (idx==-1) {
            reverseArray(nums, 0, n-1);
            return nums;
        }
        for (int i = n-1; i >idx; i--) {
            if (nums[i]>nums[idx]) {
                swap(nums, idx, i);
                break;
            }
        }
        reverseArray(nums, idx+1, n-1);
        return nums;
    }
    
    public static void leaders_in_array(int arr[]){

        Stack<Integer> s=new Stack<>();
  
        for (int i = arr.length-1; i>=0; i--) {
            if (i==arr.length-1) {
                      s.push(arr[i]);
            }
            else if(arr[i]>s.peek()){
                s.push(arr[i]);
            }

        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
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

        // int arr[] = { 1, -1, 5, -2, 3};
        // System.out.println(largest_subarray_with_sum_k(arr, 3));

        //  int arr[] = { 1,2,3,1,1,1,0,1,3,3};
        //  System.out.println(largest_subarray_with_sum_k_Optimal_Solution(arr, 6));
        

        // int arr[] = { 3,3};
        // int nums[]=two_sum(arr, 6);
        // printArray(nums);
        // System.out.println(two_sum_optimal_solution(arr, -8));

        // int arr[]={0,1,1,0,1,2,1,2,0,0,0};
        // sort_array_of_0_1_2(arr);
        // printArray(arr);

        // int arr[] = { 2, 2, 1, 1, 1, 2, 2, 1, 1 };
        // System.out.println(majorityElement(arr));
        // System.out.println(majorityElement_optimal_solution(arr));

        // int arr[] = { -2, -3, 1, 2, -1 };
        // System.out.println(maximum_sum_of_subarray(arr));

        // int arr[] = { 7, 1, 3, 5, 4, 6 };
        // System.out.println(Best_Time_to_Buy_and_Sell_Stock(arr));

        // int arr[] = { -1, 1 };
        // int nums[] = rearrange_Array_by_sign(arr);
        // printArray(nums);

        // int arr[]={1,2,-4,-5,3,6,-3,9};
        // rearrange_Array_by_sign_unequal_positive_and_negatives(arr);
        // printArray(arr);

        // int arr[]={1,1,5};
        //  permutation(arr, 0);

        // next_Permutation(arr);
        // printArray(arr);

        // int arr[]={10,22,12,0,3,6};
        // leaders_in_array(arr);

    }
}
