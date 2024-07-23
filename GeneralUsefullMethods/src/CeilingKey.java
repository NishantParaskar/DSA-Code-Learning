
import java.util.Arrays;
import java.util.TreeMap;

public class CeilingKey {
    public static void main(String[] args) {
        // Intervals represented as 2D array
        int[][] intervals = {
        		{11, 32},
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        // Creating a TreeMap
        TreeMap<Integer, Integer> startMap = new TreeMap<>();

        // Adding start points of intervals
        for (int[] interval : intervals) {
            startMap.put(interval[0], interval[1]);
        }
        System.out.println(Arrays.toString(intervals[0]));
        System.out.println(Arrays.toString(intervals[1]));
        System.out.println(Arrays.toString(intervals[2]));
        System.out.println(Arrays.toString(intervals[3]));
        System.out.println(Arrays.toString(intervals[4]));
        
        
        System.out.println("-------");
        
        System.out.println( "Ceiling key 1: "  +startMap.ceilingKey(1));
        System.out.println( "Ceiling key 2: "  +startMap.ceilingKey(2));    
        System.out.println( "Ceiling key 3: "  +startMap.ceilingKey(3));
        System.out.println( "Ceiling key 4: "  +startMap.ceilingKey(4));
        System.out.println( "Ceiling key 5: "  +startMap.ceilingKey(5));
        System.out.println( "Ceiling key 6: "  +startMap.ceilingKey(6));       
        // Example use of ceilingKey
        for (int i = 0; i < intervals.length; i++) {
            Integer ceilingKey = startMap.ceilingKey(intervals[i][1]);
            System.out.println("Ceiling key for end of interval " + intervals[i][1] + ": " + ceilingKey);
        }
    }
}
