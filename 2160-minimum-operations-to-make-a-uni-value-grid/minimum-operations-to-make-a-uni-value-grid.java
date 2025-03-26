class Solution {
    public int minOperations(int[][] grid, int x) {

        int m = grid.length, n = grid[0].length;
        int size = m * n;  // Calculate the total number of elements in the grid
        int[] freq = new int[10001]; // Frequency array to count occurrences of each number

        // Step 1: Populate the frequency array
        for( int[] row : grid) {
            for( int num: row) {
                freq[num]++; // Increment the count of each number
            }
        }
        
        // If the grid has only one element, no operations are needed
        if (size < 2) return 0; 
        
        int ans = 0; // Variable to store the minimum number of operations

        // Step 2: Find the median of the frequency array
        int median = findMedian(freq, size / 2);
        
        // Step 3: Compute the number of operations required
        for(int i = 0; i < 10001; i++ ) {
            if(freq[i] == 0) continue; // Skip numbers that are not in the grid

            int gap = Math.abs(median - i); // Calculate the absolute difference with the median
            
            if(gap % x != 0) return -1; // If the difference is not a multiple of x, return -1
            
            ans += (gap / x) * freq[i]; // Calculate the required operations and add to the total
        }

        return ans; // Return the final result
    }

    // Helper method to find the median in the frequency array
    public int findMedian(int[] freq, int size) {
        int cnt = 0;
        
        // Iterate through the frequency array to find the median
        for(int i = 0; i < freq.length; i++) {
            cnt += freq[i]; // Accumulate the count of elements
            if(cnt > size) return i; // When the count exceeds half of the total elements, return the median
        }
        
        return freq.length; // Fallback return (should not reach here in a valid case)
    }
}
