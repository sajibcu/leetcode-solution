class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");

        for(int i = 2; i<= n; i++) {
            
            sb = countAndSay(sb);
        }

        return sb.toString();
    }

    public StringBuilder countAndSay(StringBuilder sb) {
        StringBuilder temp = new StringBuilder();
        int j = 0;
        while( j < sb.length() ) {
            char c = sb.charAt(j);
            int cnt = 0;
            while(j < sb.length() && c == sb.charAt(j)) {
                cnt++;
                j++;
            }
            temp.append(String.valueOf(cnt));
            temp.append(c);
        }
        return temp;
    }
}