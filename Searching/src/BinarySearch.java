// Stri
public class BinarySearch {
	public static void main(String[] args) {
		
		int arr[] = {3,4,6,7,9,12,16,17} ;
		int target = 13 ;
		//int target = 6 ;
		
		
		int index =binarySearch(arr , target) ;
	if(index == -1)
	{
		System.out.println("Target is not prenet:"+ index);
	}
	else
	{
		System.out.println("Target is present in array:"+ index);
	}
		
		
	}

	 static int binarySearch(int[] arr, int target) {
		// TODO Auto-generated method stub
		 int n = arr.length ;
		 int low = 0 ;
		 int high = arr.length -1 ;
		 
		 
		 while(low <= high)
		 {
			 int mid = low + (high - low) /2 ;
			 
			 if(arr[mid] == target)  // compare with array element
			 {
			
				  return mid ;  // return index 
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
		 
		 
		return -1 ; // found 
	}
	

}





//take ou Forward
//reference: https://www.youtube.com/watch?v=MHf6awe89xw&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=2
