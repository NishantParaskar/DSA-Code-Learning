
public class kthMissingNumberInArray {
	public static void main(String[] args) {
		
		int arr[] = {2} ;
		int k = 1 ;
		int output = kthMissingNumber(arr , k) ;
		System.out.println(k+"th Missing number is : "+ output);
	}

	private static int kthMissingNumber(int[] arr, int k) 
	{
		int n = arr.length;
		int low = 0 ;
		int high = n-1  ;
		while(low <= high)
		{
			int mid = (low + high) /2 ;
			
			int missing = arr[mid]  - (mid +1) ;
			
		    if(missing < k)
		    {
		    
		    	low = mid + 1 ;
		    	System.out.println("low :"+  low);
		    	
		    }
		    else
		    {
		    	high = mid -1 ;
		    }
		
		}
		
		
		System.out.println("High:"+high +"  low : "+  low);
		return  high +1 +k ;//(low + k);
	}

}