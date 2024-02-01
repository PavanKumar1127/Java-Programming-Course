package reccursion.maze;
public class SudokuSolver {

    public static void main(String[] args) {
        int[][] sudokuBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(sudokuBoard)) {
            System.out.println("Sudoku solved successfully:");
            printSudoku(sudokuBoard);
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Function to solve the Sudoku puzzle using backtracking
    private static boolean solveSudoku(int[][] board) {
        int[] emptyCell = findEmptyCell(board);
        int row, col;

        // If there is no empty cell, the puzzle is solved
        if (emptyCell == null) {
            return true;
        }

        row = emptyCell[0];
        col = emptyCell[1];

        // Try placing digits 1 to 9 in the current empty cell
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                // Place the digit if it doesn't violate Sudoku rules
                board[row][col] = num;

                // Recursively try to solve the rest of the puzzle
                if (solveSudoku(board)) {
                    return true;
                }

                // If placing the current digit doesn't lead to a solution, backtrack
                board[row][col] = 0;
            }
        }

        // No digit could be placed, backtrack to the previous state
        return false;
    }

    // Function to check if it's safe to place a digit in a specific cell
    private static boolean isSafe(int[][] board, int row, int col, int num) {
        return !usedInRow(board, row, num) &&
               !usedInCol(board, col, num) &&
               !usedInBox(board, row - row % 3, col - col % 3, num);
    }

    // Function to check if a digit is used in the specified row
    private static boolean usedInRow(int[][] board, int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    // Function to check if a digit is used in the specified column
    private static boolean usedInCol(int[][] board, int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    // Function to check if a digit is used in the specified 3x3 box
    private static boolean usedInBox(int[][] board, int startRow, int startCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row + startRow][col + startCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    // Function to find an empty cell in the Sudoku puzzle
    private static int[] findEmptyCell(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    // Function to print the Sudoku board
    private static void printSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
