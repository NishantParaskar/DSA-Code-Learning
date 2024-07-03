class maximumDifference {
    public int maximumDifference(int[] nums) {
        // Initialize min to the first element and maxDiff to -1
        int min = nums[0];
        int maxDiff = -1;
        int max = Integer.MIN_VALUE;

        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is greater than min, calculate the difference
            if (nums[i] > min) {
                int diff = nums[i] - min;
                if (diff > maxDiff) {
                    maxDiff = diff;
                    max = nums[i];
                }
            } else {
                // Update min if current element is smaller
                min = nums[i];
            }
        }

        // Print min and max details
        if (maxDiff != -1) {
            System.out.println("Minimum Value: " + min);
            System.out.println("Maximum Value: " + max);
        } else {
            System.out.println("No valid pair found (all elements are in non-increasing order)");
        }

        // Return the maximum difference found or -1 if no such pair exists
        return maxDiff;
    }

    public static void main(String[] args) {
    	maximumDifference sol = new maximumDifference();

        // Test cases
        int[] testCase1 = {7, 1, 5, 4};
        int[] testCase2 = {9, 4, 3, 2};
        int[] testCase3 = {1, 5, 2, 10};
        int[] testCase4 = {1, 2, 3, 4, 5};
        int[] testCase5 = {5, 1, 2, 10, 9};

        // Print the results of the test cases
        System.out.println("TestCase1:");
        System.out.println("Maximum Difference: " + sol.maximumDifference(testCase1)); // Expected: 4
        System.out.println();

        System.out.println("TestCase2:");
        System.out.println("Maximum Difference: " + sol.maximumDifference(testCase2)); // Expected: -1
        System.out.println();

        System.out.println("TestCase3:");
        System.out.println("Maximum Difference: " + sol.maximumDifference(testCase3)); // Expected: 9
        System.out.println();

        System.out.println("TestCase4:");
        System.out.println("Maximum Difference: " + sol.maximumDifference(testCase4)); // Expected: 4
        System.out.println();

        System.out.println("TestCase5:");
        System.out.println("Maximum Difference: " + sol.maximumDifference(testCase5)); // Expected: 9
        System.out.println();
    }
}
