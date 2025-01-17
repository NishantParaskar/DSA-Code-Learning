import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.plaf.synth.SynthSeparatorUI;

//https://leetcode.com/problems/3sum/submissions/895508332/

// This Code is not for leetcode . Its for undertsanidng 
public class FourSum_TUFApproch {

	public static void main(String[] args) {
/*		int[] nums0 = {   1,0,-1,0,-2,2 };
		int target0 = 0 ;
		System.out.println("Nums:"+Arrays.toString(nums0) );
		System.out.println("Target:"+ target0 );		
		System.out.println("Output:" + Arrays.toString(fourSum(nums0, target0)));
		System.out.println("====================================================");
		
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
		System.out.println("Output:" + Arrays.toString(fourSum(nums1, target2)));
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
		*/
		
        int[] nums0 = {1000000000,1000000000,1000000000,1000000000};  // Start Input
        int target0 = -294967296;
        
        /*
         
         System.out.println((int)(1000000000 + 1000000000 + 1000000000));
	  	  System.out.println( -294967296    - (-1294967296)); 
         */
        
        System.err.println("Nums: " + Arrays.toString(nums0));
        System.err.println("Target: " + target0);
        System.err.println("Output: " + fourSum2(nums0, target0));
        System.err.println("====================================================");

/*        int[] nums1 = {1,0,-1,0,-2,2};
        int target1 = 0;
        System.out.println("Nums: " + Arrays.toString(nums1));
        System.out.println("Target: " + target1);
        System.out.println("Output: " + fourSum(nums1, target1));
        System.out.println("====================================================");

        int[] nums2 = {2, 4, 6, 8, 10};
        int target2 = 16;
        System.out.println("Nums: " + Arrays.toString(nums2));
        System.out.println("Target: " + target2);
        System.out.println("Output: " + fourSum(nums2, target2));
        System.out.println("====================================================");

        int[] nums3 = {-5, 0, 10, 5, -3, 4};
        int target3 = 2;
        System.out.println("Nums: " + Arrays.toString(nums3));
        System.out.println("Target: " + target3);
        System.out.println("Output: " + fourSum(nums3, target3));
        System.out.println("====================================================");

        int[] nums4 = {1, 2, 3, 4, 5};
        int target4 = 9;
        System.out.println("Nums: " + Arrays.toString(nums4));
        System.out.println("Target: " + target4);
        System.out.println("Output: " + fourSum(nums4, target4));
        System.out.println("====================================================");

        int[] nums5 = {-1, -2, -3, -4, -5};
        int target5 = -8;
        System.out.println("Nums: " + Arrays.toString(nums5));
        System.out.println("Target: " + target5);
        System.out.println("Output: " + fourSum(nums5, target5));
        System.out.println("====================================================");
    */
	}

	//=============Approch 1 : # pointer with binary search===================
	  public static List<List<Integer>> fourSum(int[] nums, int target) 
    {
		  System.out.println(1000000000+ 1000000000+ 1000000000);
		  
	
       Set<List<Integer>> set = new HashSet();
    	System.out.println(Arrays.toString(nums));
    	Arrays.sort(nums);
    	System.out.println(Arrays.toString(nums));
    	for (int i = 0; i < nums.length; i++)
    	{
    		//System.err.println("iii"+ i);
    		for (int j = i+1 ; j < nums.length; j++)
    		{//System.err.println("jj"+ j);
    			
				for (int k = j+1; k < nums.length; k++) 
				{
				//	System.err.println("kk"+ k);

					long Pointer3Sum = (long)nums[i] + nums[j] + nums[k] ;

					
				//	System.out.println("Pointer3Sum "+Pointer3Sum );
					int remainingSum = (int)(target - (Pointer3Sum) );

						int Find[] =  binarySearch(nums,k+1  ,remainingSum) ;
		

						if(Find[0] == 1  && (Pointer3Sum >Integer.MIN_VALUE   && Pointer3Sum <Integer.MAX_VALUE  )  )
						{
							List temp = (List) Arrays.asList(nums[i], nums[j], nums[k], Find[1]);
						//	return new int[] {nums[i] , nums[j] , nums[j],Find} ; // if we use array
						
	                       set.add(temp);

						}
					
				
					
					
				}
			}
    	
		}
  
		//return  new int[] {-1 , -1 , -1 , -1 } ; // if we use array
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
 
    }
    
	  
	  
    
    
