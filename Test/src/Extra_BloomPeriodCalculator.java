



import java.util.Arrays;

class Extra_BloomPeriodCalculator{
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int N = flowers.length;
        
        // Arrays to store start and end times of flowers blooming period
        int startArray[] = new int[N];
        int endArray[] = new int[N];
        
        // Populate the start and end arrays
        for (int i = 0; i < flowers.length; i++) {
            startArray[i] = flowers[i][0];
            endArray[i] = flowers[i][1] + 1; // Adjust end day to be the next day to consider the flower still blooming on the end day
        }

        // Sort the start and end arrays
        Arrays.sort(startArray);
        Arrays.sort(endArray);

        // Array to store the result for each person
        int result[] = new int[people.length];

        // Calculate the number of flowers in full bloom for each person's arrival time
        for (int i = 0; i < people.length; i++) {
            int time = people[i];
            int startBloomMax = BloomOrDeadSearch(startArray, time);
            int endBloomMax = BloomOrDeadSearch(endArray, time);
            result[i] = startBloomMax - endBloomMax;
        }
        return result;
    }

    // Helper method to perform binary search  : here we are not returing index . but returing the elements 
    int BloomOrDeadSearch(int arr[], int time) {
        int left = 0, right = arr.length - 1;
        int mid = 0;
        
        // Binary search to find the number of times less than or equal to given time
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= time) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    // Main method to execute the test cases
    public static void main(String[] args) {
    	Extra_BloomPeriodCalculator solution = new Extra_BloomPeriodCalculator();

        // Test Case 1
        int[][] flowers1 = {{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        int[] people1 = {2, 3, 7, 11};
        System.out.println(Arrays.toString(solution.fullBloomFlowers(flowers1, people1))); // Output: [1, 2, 2, 2]

        // Test Case 2
        int[][] flowers2 = {{1, 10}, {3, 3}};
        int[] people2 = {3, 3, 2};
        System.out.println(Arrays.toString(solution.fullBloomFlowers(flowers2, people2))); // Output: [2, 2, 1]
    }
}
//On Binary Search on similar question
//Q1: 851. Minimum Interval to Include Each Query
//Q2: 452. Minimum Number of Arrows to Burst Balloons
//Q3: 732. My Calendar III






/*
Algorithm for fullBloomFlowers:
Initialization:

Create two arrays, startArray and endArray, to store the start and end times of each flower's blooming period, respectively.
Populate Arrays:

Iterate through each flower's blooming period.
Assign the start time of the flower to startArray.
Assign the end time of the flower (adjusted to the next day) to endArray.
Sort Arrays:

Sort both startArray and endArray.
Count Flowers in Bloom:

For each person's arrival time:
Perform a binary search on startArray to find the number of flowers that have started blooming by this time (startBloomMax).
Perform a binary search on endArray to find the number of flowers that have stopped blooming by this time (endBloomMax).
Calculate the number of flowers in bloom by subtracting endBloomMax from startBloomMax.
Return Results:

Return an array containing the number of flowers in bloom for each person's arrival time.
*/