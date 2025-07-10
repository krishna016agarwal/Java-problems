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

    public static void reverseArray(int arr[],int n,int m){
        while(n<m){
            arr[n]=arr[n]+arr[m];
        arr[m]=arr[n]-arr[m];
        arr[n]=arr[n]-arr[m];
        n++;
        m--;
        }
    }
    
    public static void rotateArray(int arr[], int k) {

        // if (arr.length == 0 || arr.length == 1 || k == 0) {
        //     return;
        // }
        // int n = arr.length;
        // k = k % n;

        // int j = 0;
        // for (int i = n - k; i <= (n - 1 + n - k) / 2; i++) {
        //     int temp = arr[i];
        //     arr[i] = arr[n - (++j)];
        //     arr[n - (j)] = temp;
        // }
        
        // for (int i = 0; i <= (n - k - 1) / 2; i++) {
        //     int temp = arr[i];
        //     arr[i] = arr[n - k - 1 - i];
        //     arr[n - k - 1 - i] = temp;
        // }
        
     
        //     for (int i = 0; i < n / 2 ; i++) {
        //         int temp = arr[i];
        //         arr[i] = arr[n - i-1];
        //         arr[n - i-1] = temp;
        //     }

        //----------------------------------------------------------
        int n=arr.length;
        k=k%n;
       reverseArray(arr, n-k, n-1);
       reverseArray(arr, 0, n-k-1);
       reverseArray(arr, 0, n-1);

    }

    public static void main(String[] args) {
        // int arr[] = { 1,1,2,2,2, 2, 7, 7 };
        // System.out.println(secondLargest(arr));

        // int arr[] = { 1,1,2,2,2, 2, 7, 7,8,8,9,10,10 };
        // remove_duplicate_in_sorted_array(arr);
        // System.out.println(remove_duplicate_in_sorted_array(arr));

    //     int arr[] = { 1,2,3,4 };
    //     rotateArray(arr, 6);
    //  //  reverseArray(arr, 0, arr.length-1);
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.print(arr[i] + " ");
    //     }
    }
}
