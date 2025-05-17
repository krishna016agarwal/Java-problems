public class N_Queens {

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left
        for (int i = row - 1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right
        for (int i = row - 1, j = col+1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printboard(char board[][]) {
        System.out.println("-----------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void nQueens(char board[][], int row) {


        // base case
        if (row == board.length) {
            printboard(board);
            count++;
            return;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1); // recursion step
                
                board[row][j] = 'x'; // backtracking
            }

        }

    }

     public static boolean nQueens_one_solution(char board[][], int row) {


        // base case
        if (row == board.length) {
            return true;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if(nQueens_one_solution(board, row + 1)){
                  return true;
                }
                
                board[row][j] = 'x'; // backtracking
            }

        }
        return false;

    }






   static int count=0;
    
   
   
   public static void main(String args[]) {
        int n = 5;
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }
      
        // nQueens(board, 0);
        // System.out.println("\nTotal ways= "+count);


        // if(nQueens_one_solution(board, 0)){
        //     printboard(board);
        // }else{
        //     System.out.println("no solution");
        // }
    }
}


//time complexity = O(n!)