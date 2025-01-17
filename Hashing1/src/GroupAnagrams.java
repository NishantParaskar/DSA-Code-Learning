//49. Group Anagrams//  :https://leetcode.com/problems/group-anagrams/

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Initialize the HashMap to group anagrams
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();
        
        // Iterate over each string in the input array
        for (String str : strs) {
            // Initialize a frequency map for the current string
            HashMap<Character, Integer> smap = new HashMap<>();
            char[] charArray = str.toCharArray();
            
            // Count the frequency of each character in the current string
            for (int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            }
            
            // Checking if the current character frequency map is already in the main map
            if (!bmap.containsKey(smap)) {
                // If not, create a new list and add the current string
                ArrayList<String> ls = new ArrayList<>();
                ls.add(str);
                bmap.put(smap, ls);
            } else {
                // If it exists, add the current string to the existing list
                ArrayList<String> a = bmap.get(smap);
                a.add(str);
            }
        }
        
        // Prepare the final result list
        List<List<String>> res = new ArrayList<>();
        for (ArrayList<String> s : bmap.values()) {
            res.add(s);
        }
        
        // Return the grouped anagrams
        return res;
    }

    public static void main(String[] args) {
    	GroupAnagrams sol = new GroupAnagrams();

        // Example 1
        String[] example1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = sol.groupAnagrams(example1);
        System.out.println("Example 1: " + result1);

        // Example 2
        String[] example2 = {"abc", "bca", "cab", "xyz", "zyx", "yxz"};
        List<List<String>> result2 = sol.groupAnagrams(example2);
        System.out.println("Example 2: " + result2);

        // Example 3
        String[] example3 = {"", "b", "bb", "bbb", "bba", "abb"};
        List<List<String>> result3 = sol.groupAnagrams(example3);
        System.out.println("Example 3: " + result3);

        // Example 4
        String[] example4 = {"apple", "papel", "hello", "llohe", "world", "dlrow"};
        List<List<String>> result4 = sol.groupAnagrams(example4);
        System.out.println("Example 4: " + result4);

        // Example 5
        String[] example5 = {"abcd", "dcba", "abcd", "bcda", "acbd", "cbad"};
        List<List<String>> result5 = sol.groupAnagrams(example5);
        System.out.println("Example 5: " + result5);
    }
}
