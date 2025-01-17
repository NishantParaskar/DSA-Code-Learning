
public class BinarySearchLowerBound {

	public static void main(String[] args) {
		// Lower Bound Condition : arr[index] >= X

		int arr[] = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
		int X = 9;  
		int LBindex = BinarySearchLowerBound(arr, 9);
		System.out.println("Lower Bound of " + X + " is  : " + LBindex);

	}

	static int BinarySearchLowerBound(int[] arr, int X) {
		
		int ans = arr.length  ; // Hypothetical intialization
		
		int low = 0 ;
		int high = arr.length -1;
		
		while(low <=  high)
		{
			int mid = low + (high - low) / 2 ;
			
			
			//Case 1 :It could be the LoweBound . bit we check and try for other lesser Lower Bound.and Check in left side 
			if(arr[mid] >= X)
			{
				  ans = mid ; // update ans first . because it could be last Lower Bound Index.
				  high = mid - 1 ;
			}
			//Case 2 :It can note  be the LoweBound . So change the search space and check in right side 
			else
			{
				low = mid + 1 ; //
			}	
		}
		
		return ans;

	}

}
