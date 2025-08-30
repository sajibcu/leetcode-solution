class Solution {
    public boolean isValidSudoku(char[][] board) {

        int[] feq = new int[10];
        int m=board.length;
        int n=board[0].length;
        for(int i=0; i<m;i++){
            reset(feq);
            for(int j=0;j<n;j++){
                if(board[i][j]=='.') continue;
                int index = board[i][j]-'0';
                if(feq[index] == 1) return false;
                feq[index]++;
            }
        }

         for(int i=0; i<n;i++){
            reset(feq);
            for(int j=0;j<m;j++){
                if(board[j][i]=='.') continue;
                int index = board[j][i]-'0';
                if(feq[index] == 1) return false;
                feq[index]++;
            }
        }

        for(int a=0;a<m;a+=3){
            for(int b=0;b<n;b+=3) {
                reset(feq);
                for(int i=a; i<3+a;i++){
                    for(int j=b;j<3+b;j++){
                        if(board[j][i]=='.') continue;
                        int index = board[j][i]-'0';
                        if(feq[index] == 1) return false;
                        feq[index]++;
                    }
                }
            }
        }

        return true;
    }

    public void reset( int[] feq) {
        for( int i=0;i<10;i++) feq[i]=0;
    }
}