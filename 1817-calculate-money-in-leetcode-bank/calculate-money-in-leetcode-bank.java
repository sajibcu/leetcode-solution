class Solution {
    public int totalMoney(int n) {

        int w = 1;
        int c = 1;
        int ans = 0;
        for(int i=1;i<=n;i++) {
            ans +=c;
            c++;
            if( i%7==0 ) {
                w++;
                c= w;
            }
        }
        return ans;
        
    }
}