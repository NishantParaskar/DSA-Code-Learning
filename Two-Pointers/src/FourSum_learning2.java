import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

//https://leetcode.com/problems/3sum/submissions/895508332/

// This Code is not for leetcode . Its for undertsanidng 
public class FourSum_learning2 {

	public static void main(String[] args) {
		int[] nums1 = { 8, -1, 3, 2, 1, 7, 9, 15 };
		int target1 = 17;
		System.out.println("Nums:"+Arrays.toString(nums1) );
		System.out.println("Target:"+ target1 );		
		System.out.println("Output:" + Arrays.toString(fourSum(nums1, target1)));
		System.out.println("====================================================");
		
		
		int[] nums2 = { 2, 4, 6, 8, 10 };
		int target2 = 16;
		System.out.println("Nums:"+Arrays.toString(nums2) );
		System.out.println("Target:"+ target2 );	
		System.out.println("Output:" + Arrays.toString(fourSum(nums1, target1)));
		System.out.println("====================================================");
		
		
		int[] nums3 = { -5, 0, 10, 5, -3, 4 };
		int target3 = 2;
		System.out.println("Nums:"+Arrays.toString(nums3));
		System.out.println("Target:"+ target3 );	
		System.out.println("Output:" +Arrays.toString(fourSum(nums3, target3)));
		System.out.println("====================================================");
		
		
		int[] nums4 = { 1, 2, 3, 4, 5 };
		int target4 = 9;
		System.out.println("Nums:"+Arrays.toString(nums4) );
		System.out.println("Target:"+ target4 );	
		System.out.println("Output:" + Arrays.toString(fourSum(nums4, target4)));
		System.out.println("====================================================");
		
		System.out.println("====================================================");
		int[] nums5 = { -1, -2, -3, -4, -5 };
		int target5 = -8;
		System.out.println("Nums:"+Arrays.toString(nums5) );
		System.out.println("Target:"+ target5 );	
		System.out.println("Output:" + Arrays.toString(fourSum(nums5, target5)));
		System.out.println("====================================================");
		
	}

	//
	public static int[] twoSum_twoPointers(int[] nums, int target, int leftpt) {
		int n = nums.length;

		int rightpt = n - 1;
		// Sort the array

		// Use two pointers to find the target sum
		while (leftpt < rightpt) {
			int sum = nums[leftpt] + nums[rightpt];
			if (sum == target) {
				return new int[] { nums[leftpt], nums[rightpt] }; // return
																	// values
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

	public static int[] threeSum(int[] nums, int target, int start) {

		// System.out.println("Sorted Array:"+Arrays.toString(nums));

		for (int i = start; i < nums.length - 2; i++) {
			int ComplementarySum = target - nums[i];

			int result[] = twoSum_twoPointers(nums, ComplementarySum, i + 1);

			int sum = nums[i] + result[0] + result[1];
			// System.out.println(sum + "==ComplementarySum=>
			// "+ComplementarySum);

			if (sum == target) {
	
				return new int[] { nums[i], result[0], result[1] };

			}

		}
	
		return new int[] { -1, -1, -1 };

	}

    public static int[] fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
        	
            int complement = target - nums[i];
            int[] threeSumResult = threeSum(nums, complement, i + 1);
            if (threeSumResult[0] != -1 && threeSumResult[1] != -1 && threeSumResult[2] != -1) {
                return new int[] { nums[i], threeSumResult[0], threeSumResult[1], threeSumResult[2] };
            }
        }
        return new int[] { -1, -1, -1, -1 };
    }
}
