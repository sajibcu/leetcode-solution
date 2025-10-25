class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int totalWeeks = 7 * weeks * (weeks + 7) / 2;
        int remaining = days * (weeks + 1) + days * (days - 1) / 2;
        return totalWeeks + remaining;
    }

    public int totalMoney1(int n) {

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