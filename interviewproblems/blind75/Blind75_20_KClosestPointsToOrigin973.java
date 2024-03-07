package blind75;
import java.util.Arrays;

public class Blind75_20_KClosestPointsToOrigin973 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> distance(a) - distance(b));
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    public static void main(String[] args) {
    	Blind75_20_KClosestPointsToOrigin973 solution = new Blind75_20_KClosestPointsToOrigin973();
        int[][] points = {{3, 3},{5, -1}, {-2, 4}}; //[[3,3],[5,-1],[-2,4]]
        int k = 2;
        int[][] result = solution.kClosest(points, k);
        System.out.println("K Closest Points to Origin:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}
