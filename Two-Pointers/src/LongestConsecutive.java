import java.util.Arrays;

//https://leetcode.com/problems/longest-consecutive-sequence/     ****
public class LongestConsecutive {
	
	public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        System.out.println(Arrays.toString(nums));

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if ( nums[i] == nums[i - 1] +1 )
             {
                count = count + 1 ;
                max = Math.max(max, count);
            }
           
            if (nums[i] == nums[i - 1] || nums[i] != nums[i - 1] +1) {
    
                count = 1; // counter reset

            }

             System.out.println("i:"+i +"  count :"+count + " max : "+ max);

        }

        return max;
    }
	
	public static void main(String[] args) 
	{
		
		int[] nums = {1,2,0,1} ;
		System.out.println(longestConsecutive(nums));
		
	}

}
