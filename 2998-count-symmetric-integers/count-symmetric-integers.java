class Solution {
    public int countSymmetricIntegers(int low, int high) {

        int ans = 0;
        while( low <=high) {
            ans +=symmetric(low);
            low++;
        }

        return ans;
        
    }

    public int symmetric(int n) {
        int left = 0, right =0;

        if( n >=10 && n<=99 ) {
            return n%10 == n/10 ? 1 : 0;
        }

        if( n >=1000 && n<=9999) {
            right += n%10;
            n/=10;
            right += n%10;
            n/=10;

            left = n%10 + n/10;
            return left == right ? 1 : 0;

        }


        return 0;
    }
}