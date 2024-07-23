import java.util.HashMap;

//https://leetcode.com/problems/maximum-number-of-balloons/
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        
        // Create a HashMap to store the frequency of characters in the text
        HashMap<Character, Integer> hm = new HashMap<>();

        // Iterate through each character in the text
        for(int i = 0; i < text.length(); i++) {
            Character ch = text.charAt(i);
            
            // Check if the character is one of 'b', 'a', 'l', 'o', 'n'
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                // Increment the frequency count for the character in the HashMap
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            }
        }
        
        // Since 'l' and 'o' appear twice in "balloon", divide their counts by 2
        hm.put('l', hm.getOrDefault('l', 0) / 2);
        hm.put('o', hm.getOrDefault('o', 0) / 2);
System.out.println(hm);
        // Define the string "balloon" for reference
        String balloon = "balloon";

        // Initialize minValue to a very large value
        int minValue = Integer.MAX_VALUE;
        
        // Iterate through each character in the string "balloon"
        for(char ch : balloon.toCharArray()) {
            // Update minValue to the smallest frequency count in the HashMap
            minValue = Math.min(minValue, hm.getOrDefault(ch, 0));
        }

        // Return the minimum value which indicates the maximum number of "balloon" that can be formed
        return minValue;
    }

    public static void main(String[] args) {
        MaxNumberOfBalloons solution = new MaxNumberOfBalloons();

        // Test case 1
        String text1 = "loonbalxballpoon";
        int result1 = solution.maxNumberOfBalloons(text1);
        System.out.println("For:"+text1+"\nMaximum number of 'balloon' that can be formed: " + result1); // Expected output: 2
System.out.println();
        // Test case 2
        String text2 = "leetcode";
        int result2 = solution.maxNumberOfBalloons(text2);
        System.out.println("For:"+text2+"\nMaximum number of 'balloon' that can be formed: " + result2); // Expected output: 0

        // Add more test cases as needed
    }
}


//https://getsdeready.com/courses/design-dsa-combined/lesson/maximum-number-of-ballons-2/