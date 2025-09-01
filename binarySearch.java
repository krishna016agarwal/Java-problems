import java.util.*;

public class binarySearch {

    public static int square_root(int n) { // O(logn)
        int si = 1;
        int ei = n;
        int ans = 0;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (mid * mid <= n) {
                ans = mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return ans;
    }

    public static int searchInsert(int[] nums, int target) { // O(logn)
        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - ei) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                ei = mid - 1;

            } else {
                si = mid + 1;

            }

        }
        return si;

    }

    public static int findFloor(int[] arr, int x) { // O(logn)
        int ans = -1;
        int si = 0;
        int ei = arr.length - 1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return ans;
    }

    public static int[] search_first_and_last_index_of_element(int[] nums, int target) { // O(logn)
        int si = 0;
        int ei = nums.length - 1;
        int arr[] = { -1, -1 };
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (nums[mid] == target) {
                arr[0] = mid;
                ei = mid - 1;
            } else if (nums[mid] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        si = 0;
        ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (nums[mid] == target) {
                arr[1] = mid;
                si = mid + 1;
            } else if (nums[mid] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return arr;
    }

    public static int countFreq_in_sorted_array(int[] arr, int target) { // O(logn)
        int si = 0;
        int ei = arr.length - 1;
        int firstindex = -1;
        int lastindex = -1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == target) {
                firstindex = mid;
                ei = mid - 1;
            } else if (arr[mid] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        si = 0;
        ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == target) {
                lastindex = mid;
                si = mid + 1;
            } else if (arr[mid] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        if (lastindex == -1 && firstindex == -1) {
            return 0;
        }
        return lastindex - firstindex + 1;

    }

    public static int search_in_rotated_array(int[] nums, int target) { // O(logn)
        int si = 0;
        int ei = nums.length - 1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[si] <= nums[mid]) {
                if (nums[si] <= target && target <= nums[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[ei]) {
                    si = mid + 1;
                } else {

                    ei = mid - 1;
                }
            }
        }
        return -1;
    }

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> s = new Stack<>(); // stores indices

        // Process each day
        for (int i = 0; i < arr.length; i++) {
            // Pop elements smaller or equal to current price
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // If stack empty, span is i+1 (all previous are smaller)
            if (s.isEmpty()) {
                span.add(i + 1);
            } else {
                // Span is distance from nearest greater element to left
                span.add(i - s.peek());
            }

            // Push current day index
            s.push(i);
        }
        return span;
    }

    public static boolean search_in_rotated_array_with_dulpicates(int[] nums, int target) { // O(logn)
        int si = 0, ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == target)
                return true;

            // Skip duplicates
            if (nums[si] == nums[mid] && nums[mid] == nums[ei]) {
                si++;
                ei--;
                continue;
            }

            // Left half is sorted
            if (nums[si] <= nums[mid]) {
                if (nums[si] <= target && target < nums[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
        }
        return false;
    }

    public static int find_minimum_in_rotated_sorted_array(int[] nums) { // O(logn)
        int si = 0;
        int ei = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[si] <= nums[ei]) {
                ans = Math.min(nums[si], ans);
                break;
            } else if (nums[si] <= nums[mid]) {
                ans = Math.min(nums[si], ans);
                si = mid + 1;
            } else {
                ans = Math.min(nums[mid], ans);
                ei = mid - 1;
            }

        }
        return ans;
    }

    public static int findKRotation(int nums[]) { // O(logn)
        int si = 0;
        int ei = nums.length - 1;
        int index = -1;
        int ans = Integer.MAX_VALUE;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[si] <= nums[ei]) {
                if (nums[si] < ans) {
                    ans = nums[si];
                    index = si;
                }
                break;
            } else if (nums[si] <= nums[mid]) {
                if (nums[si] < ans) {
                    ans = nums[si];
                    index = si;
                }
                si = mid + 1;
            } else {
                if (nums[mid] < ans) {
                    ans = nums[mid];
                    index = mid;
                }
                ei = mid - 1;
            }

        }
        return index;
    }

    public static int singleNonDuplicate_in_sorted_array(int[] nums) { // O(logn)
        if (nums.length == 1)
            return nums[0];
        int si = 0;
        int ei = nums.length - 1;
        int n = nums.length;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (mid == 0 && nums[0] != nums[1])
                return nums[mid];
            if (mid == n - 1 && nums[n - 1] != nums[n - 2])
                return nums[n - 1];
            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1])
                return nums[mid];
            if (mid % 2 == 0) {
                if (nums[mid - 1] == nums[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else {
                if (nums[mid - 1] == nums[mid]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int findPeakElement(int[] nums) { // O(logn)
        int si = 1;
        int ei = nums.length - 2;
        if (nums.length == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;
        else if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] >= nums[mid + 1] && nums[mid] >= nums[mid - 1])
                return mid;
            else if (nums[mid] >= nums[mid - 1] && nums[mid] <= nums[mid + 1])
                si = mid + 1;
            else
                ei = mid - 1;
        }
        return -1;
    }

    public static int nthRoot(int n, int m) { // O(logn)

        int si = 1;
        int ei = m;
        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (Math.pow(mid, n) == m) {
                return mid;
            } else if (Math.pow(mid, n) > m)
                ei = mid - 1;
            else {
                si = mid + 1;
            }
        }
        return -1;
    }

    public static int minEatingSpeed_koko_monkey(int[] piles, int h) { // O(nlogm)
        int si = 1;
        int ei = -1;
        for (int i : piles) {
            ei = Math.max(ei, i);
        }
        int ans = Integer.MAX_VALUE;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            int ans2 = 0;
            for (int i : piles) {
                ans2 += Math.ceil((double) i / mid);

            }

            if (ans2 > h) {
                si = mid + 1;
            } else if (ans2 <= h) {
                ei = mid - 1;
                ans = Math.min(ans, mid);

            }
        }
        return ans;
    }

    public static int minDays_to_make_flower_bloom(int[] bloomDay, int m, int k) { // O(nlog(Max−Min))
        if ((long) m * k > bloomDay.length)
            return -1;
        int ans = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        while (min <= max) {
            int bouque = m;
            int adjacent = k;
            int mid = min + (max - min) / 2;
            for (int j : bloomDay) {
                if (j <= mid) {
                    adjacent--;
                } else {
                    adjacent = k;
                }
                if (adjacent == 0) {
                    bouque--;
                    adjacent = k;
                }
                if (bouque == 0)
                    break;
            }

            if (bouque == 0) {
                max = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                min = mid + 1;
            }

        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }

    }

    public static int smallestDivisor(int[] nums, int threshold) { // O(nlog(max))
        int si = 1;
        int ei = Integer.MIN_VALUE;
        for (int i : nums) {

            ei = Math.max(ei, i);
        }
        int ans2 = 0;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            int ans = 0;
            for (int i : nums) {
                ans += Math.ceil((double) i / mid);
            }
            if (ans <= threshold) {
                ans2 = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return ans2;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int si = 0;
        int ei = 0;
        int finalans = 0;
        for (int i : weights) {
            si = Math.max(si, i);
            ei += i;
        }

        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            int daysneeded = 1;
            int currentLoad = 0;

            for (int i : weights) {
                if (currentLoad + i > mid) {
                    daysneeded++;
                    currentLoad = 0;

                }

                currentLoad += i;

            }

            if (daysneeded <= days) {
                finalans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return finalans;
    }

    public static int findKthPositive(int[] arr, int k) { // O(n)

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k)
                k++;

            else
                break;
        }
        return k;
    }

    public static int findKthPositive_optimal(int arr[], int k) { // O(logn)

        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] - mid - 1 < k) {
                si = mid + 1;
            } else {

                ei = mid - 1;
            }

        }

        return si + k;
    }

    class AggressiveCows {

        public static boolean isPossible(int[] stalls, int mid, int k) { // O(n)
            int cows = 1;
            int lastcowpostion = 0;
            for (int i = 1; i < stalls.length; i++) {
                if (stalls[i] - stalls[lastcowpostion] >= mid) {
                    cows++;
                    lastcowpostion = i;
                }
            }
            if (cows >= k) {
                return true;
            }
            return false;
        }

        public static int aggressiveCows(int[] stalls, int k) {
            Arrays.sort(stalls); // O(nlogn)
            int si = 1;
            int ei = stalls[stalls.length - 1] - stalls[0];
            int ans = 0;
            while (si <= ei) { // O(log(Range) * N)
                int mid = si + (ei - si) / 2;
                if (isPossible(stalls, mid, k)) {
                    si = mid + 1;
                    ans = mid;
                } else {
                    ei = mid - 1;
                }
            }
            return ans;

        }
    }

    class BookAllocation { // O(n*log(sum(nums)))
        public static boolean isvalid(int[] arr, int mid, int k) {
            int student = 1;
            int pages = 0;
            for (int i : arr) { // O(n)
                if (i > mid)
                    return false;
                if (pages + i > mid) {
                    student++;
                    pages = i;
                    if (student > k)
                        return false;

                } else {
                    pages += i;
                }
            }
            return true;

        }

        public static int findPages(int[] arr, int k) {
            if (arr.length < k)
                return -1;
            int si = 0;
            int ei = 0;
            for (int i : arr) { // O(n)
                ei += i;
            }
            int ans = 0;
            while (si <= ei) { // O(logn * n )
                int mid = si + (ei - si) / 2;
                if (isvalid(arr, mid, k)) { // O(n)
                    ei = mid - 1;
                    ans = mid;
                } else {
                    si = mid + 1;
                }
            }
            return ans;
        }
    }

    class PainterPartition { // O(n*log(sum(nums)))

        public static boolean isValid(int[] arr, int mid, int k) {
            int painter = 1;
            int length = 0;
            for (int i : arr) {
                if (i > mid)
                    return false;
                if (length + i > mid) {
                    painter++;
                    length = i;
                } else {
                    length += i;
                }
                if (painter > k)
                    return false;

            }
            return true;
        }

        public static int minTime(int[] arr, int k) {
            int si = 0;
            int ei = 0;
            for (int i : arr) {
                ei += i;
            }
            int ans = 0;
            while (si <= ei) {
                int mid = si + (ei - si) / 2;
                if (isValid(arr, mid, k)) {
                    ans = mid;
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            return ans;

        }
    }

    class SplitArrayLargestSum { // O(n*log(sum(nums)))
        public static boolean isValid(int[] arr, int mid, int k) {
            int split = 1;
            int sum = 0;
            for (int i : arr) {
                if (i > mid)
                    return false;
                if (sum + i > mid) {
                    split++;
                    sum = i;
                } else {
                    sum += i;
                }
                if (split > k)
                    return false;
            }
            return true;
        }

        public static int splitArray(int[] nums, int k) {

            int si = 0;
            int ei = 0;
            for (int i : nums) {
                ei += i;
            }
            int ans = 0;
            while (si <= ei) {
                int mid = si + (ei - si) / 2;
                if (isValid(nums, mid, k)) {
                    ei = mid - 1;
                    ans = mid;
                } else {
                    si = mid + 1;
                }
            }
            return ans;
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) { // O(Log(Min(N1,N2)))
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int n = n1 + n2;
        int left = (n + 1) / 2;

        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 0) {
                    return (double) ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    public static int kthElement(int a[], int b[], int k) { // O(Log(Min(N1,N2)))
        int n1 = a.length, n2 = b.length;

        // Ensure first array is smaller
        if (n1 > n2)
            return kthElement(b, a, k);

        int low = Math.max(0, k - n2), high = Math.min(k, n1);

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b[mid2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2); // kth element
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return -1; // should never reach here
    }

    public static int rowWithMax1s(int mat[][]) { // O(m*log(n))

        int ans = 0;
        int ind = 0;
        for (int i = 0; i < mat.length; i++) {
            int si = 0;
            int ei = mat[0].length - 1;
            while (si <= ei) {
                int mid = si + (ei - si) / 2;
                if (mat[i][mid] == 1) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            if (ans < mat[0].length - si) {
                if (ans == mat[0].length - si) {
                    continue;
                } else {
                    ans = mat[0].length - si;

                    ind = i;
                }

            }

        }
        return ind;
    }

    public static boolean searchMatrix(int[][] matrix, int target) { // O(logn+logm)
        int si = 0;
        int ei = matrix.length - 1;

        // Binary search to find the row
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] < target) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        // Row index is ei (largest row whose first element <= target)
        int row = ei;
        if (row < 0)
            return false; // target is smaller than all first elements

        // Binary search inside the row
        int si2 = 0;
        int ei2 = matrix[row].length - 1;
        while (si2 <= ei2) {
            int mid2 = si2 + (ei2 - si2) / 2;
            if (matrix[row][mid2] == target)
                return true;
            else if (matrix[row][mid2] < target) {
                si2 = mid2 + 1;
            } else {
                ei2 = mid2 - 1;
            }
        }
        return false;
    }

     public boolean searchMatrix_optimal(int[][] matrix, int target) {  //O(log(n*m))
        int si=0;
        int ei=matrix.length*matrix[0].length-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            int row=mid/matrix[0].length;
            int col=mid%matrix[0].length;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        
        
        return false;
    }
    
    public static void main(String args[]) {

        // int arr[]={1,2,3,4,5,6};
        // System.out.println(searchInsert(arr, 7));

        // int arr[]={1,2,4,4,5,8,9};
        // System.out.println(findFloor(arr, 7));

        // int arr[]={2,5,5,6,8,8,9};
        // int nums[]=search_first_and_last_index_of_element(arr, 8);
        // printArray(nums);

        // int arr[] = { 1, 1, 2, 2, 2, 2, 3 };
        // System.out.println(countFreq_in_sorted_array(arr, 2));

        // int arr[] = { 6, 7, 1, 2, 3, 4, 5 };
        // System.out.println(search_in_rotated_array(arr, 2));

        // int arr[]={3,3,1,2,3,3,3};
        // System.out.println(search_in_rotated_array_with_dulpicates(arr, 1));

        // int arr[]={4,5,6,1,2,3};
        // System.out.println(find_minimum_in_rotated_sorted_array(arr));

        // int arr[]={5,6,1,2,3,4};
        // System.out.println(findKRotation(arr));

        // int arr[] = { 1, 2, 2, 3, 3, 4, 4, 7, 7 };
        // System.out.println(singleNonDuplicate_in_sorted_array(arr));

        // int arr[]={1,2,3,4,6,3,2,1};
        // System.out.println(findPeakElement(arr));

        // System.out.println(square_root(16));

        // System.out.println(nthRoot(4, 625));

        // int arr[] = { 30, 11, 23, 4, 20 };
        // System.out.println(minEatingSpeed_koko_monkey(arr, 5));

        // int arr[]={1,10,3,10,2};
        // System.out.println(minDays_to_make_flower_bloom(arr, 3, 1));

        // int arr[] = { 44, 22, 33, 11, 1 };
        // System.out.println(smallestDivisor(arr, 5));

        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // System.out.println(shipWithinDays(arr, 5));

        // int arr[]={2,3,4,7,11};
        // System.out.println(findKthPositive(arr, 5));
        // System.out.println(findKthPositive_optimal(arr, 5));

        // int arr[] = { 1, 2, 8, 4, 9 };
        // System.out.println(binarySearch.AggressiveCows.aggressiveCows(arr, 2));

        // int arr[]={15,17,20};
        // System.out.println(binarySearch.BookAllocation.findPages(arr, 2));

        // int arr[]={10,10,10,11};
        // System.out.println(binarySearch.PainterPartition.minTime(arr, 2));

        // int arr[]={7,2,5,10,8};
        // System.out.println(binarySearch.SplitArrayLargestSum.splitArray(arr, 2));

        // int arr1[]={1,2};
        // int arr2[]={3,4};
        // System.out.println(findMedianSortedArrays(arr1, arr2));

        // int arr1[]={1,2,3,6};
        // int arr2[]={3,4};
        // System.out.println(kthElement(arr1, arr2,5));

        // int arr[][]={{0,1,1},{1,1,1},{0,0,1}};
        // System.out.println(rowWithMax1s(arr));

        // int arr[][]={{1,2,3},{4,5,6}};
        // System.out.println(searchMatrix(arr, 2));

    }
}
