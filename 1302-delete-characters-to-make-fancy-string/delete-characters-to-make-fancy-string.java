class Solution {
    public String makeFancyString(String s) {
        char current = '.';
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == current) count++;
            else {
                current = c;
                count = 1;
            }
            if( count < 3) sb.append(c);
        }
        return sb.toString();
    }
}