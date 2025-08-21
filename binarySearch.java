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

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(shipWithinDays(arr, 5));
    }
}
