import java.lang.reflect.Array;
import java.util.Arrays;

public class AggressiveCows {

	public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;

        int ans1 = AggressiveCowsMaxofMin(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans1);
	}


	private static int AggressiveCowsMaxofMin(int[] stalls, int k) {
		   Arrays.sort(stalls);
		int n = stalls.length;

		Arrays.sort(stalls); // sorrted

		int low = 1;
		int high = stalls[n - 1] - stalls[0]; // not properly understood check
				int ans  = -1 ;								// later
		while (low <= high) {
			int mid = (low + high) / 2;
			if (canWePlace(stalls, mid, k) == true) {
				ans = mid ; // save it and check for the maximum possible
				low = mid + 1; // w

			} else {
				
				high = mid - 1;
			}

		}

		return ans;
	}
	  
	static boolean canWePlace(int stalls[], int distance, int cow) {
		int n = stalls.length;
		int numberofCowsPlace = 1; // no. of cows placed
		int lastCowPlace = stalls[0]; // position of last placed cow.

		for (int checkPlacement = 1; checkPlacement < n; checkPlacement++) {

			if (stalls[checkPlacement] - lastCowPlace >= distance) {
				numberofCowsPlace++; // place next cow.
				lastCowPlace = stalls[checkPlacement]; // update the last location.

			}
			if (numberofCowsPlace >= cow)
			{
				return true;
			}
		}
		return false;

	}

	 

}
