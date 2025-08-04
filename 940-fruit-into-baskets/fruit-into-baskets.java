class Solution {
    public int totalFruit(int[] fruits) {

        int ans = 0;

        int[] count = new int[100001];
        int type = 0;
        int left = 0;

        for(int i=0;i<fruits.length; i++) {
            if( count[fruits[i]]++ == 0) type++;

            while( type > 2 ) {
                if( --count[fruits[left]] == 0) type--;
                left++;
            }
            ans = Math.max(i-left+1,ans);
        }
        return ans;
        
    }
}