
//GSready
// Go to all elememt o to n-1 . 
// chcek each element is Odd or even 
// based on odd or even place it in result array odd position or Even position

// https://leetcode.com/problems/sort-array-by-parity-ii/

public class SortArrayByParitycheck {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];

        int evenIndex = 0;
        int oddIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) { // even index
                result[evenIndex] = nums[i];
                evenIndex += 2;
            } else {
                result[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
    	SortArrayByParitycheck sol = new SortArrayByParitycheck();
        int[] nums = {4, 2, 5, 7};
        int[] sortedArray = sol.sortArrayByParityII(nums);

        System.out.print("Sorted array by parity II: ");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}





//https://getsdeready.com/courses/design-dsa-combined/lesson/sort-array-by-parity-ii-2/
