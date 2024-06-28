import java.util.Arrays;

public class MinimumNumberofDaystoMakeMBouquets {
	
	
	//Brute Force Approch
	 static public int minDays(int[] bloomDay, int m, int k) {
		 
		 if((m*k)> bloomDay.length){ return -1   ;} 
			int min = Arrays.stream(bloomDay).min().getAsInt() ;
			int max = Arrays.stream(bloomDay).max().getAsInt()  ;
			
			int left = min ;
			int right = max;
			int mid  = 0 ;
			int ans = 0 ;
			while(left <= right)
			{
				mid  = left + (right - left)/2 ;
				boolean possible = minDays_HelperFunction(bloomDay, mid , m, k) ;
				
				if(possible)
				{   ans = mid  ;
					right = mid -1 ;
				}
				else
				{
					left = mid + 1 ;
				}	
			}
			
		 return ans; 
	    }
	
	
	
	
	
	
	//Brute Force Approch
	 static public int BTForce_minDays(int[] bloomDay, int m, int k) {
			int min = Arrays.stream(bloomDay).min().getAsInt() ;
			int max = Arrays.stream(bloomDay).max().getAsInt()  ;
			 
			 for (int i = min; i <=max; i++) 
			 {
				 boolean possible = minDays_HelperFunction(bloomDay, i, m, k) ;
				 if(possible)
				 {
					 return i ;
				 }
				 else
				 {
					  // check for next ith element
				 }		 
			 }
		 return -1; 
	    }
	
	 // helper Function
	 static boolean minDays_HelperFunction(int[] bloomDay, int onith_Day, int m, int k)
	 {
		 int count = 0 ; 
		 int numberOfBouquests = 0;
		 
	    for (int i = 0; i < bloomDay.length; i++) 
	    {
	    	if( bloomDay[i]  <= onith_Day)
	    	{
	    		count++ ;
	    	}
	    	else
	    	{
	    		numberOfBouquests =numberOfBouquests + count /k ;
	    		count = 0 ;
	    	}
			
		}
	    numberOfBouquests =numberOfBouquests + count /k ;  
		
		if(numberOfBouquests >= m ) // more Bouquest creation is Okay 
		{
			return true;
		}
		else
		{
			return false  ;   //less  Bouquest creation is not okay so false
		}
		
	
	 }
	 
	
	
	public static void main(String[] args) {
		
//		int bloomDay[] = new int[]{1,10,3,10,2} ;
//	    int m = 3 ;
//		int k = 1;  //3
		
//		int bloomDay[] = new int[]{1,10,3,10,2} ;
//	    int m = 3 ;
//		int k = 2;  //-1
		
		int bloomDay[] = new int[]{7,7,7,7,12,7,7} ;
	    int m = 2 ;
		int k = 3;   // 12
		
	
		
		System.out.println(minDays(bloomDay , m , k) );
		
		
		
	}

}
