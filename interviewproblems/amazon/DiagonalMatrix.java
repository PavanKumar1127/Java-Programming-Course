package amazon;
public class DiagonalMatrix {

    public static void printDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Traverse upper diagonals
        for (int d = 0; d < rows + cols - 1; d++) {
            int rowStart = Math.max(0, d - cols + 1);
            int colStart = Math.min(d, cols - 1);

            for (int i = rowStart, j = colStart; i < rows && j >= 0; i++, j--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Traverse lower diagonals
        for (int d = 1; d < rows + cols - 1; d++) {
            int rowStart = Math.min(d, rows - 1);
            int colStart = Math.max(0, d - rows + 1);

            for (int i = rowStart, j = colStart; i >= 0 && j < cols; i--, j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        printDiagonal(matrix);
//        1 
//        5 2 
//        9 6 3 
//        13 10 7 4 
//        14 11 8 
//        15 12 
//        16 
    }
}
