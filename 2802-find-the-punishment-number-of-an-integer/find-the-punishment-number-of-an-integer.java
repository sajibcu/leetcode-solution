class Solution {
    
    public int punishmentNumber(int n) {
        int ans = 0;
        while( n > 0 ) {
            if(isPunishmentNumber(n,Integer.toString(n*n), 0, 0,0)) {
                ans +=n*n;
            }
            n--;
        }

        return ans;
    }

    public boolean isPunishmentNumber(int n, String s, int index, int totalSum, int currentSum) {
        if( totalSum + currentSum > n ) return false;
        if(index >= s.length() ) return n ==(totalSum+currentSum);
        int a = s.charAt(index)-'0';
        return isPunishmentNumber(n,s,index+1, totalSum, currentSum*10+a )
        || isPunishmentNumber(n,s,index+1, totalSum + currentSum, a );
    }
}