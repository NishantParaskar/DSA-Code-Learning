import java.util.Arrays;

public class MaximumImportanceOfRoad {
	
    public static long maximumImportance(int n, int[][] roads)
    {
        int degreeOfNode[] = new int[ n ];
        for(int edge[] :roads)
        {
               //   edge[0]  ; // get first parameter of edge
               //   edge[1] ; // get second parameter of edge
            
              degreeOfNode[edge[0]]++;  // increase the frequncy count for for Node .(that is when edge found for node increse degree) 
              degreeOfNode[edge[1]]++;  //  increase the frequncy count for for Node .(that is when edge found for node increse degree)

        }

        Arrays.sort(degreeOfNode) ;
        long sum = 0 ;
        long value = 1; // starting from from 1 for lower degree and goes on till higher degree
        for(int i = 0 ; i< degreeOfNode.length ; i++)
        {

            sum = sum + (degreeOfNode[i] * value ) ;
            value++ ; // its goes on 1....n 
        }
return sum;
        
    }
	
	public static void main(String[] args) {
		int n = 5 ;  
		int roads[][] = {{0,1} ,{1,2} ,{2,3} ,{0,2} ,{1,3} ,{2,4} };
		
		long result = maximumImportance(n, roads) ;

  System.out.println("Result : "+ result);
		
		
	}

}




//leetcode: https://leetcode.com/problems/maximum-total-importance-of-roads/
//Later for reference : https://www.youtube.com/watch?v=p4y_rQeB2mg
//codestorywithMIK . 
//Written its explanation in notbook



/*
1.Count Connections:

Start by making a list to keep track of how many roads are connected to each place.
Go through each road and increase the count for the places connected by that road.

2.Sort Connections:

Arrange the places in order based on how many roads are connected to them.

3.Calculate Importance:

Start with a total value of zero.
Assign an increasing importance value to each place, starting with the lowest number of connections.
Multiply the number of connections for each place by its importance value and add this to the total.

4.Return Total:

The final result is the total value calculated.
 
  
  
  */
