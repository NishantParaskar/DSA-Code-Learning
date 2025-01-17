import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/3sum/submissions/895508332/

// This Code is not for leetcode . Its for undertsanidng 
public class ThreeSum_learningTUF {

	public static void main(String[] args) {

		// int[] nums1 = { 8 ,-1 , 3, 2 ,1 ,7, 9, 15, };
		// int target1 = 17;

		int[] nums1 = { 8, -1, 3, 2, 1, 7, 9, 15 };
		int target1 = 17;
		System.out.println(target1 + "==>" + triplet(nums1, target1));

		int[] nums2 = { 2, 4, 6, 8, 10 };
		int target2 = 16;
		System.out.println(target2 + "==>" + triplet(nums2, target2));

		int[] nums3 = { -5, 0, 10, 5, -3, 4 };
		int target3 = 2;
		System.out.println(target3 + "==>" + triplet(nums3, target3));

		int[] nums4 = { 1, 2, 3, 4, 5 };
		int target4 = 9;
		System.out.println(target4 + "==>" + triplet(nums4, target4));

		int[] nums5 = { -1, -2, -3, -4, -5 };
		int target5 = -8;
		System.out.println(target5 + "==>" + triplet(nums5, target5));
	}

	
	// Approch 1 :Brute Force : TUF
	public static List<List<Integer>> triplet1(int[] arr, int target) {
		int n = arr.length;
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

	//https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
	// Approch 2 : Most optimize : No HashSet is used here   : TUF
		 public static List<List<Integer>> triplet(int[] arr , int  target) {
	Arrays.sort(arr);
			List<List<Integer>> Result = new ArrayList<>();

			int n = arr.length;
			for (int i = 0; i < n - 2; i++) {
				// Avoid same duplicate Triplete starting from same Index . because
				// it will create same triple second time
				if (i > 0 && arr[i] == arr[i - 1]) {

					continue;
				} else {
					int low = i + 1;
					int high = n - 1;
					int TargetSum = 0 - (arr[i]); // a + b + c = 0 ===> (B+c) = (0 - a)   i.e (B+c) = -(a)
													// ;

					while (low < high) {

						int b = arr[low];
						int c = arr[high];

						int BplusC = arr[low] + arr[high];
	                    // i,e  TargetSum 
						if (TargetSum == BplusC) {
							Result.add(Arrays.asList(arr[i], arr[low], arr[high]));

							// Avoid Same Duplicate for b (i.e low)
							while (low < high && arr[low] == arr[low + 1]) {
								low++;
							}
							// Avoid Same Duplicate for c (i.e high)
							while (low < high && arr[high] == arr[high - 1]) {
								high--;
							}

							// In general , for next b and c we have to increase low
							// and high
							low++;
							high--;
						}
	                    	else if(BplusC< TargetSum)
						{
							low++;
						}
						else
						{
							high--;
						}

					}

				}

			}

			return Result;

		}
		 
		 
		 
		 
		 //Approch 3==========================Three Sum Using two Sum  (With extra Space of Set  )================================
		 public static List<List<Integer>> threeSum_helper(int[] nums, int target) {
		        Set<List<Integer>> allTripletsResult = new HashSet<>();
		        Arrays.sort(nums);

		        for (int i = 0; i < nums.length - 2; i++) {


		            int complementarySum = target - nums[i];
		            List<List<Integer>> pairs = twoSum_twoPointers(nums, complementarySum, i + 1);

		            for (List<Integer> pair : pairs) {
		                List<Integer> triplet = new ArrayList<>(pair);
		                triplet.add(0, nums[i]);
		                allTripletsResult.add(triplet);
		            }
		        }
		        return new ArrayList<>(allTripletsResult);
		    }

		 public static List<List<Integer>> twoSum_twoPointers(int[] nums, int target, int leftpt) {
		        Set<List<Integer>> allPairs = new HashSet<>();
		        int rightpt = nums.length - 1;

		        while (leftpt < rightpt) {
		            int sum = nums[leftpt] + nums[rightpt];
		            if (sum == target) {
		                allPairs.add(Arrays.asList(nums[leftpt], nums[rightpt]));
		                leftpt++;
		                rightpt--;

		            } else if (sum < target) {
		                leftpt++;
		            } else {
		                rightpt--;
		            }
		        }
		        return new ArrayList<>(allPairs);
		    }
		 
		 
		 //Approch 4 :==================== Three Sum (With extra Space of Set  ) =====================================
		   public List<List<Integer>> threeSum(int[] nums) {

			   int arr[] = new int[3] ;

			   int startPt = 0 ;

			   Arrays.sort(nums) ;
			   Set<List<Integer>>  list = new HashSet() ;  // there might a possiblity of having muliple same tripltes so avoid that we use set .
			   List<Integer> ls = new ArrayList() ;
			   while(startPt <nums.length-2  )  // TC : O(N)
			   {
			   int middlePt = startPt +1 ;
			   int endpt = nums.length -1  ;


			       while(middlePt < endpt)  // TC : O(N)
			       {
			           int midPtEndpt =nums[middlePt] +    nums[endpt]  ;
			           int result = nums[startPt] +   nums[middlePt] +    nums[endpt]  ;

			           if(result == 0)
			           {
			             /// System.out.println(result + "||| startpt: "+nums[startPt] + "midpt :  " +nums[middlePt]   +" Endpt : "+ nums[endpt] );
			              list.add(Arrays.asList(nums[startPt] ,nums[middlePt] ,nums[endpt])  ) ;
			      
			              
			           }
			           if(result <0  )
			           {
			                middlePt++ ;
			           }
			           else
			           { 
			               endpt-- ;
			           }

			       }


			       startPt++ ;
			    

			   }


			    return  new ArrayList<>(list) ;

			           
			           
			       }

		   
}
