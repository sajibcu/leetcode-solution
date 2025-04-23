class Solution {
    public int countLargestGroup(int n) {
        int[] freq = new int[37];
        while( n > 0) {
            freq[getDigitSum(n--)]++;
        }
        int ans = 0;
        int mx = 0;
        for( int a: freq)  {
            //System.out.println(a);
            if( a > ans) {
                ans = a;
                mx = 1;
            }else if( a == ans) mx++; 
        }
        return mx;
    }

    public int getDigitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum +=n%10;
            n /=10;
        }

        return sum;
    }
}