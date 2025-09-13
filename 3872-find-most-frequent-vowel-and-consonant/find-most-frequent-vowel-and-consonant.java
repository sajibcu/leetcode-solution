class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[256];
        for(int i=0;i<s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        int maxVowel = 0;
        int maxConsonants = 0;
        for(char c : List.of('a','e','i','o','u')) {
            maxVowel = Math.max(maxVowel,freq[c]);
        }

        for(char c : List.of('b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z') ) {
            maxConsonants = Math.max(maxConsonants,freq[c]);
        }

        return maxVowel + maxConsonants;
    }
}