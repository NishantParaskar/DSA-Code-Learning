import java.util.HashSet;
import java.util.Set;

public class fairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        // Creating a set to store Bob's candy sizes for quick lookup
        Set<Integer> bobSet = new HashSet<>();

        // Variables to store the total candy sizes for Alice and Bob
        int totalAlices = 0;
        int totalBobs = 0;

        // Calculate the total candy size for Alice
        for (int candyAlices : aliceSizes) {
            totalAlices += candyAlices;
        }

        // Calculate the total candy size for Bob and populate the set with Bob's candy sizes
        for (int candyBobs : bobSizes) {
            totalBobs += candyBobs;
            bobSet.add(candyBobs);
        }

        // Calculate the delta: the difference in total candy size divided by 2
        // This represents the amount by which Bob's candy size should increase
        // and Alice's candy size should decrease to achieve equal total candy sizes
        int delta = (totalBobs - totalAlices) / 2;

        // Array to store the result
        int result[] = new int[2];

        // Iterate through each candy size in Alice's list
        for (int candy : aliceSizes) {
            // Calculate the corresponding candy size that Bob should give
            int replaceCandywithBob = candy + delta;

            // Check if Bob has the corresponding candy size
            if (bobSet.contains(replaceCandywithBob)) {
                // If a match is found, store the result and return
                result[0] = candy;
                result[1] = replaceCandywithBob;
                return result;
            }
        }

        // Return null if no valid swap is found (though problem guarantees a solution)
        return null;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] aliceSizes1 = {1, 1};
        int[] bobSizes1 = {2, 2};
        testSwap(aliceSizes1, bobSizes1);

        // Test case 2
        int[] aliceSizes2 = {1, 2, 5};
        int[] bobSizes2 = {2, 4};
        testSwap(aliceSizes2, bobSizes2);

        // Test case 3
        int[] aliceSizes3 = {1, 2, 3};
        int[] bobSizes3 = {4, 5, 6};
        testSwap(aliceSizes3, bobSizes3);

        // Test case 4
        int[] aliceSizes4 = {2, 3, 4};
        int[] bobSizes4 = {1, 2, 5};
        testSwap(aliceSizes4, bobSizes4);

        // Test case 5
        int[] aliceSizes5 = {5, 7, 8};
        int[] bobSizes5 = {3, 4, 6};
        testSwap(aliceSizes5, bobSizes5);
    }

    private static void testSwap(int[] aliceSizes, int[] bobSizes) {
        fairCandySwap solution = new fairCandySwap();
        int[] result = solution.fairCandySwap(aliceSizes, bobSizes);

        // Print input arrays
        System.out.print("Alice's candies: ");
        printArray(aliceSizes);
        System.out.print("Bob's candies: ");
        printArray(bobSizes);

        // Print the result
        if (result != null) {
            System.out.println("Alice gives: " + result[0] + ", Bob gives: " + result[1]);
        } else {
            System.out.println("No valid swap found");
        }
        System.out.println("-------------");
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}












/*
Algorithm:

Sure! Here's a concise algorithm for the "fair candy swap" problem in fewer words:

1. Compute Totals: Calculate the sum of candies for Alice and Bob.
2. Prepare Set: Add Bob's candy sizes to a set for fast lookup.
3. Determine Delta:** Compute the difference in total candies, then divide by 2 to find the target difference.
4. Find Swap: For each candy in Alice's list, check if Bob has a candy that matches the required swap value (Alice's candy + delta).
5. Return Pair: If a matching pair is found, return it as the result; otherwise, return null.


*/









//https://getsdeready.com/courses/design-dsa-combined/lesson/fair-candy-swap-3/

//Explaination :
//https://www.youtube.com/watch?v=-gY42yiNLxY 