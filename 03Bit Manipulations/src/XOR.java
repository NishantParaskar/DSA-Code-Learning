
public class XOR {
	public static void main(String[] args) {
		int nums[] ={4,1,2,1,2,} ;
		
		    int XOR = 0 ;

        for(int i = 0 ; i < nums.length ; i++)
        {
         XOR = XOR ^ nums[i] ;
         System.out.println(" XOR======> "+  XOR);
        }
  
      
	}
}
