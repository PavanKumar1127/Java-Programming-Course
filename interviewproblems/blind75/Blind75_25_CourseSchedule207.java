package blind75;
import java.util.*;

public class Blind75_25_CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            adjList.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        // Topological Sorting
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            count++;
            for (int nextCourse : adjList.get(currCourse)) {
                if (--inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
    	Blind75_25_CourseSchedule207 cs = new Blind75_25_CourseSchedule207();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Can finish courses: " + cs.canFinish(numCourses, prerequisites));
    }
}
