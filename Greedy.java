import java.util.*;

public class Greedy {

    public static void maxActivity_sorted_end_time(int start[], int end[]) { // O(n)

        // end time basis sorted
        int maxActivity = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxActivity = 1;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxActivity++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("max activity " + maxActivity);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    };

    public static void maxActivity_sorted_start_time(int start[], int end[]) { // O(nlogn)
        int activity[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }

        // lambda function
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2])); // O(nlogn)

        // end time basis sorted
        int maxActivity = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxActivity = 1;
        ans.add(activity[0][0]);
        int lastEnd = activity[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activity[i][1] >= lastEnd) {
                maxActivity++;
                ans.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }
        System.out.println("max activity " + maxActivity);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();

    }

    public static void fractionalKnapsack(int val[], int weight[], int w) {
        double ratio[][] = new double[val.length][2];
        // 0th col-> index; 1st col=> ratio;

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }
        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalval = 0;

        for (int i = ratio.length - 1; i >= 0; i--) { // descending order
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalval += val[idx]; // include full item
                capacity -= weight[idx];
            } else {
                // include fractional item
                finalval += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.println(finalval);
    }

    public static void main(String[] args) {
        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };
        // maxActivity_sorted_end_time(start, end);
        // maxActivity_sorted_start_time(start, end);

        // --------------------------------

        // int value[] = { 60, 100, 120, 100 };
        // int weight[] = { 10, 20, 30, 10 };
        // int maxWeight = 50;
        // fractionalKnapsack(value, weight, maxWeight);

    }
}
