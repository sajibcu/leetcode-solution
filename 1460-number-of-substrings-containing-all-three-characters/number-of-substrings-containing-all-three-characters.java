class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] count = {0, 0, 0};
        int ans = 0;
        int left = 0;
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
            
            while( count[0] > 0 && count[1]> 0 && count[2]> 0) {
                
                ans += s.length() - i;
                count[s.charAt(left++) - 'a']--;
            }
            
        }

        return ans;
        
    }
}