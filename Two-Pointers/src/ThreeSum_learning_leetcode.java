import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/3sum/submissions/895508332/

// This Code is not for leetcode . Its for undertsanidng 
public class ThreeSum_learning_leetcode {

	public static void main(String[] args) {
		int[] nums1 = { 8, -1, 3, 2, 1, 7, 9, 15 };
		int target1 = 0;
		System.out.println("Input: nums = " + Arrays.toString(nums1));
		System.out.println("Target: " + target1);
		System.out.println("Output: " + threeSum(nums1, target1));
		System.out.println();

		int[] nums2 = { -1, 0, 1, 2, -1, -4 };
		int target2 = 0;
		System.out.println("Input: nums = " + Arrays.toString(nums2));
		System.out.println("Target: " + target2);
		System.out.println("Output: " + threeSum(nums2, target2));
		System.out.println();

		int[] nums3 = { 0, 1, 1 };
		int target3 = 0;
		System.out.println("Input: nums = " + Arrays.toString(nums3));
		System.out.println("Target: " + target3);
		System.out.println("Output: " + threeSum(nums3, target3));
		System.out.println();

		int[] nums4 = { 0, 0, 0 };
		int target4 = 0;
		System.out.println("Input: nums = " + Arrays.toString(nums4));
		System.out.println("Target: " + target4);
		System.out.println("Output: " +threeSum(nums4, target4));
		System.out.println();
		
		
		int[] nums5 = { 0, 0, 0,0};
		int target5 = 0;
		System.out.println("Input: nums = " + Arrays.toString(nums5));
		System.out.println("Target: " + target5);
		System.out.println("Output: " +threeSum(nums5, target5));
		System.out.println();
		
	
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

	public static List<List<Integer>> threeSum(int[] nums, int target) {
		
		  List<List<Integer>> allTripletsResult = new ArrayList<>();
		Arrays.sort( nums);
		//System.out.println("Sorted Array:"+Arrays.toString(nums));
		boolean triplesExits = false ;
		for (int i = 0; i < nums.length - 2; i++) {
			int ComplementarySum = target - nums[i];

			int result[] = twoSum_twoPointers(nums, ComplementarySum, i + 1);

			int sum = nums[i] + result[0] + result[1];
			//System.out.println(sum + "==ComplementarySum=> "+ComplementarySum);

			if (sum == target) 
			{
		     List triplets = new ArrayList<>() ;
		     triplets.add(nums[i])  ;
		     triplets.add(result[0] )  ;
		     triplets.add(result[1])  ;
		     allTripletsResult.add(triplets);
		     triplesExits = true;
				
				//return new int[] { nums[i], result[0], result[1] };

			}

		}
		
		if(!triplesExits)
		{
		     List triplets = new ArrayList<>() ;
	     	 triplets.add(-1)  ;
	     	 triplets.add(-1)  ;
	     	 triplets.add(-1)  ;
	     	 allTripletsResult.add(triplets) ;	
			return  allTripletsResult;
		}
		
	return  allTripletsResult;
		

	}

	///
	
	//Brute Force
	  public static List<List<Integer>> triplet( int[] arr ,int target)  //target = 0
	  {
	       int n = arr.length ;
	        Set<List<Integer>> st = new HashSet<>();

	        // check all possible triplets:
	        for (int i = 0; i < n; i++) {
	            for (int j = i + 1; j < n; j++) {
	                for (int k = j + 1; k < n; k++) {
	                    if (arr[i] + arr[j] + arr[k] == target) {
	                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
	                        temp.sort(null);
	                        st.add(temp);
	                    }
	                }
	            }
	        }

	        // store the set elements in the answer:
	        List<List<Integer>> ans = new ArrayList<>(st);
	        return ans;
	    }
}
