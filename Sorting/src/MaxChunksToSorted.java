
//https://leetcode.com/problems/max-chunks-to-make-sorted/

//explanation :https://docs.google.com/document/d/1wkXP6fSrIrNEDFPB-Jng-fuobxT6Sh0APODb_PXws5U/edit
class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        // Initialize the maximum value seen so far to the smallest possible integer value
        int max = Integer.MIN_VALUE;
        // Initialize the count of chunks to 0
        int count = 0;
        
        // Iterate through each element in the array
        for (int index = 0; index < arr.length; index++) {
            // Update the maximum value seen so far
            max = Math.max(max, arr[index]);
            
            // If the current index matches the maximum value seen so far
            if (index == max) {
                // Increment the chunk count
                count++;
            }
        }
        
        // Return the total number of chunks
        return count;
    }

    public static void main(String[] args) {
    	MaxChunksToSorted solution = new MaxChunksToSorted();
        
        // Test case 1
       // int[] arr1 = {0, 1, 2, 3, 4, 5};
        int  arr1[] ={2,1,3,4,4};
        System.out.println("Test Case 1: " + solution.maxChunksToSorted(arr1));
        // Expected Output: 6

        // Test case 2
        int[] arr2 = {1, 0, 2, 3, 4};
        System.out.println("Test Case 2: " + solution.maxChunksToSorted(arr2));
        // Expected Output: 4

        // Test case 3
        int[] arr3 = {4, 3, 2, 1, 0};
        System.out.println("Test Case 3: " + solution.maxChunksToSorted(arr3));
        // Expected Output: 1
        
        // Test case 4
        int[] arr4 = {1,0,2,3,4};
        System.out.println("Test Case 3: " + solution.maxChunksToSorted(arr4));
        
        // Test case 5
        int[] arr5 = {5,6,6,6,6,6,6};
        System.out.println("Test Case 3: " + solution.maxChunksToSorted(arr5));
        
        // Test case 6
        int[] arr6 = {2,1,0,4,3,5};
        System.out.println("Test Case 3: " + solution.maxChunksToSorted(arr6));
        
    }
}

//other explain :
//https://www.youtube.com/watch?v=XZueXHOhO5E
