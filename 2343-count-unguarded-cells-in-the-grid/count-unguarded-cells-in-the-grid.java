class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mt = new int[m][n];
        for(int[] g : guards) {
            mt[g[0]][g[1]] = 1;
        }

        for(int[] w : walls) {
            mt[w[0]][w[1]] = 2;
        }

        for(int i=0;i<m;i++) {
            for( int j=0;j<n;j++){
                update(i,j,mt,m,n);
            }
        }

        int ans = 0;

        for(int i=0;i<m;i++) {
            for( int j=0;j<n;j++){
                if( mt[i][j]==0) ans++;
            }
        }
        return ans;
        
    }

    public void update(int i, int j, int[][] mt, int m, int n) {
        if (mt[i][j] != 1) return; // only for guards

        // directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for (int[] d : dirs) {
            int r = i + d[0];
            int c = j + d[1];
            while (r >= 0 && r < m && c >= 0 && c < n && mt[r][c] != 1 && mt[r][c] != 2) {
                if (mt[r][c] == 0) mt[r][c] = 3; // mark guarded
                r += d[0];
                c += d[1];
            }
        }
    }
}