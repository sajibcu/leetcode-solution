class Solution {
    public int maximumGain(String s, int x, int y) {
       int point = x > y ? getPoint(s,'a','b',x,y) : getPoint(s,'b','a',y,x);
        return point;
    }

    public int getPoint(String s, char a, char b, int x, int y) {
        StringBuilder sb = new StringBuilder();
        int point = 0;
        for(int i = 0; i< s.length(); i++) {
            sb.append(s.charAt(i));
            int len = sb.length(); 
            if( len > 1 ) {
                if(a== sb.charAt(len-2) && b== sb.charAt(len-1)) {
                    point +=x;
                    sb.setLength(len-2);
                }
            }
        }
        s = sb.toString();
        sb = new StringBuilder();

        for(int i = 0; i< s.length(); i++) {
            sb.append(s.charAt(i));
            int len = sb.length(); 
            if( len > 1 ) {
                if(b== sb.charAt(len-2) && a== sb.charAt(len-1)) {
                    point +=y;
                    sb.setLength(len-2);
                }
            }
        }

        return point;
    }
}