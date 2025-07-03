class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        while( sb.length() < k ) {
            int l = sb.length();
            for( int i=0; i< l; i++) {
                char c = sb.charAt(i);
                if( c == 'z') c = 'a';
                else c = (char) (c + 1);
                sb.append(c);
            }
        }
        return sb.charAt(k-1);
    }
}