class Solution {
    public int numIslands(char[][] grid) {

        int islands = 0;

        for( int i =0; i< grid.length; i++) {
            for(int j=0;j<grid[0].length; j++ ) {
                if( grid[i][j] == '1') {
                    dfs(grid,i,j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, int i, int j) {
        int m=grid.length,n=grid[0].length;
        if( i >= m || i < 0 || j >=n || j< 0) return;
        if( grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
        }
    }
}