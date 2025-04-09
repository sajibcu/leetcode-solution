class Solution {
    public String reverseVowels(String s) {
        char[] ar = s.toCharArray();

        int start = 0, end = s.length()-1;

        while( start < end ) {
            while( start < end && !isVowel(ar[start]) ) {
                
                start++;
            }

            while( start < end && !isVowel(ar[end]) ) {
                
                end--;
            }

            char temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
            start++;
            end--;
        }

        return new String(ar);
        
    }

    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

}