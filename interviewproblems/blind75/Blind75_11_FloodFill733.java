package blind75;

public class Blind75_11_FloodFill733 {

    public static void main(String[] args) {
    	Blind75_11_FloodFill733 solution = new Blind75_11_FloodFill733();

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        System.out.println("Original Image:");
        printImage(image);

        int[][] filledImage = solution.floodFill(image, sr, sc, newColor);

        System.out.println("Image after flood fill:");
        printImage(filledImage);
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor) {
            return image; // No need to process if image is empty or pixel already has new color
        }
        
        floodFillHelper(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    private void floodFillHelper(int[][] image, int sr, int sc, int prevColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != prevColor) {
            return; // Out of bounds or already processed pixel
        }
        
        image[sr][sc] = newColor;
        
        // Recursively flood fill adjacent pixels
        floodFillHelper(image, sr + 1, sc, prevColor, newColor); // Down
        floodFillHelper(image, sr - 1, sc, prevColor, newColor); // Up
        floodFillHelper(image, sr, sc + 1, prevColor, newColor); // Right
        floodFillHelper(image, sr, sc - 1, prevColor, newColor); // Left
    }
    
}

//An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//
//You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//
//To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
//
//Return the modified image after performing the flood fill.
//
// 
//
//Example 1:
//
//
//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
//Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
//Example 2:
//
//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
//Output: [[0,0,0],[0,0,0]]
//Explanation: The starting pixel is already colored 0, so no changes are made to the image.
// 
//
//Constraints:
//
//m == image.length
//n == image[i].length
//1 <= m, n <= 50
//0 <= image[i][j], color < 216
//0 <= sr < m
//0 <= sc < n