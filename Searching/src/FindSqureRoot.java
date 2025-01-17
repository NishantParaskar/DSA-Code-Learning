// take you forward:
public class FindSqureRoot {
	
	
	public static void main(String[] args) {
		int num =  4 ;//25   // 18 // 32
		int ans = FindSqureRoot(num);
		System.out.println("Square root of "+num+ " ====> " +ans );
		
	}

	private static int FindSqureRoot(int num) {

		
		// edge case 
		if(num == 1){  return 1 ;}
		
		int low  =  0 ;   // start from 0 only
		int high =  num ;
		int ans = -1 ;
		
		while(low <= high)
		{
			int mid = ( low + high ) / 2 ;
			
			// Exact Square Root
			if(mid * mid ==  num)
			{   ans = mid ;
				return ans ;
			}
			
			if(mid * mid <=  num)
			{
				ans = mid  ;   // it could be the answer so save it and  check for next greater answer 
				low = mid + 1 ; 
			}
			else
			{
			  high = mid - 1  ;	
			}
			
		}
		
		
		
		return ans  ;
	}

}
