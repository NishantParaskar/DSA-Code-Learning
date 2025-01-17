
public class SearchInRotatedSortedArray {

    // using iteration
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
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
        return -1;
    }
	
	
	public static void main(String[] args) {
		
		
		int nums[] = {4,5,6,7,0,1,2} ;
		
		int  target = -4 ;
		int indexfound = search(nums,  target) ; 
		System.out.println("Target "+target+ " found at index : "+ indexfound);
	}
}








//reference : https://www.youtube.com/watch?v=5qGrJbHhqFs&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=5