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

    public int[] heapSort(int nums[]) {
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

    public static void main(String args[]) {
        // heap a = new heap();
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

        // int nums[] = a.Max_Heap(arr);
        // code.printArray(nums);

        // int nums[]= a.heapSort(arr);
        // code.printArray(nums);

    }

}
