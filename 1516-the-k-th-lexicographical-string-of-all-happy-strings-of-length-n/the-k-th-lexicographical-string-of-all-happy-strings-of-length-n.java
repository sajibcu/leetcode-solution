class Solution {
    private String ans = "";
    private int count = 0;
    public String getHappyString(int n, int k) {
        List<String> allString = new ArrayList<>();
        ans = "";
        count = 0;
        bracktrack(new StringBuilder(),n, k);
        
        return ans;
        
    }

    public void bracktrack( StringBuilder path,int n, int k){
        if(count >= k ) return;
        if( path.length() == n ) {
            count++;
            if(count == k ){
                ans = path.toString();
            }
            return;
        }else if(path.length() > n) {
            return;
        }

        for(char c : new char[]{'a','b','c'}) {
            
            if( path.length() < 1 ||
                c != path.charAt(path.length()-1)
            ) {
                path.append(c);
                bracktrack(path,n,k);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}