
//Last occurrence in a sorted array 
//take you forward
//refercne:https://takeuforward.org/data-structure/last-occurrence-in-a-sorted-array/

import java.util.ArrayList;


//TC : O(log2n )  (Log 2n)  == 2 O(log2N)
public class FirstAndlastOccurance  {

    public static int[] firstAndLastPosition(ArrayList<Integer> arrList, int n, int x) {
        int[] arr = convertArrayListToArray(arrList);

        int lb = lowerBound(arr, n, x);
        int ub = upperBound(arr, n, x);  // Adjust for the upper bound

        // Edge case 1: if lb is out of bounds or the element at lb is not x
        if (lb == n || arr[lb] != x) {
            return new int[]{-1, -1};
        }

        return new int[]{lb, ub - 1};
    }

    // Method to convert ArrayList<Integer> to int[]
    private static int[] convertArrayListToArray(ArrayList<Integer> arrList) {
        int[] arr = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            arr[i] = arrList.get(i);
        }
        return arr;
    }

    // Lower Bound
    public static int lowerBound(int[] arr, int n, int x) {
        int ans = n;  // Hypothetical initialization
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Case 1: It could be the LowerBound, so check the left side
            if (arr[mid] >= x) {
                ans = mid;  // Update ans first, because it could be the last Lower Bound Index
                high = mid - 1;
            } else {
                low = mid + 1; // Check the right side
            }
        }

        return ans;
    }

    // Upper Bound
    public static int upperBound(int[] arr, int n, int x) {
        int ans = n;  // Hypothetical initialization
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Case 1: It could be the UpperBound, so check the right side
            if (arr[mid] <= x) {
                ans = mid + 1;  // Update ans, because it could be the last Upper Bound Index
                low = mid + 1;  // Check the right side
            } else {
                high = mid - 1; // Check the left side
            }
        }

        return ans;
    }

    public static void main(String[] args) {
    	//8 2
    	//0 0 1 1 2 2 2 2
        ArrayList<Integer> arrList = new ArrayList<>();
        //Input 1 : 
//        arrList.add(0);
//        arrList.add(0);
//        arrList.add(1);
//        arrList.add(1);
//        arrList.add(2);
//        arrList.add(2);
//        arrList.add(2);
//        arrList.add(2);
//        
//        int k = 2 ;
       
        
   //Input 2 :     
      arrList.add(1);
      arrList.add(3);
      arrList.add(3);
      arrList.add(5);   
        
   int k = 2 ;
  
        
        int[] result = firstAndLastPosition(arrList, arrList.size(), k);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
    }
}



// refernce : https://www.youtube.com/watch?v=hjR1IYVx9lY&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=4