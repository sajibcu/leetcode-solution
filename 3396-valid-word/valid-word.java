class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        String regexAlphanumeric = "^[A-Za-z0-9]+$";
        String regexHasVowel = ".*[aeiouAEIOU].*";
        String regexHasConsonant = ".*[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z].*";

        return word.matches(regexAlphanumeric)
            && word.matches(regexHasVowel)
            && word.matches(regexHasConsonant);
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
}
