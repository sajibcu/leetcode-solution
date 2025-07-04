class Solution {
    public char kthCharacter(long k, int[] operations) {

        int level = 0;
        for(int i=0; i < operations.length;i++) {
            if( k == 1 ) break;
            if( operations[i] == 1 && k%2 == 0 ) level++;
            k = (k+1)/2;
        }
        return (char)(( level )%26 + 'a' );
        
    }
}