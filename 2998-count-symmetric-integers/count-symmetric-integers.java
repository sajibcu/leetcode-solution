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
        String s = String. valueOf(n);
        int l = s.length(); 
        if( (l&1) !=0) return 0;
        int digitSum = 0;
        for( int i = 0; i< l/2; i++) {
            digitSum +=s.charAt(i);
        }

        for( int i = l/2; i< l; i++) {
            digitSum -=s.charAt(i);
        }

        return digitSum == 0 ? 1 : 0;

    }
}