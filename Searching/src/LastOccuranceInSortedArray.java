
public class LastOccuranceInSortedArray {
	
	
	

	
	public static void main(String[] args) {
		
		
		int arr[] = {1,2,3,3,3,4,4,5,6,6,7,  8,  8,  8,  8,  8,  8,  10} ;
		//           0,1,2,3,4,5,6,7,8,9,10, 11, 12, 13, 14, 15, 16  17
		int k = 8;
		int lastocurranceIndex =   LastoccuranceIndex(arr , arr.length , k);
		
		System.out.println("===>" +lastocurranceIndex);
		
	}

	 static int LastoccuranceIndex(int[] arr, int length, int k) {

		 int low = 0 ;
		 int high = length-1 ;
		 
		 int ans = -1 ;
		 
		 while(low <= high)
		 {
			 int mid = low + (high - low)/2 ;
			 if(arr[mid] == k)
			 {
				 ans = mid ; // int could be last occurance we save it
				 low  = mid + 1 ;
				 
			 }
			 if( arr[mid] >k)
			 {
				 high = mid -1 ;
			 }
			 else
			 {
				 low = mid + 1 ;
			 }
			 
		 }
			 
		 
		 
		return ans;
	}
}
