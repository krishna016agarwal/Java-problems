public class sudoku {

    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // check column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // check row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        // check grid
        int strow = (row / 3) * 3;
        int stcol = (col / 3) * 3;

        for (int i = strow; i < strow + 3; i++) {
            for (int j = stcol; j < stcol + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudoku_solver(int sudoku[][], int row, int col) {

        // base case
        if (row == 9) {
            return true;
        }
        // recursion

        int nextrow = row, nextcol = col + 1;
        if (col + 1 == 9) {
            nextrow = row + 1;
            nextcol = 0;
        }
        if (sudoku[row][col] != 0) {
            return sudoku_solver(sudoku, nextrow, nextcol);
        }
        for (int digit = 1; digit <=9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudoku_solver(sudoku, nextrow, nextcol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] sudoku = {

                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },

                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },

                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }

        };
        if (sudoku_solver(sudoku, 0, 0)) {
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku.length; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println("\n");
            }
        } else {
            System.out.println("Sudoku can't be solved");
        }

    }
}
