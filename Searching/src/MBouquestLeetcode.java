import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class MBouquestLeetcode {
	
	//Creation of Bouquest is possible or not in given Days
	static boolean possible(int arr[] , int  mid_Day, int m,int k)
	{
		int counter = 0 ;
		int noOfBouquets = 0;
	 for(int i = 0 ; i < arr.length ;i++)
	 {
		  if(arr[i] <= mid_Day) //
		  {
			  counter++ ; //  Adjacent flower in garden bloom to increase counter .
		  }
		  else
		  {
			  noOfBouquets = noOfBouquets + (counter /k) ; // Before Reset save the number of bouquest created from adjacent flower in garden  
		     counter = 0 ;  //  Reset  counter to 0
		  }
		  
		  
	 }
	  noOfBouquets = noOfBouquets + (counter /k) ;  // Remaining the number of bouquest at the end (if any)
	  
	 //Check Minimum k Bouquest are created, more are all expected ? If yes Return true for created , else false: for not created
	  if(noOfBouquets >= m)
	  { 
		  System.err.println("Possible on Day : "+ mid_Day);
		return true ;  
	  }
	  else 
	  {
		  System.err.println("Not Possible on Day : "+ mid_Day);
		  return false ;
	  }
	  
	}
	
	
static	int garden(int arr[]  , int k , int m)
	{

		int n = arr.length ;
		long val = (long) m * k ;
		if(val > n) {  return -1 ;} // impossible case

		
		int min = Arrays.stream(arr).min().getAsInt(); 
	    int max = Arrays.stream(arr).max().getAsInt();
	     System.out.println(min +"="+max);
	    int low = min ;
	    int high = max ;
	    
	    int minAns = -1 ;
	    
	    while(low <= high)
	    {
	    	
	    	int mid = (low + high) / 2 ;
	    	
	    	if(possible(arr, mid, m, k))
	    	{
	    		minAns = mid ; // save it and check for other minimum  Days Or answer (to create m bouquest)
	    		high = mid -1 ;
	    	}
	    	else
	    	{
	    		low = mid + 1 ;
	    	}
	    	
	    }
	    return minAns ;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		int bloomDay[] = {7,7,7,7,13,11,12,7} ; 
		int m = 2 ;
		int k = 3 ;
		
		int minimumDays = garden(bloomDay, k , m);
		
		System.out.println("Minimum Days to Bloom adjacent flower and posible to create the m Bouquets : "+minimumDays);
		
		
	}

}








//Reference :
//Ref : https://www.youtube.com/watch?v=TXAuxeYBTdg
//Ref Code:https://takeuforward.org/arrays/minimum-days-to-make-m-bouquets/

