import java.util.*;

public class Graph {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) { // O(n^2)

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[adj.size()];

        // Start BFS from node 0
        q.add(0);
        visited[0] = true;
        ans.add(0);
        while (!q.isEmpty()) {
            int node = q.remove();

            // Traverse all neighbors
            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(neigh);
                    ans.add(neigh);
                }
            }
        }

        return ans;
    }

    class DFS {
        public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
            // code here
            ArrayList<Integer> a = new ArrayList<>();
            int arr[] = new int[adj.size()];
            helper(adj, a, arr, 0);
            return a;

        }

        public void helper(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> a, int arr[], int i) {
            if (arr[i] == 0) {
                a.add(i);
                arr[i] = 1;
                for (int j : adj.get(i)) {
                    if (arr[j] != 1) {
                        helper(adj, a, arr, j);
                    }
                }

            }
        }
    }

    public static int Prims_Algorithm_for_minimum_spanning_tree(int V, int[][] edges) {

        // Step 1: Build adjacency list (u, v, wt)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2];
            adj.get(u).add(new int[] { v, wt });
            adj.get(v).add(new int[] { u, wt });
        }

        // Step 2: Create min-heap {weight, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0 }); // {wt, node}

        boolean[] visited = new boolean[V];
        int mstSum = 0;

        // Step 3: Prim's Algorithm
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int wt = top[0];
            int node = top[1];

            if (visited[node])
                continue;

            visited[node] = true;
            mstSum += wt;

            // Add all adjacent edges
            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int adjWt = it[1];

                if (!visited[adjNode]) {
                    pq.add(new int[] { adjWt, adjNode });
                }
            }
        }
        return mstSum;
    }

    class KruskalsMST {

        static int kruskalsMST(int V, int[][] edges) {
            int set[] = new int[V];

            PriorityQueue<int[]> a = new PriorityQueue<>((c, b) -> c[2] - b[2]);
            for (int[] i : edges) {
                a.add(i);
            }

            for (int i = 0; i < V; i++) {
                set[i] = -1;
            }

            int sum = 0;
            int full = V - 1;
            while (full > 0) {
                int[] y = a.poll();
                int i = y[0];
                int j = y[1];
                int cost = y[2];
                if (findparent(i, set) == findparent(j, set)) {

                    continue;
                }
                union(i, j, set);
                sum += cost;
                full--;

            }
            return sum;
        }

        static void union(int u, int v, int[] s) {
            int fu = findparent(u, s);
            int fv = findparent(v, s);
            if (fu < fv) {
                s[fv] = s[fu] + s[fv];
                s[fu] = fv;
            } else {
                s[fu] = s[fv] + s[fu];
                s[fv] = fu;
            }
        }

        static int findparent(int u, int[] s) {
            while (s[u] > 0) {
                u = s[u];
            }
            return u;
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
        // System.out.println(Prims_Algorithm_for_minimum_spanning_tree(3, arr));
        //System.out.println(Graph.KruskalsMST.kruskalsMST(3, arr));
    }
}
