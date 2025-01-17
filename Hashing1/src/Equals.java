import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.interviewbit.com/problems/equal/hints/
//https://getsdeready.com/courses/design-dsa-combined/lesson/equal-2/
public class Equals {

	public static void main(String[] args) {

		// 0 1 2 3 4 5 6
		// int arr[] = {3, 4, 7, 1, 2, 9, 8} ;
		int arr[] = { 0, 0, 1, 0, 2, 1 };
		System.out.println("=================MY====================");
		int output[] = equal(arr);
		System.out.println(Arrays.toString(output));
		System.out.println("=================chatgpt====================");
		int output1[] = equal1(arr);
		System.out.println(Arrays.toString(output1));

		int output01[] = equal01(arr);
		System.out.println(Arrays.toString(output01));
		System.out.println("================My 2=====================");
		System.out.println(equal2(arr));
		System.out.println("=================MY 3 optimize====================");
		int outputequal_optimize[] = equal_optimize(arr);
		System.out.println(Arrays.toString(outputequal_optimize));

	}

	public static int[] equal_optimize(int[] arr) {

		HashMap<Integer, List<Integer>> pairs = new HashMap();
		int[] result = null;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				// The last Pair will this we have to check for the is the any
				// pair add already i.e(a,b)
				int c = i;
				int d = j;

				int sum = arr[c] + arr[d];
				if (pairs.containsKey(sum)) {
					System.out.println("found=" + pairs);

					// found Existing pair (i.e first Pair)
					int a = pairs.get(sum).get(0); // first pair
					int b = pairs.get(sum).get(1);
					; // first pair
					c = i; // second Pair
					d = j; // second Pair

					// if(a < b && c<d && a<c && b!=d && b !=c )
					// This index of first pair (a, b) should not match with
					// seconde pair(c,d)
					// also pair first(a,b) indices is less then second(c ,d)
					if (a != c && a != d && b != c && b != d && c < d && a < b) {
						System.err.println("found=");
						int[] candidate = { a, b, c, d };
						if (result == null || compareTuples(candidate, result) < 0) {
							result = candidate;
						}

					}

				} else {

					pairs.put(sum, Arrays.asList(i, j));
					System.out.println("New=" + pairs);
				}

			}

		}

		return result;

	}

	// to check lex order
	private static int compareTuples(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return a[i] - b[i]; // return Positive value of or negative
			}
		}

		return 0;
	}

	// Brute force
	// As question is requirement
	// This solution is to find two pair but in order i < j && k < l (i + j == k
	// + l ) i j k l are unique index
	public static int[] equal01(int[] arr) {
		int n = arr.length;
		int[] result = null;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (k == i || k == j) {
						System.out.println("i:" + i + " j :" + j + " k:" + k + "==continue");
						continue;
					}
					;
					for (int l = k + 1; l < n; l++) {
						if (l == i || l == j) {
							System.out.println("i:" + i + " j :" + j + " k:" + k + " l:" + l + "==continue");
							continue;
						}
						;
						if (arr[i] + arr[j] == arr[k] + arr[l]) {
							System.err.println("i:" + i + " j :" + j + " k:" + k + " l:" + l);
							int[] candidate = { i, j, k, l };
							if (result == null || compareTuples(candidate, result) < 0) {
								result = candidate;
							}
						}
					}
				}
			}
		}

		return result == null ? new int[] {} : result;
	}

	// ====================================================================================

	// Brute Force Approch : O(n^4) . Single pair
	// For understanding only. As question is requirement is different
	// This solution is to find two pair but in order i < j < k < l
	private static int[] equal(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				for (int k = j + 1; k < arr.length; k++) {

					for (int l = k + 1; l < arr.length; l++) {

						if (arr[i] + arr[j] == arr[k] + arr[l]) {
							return new int[] { i, j, k, l };

						}

					}
				}
			}
		}

		return new int[] {};
	}

	// For understanding only. As question is requirement is different
	// This solution is to find two pair but in order i < j < k < l
	// Ensure that for each pair ( 𝑖 , 𝑗 ) (i,j), we find pairs ( 𝑘 , 𝑙 )
	// (k,l) such that 𝑖 < 𝑗 < 𝑘 < 𝑙 i<j<k<l.
	// We need to check for all combinations of ( 𝑖 , 𝑗 ) (i,j) and ( 𝑘 , 𝑙
	// )
	// (k,l) pairs without reusing the same indices and ensuring 𝑘 > 𝑗 k>j.

	public static int[] equal1(int[] arr) {
		int n = arr.length;
		int[] result = null;

		// Iterate over all pairs (i, j)
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// Iterate over all pairs (k, l) such that k > j
				for (int k = j + 1; k < n; k++) {
					for (int l = k + 1; l < n; l++) {
						// Check if the sum of pairs (i, j) and (k, l) are equal
						if (arr[i] + arr[j] == arr[k] + arr[l]) {
							int[] candidate = { i, j, k, l };
							if (result == null || compareTuples(candidate, result) < 0) {
								result = candidate;
							}
						}
					}
				}
			}
		}

		return result == null ? new int[] {} : result;
	}

	// Brute Force Approch : O(n^4) . All pair
	// For understanding only. As question is requirement is different
	// This solution is to find two pair but in order i < j < k < l
	private static List<List<Integer>> equal2(int[] arr) {
		List<List<Integer>> output = new ArrayList();

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				for (int k = j + 1; k < arr.length; k++) {

					for (int l = k + 1; l < arr.length; l++) {

						if (arr[i] + arr[j] == arr[k] + arr[l]) {
							List<Integer> pair = new ArrayList();
							output.add(Arrays.asList(i, j, k, l));

						}

					}
				}
			}
		}

		return output;
	}

	// Optimizing the

}
