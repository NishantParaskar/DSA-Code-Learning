import java.util.Arrays;

public class KokoBananaProblem {

	public static void main(String[] args) {
		int nums[] = { 3, 6, 7, 11 };
		int h = 8;
		
		
//		int nums[] ={30,11,23,4,20} ;
//		int h = 5;
		
				
//		int nums[] ={30,11,23,4,20} ;
//		int h = 6 ;		
				;
		int minHour = KokoBananaProblem(nums, h);
		System.out.println("The Minimum hour required to finish the banana is :" + minHour);
	}

	private static int KokoBananaProblem(int[] nums, int h) {

		int max = Arrays.stream(nums).max().getAsInt();

		int low = 1;
		int high = max;
		
		int ans = -1 ;

		while (low <= high) {
			
			int mid = (low + high) / 2;
			System.out.println("Low is :"+low +". High is "+high );
			System.out.println("Mid is "+ mid);
			int completedInHour = EatingInhour(nums, mid, h);
			System.out.println("completedInHour is "+ completedInHour);
			if(completedInHour <= h)
			{
				System.out.println("Go in left");
				ans = mid ; // it could be the answer still check for meaning ans ;
				high = mid -1 ;
			}
			else
			{
				System.out.println("Go in right");
				low = mid  + 1 ;
			}
			System.out.println("==========");

		}

		return ans;
	}

	static int EatingInhour(int nums[], int mid, int h) {

		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans = ans + (int) Math.ceil((double) nums[i] / (double) mid);
		}
		return ans; 
	}
}




















//ref: https://www.youtube.com/watch?v=qyfekrNni90&t=474s
//https://takeuforward.org/binary-search/koko-eating-bananas/
//take you forward
