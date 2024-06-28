
public class firstOccuranceInSortedArray {

	
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,3,3,4,4,5,6,6,7,  8,  8,  8,  8,  8,  8,  10} ;
		//           0,1,2,3,4,5,6,7,8,9,10, 11, 12, 13, 14, 15, 16  17
	
		int k = 4;
		int index = firstOccuranceInSortedArray(arr , arr.length , k )  ;
		
		 System.out.println("=================Result=============");
		System.out.println(k +" : First Occurance is :" + index);
		
		
	}

	static int firstOccuranceInSortedArray(int[] arr, int length, int k) 
	{
		int low   = 0   ;
		int high  = arr.length -1 ;
		int ans = -1 ;
		
		while(low <= high)
 		{	  System.out.println("========================================");
		  int  mid = low + (high - low) / 2  ;
		  System.out.println("Low: "+low);
		  System.out.println("High: "+high);
		  System.out.println("Mid: "+mid);
	
		  
		  
		  if(arr[mid] == k)
		  {
			  System.out.println("Mid: "+mid);
			  ans = mid ; // it could be the index
			  high = mid -1 ;    // nect look for left again
			  System.out.println("Mid:High change "+high);
		  }
		  
		  if(arr[mid] > k)
		  {
			  high = mid -1 ;
			  System.out.println("High change "+high);
		  }
		  else if (arr[mid] < k)   // use else if Because of Duplicates it has some issue
		  {
			low = mid + 1;  
			  System.out.println("low change "+low);
		  }
		  
		
		}
		
		return ans;
	}
	
}
