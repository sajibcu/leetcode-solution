class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n-a;
        int[] ans = new int[2];
        while(a <= b ) {
            if( isContainZero(a) && isContainZero(b) ) {
                ans[0]=a;
                ans[1] = b;
                break;
            }
            a++;
            b--;
        }
        return ans;
    }

    public boolean isContainZero(int n) {
        while( n > 0) {
            if( n%10 == 0 ) return false;
            n/=10;
        }
        return true;
    }
}