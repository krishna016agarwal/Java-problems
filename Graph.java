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

    public static void main(String[] args) {

    }
}
