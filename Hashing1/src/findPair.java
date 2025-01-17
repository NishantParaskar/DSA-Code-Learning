//https://getsdeready.com/courses/design-dsa-combined/lesson/find-pairs-in-array-whose-sums-already-exist-in-array-2/

import java.util.HashSet;

public class findPair {

//	Approch 1 : brute Force 
	//Time complexity: O(n3) . Auxiliary space: O(1)
	// Function to find pair whose
    // sum exists in arr[]
    static void findPair1(int[] arr, int n)
    {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[i] + arr[j] == arr[k]) {
                        System.out.println(arr[i] + 
                                      " " + arr[j]);
                        found = true;
                    }
                }
            }
        }
 
        if (found == false)
            System.out.println("Not exist");
    }
    
    
//	Approch 2 : Efficient Approch
    
    //Time Complexity: O(n2)
   // Auxiliary Space: O(n)
    // Function to find pair whose sum
    // exists in arr[]
    public static void findPair2(int[] arr, int n)
    {
        /* store all the array elements as a 
        Hash value*/
        HashSet<Integer> s = new HashSet<Integer>();
 
        for (Integer i : arr) {
            s.add(i);
        }
 
        /* Run two loop and check for the sum 
    in the Hashset*/
        /* if not a single pair exist then found 
    will be false else true*/
        boolean found = false;
 
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (s.contains(sum)) {
                    /* if the sum is present in 
                 hashset then found become
                true*/
                    found = true;
 
                    System.out.println(arr[i] + " "
                                       + arr[j]);
                }
            }
        }
 
        if (found == false)
            System.out.println("Not Exist ");
    }
    
 
    // Driver code
    static public void main(String[] args)
    {
        int[] arr = {10, 4, 8, 13, 5};
        int n = arr.length;
        findPair1(arr, n);  // bruet force
        findPair2(arr, n);   // efficient
    }
    
    
    
}
