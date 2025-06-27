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

    public static void min_sum_absolute_difference_pairs(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        System.out.println(sum);
    }

    public static void maximum_length_chain_of_pair(int pair[][]) { // O(nlogn)
        Arrays.sort(pair, Comparator.comparing(o -> o[1]));// sort 2d array //sorting on the basis of column 2 index 1
        int chainLength = 1;

        int chainEnd = pair[0][1];
        for (int i = 0; i < pair.length; i++) {
            if (pair[i][0] > chainEnd) {
                chainLength++;
                chainEnd = pair[i][1];

            }
        }
        System.out.println("max length of chain " + chainLength);

    }

    public static void make_amount_with_quantised_indian_Coins(int target, Integer coin[]) {
        Arrays.sort(coin, Comparator.reverseOrder());
        ArrayList<Integer> s = new ArrayList<>();
        int minCoinsUsed = 0;
        for (int i = 0; i < coin.length; i++) {
            if (target >= coin[i]) {
                while (target >= coin[i]) {
                    minCoinsUsed++;
                    target -= coin[i];
                    s.add(coin[i]);
                }
            }
        }
        System.out.println("min coins used " + minCoinsUsed);
        for (int i = 0; i < s.size(); i++) {

            System.out.print(s.get(i) + " ");
        }

    }

    public static class job {
        public static class Job {

            int id;
            int deadline;
            int profit;

            Job(int i, int d, int p) {
                id = i;
                deadline = d;
                profit = p;
            }
        }

        public static void job_maximum_profit(ArrayList<Job> s) {
            Collections.sort(s, (obj1, obj2) -> obj2.profit - obj1.profit); // descending order
            ArrayList<Integer> q = new ArrayList<>();
            int time = 0;
            for (int i = 0; i < s.size(); i++) {
                Job curr = s.get(i);
                if (curr.deadline > time) {
                    q.add(curr.id);
                    time++;
                }

            }

            // print
            System.out.println("max jobs " + q.size());
            for (int i = 0; i < q.size(); i++) {
                System.out.print(q.get(i) + " ");
            }
        }
    }

    public static void chocola_problem(Integer costHor[], Integer costVer[]) {
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;
        while (h < costHor.length && v < costVer.length) {
            // vertical cost < hor cost
            if (costVer[v] <= costHor[h]) { // horizontal cut
                cost += costHor[h] * vp;
                hp++;
                h++;
            } else { // vertical cut
                cost += costVer[v] * hp;
                vp++;
                v++;

            }
        }
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }
        System.out.println("minimum cost = " + cost);

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

        // ------------------------------------
        // int a[]={4,1,8,7};
        // int b[]={2,3,6,5};
        // min_sum_absolute_difference_pairs(a, b);

        // ----------------------------
        // int pair[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
        // maximum_length_chain_of_pair(pair);

        // -----------------------------------

        // Integer coin[]={1,2,5,10,20,50,100,500,2000};
        // make_amount_with_quantised_indian_Coins(1059, coin);

        // -----------------------------------------

        // int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        // ArrayList<job.Job> s = new ArrayList<>();

        // for (int i = 0; i < jobInfo.length; i++) {
        // s.add(new job.Job(i, jobInfo[i][0], jobInfo[i][1]));
        // }
        // job.job_maximum_profit(s);

        // ---------------------------------------------------

        // int n = 4;
        // int m = 6;
        // Integer costVer[] = { 2, 1, 3, 1, 4 };
        // Integer costHor[] = { 4, 1, 2 };
        // chocola_problem(costHor, costVer);

    }
}
