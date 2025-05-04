public class code {

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

    public static int last_occurance_of_number_in_array(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isfound = last_occurance_of_number_in_array(arr, key, i + 1);
        if (isfound == -1 && arr[i] == key) {
            return i;
        }
        return isfound;
    }

    public static int print_x_power_n(int a, int n) {
        if (n == 1)
            return a;
        int number = print_x_power_n(a, n - 1);
        return number * a;
    }

    public static int optamize_x_power_n(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int halfpower = optamize_x_power_n(a, n / 2);
        int halfpowersq = halfpower * halfpower;
        if (n % 2 != 0) {
            halfpowersq = a * halfpowersq;
        }
        return halfpowersq;
    }

    public static int tiling_problem(int n) {
        if (n == 0 || n == 1)
            return 1;

        // vertical choice
        int v = tiling_problem(n - 1);

        // horizontal choice
        int h = tiling_problem(n - 2);

        int total = v + h;
        return total;
    }

    public static void print_duplicates_of_a_string_adjacent_to_each_other(String arr) {

        int arr2[] = new int[arr.length()];
        for (int j = 0; j < arr.length(); j++) {

            for (int j2 = 0; j2 <= j; j2++) {
                if (j2 != j) {
                    if (arr.charAt(j2) == arr.charAt(j)) {
                        arr2[j2]++;
                        arr2[j] = 0;

                        break;
                    }
                } else {
                    int c = 1;

                    arr2[j] = c;
                }

            }

        }
        for (int i = 0; i < arr.length(); i++) { // aacbcadddd
            for (int j = 0; j < arr2[i]; j++) { // 3021004000
                System.out.print(arr.charAt(i));
            }
        }
    }

    public static void remove_duplicates_in_a_string(String str, int index, StringBuilder newstr, boolean arr[]) {
        // base case
        if (index == str.length()) {
            System.out.println(newstr);
            return;
        }
        ;
        // recusrsive function
        char currChar = str.charAt(index);
        if (arr[currChar - 'a'] == true) {
            // duplicate found
            remove_duplicates_in_a_string(str, index + 1, newstr, arr);
        } else {
            arr[currChar - 'a'] = true;
            newstr.append(currChar);
            remove_duplicates_in_a_string(str, index + 1, newstr, arr);
        }
    }

    public static void rain_problem(int arr[]) {

        int total_rain_water = 0;
        int max_height_of_building_in_left_side = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (max_height_of_building_in_left_side < arr[j]) {
                    max_height_of_building_in_left_side = arr[j];
                }
            }
            total_rain_water += max_height_of_building_in_left_side - arr[i];
        }
        System.out.println("Total Rain Water=" + " " + total_rain_water);
    }

    public static int friends_Pairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // single ..total pairs
        return friends_Pairing(n - 1) + friends_Pairing(n - 2) * (n - 1);
    }

    public static void print_binary_string_without_consecutive_ones(int n, String str, int lastplace) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        System.out.println("\n" + "upper" + lastplace + "n" + n + "str" + str);
        print_binary_string_without_consecutive_ones(n - 1, str + "0", 0);
        if (lastplace == 0) {
            System.out.println("\n" + "lower" + lastplace + "n" + n + "str" + str);
            print_binary_string_without_consecutive_ones(n - 1, str + "1", 1);
        }
        System.out.println("\n" + "upperlower" + lastplace + "n" + n + "str" + str);
    }

    public static void main(String args[]) {

        // int arr[] = { 1, 2, 3, 4, 5, 6, 9 };
        // check_if_array_is_sorted(arr, 0);

        // int arr[] = { 1, 2, 3, 4, 5, 6, 1 };
        // int index=last_occurance_of_number_in_array(arr, 1, 0);
        // System.out.println(index);

        // int number=print_x_power_n(3, 3);
        // System.out.println(number);

        // int number=optamize_x_power_n(3, 10);
        // System.out.println(number);

        // int number = tiling_problem(6);
        // System.out.println(number);

        // int arr[] = {9,5,7,3,52,1,4,78,62,2 };
        // selection_sorting(arr);
        // bubble_sorting(arr);
        // inserting_sorting(arr);

        // String arr = "aacbcadddd";
        // print_duplicates_of_a_string_adjacent_to_each_other(arr);

        // String str = "helloworld";
        // remove_duplicates_in_a_string(str, 0, new StringBuilder(""), new
        // boolean[26]);

        // int arr[]={5,2,5,4,3,5};
        // rain_problem(arr);

        // int a=friends_Pairing(3);
        // System.out.println(a);

        // print_binary_string_without_consecutive_ones(2, "", 0);

        // int arr[] = { 8, 5, 2, 9, -6, 1, -3 };
        // MergeSort.mergeSort(arr, 0, arr.length - 1);
        // MergeSort.printSortedArray(arr);
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
        int i = si, j = mid + 1, k = 0;

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

    public static void printSortedArray(int arr[]) {
        for (int value : arr) {
            System.out.print(" " + value);
        }
        System.out.println();
    }
}
