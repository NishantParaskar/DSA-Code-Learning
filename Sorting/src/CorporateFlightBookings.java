import java.util.Arrays;

public class CorporateFlightBookings {
	
	 public static void main(String[] args) {
	        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
	        int n = 5;
	        int[] result = corpFlightBookings_helper(bookings, n);
	        System.out.println("Final result: " + Arrays.toString(result));
	    }

	    //Optimize 
	private static int[] corpFlightBookings_helper(int[][] bookings, int n) {
	        int[] seats = new int[n + 1]; // This array will hold the difference values, with an extra space for boundary conditions
int flight = 1;
	        for (int[] booking : bookings) {
	            int start = booking[0];
	            int end = booking[1];
	            int numSeats = booking[2];

	            // Increment seats at the start index
	            seats[start] += numSeats;
	            // Decrement seats at the end+1 index (if within bounds)
	            if (end + 1 <= n) {
	                seats[end + 1] -= numSeats;
	            }
	            System.out.println("Flight "+ flight++ +" : {"+ booking[0] +","+ booking[1]+","+booking[2]+ "}");
	            System.out.println(Arrays.toString(seats)+"\n");
	        }

	        
	        System.out.println("\n\n\n Calculate the prefix sum (Cummulative sum)");
	        // Calculate the prefix sum
	        for (int i = 1; i <= n; i++) {
	            seats[i] += seats[i - 1]; // Update seats[i] to include the previous value
	         
	            System.out.println(Arrays.toString(seats));
	        }

	        // Prepare the result array
	        System.out.println("\n\n\nValue copy from seata rray to result array");
	        int[] result = new int[n];
	        System.arraycopy(seats, 1, result, 0, n);

	        return result;
	    }
	

}


/*For better understand see brute force first
https://www.youtube.com/watch?v=a39nOyhaqRY :3.29
 
Q[[1,2,10],[2,3,20],[2,5,25]]

Index (N+1)
//0 [1 ,2, 3 , 4 ,5 ] 6

first flight==>  [1,2,10]   , start = 10 , end+1 = -10     end = 3(In bound)
//fir  [10,- ,-10, - , - ]

Second flight==> [2,3,20]    , start = 20 , end+1 = -20    end = 4(In bound)
//fir  [- ,20 ,- , -20 , -]

Third flight ==> [2,5,25]      ,start = 25 , end+1 = -25   end = 6(out of bound)
//fir  [- ,25 ,- , - , - ] -


now Add all
-[10,    - ,     -10,     -,      - ] -
-[-,     20 ,    - ,      -20 ,   -] -
-[- ,    25      ,- ,     -   ,   - ] -

Result
- [10,    45,     -10,    -20,      -] -

Now Cummultive adding from start
- [10,    55,     45,    25,      25] -


Result from (i=1 to i= )
[10,    55,     45,    25,      25]



 
 
 
 */
//Prefix sum question
// Clear the concept behind. Why its use
//https://leetcode.com/problems/corporate-flight-bookings/
//https://getsdeready.com/courses/design-dsa-combined/lesson/corporate-flight-bookings-2/