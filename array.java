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

    public static void union_of_two_arrays(int arr1[], int arr2[]) { //O(n) SC- O(n)
        Deque<Integer> q = new LinkedList<>();
        int i = 0, j = 0;
           int a=0;
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
    }
}
