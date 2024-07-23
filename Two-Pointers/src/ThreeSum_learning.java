import java.util.Arrays;

//https://leetcode.com/problems/3sum/submissions/895508332/

// This Code is not for leetcode . Its for undertsanidng 
public class ThreeSum_learning {

	public static void main(String[] args) {

	//	int[] nums1 = { 8 ,-1 , 3, 2 ,1 ,7, 9, 15,  };
	//	int target1 = 17;
		
		int[] nums1 = { 8, -1, 3, 2, 1, 7, 9, 15 };
		int target1 = 17;
		System.out.println(target1 +"==>"+Arrays.toString(threeSum(nums1,target1)));

		int[] nums2 = { 2, 4, 6, 8, 10 };
		int target2 = 16;		
		System.out.println(target2 +"==>"+Arrays.toString(threeSum(nums2,target2)));
		
		int[] nums3 = { -5, 0, 10, 5, -3, 4 };
		int target3 = 2;	
		System.out.println(target3 +"==>"+Arrays.toString(threeSum(nums3,target3)));
		
		int[] nums4 = { 1, 2, 3, 4, 5 };
		int target4 = 9;		
		System.out.println(target4 +"==>"+Arrays.toString(threeSum(nums4,target4)));
		
		int[] nums5 = { -1, -2, -3, -4, -5 };
		int target5 = -8;	
		System.out.println(target5 +"==>"+Arrays.toString(threeSum(nums5,target5)));
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

	public static int[] threeSum(int[] nums, int target) {

		Arrays.sort( nums);
		//System.out.println("Sorted Array:"+Arrays.toString(nums));
		
		for (int i = 0; i < nums.length - 2; i++) {
			int ComplementarySum = target - nums[i];

			int result[] = twoSum_twoPointers(nums, ComplementarySum, i + 1);

			int sum = nums[i] + result[0] + result[1];
			//System.out.println(sum + "==ComplementarySum=> "+ComplementarySum);

			if (sum == target) 
			{
				System.out.println("====================================================");
				return new int[] { nums[i], result[0], result[1] };

			}

		}
		System.out.println("====================================================");
		return  new int[] { -1, -1, -1 };

	}

	///
}
