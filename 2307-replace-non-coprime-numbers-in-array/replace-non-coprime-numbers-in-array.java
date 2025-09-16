class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int a : nums) {
            int cur = a;
             while (!st.isEmpty() && gcd(st.peek(), cur) > 1) {
                int top = st.pop();
                cur = (int)lcm(top, cur);
            }
            st.push(cur);
        }

        return st.stream().toList();
        
    }

    public int gcd(int a, int b) {
        if( b < a ) {
            int t = a;
            a= b;
            b=t;
        }
        while (b != 0) {
            int temp = b;
            b = a % b; // remainder
            a = temp;
        }
        return a;
    }

    public long lcm(int a, int b) {
        return (long)a*b/gcd(a,b);
    }
}