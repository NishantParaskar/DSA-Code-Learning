//https://www.youtube.com/watch?v=cXxmbemS6XM&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=10&pp=iAQB

// tricey Input int nums[] = {1,5,1,2,1};   // tricky input : dip in input
public class FindPeakElement1 {
	/*
	 * case 1 : one elementiin array return  0thn index as Peak 
	 * case 2 : Peak element on Start 
	 * case 3 : Peak element in End
	 * case 4 : Peak element from bewtwenn i = 1 To i = (n-1) ; 
	 */
	
	
	public static void main(String[] args) {
		
		//int nums[] = {1,2,3,4,5,6,7,8,5,1};
		int nums[] = {1,5,1,2,1};   // tricky input : dip in input
		
		int value  = findPeakElement(nums) ;
		System.out.println(" Peak element found at index : "+ value);
		
	}

	 static int findPeakElement(int[] nums) {
	
		 int n=  nums.length;
		 //edge cases
		 if(n == 1 )  {return nums[0];}
		 if( nums[0]  >  nums[1]){ return 0 ;}  // On starting Index  peak is found ;
		 if( nums[n-1] >   nums[n-2]) { return  n-1  ;}   // On Ending Index  peak is found ;
		 
		 
		 // in between 1 to n-2 peak is found ;
		 int low = 1 ;
		 int high = n-2 ;
		 while(low <=  high)
		 {

			 int mid  = low+ (high -low)/2  ;

			 
			 // Peak element : element which greater then its previour element and next element;
			 if(nums[mid]> nums[mid-1] && nums[mid] > nums[mid+1]    )
			 {
				 	return mid ;
			 }
			 // Peak is on Right Side :When No Dip Found
			 else  if(nums[mid] > nums[mid-1])
			 {
				 	low = mid+1 ;
			 }
			 
/*	         Dont use this condition it will fail for input like [1  ,5,1,2,   1]
 * 
 			else if(nums[mid]> nums[mid+1])
			 {
				 high = mid -1 ;
			 }
			 use instead of else if use below else  {  // you can go anywhere left or right it up to you}
			 here for low:5 and mid:1 and high :2
			 1 is  dip between 5 and 2 . No condition is excuted here. Its goes to infinity
			 
			 or you can add this condition and then seperate else condition
			  			else if(nums[mid]> nums[mid+1])
			 {
				 high = mid -1 ;
			 }
			 
			 
*/
			// Peak is on left Side  : When No Dip Found
	 			else if(nums[mid]> nums[mid+1])
				 {
					 high = mid -1 ;
				 }
			 
			 // // Peak is on left Side and also on right side it up to you which you want  : In case No Dip Found
	 			else 
				 {
	 				low = mid+1 ; // either you check for right peak ;
	 				//high = mid -1 ;// Or you can check for left peak;
	 				
				 }
	
			 
			 
		 }
			 
		 
		return -1;  // pdeak not foun
	}

}
