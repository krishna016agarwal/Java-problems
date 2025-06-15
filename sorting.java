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

   

    public static void main(String args[]) {
        // int arr[] = { 9, 5, 7, 3, 52, 1, 4, 78, 62, 2 };
        // selection_sorting(arr);
        // bubble_sorting(arr);
        // inserting_sorting(arr);

        // int arr[] = { 1, 2, 3, 4, 5, 6, 9 };
        // check_if_array_is_sorted(arr, 0);

        // int arr[] = { 1, 3, 1, 3, 2, 1, 8, 6,2 }; //time complexity-O(n+k)
        // counting_sort(arr);

       // spiral_matrix();
    }
}
