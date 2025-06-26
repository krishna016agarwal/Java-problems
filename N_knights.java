public class N_knights {
    static int count;

    public static boolean isSafe(char board[][], int row, int col) {
        int n = board.length;

        if (row > 1 && col <= n - 2 && board[row - 2][col + 1] == 'K') {
            return false;
        }
        if (row > 1 && col >= 1 && board[row - 2][col - 1] == 'K') {
            return false;
        }
        if (row > 0 && col <= n - 3 && board[row - 1][col + 2] == 'K') {
            return false;
        }
        if (row > 0 && col >= 2 && board[row - 1][col - 2] == 'K') {
            return false;
        }
        return true;
    }

    public static void nKnights(char board[][], int row, int col) {
        // base case
        if (row == board.length) {
            N_Queens.printboard(board);
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'K';
                nKnights(board, row + 1, col); // recursion
                board[row][j] = 'x'; // back tracking
            }
        }

    }

    public static boolean nKnight_one_solution(char board[][], int row) {

        // base case
        if (row == board.length) {
            return true;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nKnight_one_solution(board, row + 1)) {
                    return true;
                }

                board[row][j] = 'x'; // backtracking
            }

        }
        return false;

    }

    public static void main(String args[]) {
        int n = 3;
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }
        nKnights(board, 0, 0);
        System.out.println(count);

        // if(nKnight_one_solution(board, 0)){
        // N_Queens.printboard(board);
        // }else{
        // System.out.println("no solution");
        // }
    }
}
