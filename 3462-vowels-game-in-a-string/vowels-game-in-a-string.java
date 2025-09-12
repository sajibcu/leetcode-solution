class Solution {
    public boolean doesAliceWin(String s) {
        int vowels = 0;
        for(int i =0; i< s.length(); i++ ) {
            if( isVowel(s.charAt(i))) vowels++;
        }

        if( vowels ==0  ) return false;
        return true;
    }

    public boolean isVowel( char c) {
        return "aeiou".indexOf(c) !=-1;
    }
}