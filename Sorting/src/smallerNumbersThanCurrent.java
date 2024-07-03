import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class smallerNumbersThanCurrent {
	//logic 1 : count sort logic
	//https://www.youtube.com/watch?v=C5u_hvbq1qQ
	// step1 :  calculate frequency
	// step2 :  calculate cumulative sum starting from 1 
	// step3 :  To Check smaller element for num . check result store at num -1 index  in count array
	 public static int[] smallerNumbersThanCurrent(int[] nums) {
	        int[] count = new int[101];
	        System.out.println();
	        System.out.println("initialize");
	        System.out.println(Arrays.toString(count));
	        int n = nums.length;
	        
	     // step1 :  calculate frequency
	        for (int i = 0; i < n; i++) {
	            count[nums[i]]++;
	        }
	        System.out.println();
	        System.out.println("Assigne value per frequency");
	        System.out.println(Arrays.toString(count));
	        
	    	// step2 :  calculate cumulative sum starting from 1 
	        for (int i = 1; i <= 100; i++) {
	            count[i] = count[i] + count[i - 1];
	        }
	        
	        System.out.println();
	        System.out.println("===");
	        System.out.println(Arrays.toString(count));
	        
	        int[] result = new int[n];
	        
	        for (int i = 0; i < n; i++) {
	            if (nums[i] == 0) {
	                result[i] = 0;
	            } else {	// step3 :  To Check smaller element for num . check result at num -1 index  in count array
	                result[i] = count[nums[i] - 1];
	            }
	        }
	        
	        return result;
	    }
	 
	 
	 //logic 2: using sorting and hashMap
	// https://www.youtube.com/watch?v=CKSdHsQyPYk
	 public static int[] smallerNumbersThanCurrent2(int[] nums)
	 {
	    	
	    	int result[] = nums.clone() ;
	    	Arrays.sort(result);
	    	
	    	HashMap<Integer, Integer > hm = new HashMap<>() ;
	    	for (int i = 0; i < result.length; i++) 
	    	{
	    		hm.putIfAbsent(result[i], i) ;  // two will not be added only first added will consider with index
			}
	    	
	    	
	    	for (int i = 0; i < result.length; i++)
	    	{
	    		result[i] = hm.get(nums[i]) ;
				
			}
			return result;
	    	
		 
	 }
	 public static void main(String[] args) {
		
		 int[] nums =  {8,1,2,2,3} ;
		 System.out.println("=====Logic 2========================================");
		 System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
	
		 System.out.println();
		 System.out.println("=====Logic 2========================================");
		 System.out.println("Array is :");
		 System.out.println(Arrays.toString(nums));
		 System.out.println("Smaller Numbers Than Current Array is :");
		 System.out.println(Arrays.toString(smallerNumbersThanCurrent2(nums)));
		
	}

}
