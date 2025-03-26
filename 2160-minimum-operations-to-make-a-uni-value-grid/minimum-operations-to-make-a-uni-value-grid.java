class Solution {
    public int minOperations(int[][] grid, int x) {

        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] values = new int[size];

        int i=0;
        for( int[] row : grid) {
            for( int num: row) {
                values[i++] = num; 
            }
        }

        Arrays.sort(values);
        int ans = 0;

        int median = values[size/2];

        for( int num: values) {
            int gap =  Math.abs(median - num); 
            if( gap % x != 0) return -1;
            ans +=gap/x;
        }

        return ans;
        
    }
}