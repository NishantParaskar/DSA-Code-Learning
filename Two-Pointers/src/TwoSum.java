import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description/

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
        // Uncomment the brute force approach to test it
        // return twoSum_brutforce(nums, target);
        return twoSum_twoPointers(nums, target);
    }

    // Brute Force Approach
    public int[] twoSum_brutforce(int[] nums, int target) {
        int n = nums.length;
        int result[] = new int[2];

        // Iterate through each pair of elements
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if the sum of the pair equals the target
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        // Return {-1, -1} if no solution is found
        return new int[] { -1, -1 };
    }

    // Optimized Approach using a HashMap
    public static int[] twoSum_twoPointers(int[] nums, int target) {
        int n = nums.length;
        // HashMap to store the indices of the elements
        Map<Integer, Integer> storeIndexes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            storeIndexes.put(nums[i], i);
        }

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            // Check if the complement exists in the map and is not the same element
            if (storeIndexes.containsKey(complement) && storeIndexes.get(complement) != i) {
                return new int[] { i, storeIndexes.get(complement) };
            }
        }
        // Return {-1, -1} if no solution is found
        return new int[] { -1, -1 };
    }


    
    // as sorting is used to index location is change
    // This code is not indend to return to Indexes.
    //This Code return(X,Y) Values X + Y= Target
    public static int[] twoSum_twoPointers_(int[] nums, int target) {
        int n = nums.length;
        int leftpt = 0;
        int rightpt = n - 1;

        // Sort the array
        Arrays.sort(nums);

        // Use two pointers to find the target sum
        while (leftpt < rightpt) {
            int sum = nums[leftpt] + nums[rightpt];
            if (sum == target) {
                return new int[] { nums[leftpt], nums[rightpt] }; // return values
            }
            if (sum < target) {
                leftpt++;
            }
            if (sum > target) {
                rightpt--;
            }
        }
        return new int[] { -1, -1 }; // Return if no solution found
    }

    
    // Main method to test edge cases
    public static void main(String[] args) {
     

        // Edge case 1: Normal case with positive numbers
        // Expected result: [0, 1]
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        printResult(nums1, target1, twoSum_twoPointers(nums1, target1));

        // Edge case 2: Negative numbers
        // Expected result: [0, 2]
        int[] nums2 = {-3, 4, 3, 90};
        int target2 = 0;
        printResult(nums2, target2, twoSum_twoPointers(nums2, target2));

        // Edge case 3: No solution
        // Expected result: [-1, -1]
        int[] nums3 = {1, 2, 3, 4};
        int target3 = 8;
        printResult(nums3, target3,  twoSum_twoPointers(nums3, target3));

        // Edge case 4: Multiple pairs
        // Expected result: [0, 1] or [2, 3]
        int[] nums4 = {3, 3, 4, 4};
        int target4 = 6;
        printResult(nums4, target4, twoSum_twoPointers(nums4, target4));

        // Edge case 5: Single element array
        // Expected result: [-1, -1]
        int[] nums5 = {1};
        int target5 = 2;
        printResult(nums5, target5, twoSum_twoPointers(nums5, target5));

        // Edge case 6: Array with duplicate elements
        // Expected result: [3, 4]
        int[] nums6 = {1, 2, 3, 4, 4};
        int target6 = 8;
        printResult(nums6, target6, twoSum_twoPointers(nums6, target6));
    }

    // Helper method to print results
    private static void printResult(int[] nums, int target, int[] result) {
        System.out.print("nums: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\ntarget: " + target);
        System.out.print("result: ");
        if (result[0] == -1) {
            System.out.println("No solution found.");
        } else {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        }
        System.out.println("---------------------------");
    }
    

}




/* Expliantions:
 
 
 
 
 */