	 static int[] binarySearch(int[] arr,int start ,int target) {
		// TODO Auto-generated method stub
		 int n = arr.length ;
		 int low = start ;
		 int high = arr.length -1 ;
		 
		 while(low <= high)
		 {
			 int mid = low + (high - low) /2 ;
			 
			 if(arr[mid] == target)  // compare with array element
			 {
			//System.out.println(arr[mid]  + "==="+ target);
				  return new int[]{1 ,arr[mid]} ;  // return index 
			 }
			 
			 if( target > arr[mid])  // compare with array element
			 {
				 low = mid + 1 ; 
			 }
			 else
			 {
				 high = mid -1 ; 
			 }
			 
		 }
		 
		  return new int[]{0 ,-1} ;  // // found 
	}


	 
	 
	// =============Approch 3 : without Using Set ======================
	    // Tc : O(n^3 log n)
	    // SC O(1) : here Save the safe by avoiding duplicates uidng conditions
	    public static List<List<Integer>> fourSum2(int[] nums, int target) {
	        List<List<Integer>> ls = new ArrayList();
	        Arrays.sort(nums);

	        for (int i = 0; i < nums.length; i++) {
	            if (i > 0 && nums[i] == nums[i - 1]) {
	                continue;
	            }
	            for (int j = i + 1; j < nums.length; j++) {// System.err.println("jj"+ j);
	                if (j > i + 1 && nums[j] == nums[j - 1]) {
	                    continue;
	                }

	                // a + b + c + d = target
	                // c + d = target - ( a + b )
/*	                long presentNumber = ( long)((nums[i] + nums[j])  );
	                long remainingSum1 = (int)(target - presentNumber);

	                int remainingSum =(int)remainingSum1 ; */
	                int targetSum1 = target -  (nums[i] + nums[j])  ;
	                long targetSum = (long)target - nums[i] - nums[j];
	                
	                
	     
	                System.out.println("targetSum "+ targetSum);


	            
	                    List<List<Integer>> Find = binarySearchModified(nums, j + 1, targetSum ,targetSum1);

	                    for (List<Integer> halfList : Find)
	                     {

	                        if( nums[i] +  nums[j] +  halfList.get(0) +  halfList.get(1)  < Integer.MAX_VALUE &&
	                           nums[i] + nums[j] +  halfList.get(0) + halfList.get(1)  >Integer.MIN_VALUE )
	                        {

	                        }
	                        List fullList = (List) Arrays.asList(nums[i], nums[j], halfList.get(0), halfList.get(1));
	                        ls.add(fullList);
	                    }

	                

	            }

	        }

	        return ls;

	    }

	    static List<List<Integer>> binarySearchModified(int[] arr, int start, long target ,int target1) {
	    	System.out.println("bS int: "+ target1);
	    	System.out.println("bS long: "+ target);
	        List<List<Integer>> Result = new ArrayList<>();
	        // TODO Auto-generated method stub
	        int n = arr.length;
	        int low = start;
	        int high = arr.length - 1;

	        while (low < high) {
	            int sum = arr[low] + arr[high];

	            if (sum == target) // compare with array element
	            {

	                Result.add(Arrays.asList(arr[low], arr[high]));

	                // Avoid Same Duplicate for b (i.e low)
	                while (low < high && arr[low] == arr[low + 1]) {
	                    low++;
	                }
	                // Avoid Same Duplicate for c (i.e high)
	                while (low < high && arr[high] == arr[high - 1]) {
	                    high--;
	                }

	                low++;
	                high--;
	            }

	            else if (target > sum) // compare with array element
	            {
	                low++;
	            } else {
	                high--;
	            }

	        }

	        return Result;
	    }


}
