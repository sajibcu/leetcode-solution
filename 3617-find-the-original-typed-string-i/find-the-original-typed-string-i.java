class Solution {
    public int possibleStringCount(String word) {

        int ans = 1;

        int temp = 0;
        char[] charArray = word.toCharArray();
        int i= 0;
        char c = charArray[0];
        while(  i < charArray.length) {
            if( c != charArray[i]) {
                c = charArray[i];
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