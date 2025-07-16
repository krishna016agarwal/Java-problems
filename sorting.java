public class sorting {

    public static void bubble_sorting(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void selection_sorting(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int c = 0;
            for (int j = i; j < arr.length; j++) {

                if (arr[j] < min) {
                    min = arr[j];
                    c = j;
                }

            }
            arr[c] = arr[i];
            arr[i] = min;

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void inserting_sorting(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void check_if_array_is_sorted(int arr[], int a) {
        int n = arr.length;
        if (a < n - 1) {
            if (arr[a] < arr[a + 1]) {

                check_if_array_is_sorted(arr, a + 1);

                return;
            }
            System.out.println("not sorted");
            return;
        }

        System.out.println("sorted");
    }

    public static void counting_sort(int arr[]) {
        // arr=[1,3,1,3,2,1,8,6]
        // fre=[0,3,1,2,0,0,1,0,1]
        int fre[] = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            fre[arr[i]] += 1;
        }
        for (int i = 0; i < fre.length; i++) {
            for (int j = 0; j < fre[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void spiral_matrix() {
        int n = 5; // You can change n to any size
        int[][] matrix = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            // Left to Right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // Right to Left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // Bottom to Top
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        // Print the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    class recursiveBubble {
        public static int[] bubblesort(int arr[]) {
            helper(arr, arr.length);
            return arr;
        }

        private static void helper(int arr[], int n) {
            if (n == 1)
                return;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            helper(arr, n - 1);
        }
    }

    class insertionSort {
        public int[] insertingSorting(int arr[]) {
            helper(arr, 1);
            return arr;
        }

        private void helper(int arr[], int n) {
            if (n == arr.length) {
                return;
            }
            for (int i = n; i > 0; i--) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                }
            }
            helper(arr, n + 1);
        }
    }

    class mergeSorting{
        public int[] sort(int arr[]){
            helper(arr);
            return arr;
        }
        private void helper(int arr[]){
            
        }
    }
    
    public static void main(String args[]) {
        // int arr[] = { 9, 5, 7, 3, 52, 1, 4, 78, 62, 2 };
        // selection_sorting(arr);
        // bubble_sorting(arr);
        // inserting_sorting(arr);

        // int arr[] = { 1, 2, 3, 4, 5, 6, 9 };
        // check_if_array_is_sorted(arr, 0);

        // int arr[] = { 1, 3, 1, 3, 2, 1, 8, 6,2 }; //time complexity-O(n+k)
        // counting_sort(arr);

        //spiral_matrix();
//--------------------------------------------------------
        // int arr[] = { 8, 5, 2, 9, -6, 1, -3 };
        // MergeSort.mergeSort(arr, 0, arr.length - 1);
        // code.printArray(arr);
//----------------------------------------------------------
        // int arr[] = { 8, 5, 2, 9, -6, 1, -3 };
        // QuickSort.quicksort(arr, 0, arr.length-1);
        // code.printArray(arr);

        // --------------------------------------
        // int arr[]={7,5,4,1,3};
        // sorting.recursiveBubble.bubblesort(arr);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i]+" ");
        // }
        // ---------------------------------------
        // sorting s=new sorting();
        // int arr[]={7,1,5,4,3,6,2};
        // insertionSort a=s.new insertionSort();
        // a.insertingSorting(arr);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i]+" ");
        // }
    }
}

class MergeSort {

    public static void mergeSort(int arr[], int i, int e) {
        if (i >= e)
            return;
        int mid = i + (e - i) / 2;

        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, e);
        mergeConquor(arr, i, e, mid);
    }

    public static void mergeConquor(int arr[], int si, int e, int mid) {
        int temp[] = new int[e - si + 1];
        int i = si; //first array
        int j = mid + 1; //second array
        int k = 0; //temp array

        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= e) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

}

class QuickSort { // time complexity- O(nlogn)

    public static void quicksort(int arr[], int si, int ei) {
        if (si >= ei)
            return;

        int ptind = partition(arr, si, ei);
        quicksort(arr, si, ptind - 1); // left part
        quicksort(arr, ptind + 1, ei); // right part

    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei]; // last element will be pivot
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[ei];
        arr[ei] = temp;
        return i;
    }
}
