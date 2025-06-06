import java.util.*;

public class arrayList {

    public static int container_with_most_water(ArrayList<Integer> height) { // time-> O(n^2)

        int max_water = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int width = j - i;
                int ht = Math.min(height.get(i), height.get(j));
                int vol = ht * width;
                max_water = Math.max(max_water, vol);
            }
        }
        return max_water;
    }

    public static int container_with_most_water_two_pointer_approach(ArrayList<Integer> height) { // time-> O(n)

        int max_water = 0;
        int lp = 0;
        int rp = height.size() - 1;
        while (lp < rp) {
            int width = rp - lp;
            int ht = Math.min(height.get(lp), height.get(rp));
            int vol = ht * width;
            max_water = Math.max(max_water, vol);
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return max_water;
    }

    public static void pair_sum_two_pointer_approach(ArrayList<Integer> number, int target) {
        int lp = 0;
        int rp = number.size() - 1;
        boolean isFound = false;
        while (lp < rp) {
            int sum = number.get(lp) + number.get(rp);

            if (sum == target) {
                isFound = true;
                System.out.println("(" + number.get(lp) + "," + number.get(rp) + ")");
            }
            if (sum >= target) {
                rp--;
            } else {
                lp++;
            }
        }
        if (!isFound) {
            System.out.println("no pair exist");
        }
    }

    public static void pair_sum_rotated_array(ArrayList<Integer> list, int target) {
        int breakpoint = -1;
        int n = list.size();
        boolean isFound = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                breakpoint = i;
                break;
            }
        }
        int lp = breakpoint + 1;
        int rp = breakpoint;

        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target) {
                isFound = true;
                System.out.println("(" + list.get(lp) + "," + list.get(rp) + ")");
            }
            if (sum < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }
        if (!isFound) {
            System.out.println("no pair exist");
        }
    }

    public static void main(String args[]) {
        // ArrayList<Integer> height = new ArrayList<>();
        // height =[1,8,6,2,5,4,8,3,7]
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);
        // System.out.println(container_with_most_water(height));
        // System.out.println(container_with_most_water_two_pointer_approach(height));

        // ArrayList<Integer> number = new ArrayList<>();
        // number.add(1);
        // number.add(2);
        // number.add(3);
        // number.add(4);
        // number.add(5);
        // number.add(6);
        // pair_sum_two_pointer_approach(number, 6);

       
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(11);
        // list.add(15);
        // list.add(5);
        // list.add(6);
        // list.add(8);
        // list.add(9);
        // list.add(10);
        // pair_sum_rotated_array(list, 16);
    }
}
