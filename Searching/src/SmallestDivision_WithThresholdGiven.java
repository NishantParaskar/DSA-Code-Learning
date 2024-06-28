//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
public class SmallestDivision_WithThresholdGiven {
    public static int sumByD(int[] arr, int div) {
        int n = arr.length; //size of array
        //Find the summation of division values:
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }
    public static int smallestDivisor(int[] arr, int limit) {
        int n = arr.length; //size of array.
        if(n > limit) return -1;
        //Find the maximum element:
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int low = 1, high = maxi;
        int minDivisor = -1 ;

        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                minDivisor = mid ; // chekc for other smallest ;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minDivisor;
    }
	    public static void main(String[] args) {
	        int[] arr = {1, 2, 3, 4, 5};
	        int limit = 8;
	        int ans = smallestDivisor(arr, limit);
	        System.out.println("The minimum divisor is: " + ans);
	    }
}


//https://takeuforward.org/arrays/find-the-smallest-divisor-given-a-threshold/
//https://www.youtube.com/watch?v=UvBKTVaG6U8&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=15