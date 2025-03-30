import java.util.*; 

class Solution {
    public List<Integer> partitionLabels(String s) {
        
        // Array to store the last occurrence index of each character in the string
        int[] lastIndex = new int[26];
        
        // Populate lastIndex array with the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> ans = new ArrayList<>(); // List to store partition lengths
        
        int start = 0, end = 0; // Start and end pointers for partitions
        
        // Iterate over the string to determine partitions
        for (int i = 0; i < s.length(); i++) {
            // Update the end of the current partition to the farthest last occurrence of the character
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            
            // If the current index reaches the end of the partition
            if (i == end) {
                // Add the partition size to the answer list
                ans.add(end - start + 1);
                
                // Move start to the next index for a new partition
                start = i + 1;
            }
        }
        
        return ans; // Return the list of partition sizes
    }
}
