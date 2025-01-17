import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumbers {

    public List<Integer> luckyNumbers(int[][] matrix) {
        System.out.println("____________________________________________________________________-");
        List<Integer> luckyNumbers = new ArrayList<>();
        Set<Integer> minRowValues = new HashSet<>();

        // get minimum values from each row
        for (int[] row : matrix) {
            minRowValues.add(Arrays.stream(row).min().getAsInt());
          
        }
        System.out.println("Min in each row : "+minRowValues);

        // Check if the maximum values in each column are
        // in the set of minimum row values
        for (int c = 0; c < matrix[0].length; c++) {
            int max = Integer.MIN_VALUE;
            for (int[] row : matrix) {
           
                max = Math.max(max, row[c]);
                
            }
            System.out.println( "For column " +c  + ". Max is "+ max);
            if (minRowValues.contains(max)) {
                luckyNumbers.add(max);
            }
         
        }

        return luckyNumbers;
    }
    
    
    public static void main(String[] args) {
    	LuckyNumbers solution = new LuckyNumbers();
        
        // Example 1
        int[][] matrix1 = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        };
        System.out.println("Example 1: " + solution.luckyNumbers(matrix1));
        System.out.println();
        
        // Example 2
        int[][] matrix2 = {
            {1, 10, 4, 2},
            {9, 3, 8, 7},
            {15, 16, 17, 12}
        };
        System.out.println("Example 2: " + solution.luckyNumbers(matrix2));
        
        // Example 3
        int[][] matrix3 = {
            {7, 8},
            {1, 2}
        };
        System.out.println("Example 3: " + solution.luckyNumbers(matrix3));
        
        // Example 4
        int[][] matrix4 = {
            {10, 10, 10},
            {5, 7, 10},
            {1, 2, 3}
        };
        System.out.println("Example 4: " + solution.luckyNumbers(matrix4));
        
        // Example 5
        int[][] matrix5 = {
            {3, 5, 6},
            {2, 7, 8},
            {1, 4, 9}
        };
        System.out.println("Example 5: " + solution.luckyNumbers(matrix5));
    }

}

/*
Here's a concise algorithm for finding the lucky numbers in a matrix:

1. Initialize an empty list `luckyNumbers` to store the lucky numbers.
2. Initialize a set `minRowValues` to store the minimum values from each row.
3. Iterate over each row in the matrix:
   - Find the minimum value in the current row.
   - Add this minimum value to `minRowValues`.
4. Iterate over each column in the matrix:
   - Find the maximum value in the current column.
   - Check if this maximum value is present in `minRowValues`.
   - If present, add this maximum value to `luckyNumbers`.
5. Return the list `luckyNumbers` containing all the lucky numbers found.

This algorithm ensures that we identify numbers that are the minimum in their row and the maximum in their column, which defines a "lucky number" in the given matrix.



 */
