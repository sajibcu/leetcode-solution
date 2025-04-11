class Solution {
    private int ar[] = new int[10001];

    Solution() {
        ar[0] = 0;
        for(int i =1; i<=10000 ; i++) {
            ar[i] = ar[i-1] + symmetric(i);
        }
    }

    public int countSymmetricIntegers(int low, int high) {

        return ar[high] - ar[low-1];
        
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