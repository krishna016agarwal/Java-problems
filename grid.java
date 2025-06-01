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

    public static void main(String args[]) {
        path(3, 3, 0, 0, "");
    }
}


//timecomplexity=2^(n+m)


//best solution 
//formula=  (n-1+m-1)!
//        _________________
//          (n-1)!(m-1)!
//time complexity=O(n+m)