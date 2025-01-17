// take you Forward :
//reference:

//reference : https://www.youtube.com/watch?v=rjEJeYCasHs&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=14
//reference :https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/

//Question :https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-nth-root-of-m


public class Find_Nth_root_of_M {
	
	public static void main(String[] args) {
       
        // Test cases
        int result1 = NthRoot(3, 27);
        System.out.println("The 3rd root of 27 is: " + result1);  // Expected output: 3

        int result2 = NthRoot(2, 16);
        System.out.println("The 2nd root of 16 is: " + result2);  // Expected output: 4

        int result3 = NthRoot(4, 81);
        System.out.println("The 4th root of 81 is: " + result3);  // Expected output: 3 (since 3^4 = 81)

        int result4 =NthRoot(2, 10);
        System.out.println("The 2nd root of 10 is: " + result4);  // Expected output: -1 (since there is no integer root)
    
     
    }

   static public int NthRoot(int n, int m) {
        // Initialize low to 1
        int low = 1;
        // Initialize high to the given number m
        int high = m;
        // Initialize output to -1, which will store the result if found
        int output = -1;
        
        // Perform binary search while low is less than or equal to high
        while (low <= high) {
            // Calculate mid point
            int mid = (low + high) / 2;
            // Call the func method to determine if mid^n equals m, or if we need to search left or right
            String midN = func(mid, n, m);
            
            // If mid^n is equal to m, return mid
            if (midN == "root Found") {
                return mid;
            } 
            // If mid^n is less than m, search in the right half
            else if (midN == "Check in right") {
                low = mid + 1;
            } 
            // If mid^n is greater than m, search in the left half
            else {
                high = mid - 1;
            }
        }
        
        // Return -1 if no integer nth root is found
        return -1;
    }

    public static String func(int mid, int n, int m) {
        // Initialize ans to 1, which will store the result of mid^n
        long ans = 1; // take long when come to  multiplication it might exceed.
        // Calculate mid^n
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            // If ans exceeds m, return "Check in left"
            if (ans > m) // dont check for other multiplication once across  m then get return out of it
            {
                return "Check in left";
            }
        }
        // If ans equals m, return "root Found"
        if (ans == m) {
            return "root Found";
        }
        // If ans is less than m, return "Check in right"
        return "Check in right";
    }
	
	

}
