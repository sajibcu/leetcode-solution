class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int[] preSum = new int[400001];
        int j=0,i=0;

        for( i = 0;i<400001;i++) {
            if( i > 0) preSum[i] +=preSum[i-1];
            if( j< fruits.length && i >= fruits[j][0]) {
                preSum[i] +=fruits[j][1];
                j++;
            }
            if( i > startPos + k) break;
            // if( i  < 10)
            // System.out.println(i+"##"+preSum[i]);

        }
        
        int ans = 0;
        i = startPos;

        while( i >= 0 ) {
            int stepsLeft = startPos - i;
            if( stepsLeft > k ) break;

            int remaining = k - 2* stepsLeft;
            int right = startPos + remaining;

            ans = Math.max(ans,preSum[right] - (i==0 ? 0 : preSum[i-1]));
            
            i--;
        }

        i = startPos;
        while( i <= startPos+k) {

            int remaining = k - 2*(i- startPos);
            int left = startPos - remaining;

            ans = Math.max(ans,preSum[i] - (left < 1 ? 0 : preSum[left-1]));
            i++;
        }  

        return ans;
        
    }
}