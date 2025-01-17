import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//uisng priority Queue
public class KClosestPointstoOriginProblem_Way1 {

	public static int[][] kClosest(int[][] points, int k) {
		// step 1 :Create priority queue
		PriorityQueue<point> pq = new PriorityQueue<>();

		for (int i = 0; i < points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];
			int dist = (x * x) + (y * y);

			// Add the point to the priority queue
			pq.add(new point(x, y, dist, i));
			System.out.println(pq.toString());
		}

		int[][] ans = new int[k][]; // Array to store the k closest points
		// Retrieve the k closest points from the priority queue
		for (int i = 0; i < k; i++) {
			point point = pq.remove(); // Remove the point with the smallest
										// distance
			System.err.println("Removed:" + point);
			// Putting in answer array by fetch Specific indes 0(x ) an 1(y)
			// position

			ans[i] = new int[] { points[point.index][0], points[point.index][1] }; // Store
																					// the
																					// point
																					// in
																					// the
																					// answer
																					// array

		}
		return ans; // Return the k closest points

	}

	public static void main(String[] args) {
		// int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
		// int k = 2;

		int[][] points = { { 1, 3 }, { -2, 2 } };
		int k = 1;
		int[][] result = kClosest(points, k);

		// Print the result
		System.out.println("The " + k + " closest points to the origin are:");
		for (int[] point : result) {
			System.out.println("[" + point[0] + ", " + point[1] + "]");
		}

	}

}

class point implements Comparable {
	int x;
	int y;
	int distFromCenter;
	int index;

	public point(int x, int y, int distFromCenter, int index) {
		super();
		this.x = x;
		this.y = y;
		this.distFromCenter = distFromCenter;
		this.index = index;
	}

	@Override
	public String toString() {
		return "point [x=" + x + ", y=" + y + ", distFromCenter=" + distFromCenter + ", index=" + index + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		point p1 = this;
		point p2 = (point) o;

		return this.distFromCenter - p2.distFromCenter;
	}

}





//https://leetcode.com/problems/k-closest-points-to-origin/

//https://getsdeready.com/courses/design-dsa-combined/lesson/k-closest-points-to-origin-2/
//i wrote explianation https://docs.google.com/document/d/1wkXP6fSrIrNEDFPB-Jng-fuobxT6Sh0APODb_PXws5U/edit  