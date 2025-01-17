import java.util.*;
//uisng Tree map
class KClosestPointstoOriginProblem_Way2_usingTreeSet {
    // Define a Point class
    public class Point {
        int x;    // x-coordinate of the point
        int y;    // y-coordinate of the point
        int dist; // Squared distance from the origin (0, 0)

        // Constructor to initialize the Point object
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // Method to find the k closest points to the origin
    public int[][] kClosest(int[][] points, int k) {
        // TreeMap to store distances as keys and lists of points as values
        TreeMap<Integer, List<Point>> map = new TreeMap<>();

        // Iterate through each point in the input array
        for (int i = 0; i < points.length; i++) {
            // Calculate the squared distance from the origin
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            // Create a new Point object
            Point point = new Point(points[i][0], points[i][1], dist);
            // Check if the distance is already a key in the TreeMap
            if (!map.containsKey(dist)) {
                // If not, create a new list and put it in the TreeMap
                map.put(dist, new ArrayList<>());
            }
            // Add the point to the list corresponding to the distance
            map.get(dist).add(point);
        }

        int[][] ans = new int[k][2]; // Array to store the k closest points
        int count = 0; // Counter for the number of closest points added

        // Iterate over the keys of the TreeMap
        for (Integer key : map.keySet()) {
            List<Point> pointsAtDistance = map.get(key);
            for (Point point : pointsAtDistance) {
                if (count < k) {
                    ans[count++] = new int[]{point.x, point.y}; // Add the point to the answer array
                } else {
                    break;
                }
            }
            if (count >= k) {
                break;
            }
        }
        return ans; // Return the k closest points
    }

    // Main method to test the Solution class
    public static void main(String[] args) {
    	KClosestPointstoOriginProblem_Way2_usingTreeSet sol = new KClosestPointstoOriginProblem_Way2_usingTreeSet();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] result = sol.kClosest(points, k);

        // Print the result
        System.out.println("The " + k + " closest points to the origin are:");
        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}


//https://leetcode.com/problems/k-closest-points-to-origin/

//https://getsdeready.com/courses/design-dsa-combined/lesson/k-closest-points-to-origin-2/
//i wrote explianation https://docs.google.com/document/d/1wkXP6fSrIrNEDFPB-Jng-fuobxT6Sh0APODb_PXws5U/edit  