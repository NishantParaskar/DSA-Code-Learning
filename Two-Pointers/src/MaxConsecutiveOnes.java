
//https://leetcode.com/problems/max-consecutive-ones/
//TUF
class MaxConsecutiveOnes {
    // Function to find the maximum number of consecutive 1s in an array
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0; // Counter for current sequence of 1s
        int max = 0;   // Maximum length of sequence found

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++; // Increment count if 1 is found
                max = Math.max(max, count); // Update max if current count is greater
            } else {
                count = 0; // Reset count if 0 is found
            }
        }

        return max; // Return the maximum length of consecutive 1s
    }

    public static void main(String[] args) {
    	MaxConsecutiveOnes sol = new MaxConsecutiveOnes();
        
        // Test cases
        int[][] testCases = {
            {1, 1, 0, 1, 1, 1}, // Expected output: 3
            {1, 0, 1, 1, 0, 1}, // Expected output: 2
            {0, 0, 0, 0, 0},    // Expected output: 0
            {1, 1, 1, 1, 1},    // Expected output: 5
            {1, 0, 1, 0, 1, 0}  // Expected output: 1
        };

        // Execute test cases
        for (int[] testCase : testCases) {
            System.out.println("Max consecutive ones in " + java.util.Arrays.toString(testCase) + ": " + sol.findMaxConsecutiveOnes(testCase));
        }
    }
}
