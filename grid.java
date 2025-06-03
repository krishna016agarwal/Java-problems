public class grid {

    public static void path(int i, int j, int n, int m, String currentPath) {
        // Base Case: reached destination
        if (n == i - 1 && m == j - 1) {
            currentPath += "(" + n + "," + m + ")";
            System.out.println(currentPath + " --> reached\n");
            System.out.println("-------------------\n");
            return;
        }

        // Add current position to path
        currentPath += "(" + n + "," + m + ")" + " --> ";

        // Move Down
        if (n < i - 1) {
            path(i, j, n + 1, m, currentPath);
        }

        // Move Right
        if (m < j - 1) {
            path(i, j, n, m + 1, currentPath);
        }
    }

    static boolean solutionFound = false;

    public static void ratInMaze(int[][] maze, int row, int col, String path, boolean[][] visited) {
        int n = maze.length;

        // Out of bounds or blocked or already visited
        if (row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0 || visited[row][col]) {
            return;
        }

        // Destination reached
        if (row == n - 1 && col == n - 1) {
            path += "(" + row + "," + col + ")";
            System.out.println(path + " --> reached\n");
            System.out.println("-------------------\n");
            solutionFound = true;
            return;
        }

        // Mark this cell as visited
        visited[row][col] = true;

        // Add current cell to path
        path += "(" + row + "," + col + ")" + " --> ";

        // Explore all 4 directions
        ratInMaze(maze, row, col + 1, path, visited); // right
        ratInMaze(maze, row + 1, col, path, visited); // down
        ratInMaze(maze, row, col - 1, path, visited); // left
        ratInMaze(maze, row - 1, col, path, visited); // up

        // Backtrack
        visited[row][col] = false;
    }

    public static void main(String args[]) {
        // path(3, 3, 0, 0, "");
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 } };
        boolean[][] visited = new boolean[maze.length][maze.length];
        ratInMaze(maze, 0, 0, "", visited);
        if (!solutionFound) {
            System.out.println("No solution exists");
        }
    }
}

// timecomplexity=2^(n+m)

// best solution
// formula= (n-1+m-1)!
// _________________
// (n-1)!(m-1)!
// time complexity=O(n+m)