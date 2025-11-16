class Solution {
    public int numSub(String s) {
        long mod = 1000000007L;

        long ans = 0;
        long one = 0;
        for(int i=0;i<s.length(); i++) {
            if( s.charAt(i) == '1') one++;
            else one = 0;
            ans =(one+ans)%mod; 
        }

        return (int)ans;
        
    }
}