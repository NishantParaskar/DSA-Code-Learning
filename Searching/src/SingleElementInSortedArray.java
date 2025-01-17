
public class SingleElementInSortedArray {

	static int SingleElementInSortedArray(int nums[]) {
		 int n = nums.length ;
		
		// edge case 
		if(n == 1 ){ return nums[0]   ;} 
		if(nums[0] !=nums[1] ){ return nums[0]   ;} 
		if(nums[n-1] != nums[n-2] ){ return nums[n-1]   ;} 
		
		
		
		//in between unique element
		int low = 1 ;
		int high = n-2 ;
		
		while( low <= high)
		{
			int   mid = low +(high - low) / 2 ;
			
			// element found 
			if(   ( nums[mid] != nums[mid +1]  )  &&  (  nums[mid] != nums[mid -1]  )     )
			{
				return nums[mid]  ;   // element found 
			}
			
			// even case || odd case ==> Unique element in right side
			if(   ( mid%2 ==0  && nums[mid] == nums[mid +1]  )  ||  ( mid%2 ==1 && nums[mid] == nums[mid -1]  )     )
			{
				low = mid +1  ; 
			}
			else
			{
				high = mid -1 ;
			}
			
		}

		return -1;
	}

	public static void main(String[] args) {

		int nums[] = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
		int output = SingleElementInSortedArray(nums);
		
		
		System.out.println("single element found :"+output);

	}
}
