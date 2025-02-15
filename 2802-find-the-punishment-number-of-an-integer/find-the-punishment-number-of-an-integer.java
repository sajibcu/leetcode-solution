class Solution {
    
    public int punishmentNumber(int n) {
        int ans = 0;
        int[] isPunishmentNumber = {1,9,10,36,45,55,82,91,99,100,235,297,369,370,379,414,657,675,703,756,792,909,918,945,964,990,991,999,1000};
        for(int i : isPunishmentNumber ) {
            if( i <=n ) ans +=i*i;
            else break;
        }
        // while( n > 0 ) {
        //     if(isPunishmentNumber(n,Integer.toString(n*n), 0, 0,0)) {
        //         ans +=n*n;
        //     }
        //     n--;
        // }

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