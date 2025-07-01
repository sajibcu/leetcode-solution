class Solution {
    public int possibleStringCount(String word) {
        if (word == null || word.isEmpty()) return 0;

        int ans = 1;
        int i= 1;
        while(  i < word.length()) {
            if( word.charAt(i) == word.charAt(i-1)) {
                ans ++;
            }
            i++;
        }
        return ans;
        
    }
}