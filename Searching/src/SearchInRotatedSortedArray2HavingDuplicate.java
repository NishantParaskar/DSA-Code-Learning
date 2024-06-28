
public class SearchInRotatedSortedArray2HavingDuplicate {

    // using iteration
    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            
            
            if(nums[mid] == nums[low] && nums[mid] == nums[high])
            {
            	high = high -1 ;
            	low  = low + 1  ;
            	continue ;           // eg   { 3, 1 ,2, 3 ,3, 3 ,3 } ;   Mid= 3  . nums[low] = 3 and nums[high] = 3
            }
            
            
            
            
            // Part 1:Array is Sorted from low to mid
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) // target lies in Sorted Array between low to mid
                {
                    // go left
                    high = mid - 1;
                } else // targetr lies in Sorted Array between mid to high
                {
                    // go right
                    low = mid + 1;
                }
            }

            // Part 2 :Array is Sorted from mid to High
            else {
                if (nums[mid] <= target && target <= nums[high]) // target lies in Sorted Array between mid to High
                {
                    // go right
                    low = mid + 1;
                } else // target lies in Sorted Array between low to mid
                {
                    // go left
                    high = mid - 1;
                }
            }
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		
		
		int nums[] = { 3, 1 ,2, 3 ,3, 3 ,3 } ;
		
		int  target =2;
//		int  target =2;
//		int  target =3;
//		int  target =4;
//		int  target =5;
		
		boolean indexfound = search(nums,  target) ; 
		System.out.println("Target "+target+ " found at index : "+ indexfound);
	}
}








//reference : https://www.youtube.com/watch?v=5qGrJbHhqFs&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=5