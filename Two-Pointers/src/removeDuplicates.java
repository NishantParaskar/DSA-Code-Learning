//https://leetcode.com/problems/remove-duplicates-from-sorted-array/


class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        // Initialize a count variable to keep track of the number of unique elements
        int count = 0;

        // Iterate through the array
        for(int i = 0; i < nums.length; i++) {
            // Check if the current element is the same as the next one
            if(i < nums.length - 1 && nums[i] == nums[i+1]) {
                // If it's a duplicate, continue to the next iteration
                continue;
            } else {
                // If it's not a duplicate, assign it to the position indicated by count
                nums[count] = nums[i];
                // Increment count to indicate a unique element has been added
                count++;
            }
        }

        // Return the number of unique elements
        return count;
    }

    //Approch 2 : Same but pointer use differently
    //Take you forward :https://www.youtube.com/watch?v=Fm_p9lJ4Z_8&list=PLgUwDviBIf0rBT8io74a95xT-hDFZonNs&index=3
    public int removeDuplicates1(int[] nums)
    {
    	
    	if(nums.length == 0)
    	{
    		return 0 ;
    	}
    	
        int i = 0 ;
        for(int j = 1 ; j< nums.length ;j++)
        {
            if(nums[i] ==  nums[j])
            {
                continue;
            }
           else   if(nums[i] !=nums[j])
            {
                i++  ;
                nums[i] = nums[j] ;
            }
        }
        int finalLength =  i + 1 ; // as index start from zero
        return   finalLength  ;
    }
    public static void main(String[] args) {
    	removeDuplicates solution = new removeDuplicates();

        // Define test cases
        int[][] testCases = {
            {1, 1, 2, 2, 3, 4, 4, 5, 5},
            {1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5},
            {},
            {1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6}
        };

        // Test the removeDuplicates method with each test case
        for(int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int uniqueCount = solution.removeDuplicates1(nums);

            // Print the number of unique elements
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Number of unique elements: " + uniqueCount);

            // Print the array with unique elements
            System.out.print("Array with unique elements: ");
            for(int j = 0; j < uniqueCount; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println("\n");
        }
        
    }
}



/* Approch 1
### Explanation
- Time Complexity:  O(n)
- Space Complexity: O(1)

This algorithm works as follows:

1. **Initialize a `count` variable to 0:** This will keep track of the number of unique elements in the array.
2. **Iterate through the array:** Use a `for` loop to traverse the array.
3. **Check for duplicates:** Within the loop, check if the current element is the same as the next one.
    - **If it's a duplicate:** Use `continue` to skip to the next iteration of the loop.
    - **If it's not a duplicate:** Assign the current element to the position indicated by `count` in the array and increment `count`.
4. **Return `count`:** At the end of the loop, `count` will be the number of unique elements in the array, and the first `count` elements of `nums` will be the unique elements in sorted order.
*/



/* Approch 2:
 
 
 Here is the meaning of each step in the algorithm:

1. **Initialize a pointer `i` to 0:**
   - This pointer `i` keeps track of the last position in the array where a unique element has been placed.

2. **Iterate through the array with a pointer `j` starting from 1:**
   - Pointer `j` is used to traverse the array from the second element to the end, comparing each element with the element at position `i`.

3. **If `nums[i]` is not equal to `nums[j]`, increment `i` and update `nums[i]` to `nums[j]`:**
   - When a new unique element (i.e., an element that is different from the one at position `i`) is found at position `j`, move the pointer `i` one step forward and copy the element at `j` to the new position of `i`.

4. **Continue the loop until all elements are processed:**
   - The loop continues to iterate through the entire array, ensuring that all elements are checked and unique elements are moved to the front part of the array.

5. **Return `i + 1` as the length of the array with unique elements:**
   - Since `i` is an index (starting from 0), the number of unique elements is `i + 1`. This value represents the length of the portion of the array that contains only unique elements.
 */


