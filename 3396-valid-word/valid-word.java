class Solution {
    public boolean isValid(String word) {
        if( word.length() < 3) return false;
        String regex = "^[0-9A-Za-z]+$";
        if( !word.matches(regex) ) return false;
        boolean hasVowel = false,hasConsonant=false;

        for(int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if( c >='0' && c<='9' ) {
                // nothing
                continue;
            }
            else if( isVowel(c) ) hasVowel = true;
            else hasConsonant = true;
            
            if(hasVowel && hasConsonant) return true;
        }
        return false;
    }

    public boolean isVowel(char c) {
        switch (c) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
            case 'A': case 'E': case 'I': case 'O': case 'U':
                return true;
            default:
                return false;
        }
    }

    public boolean isConsonant(char c) {
        return Character.isLetter(c) && !isVowel(c);
    }
}
