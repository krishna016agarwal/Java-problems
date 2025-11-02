import java.util.*;

public class Bit {

    String reverse_String(String s) {
        String d = "";
        for (int i = 0; i < s.length(); i++) {
            d += s.charAt(s.length() - i - 1);
        }

        return d;
    }

    String Number_to_binary(int n) { // O(logn) SC- O(logn)

        String s = "";
        while (n != 0) {
            int r = n % 2;
            n = n / 2;
            s += r;
        }

        return reverse_String(s);

    }

    int binary_to_Number(String n) { // O(n) SC-(1)
        int num = 0;
        int pow = 0;
        while (!n.isEmpty()) {
            char a = n.charAt(n.length() - 1);
            num += Math.pow(2, pow) * (a - '0');
            n = n.substring(0, n.length() - 1);
            pow++;
        }
        return num;
    }

    String ones_Complement(int n) {
        String a = Number_to_binary(n);
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0') {
                b += "1";
            } else {
                b += "0";
            }
        }
        return b;
    }

    String twos_complement(int n) {
        String a = ones_Complement(n);
        int len = a.length();

        int carry = 0;
        String b = "";
        while (!a.isEmpty()) {
            int c = a.charAt(a.length() - 1) - '0';

            if (a.length() == len) {
                if (c == 1) {
                    b += "0";

                    carry = 1;
                } else if (c == 0) {
                    b += "1";
                    carry = 0;
                }
            } else {
                int d = c + carry;
                if (d == 1) {
                    b += "1";
                    carry = 0;
                } else if (d == 0) {
                    b += "0";
                    carry = 0;
                }
            }

            a = a.substring(0, a.length() - 1);

        }

        return reverse_String(b);
    }

    void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }

    boolean checkKthBit(int n, int k) {

        String a = Number_to_binary(n);
        int l = a.length();
        if (k >= l)
            return false;
        for (int i = l - 1; i >= 0; i--) {
            if (k == 0) {
                if (a.charAt(i) == '1')
                    return true;
                else
                    return false;
            }
            k--;
        }
        return false;
    }

    boolean checkKthBit_optimal(int n, int k) { // O(1)

        if (((n >> k) & 1) == 1)
            return true;
        return false;
    }

    int setKthBit(int n, int k) {
        return (n | 1 << k);

    }

    int clearKthBit(int n, int k) {
        return (n & ~(1 << k));
    }

    int toggleKthBit(int n, int k) {
        return (n ^ (1 << k));
    }

    int Set_the_rightmost_unset_bit(int n) {
        // code here
        return n | n + 1;
    }

    int UnSet_the_rightmost_set_bit(int n) {
        // code here
        return n & n - 1;
    }

    boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;

        return (n & (n - 1)) == 0;
    }

    int count_no_of_set_bits(int n) {
        int count = 0;
        while (n > 1) {
            count += n & 1; // n%2
            n = n >> 1; // n/2
            if (n == 1)
                count++;
        }
        return count;
    }

    int count_no_of_set_bits_optimal(int n) {
        int count = 0;
        while (n != 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }

    int count_minimum_flips(int n, int m) {
        int a = n ^ m;
        return count_no_of_set_bits_optimal(a);
    }

    List<List<Integer>> powerSet(int[] arr) { // O(2^n * n) SC - O(2^n *n)
        List<List<Integer>> a = new ArrayList<>();
        int subsets = 1 << arr.length;
        for (int i = 0; i < subsets; i++) { // 2^n
            List<Integer> b = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) {
                    b.add(arr[j]);
                }
            }
            a.add(b);
        }
        return a;
    }

    int SinglNumber(int arr[]) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num ^= arr[i];
        }
        return num;
    }

    public static void main(String args[]) {
        Bit a = new Bit();

        // System.out.println(a.Number_to_binary(10));
        // System.out.println(a.binary_to_Number("1101"));
        // System.out.println(a.ones_Complement(13));
        // System.out.println(a.twos_complement(14));
        // a.swap(3, 1);
        // System.out.println(a.checkKthBit(4, 2));
        // System.out.println(a.checkKthBit_optimal(13, 2));
        // System.out.println(a.setKthBit(13, 1));
        // System.out.println(a.clearKthBit(13, 2));
        // System.out.println(a.toggleKthBit(13, 2));
        // System.out.println(a.count_no_of_set_bits(12456));
        // System.out.println(a.count_no_of_set_bits_optimal(12456));
        // System.out.println(a.count_minimum_flips(10, 7));

        // int arr[]={1,2,3};
        // System.out.println(a.powerSet(arr));

        // int arr[] = { 4, 1, 2, 1, 2 };
        // System.out.println(a.SinglNumber(arr));
        

    }
}
