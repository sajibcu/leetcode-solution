class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i< s.length(); i++) {
            char c = s.charAt(i);
            if( c >='a' && c<='z') {
                st.push(c);
            }else {
                if( st.isEmpty()) {
                    st.push(c);
                }else {
                    char p = st.peek();
                    if( p >='a' && p<='z') {
                        st.pop();
                    }else {
                        st.push(c);
                    }
                }
            }
        }

        String ans = "";

        while(!st.isEmpty()) {
            ans = st.pop()+ ans ;
        }

        return ans;
    }
}