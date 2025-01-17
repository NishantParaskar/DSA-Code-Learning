
public class FindMinimumiInRotatedSortedArray {
	
	public static void main(String[] args) {
		
		
//		int nums[] = {4 ,5,6,7,0,1,2} ;     // o/p -: 0
//		int nums[] = {7,8,1,2 ,3,4,5,6} ;   // o/p :1 
//		int nums[] = {4 ,5,1,2,3} ;    // o/p : 1 


		int nums[] = {4 ,5,6,7,0,1,2} ; // o/p -: 0
		

		int minimumValue  =Binarysearch(nums)  ;
		System.out.println("Mininmum value is:"+ minimumValue);
	}
	
	  static int  Binarysearch(int nums[])
	    {
	        int n = nums.length;

	       int low = 0 ;
	       int high = n - 1 ;
	       
	        int ans = Integer. MAX_VALUE ; //minimumAnswer
	       while(low <= high)
	       {
	        int mid = (high +low) /2 ;
	            if(nums[low] <= nums[mid])  //when left part is sorted
	            { 
	                ans = Math.min(ans, nums[low]) ;     // it could be the minimum
	                low = mid + 1 ;                 // There could be another min on right side Do Check


	            }
	            else   //when right part is sorted
	            {    high = mid  - 1 ; 
	                ans = Math.min(ans, nums[mid]) ;     // it could be the minimum  
	                           // There could be another min on left side Do Check
	            }
	       } 

	 return ans;

	    }

}


//Logic here is . Check sorted array and take low from it .thats it 
//once sorted array got it then element  other side will be discarded.
 // case 1  :Like sorted arrar is on left (i.e nums[left]  <= nums [mid]) 
            // Discard left side and check into right of mid now for newer Minimum  (if any)
            // low = mid +1 ;       // reduce from left side


 // case 2  :Like sorted arrar is on right side  (i.e nums[mid]  <= nums [right]) 
            // Discard right side and check into left of mid now for newer mininum (if any)
            // high = mid  -1 ;    // reduce from right side            


/*

Summary
Identify Sorted Half: Compare nums[low] with nums[mid] to check if the left half is sorted, otherwise the right half is sorted.
Update Minimum: Update ans with the minimum value encountered in the sorted half.
Narrow Search Range: Adjust low or high to discard the half that cannot contain the minimum element.
Continue Until Found: Repeat until the search range is exhausted, then return the minimum value stored in ans.








*/