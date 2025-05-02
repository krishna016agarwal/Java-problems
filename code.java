public class code {

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

    public static int last_occurance_of_number_in_array(int arr[],int key,int i){
        if (i==arr.length) {
            return -1;
        }
        int isfound=last_occurance_of_number_in_array(arr, key, i+1);
        if (isfound==-1 && arr[i]==key) {
            return i;
        }
        return isfound;
    }
    
    public static int print_x_power_n(int a,int n){
       if(n==1) return a;
       int number=print_x_power_n(a, n-1);
       return number*a;
    }
    public static void main(String args[]) {
        
        // int arr[] = { 1, 2, 3, 4, 5, 6, 9 };
        // check_if_array_is_sorted(arr, 0);

        // int arr[] = { 1, 2, 3, 4, 5, 6, 1 };
        // int index=last_occurance_of_number_in_array(arr, 1, 0);
        // System.out.println(index);

        // int number=print_x_power_n(3, 3);
        // System.out.println(number);
    }
}