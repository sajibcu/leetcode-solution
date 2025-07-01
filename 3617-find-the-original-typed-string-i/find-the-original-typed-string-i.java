class Solution {
    public int possibleStringCount(String word) {
        if (word == null || word.isEmpty()) return 0;

        int ans = 1;
        int temp = 1;
        int i= 1;
        char c = word.charAt(0);
        while(  i < word.length()) {
            if( word.charAt(i) != word.charAt(i-1)) {
                ans +=temp-1;
                temp = 0;
            }
            temp++;
            i++;
        }
        ans +=temp-1;

        return ans;
        
    }
}