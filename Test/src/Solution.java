import java.util.PriorityQueue;

class Solution {
    // Define a Point class which implements the Comparable interface
    public class Point implements Comparable<Point> {
        int x;    // x-coordinate of the point
        int y;    // y-coordinate of the point
        int dist; // Squared distance from the origin (0, 0)
        int i;    // Index of the point in the input array

        // Constructor to initialize the Point object
        public Point(int x, int y, int dist, int i) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.i = i;
        }

        // Override the compareTo method to enable sorting Points by distance
        @Override
        public int compareTo(Point p2) {
            return this.dist - p2.dist; // Ascending order sorting based on distance
        }
    }

    // Method to find the k closest points to the origin
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(); // Min-heap to store Points

        // Iterate through each point in the input array
        for (int i = 0; i < points.length; i++) {
            // Calculate the squared distance from the origin
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            // Add the point to the priority queue
            pq.add(new Point(points[i][0], points[i][1], dist, i));
        }

        int[][] ans = new int[k][]; // Array to store the k closest points
        // Retrieve the k closest points from the priority queue
        for (int i = 0; i < k; i++) {
            Point point = pq.remove(); // Remove the point with the smallest distance
            ans[i] = new int[]{points[point.i][0], points[point.i][1]}; // Store the point in the answer array
        }
        return ans; // Return the k closest points
    }

    // Main method to test the Solution class
    public static void main(String[] args) {
        Solution sol = new Solution();
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
