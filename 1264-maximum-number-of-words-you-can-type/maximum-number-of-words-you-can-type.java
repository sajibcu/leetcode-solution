class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[256];
        for(int i=0;i<brokenLetters.length();i++) {
            broken[brokenLetters.charAt(i)] = true;
        }

        int ans = 0;
        for( String s : text.split(" ")) {
            if( isOk(s,broken)) {
                ans++;
            }
        }
        return ans;
        
    }
    public boolean isOk(String s, boolean[] broken) {
        if( s == "") return false;
        for(int i=0;i<s.length();i++) {
           if(broken[s.charAt(i)] ) return false;
        }

        return true;
    }
}