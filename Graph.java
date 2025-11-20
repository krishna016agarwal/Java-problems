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

    public static void main(String[] args) {

    }
}
