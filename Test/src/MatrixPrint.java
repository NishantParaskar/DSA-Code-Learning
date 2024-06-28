
public class MatrixPrint {

	public static void main(String[] args) {
		int[][] flowers = { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } };

		// Iterate through the rows of the 2D array
		for (int i = 0; i < flowers.length; i++) {
			// Iterate through the columns of the current row
			for (int j = 0; j < flowers[i].length; j++) {
				// Print each element followed by a space
				System.out.print(flowers[i][0] + " ");
			}
			// Print a newline after each row
			System.out.println();
		}
		
		
		
		System.out.println("======================================");
		
		// Iterate through the rows of the 2D array
		for (int i = 0; i < flowers.length; i++) {
			// Iterate through the columns of the current row
			for (int j = 0; j < flowers[i].length; j++) {
				// Print each element followed by a space
				System.out.print(flowers[i][1] + 1 +" ");
			}
			// Print a newline after each row
			System.out.println();
		}
	}
}
