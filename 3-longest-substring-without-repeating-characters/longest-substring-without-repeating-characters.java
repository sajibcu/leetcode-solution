class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];

        int ans = 0,l=0;
        for(int i = 0; i<s.length(); i++ ) {
            char c = s.charAt(i);
            if( freq[c] == 1) {
                // System.out.println(l+"&&"+i);
                while( s.charAt(l) != c ) {
                    freq[s.charAt(l)]--;
                    l++;
                }
                freq[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans, i-l+1);
            freq[c]++;
        }
        

        return ans;
    }
}