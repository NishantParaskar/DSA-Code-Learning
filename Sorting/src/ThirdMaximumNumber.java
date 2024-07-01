import java.util.Arrays;
import java.util.TreeSet;
public class ThirdMaximumNumber {
	
	
	//.lower(int num) method to find who less the nums
	 public static int thirdMax(int[] nums) {
	        TreeSet<Integer> uniqueNums = new TreeSet<>();
	        for (int num : nums) {
	            uniqueNums.add(num);
	   }
	        if (uniqueNums.size() < 3) {
	            return uniqueNums.last();
	        } else {
	            return uniqueNums.lower(uniqueNums.lower(uniqueNums.last())) ;
	        }
	    }
	 
	 public static void main(String[] args) {
		 int output  = thirdMax(new int[] {1,3 ,2} ) ;
		System.out.println(output);
	}

}



