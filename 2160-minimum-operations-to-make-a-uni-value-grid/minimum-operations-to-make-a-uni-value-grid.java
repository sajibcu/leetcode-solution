class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> values = new ArrayList<>();

        for(int i=0; i<grid.length; i++ ) {
            for(int j=0; j<grid[0].length; j++) {
                values.add(grid[i][j]);
            }
        }

        Collections.sort(values);
        int ans = 0;

        int mid = values.get(values.size()/2);

        for( int n: values) {
            int gap =  Math.abs(mid - n); 
            if( gap % x != 0) return -1;
            ans +=gap/x;
        }

        return ans;
        
    }
}