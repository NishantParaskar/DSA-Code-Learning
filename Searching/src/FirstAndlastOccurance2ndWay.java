
//Last occurrence in a sorted array 
//take you forward
//refercne:https://takeuforward.org/data-structure/last-occurrence-in-a-sorted-array/

import java.util.ArrayList;


//TC : O(log2n )  (Log 2n)  == 2 O(log2N)  Using Lower and upper bound
public class FirstAndlastOccurance2ndWay  {

 
    public static void main(String[] args) {
   
        
		int arr[] = {1,2,3,3,3, 4,4,5,6,6, 7,  8,  8,  8,  8,  8,  8,  10} ;
		//           0,1,2,3,4, 5,6,7,8,9, 10, 11, 12, 13, 14, 15, 16  17
	
		int k = -1;
		int firstOccuranceindex = firstOccuranceInSortedArray(arr , arr.length , k )  ;
		// firstOccuranceindex is -1 on then return whole answer -1 -1 . dont waste time in checking the  Last Occurance
		
		
        int lastocurranceIndex =   LastoccuranceIndex(arr , arr.length , k);
		
		System.out.println("===>" +lastocurranceIndex);
		 System.out.println("=================Result=============");
		System.out.println(k +" : First Occurance is :" + firstOccuranceindex);
		System.out.println(k +" : Last  Occurance is :" + lastocurranceIndex);
		
		// Egde case : handle condition edge case when element not found 
		if(firstOccuranceindex == -1)
		{
			System.out.println("Count :"+ (lastocurranceIndex - firstOccuranceindex )); 
		}
		else
		{
			System.out.println("Count :"+ (lastocurranceIndex - firstOccuranceindex +1));
		}
		  
		
	
    }
    
    
    
    
	static int firstOccuranceInSortedArray(int[] arr, int length, int k) 
	{
		int low   = 0   ;
		int high  = arr.length -1 ;
		int first = -1 ;
		
		while(low <= high)
 		{	  System.out.println("========================================");
		  int  mid = low + (high - low) / 2  ;
		  System.out.println("Low: "+low);
		  System.out.println("High: "+high);
		  System.out.println("Mid: "+mid);
	
		  
		  
		  if(arr[mid] == k)
		  {
			  System.out.println("Mid: "+mid);
			  first = mid ; // it could be the first occurance so save it
			  high = mid -1 ;    // nect look for left again
			  System.out.println("Mid:High change "+high);
		  }
		  
		  else if(arr[mid] > k)
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
		
		return first;
	}
	 static int LastoccuranceIndex(int[] arr, int length, int k) {

		 int low = 0 ;
		 int high = length-1 ;
		 
		 int last = -1 ;
		 
		 while(low <= high)
		 {
			 int mid = low + (high - low)/2 ;
			 if(arr[mid] == k)
			 {
				 last= mid ; // int could be last occurance we save it
				 low  = mid + 1 ;
				 
			 }
			 else if( arr[mid] >k)
			 {
				 high = mid -1 ;
			 }
			 else
			 {
				 low = mid + 1 ;
			 }
			 
		 }
			 
		 
		 
		return last;
	}	
    
    
}




//Reference :