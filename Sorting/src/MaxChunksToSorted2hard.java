
//https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
//get SDE in Sorting advance
//https://getsdeready.com/courses/design-dsa-combined/lesson/max-chunks-to-make-sorted-ii-2/
class MaxChunksToSorted2hard {
    public int maxChunksToSorted(int[] arr) {
        int leftMax[] = new int[arr.length]; // Array to store the maximum value from the left up to each index
        int rightMin[] = new int[arr.length]; // Array to store the minimum value from the right up to each index
        int max = Integer.MIN_VALUE; // Variable to keep track of the maximum value encountered so far
        int min = Integer.MAX_VALUE; // Variable to keep track of the minimum value encountered so far

        // Calculate Left Max
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }

        // Calculate Right Min
        for (int i = arr.length - 1; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            rightMin[i] = min;
        }

        int chunks = 1; // Initialize the number of chunks to 1 (at least one chunk exists)

        // Calculate the number of chunks
        for (int i = 0; i < arr.length - 1; i++) { // Comparing with next so that's why (arr.length - 1)
            if (leftMax[i] <= rightMin[i + 1]) { // If leftMax[i] is less than or equal to rightMin[i + 1], increment chunks
                chunks++;
            }
        }

        return chunks; // Return the total number of chunks
    }

    // Main method to test the functionality
    public static void main(String[] args) {
    	MaxChunksToSorted2hard solution = new MaxChunksToSorted2hard();
        int[] arr = {2, 1, 3, 4, 4};
        int result = solution.maxChunksToSorted(arr);
        System.out.println("Maximum number of chunks: " + result); // Expected output: 4
    }
}
