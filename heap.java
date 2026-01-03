import java.util.PriorityQueue;

public class heap {

    public int[] Max_Heap(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int parentIndex = (i - 1) / 2;

            int v = i;
            while (v > 0 && nums[parentIndex] < nums[v]) {

                int temp = nums[parentIndex];
                nums[parentIndex] = nums[v];
                nums[v] = temp;
                v = parentIndex;
                parentIndex = (v - 1) / 2;

            }
        }
        return nums;

    }

    public int[] heapSort(int nums[]) { // O(nlogn)
        nums = Max_Heap(nums);

        int s = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int v = 0;
            int temp = nums[0];
            nums[0] = nums[s];
            nums[s] = temp;

            while (true) {
                int child1 = 2 * v + 1;
                int child2 = 2 * v + 2;
                int largest = v;

                if (child1 < s && nums[child1] > nums[largest]) {
                    largest = child1;
                }
                if (child2 < s && nums[child2] > nums[largest]) {
                    largest = child2;
                }

                if (largest == v)
                    break;

                temp = nums[v];
                nums[v] = nums[largest];
                nums[largest] = temp;
                v = largest;

            }
            s--;
        }
        return nums;

    }

    public int findKthLargest(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int parentIndex = (i - 1) / 2;

            int v = i;
            while (v > 0 && nums[parentIndex] < nums[v]) {

                int temp = nums[parentIndex];
                nums[parentIndex] = nums[v];
                nums[v] = temp;
                v = parentIndex;
                parentIndex = (v - 1) / 2;

            }
        }
        int s = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int v = 0;
            int temp = nums[0];
            nums[0] = nums[s];
            nums[s] = temp;

            while (true) {
                int child1 = 2 * v + 1;
                int child2 = 2 * v + 2;
                int largest = v;

                if (child1 < s && nums[child1] > nums[largest]) {
                    largest = child1;
                }
                if (child2 < s && nums[child2] > nums[largest]) {
                    largest = child2;
                }

                if (largest == v)
                    break;

                temp = nums[v];
                nums[v] = nums[largest];
                nums[largest] = temp;
                v = largest;

            }
            s--;
        }
        return nums[nums.length - k];
    }

    public void heapify_min(int i, int arr[], int e) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;

        if (left < e && arr[max] > arr[left])
            max = left;

        if (right < e && arr[max] > arr[right])
            max = right;

        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            heapify_min(max, arr, e);
        }
    }

    public void heapify_max(int i, int arr[], int e) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;

        if (left < e && arr[max] < arr[left])
            max = left;

        if (right < e && arr[max] < arr[right])
            max = right;

        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            // System.out.println(i);
            // code.printArray(arr);
            heapify_max(max, arr, e);
        }
    }

    public int[] Min_Heap(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (2 * i + 1 < nums.length || 2 * i + 2 < nums.length)
                heapify_min(i, nums, nums.length);
        }
        return nums;
    }

    public int[] heapSort_using_heapify(int nums[]) { // ascending order

        for (int i = nums.length - 1; i >= 0; i--) { // formation of Max_heap
            if (2 * i + 1 < nums.length || 2 * i + 2 < nums.length)
                heapify_max(i, nums, nums.length);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify_max(0, nums, i);

        }
        return nums;
    }

    public int[] heapSort_using_heapify_min(int nums[]) { // descending order

        for (int i = nums.length - 1; i >= 0; i--) { // formation of Max_heap
            if (2 * i + 1 < nums.length || 2 * i + 2 < nums.length)
                heapify_min(i, nums, nums.length);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify_min(0, nums, i);

        }
        return nums;
    }

    public static int minCost_for_connecting_n_ropes(int[] arr) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : arr) {
            q.add(i);
        }
        int sum = 0;
        while (q.size() != 1) {
            int left = q.remove();
            int right = q.remove();
            int x = left + right;
            sum += x;
            q.add(x);
        }
        return sum;
    }

    class k_Weakest_Soliders { // O(n^2)
        class Points implements Comparable<Points> {
            int n;
            int i;

            Points(int n, int i) {
                this.n = n;
                this.i = i;
            }

            @Override
            public int compareTo(Points a) {
                if (this.n == a.n)
                    return this.i - a.i; // ascending order
                return this.n - a.n;
            }
        }

        public int[] kWeakestRows(int[][] mat, int k) {
            PriorityQueue<Points> a = new PriorityQueue<>();
            for (int i = 0; i < mat.length; i++) {
                int c = 0;
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1)
                        c++;
                }
                a.add(new Points(c, i));
            }
            int arr[] = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = a.remove().i;
            }
            return arr;
        }
    }

    class MaxSlidingWindow { // O(nlogk)

        class Num implements Comparable<Num> {
            int n;
            int i;

            Num(int n, int i) {
                this.n = n;
                this.i = i;
            }

            @Override
            public int compareTo(Num a) {
                return a.n - this.n; // descending order
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {

            int ans[] = new int[nums.length - k + 1];
            PriorityQueue<Num> q = new PriorityQueue<>();

            for (int m = 0; m < k; m++) {
                q.add(new Num(nums[m], m));
            }

            int j = 0;
            ans[j] = q.peek().n;

            for (int m = k; m < nums.length; m++) {

                while (!q.isEmpty() && q.peek().i <= m - k)
                    q.remove();

                q.add(new Num(nums[m], m));

                ans[++j] = q.peek().n;

            }
            return ans;

        }
    }

    public int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            q.remove();
        }
        return q.remove();

    }

    public static void main(String args[]) {
        // heap a = new heap();
        // int arr[] = { 7, 6, 5, 4, 3, 2, 9 };

        // a.heapify(0, arr);
        // code.printArray(arr);

        // int nums[] = a.Max_Heap(arr);
        // code.printArray(nums);

        // int nums[] = a.heapSort_using_heapify(arr);
        // code.printArray(nums);

        // int nums[] = a.Min_Heap(arr);
        // code.printArray(nums);

        // int nums[] = a.heapSort_using_heapify_min(arr);
        // code.printArray(nums);

    }

}
