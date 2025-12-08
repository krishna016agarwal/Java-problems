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

            int id; // index
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
        int h = 0, v = 0; // traverse over costVer & costHor
        int hp = 1;// horizontal pieces
        int vp = 1;
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

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {

            if (bill == 5) {
                five++;
            }

            else if (bill == 10) {
                if (five == 0)
                    return false;
                five--;
                ten++;
            }

            else { // bill == 20
                   // Prefer giving 10 + 5 as change
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                // Otherwise give 3 fives
                else if (five >= 3) {
                    five -= 3;
                }
                // Cannot give change
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int r = 0; // children pointer
        int l = 0; // cookies pointer

        while (l < s.length && r < g.length) {
            if (g[r] <= s[l]) {
                r++; // child satisfied
            }
            l++; // move to next cookie
        }

        return r;
    }

    public boolean canJump(int[] nums) { // O(n)
        int reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reach)
                return false; // cannot reach this index
            reach = Math.max(reach, i + nums[i]);
        }

        return true;
    }

    class Jump2 { // O(n^n) SC-O(n)
        public int jump2(int[] nums) { // O(n^n) SC-O(n)
            return helper(nums, 0, 0);
        }

        int helper(int[] nums, int i, int c) {
            if (i >= nums.length - 1)
                return c;

            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i]; j++) {
                min = Math.min(min, helper(nums, i + j, c + 1));
            }
            return min;
        }
    }

    public int jump(int[] nums) { // O(n)
        int jumps = 0;
        int l = 0, r = 0;

        while (r < nums.length - 1) {
            int farthest = 0;

            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }

    class JobSequencing { // O(nlogn + n*maxdealine) SC-O(n)

        class Job {
            int deadline;
            int profit;

            Job(int d, int p) {
                deadline = d;
                profit = p;
            }
        }

        public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

            int maxprofit = 0;
            int count = 0;
            Job arr[] = new Job[profit.length];
            int maxdeadline = 0;
            for (int i = 0; i < profit.length; i++) {
                arr[i] = new Job(deadline[i], profit[i]);
                maxdeadline = Math.max(maxdeadline, deadline[i]);
            }
            Arrays.sort(arr, (a, b) -> b.profit - a.profit);
            int slot[] = new int[maxdeadline + 1];
            Arrays.fill(slot, -1);
            for (Job i : arr) {
                for (int j = i.deadline; j > 0; j--) {
                    if (slot[j] == -1) {
                        count++;
                        maxprofit += i.profit;
                        slot[j] = i.profit;
                        break;
                    }
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            result.add(count);
            result.add(maxprofit);
            return result;

        }
    }

    class JbSequencing_optimal { // O(nlogn)

        class Job {
            int deadline, profit;

            Job(int d, int p) {
                deadline = d;
                profit = p;
            }
        }

        // DSU find function
        int find(int parent[], int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent, parent[x]); // path compression
        }

        public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

            int n = deadline.length;

            Job[] arr = new Job[n];
            int maxDeadline = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = new Job(deadline[i], profit[i]);
                maxDeadline = Math.max(maxDeadline, deadline[i]);
            }

            // Sort by descending profit
            Arrays.sort(arr, (a, b) -> b.profit - a.profit);

            // DSU parent array
            int parent[] = new int[maxDeadline + 1];
            for (int i = 0; i <= maxDeadline; i++)
                parent[i] = i;

            int countJobs = 0;
            int maxProfit = 0;

            for (Job job : arr) {

                // find latest available day
                int availableDay = find(parent, job.deadline);

                if (availableDay > 0) {
                    // schedule job
                    countJobs++;
                    maxProfit += job.profit;

                    // mark this slot used → point to next free slot
                    parent[availableDay] = find(parent, availableDay - 1);
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            result.add(countJobs);
            result.add(maxProfit);
            return result;
        }
    }

    class MaxMeetings {

        class time {
            int start;
            int end;

            time(int s, int e) {
                start = s;
                end = e;
            }
        }

        public int maxMeetings(int start[], int end[]) {
       
            time arr[] = new time[end.length];
            
            for (int i = 0; i < end.length; i++) {
                arr[i] = new time(start[i], end[i]);
            }
            Arrays.sort(arr, (a, b) -> a.end - b.end);

            int count = 0;
            int init = -1;
            for (int i = 0; i < arr.length; i++) {
                if (init == -1) {
                    count++;
                    init = arr[i].end;
                } else {
                    if (arr[i].start > init) {
                        count++;
                        init = arr[i].end;
                    }
                }
            }
            return count;
        }
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

        // int jobInfo[][] = { { 2, 20 }, { 1, 10 }, { 2, 40 }, { 2, 30 } }; //index 0
        // is deadline inex 1 is profit
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
