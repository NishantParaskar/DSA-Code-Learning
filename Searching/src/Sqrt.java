
public class Sqrt {
	
	
   // having long internall : Coding ninja
//https://www.naukri.com/code360/problems/square-root-integral_893351?leftPanelTab=0%3Futm_source%3Dyoutube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries&leftPanelTabValue=PROBLEM
	static int mySqrt1(long x) {

	     long left = 1 ;
	     long right = x;
	     long ans =0 ;
	     while(left <= right)
	     {
	       long mid = left + (right - left) /2 ;
        long val = mid * mid ;


	         if(val <=x  )
	        {
				ans =  mid ;   // it could be the answer . So saved it 	
	            left =  mid + 1 ;  
  			}
	        else
	        {  
				
	             right  = mid - 1 ;  // here can never be answer
	      
	        }

	     }
	return (int)ans ;   

	    }

	
//getSDE READY SHEET: GeeksForgeeks
//link:	
//https://www.geeksforgeeks.org/problems/square-root/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
	long mySqrt2(long x) {

	     long left = 1 ;
	     long right = x;
	     long ans =0 ;
	     while(left <= right)
	     {
	       long mid = left + (right - left) /2 ;
       long val = mid * mid ;


	         if(val <=x  )
	        {
				ans =  mid ;   // it could be the answer . So saved it 	
	            left =  mid + 1 ;  
 			}
	        else
	        {  
				
	             right  = mid - 1 ;  // here can never be answer
	      
	        }

	     }
	return ans ;   

	    }
	
	
	//Coding ninja
	//https://www.naukri.com/code360/problems/square-root-integral_893351?leftPanelTab=0%3Futm_source%3Dyoutube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries&leftPanelTabValue=SUBMISSION
	static int mySqrt(int x) {

	     int left = 0 ;
	     int right = x;
	     int mid = 0 ;
	     int ans =0 ;
	     while(left <= right)
	     {
	        mid = left + (right - left) /2 ;
	        if((long)  mid * mid <= x   &&  (long)( mid + 1) * ( mid+1 ) > x)
	        {
	             return mid ;
	        }

	         if((long) mid * mid >  x    )
	        {   
	             right  = mid - 1 ;  // here can never be answer
	        }
	        else
	        {  
	            ans = mid ; // lower could be the answer  so store it
	            left =  mid + 1 ;
	        }

	     }
	return ans ;   

	    }
	
	public static void main(String[] args) {
		
		System.err.println("Square root of :28 is "+ mySqrt(28));
		System.err.println("Square root of :25 is "+ mySqrt(25));
		System.err.println("Square root of :16 is "+ mySqrt(16));
		System.err.println("Square root of :18 is "+ mySqrt(18));
		System.err.println("Square root of :25 is "+ mySqrt(25));
		System.err.println("Square root of :42 is "+ mySqrt(42));
		System.err.println("Square root of :36 is "+ mySqrt(36));
		
	}
}




//refernce : https://www.youtube.com/watch?v=Bsv3FPUX_BA&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=11
