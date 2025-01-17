import java.util.TreeMap;
import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/find-right-interval/description/

public class FindRightInterval {
	public static void main(String[] args) {
		int[][] intervals = { {3,4},{2,3},{1,2} };
		
		   // Number of rows
        int numberOfRows = intervals.length;
        
	      System.out.println("Result :"+ Arrays.toString(func(intervals ,numberOfRows)));

	}
	
	static int[] func(int[][] intervals ,int numberOfRows)
	{
		// Creating a TreeMap
        TreeMap<Integer, Integer> startMap = new TreeMap<>();
   

        HashMap<Integer, Integer> originalIndices = new HashMap<>();
        
        // Adding start points of intervals
        
        int result[] = new int[numberOfRows]   ;
       
        for (int index = 0 ; index <numberOfRows ; index++) 
        {
            startMap.put(intervals[index][0], index);  // adding 1st value from array as key and 2nd as index
            originalIndices.put(intervals[index][0], index); 
        }
        
        System.out.println("intervals[0]  :" +Arrays.toString(intervals[0]));
        System.out.println("intervals[1]  :" +Arrays.toString(intervals[1]));
        System.out.println("intervals[2]  :" +Arrays.toString(intervals[2]));
        // For each interval, find the right interval using ceilingKey
        for (int i = 0; i < numberOfRows; i++) 
        { 
        	 Integer ceilingKey = startMap.ceilingKey(intervals[i][1])  ;
        	 if(ceilingKey != null  && startMap.containsKey(ceilingKey))
        	 {
        		 System.out.println("Interteval ends at " + intervals[i][1] + " .Any other start found==> "+startMap.get(ceilingKey));
        		 result[i] =startMap.get(ceilingKey) ;
        	 }
        	 else
        	 {
        		 System.out.println("Interteval ends at " +intervals[i][1] + " .Any other start found==> " + (-1));
        		 result[i] =-1  ;  // not found
        	 }
        	 
        	 
        
        }
		return result  ;
        
	}
		
}

/* OutPut


intervals[0]  :[3, 4]
intervals[1]  :[2, 3]
intervals[2]  :[1, 2]
Interteval ends at 4 .Any other start found==> -1
Interteval ends at 3 .Any other start found==> 0
Interteval ends at 2 .Any other start found==> 1
Result :[-1, 0, 1]



*/
