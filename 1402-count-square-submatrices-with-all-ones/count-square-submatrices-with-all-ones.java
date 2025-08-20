class Solution {
    public int countSquares(int[][] matrix) {

        int ans = 0;

        for(int i=0;i<matrix.length; i++) {
            for( int j=0;j<matrix[0].length; j++) {
                if( matrix[i][j]==1 ) {
                    //ans++;
                    int k=1;
                    while(isSquare(i,j,k,matrix)) {
                        ans++;
                        k++;
                    }
                }
            }
        }

        return ans;
        
    }
    public boolean isSquare(int i,int j,int level, int[][] matrix ) {
        int one = 0;
        int m=matrix.length, n = matrix[0].length;
        for( int a=i;a<i+level;a++) {
            for(int b=j;b<j+level; b++) {
                if( a < m && b< n ) one+=matrix[a][b];
            }
        }

        return one == level*level;
    }
}