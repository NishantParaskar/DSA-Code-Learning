//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public class FindtheIndexoftheFirstOccurrenceinaString {
	
	// Main function to test the implementation
    public static void main(String[] args) {
    	FindtheIndexoftheFirstOccurrenceinaString solution = new FindtheIndexoftheFirstOccurrenceinaString();

        // Example 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        int result1 = solution.strStr(haystack1, needle1);
        System.out.println("Example 1 - haystack: " + haystack1 + ", needle: " + needle1 + ", Output: " + result1);

        // Example 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        int result2 = solution.strStr(haystack2, needle2);
        System.out.println("Example 2 - haystack: " + haystack2 + ", needle: " + needle2 + ", Output: " + result2);
    }
	
	
	//my code : Working
	  public int strStr1(String haystack, String needle) {
          // Check if haystack is shorter than needle
          if (haystack.length() < needle.length()) {
              return -1;
          }

          // Check if either haystack or needle is empty
          if (haystack.isEmpty() || needle.isEmpty()) {
              return -1;
          }

          // Initialize variables
          int firstOccuranceIndex = -1;
          int haystackEndPointer = 0;
          int needlePointer = 0;

          // Traverse haystack and needle
          while (haystackEndPointer < haystack.length() && needlePointer < needle.length()) {
              if (haystack.charAt(haystackEndPointer) == needle.charAt(needlePointer)) {
                  // Match found, update firstOccuranceIndex if first match
                  if (firstOccuranceIndex == -1) {
                      firstOccuranceIndex = haystackEndPointer;
                  }
                  // Move both pointers
                  haystackEndPointer++;
                  needlePointer++;

                  // If all characters of needle matched
                  if (needlePointer == needle.length()) {
                      return firstOccuranceIndex;
                  }
              } else {
                  // Reset pointers on mismatch
                  if (firstOccuranceIndex != -1) {
                      haystackEndPointer = firstOccuranceIndex + 1;
                  } else {
                      haystackEndPointer++;
                  }
                  firstOccuranceIndex = -1;
                  needlePointer = 0;
              }
          }
          // If needle not found
          return -1;
      }

	  
	  //Get SDE Ready Code:https://getsdeready.com/courses/design-dsa-combined/lesson/find-the-index-of-the-first-occurrence-in-a-string-2/
      public int strStr(String haystack, String needle) {
          // If the needle is larger than the haystack, it can't be found in the haystack
          if (needle.length() > haystack.length()) {
              return -1;
          }

          int m = needle.length(); // Length of the needle
          int n = haystack.length(); // Length of the haystack

          // Iterate over the haystack until there are not enough characters left to match the needle
          for (int i = 0; i <= (n - m); i++) {
              // Check if the substring of haystack starting from index i with length m matches the needle
              if (haystack.substring(i, i + m).equals(needle)) {
                  return i; // Return the starting index if the needle is found
              }
          }

          return -1; // Return -1 if the needle is not found in the haystack
      }
	  
}
