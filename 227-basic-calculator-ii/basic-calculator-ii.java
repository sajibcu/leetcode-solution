class Solution {
    public int calculate(String s) {

        Stack<Integer> num = new Stack<>();
        int current = 0;
        char lastOp = '+';

        int len = s.length();

        for(int i = 0; i< len; i++) {
            char c = s.charAt(i);
            if( Character.isDigit(c)) current = current*10+c-'0';

            //System.out.println(current);

            if( !Character.isDigit(c) && c !=' ' || i==len-1 ) {

                if( lastOp == '+') {
                    num.push(current);
                }else if( lastOp == '-') {
                    num.push(-current);
                }else if( lastOp == '*') {
                    num.push(num.pop() * current);
                }else if( lastOp == '/' && current != 0) {
                    num.push(num.pop() / current);
                }

                current = 0;
                lastOp = c;
            }
        }

        int ans = 0;
        for(int n: num) ans +=n;
        return ans;
    }
}