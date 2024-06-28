
public class mySqrt {

	
	public static void main(String[] args) {
	     System.out.println("==================================="+ mySqrt(21)  );
	}
	

	
	  static  int mySqrt(int x) 
   {
       
       // i * i == Mid ===> result 
       // i * i > mid  ===> end   = mid-1 ;
       // i * i < mid  ===> start = mid +1 ;
       
    int start = 1;
    int end = x ;
       
       int result = 0 ;
       while(start <= end)
       {
           System.out.println("===================================");
           int mid =  start  + (end- start) / 2 ;
           	System.out.println("MID : "+ mid);
           if(mid * mid == x)
           {   
               
                 result = mid ;
               return result  ;
           }
            else if(mid * mid > x)
           {  
                 	System.out.println(mid * mid +" : mid * mid > x : "+ x);
              
                end = mid-1 ;
           }
           else if(mid * mid < x)
           {   
                 	System.out.println(mid * mid +" : mid * mid <  : "+ x);
                result = mid ;
                start = mid + 1 ;     
           }
           
              	System.out.println("Start : "+ start);
               System.out.println("End : "+ end);
       }
       
       
       
       return result ;
       
       
   }
}
