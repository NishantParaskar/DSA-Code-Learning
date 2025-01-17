

public class BinarySearchFloorProblem {

	public static void main(String[] args) {
		// Lower Bound Condition : arr[index] >= X

//		int arr[] = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
//		int X = 9;  
		
		
//		int arr[] = { 10,20,30,40,50 };
//		int X = 25;  
		
//		int arr[] = { 1 ,4 ,7 ,8 ,10 };
//		int X = 7;  
		
		int arr[] = { 1 ,4,5,6 ,7 ,8 ,9,10,14,16,18,22,30,44,50,57,60};
		int X = 43;  

		//opposite of Lowe Bound Problem
		int UBindex = BinarySearch_FloorProblem(arr, X);
	
		System.out.println("Upper Bound of " + X + " is  : " + UBindex +". Value is :"+ arr[UBindex]);

	}

	static int BinarySearch_FloorProblem(int[] arr, int X) {
		
		int ans = arr.length  ; // Hypothetical intialization
		
		int low = 0 ;
		int high = arr.length -1;
		
		while(low <=  high)
		{
			int mid = low + (high - low) / 2 ;
			
			
			//Case 1 :It could be the LoweBound . bit we check and try for other lesser Lower Bound.and Check in left side 
			if(arr[mid] <= X)
			{
				  ans = mid ; // update ans first . because it could be last Lower Bound Index.
		
					low = mid + 1 ; //
			}
			//Case 2 :It can note  be the LoweBound . So change the search space and check in right side 
			else
			{
				  high = mid - 1 ;
			}	
		}
		
		return ans;

	}

}





