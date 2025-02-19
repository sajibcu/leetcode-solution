class Solution {
    public String getHappyString(int n, int k) {
        List<String> allString = new ArrayList<>();
        bracktrack(allString, new StringBuilder(),n, k);
        String ans = "";
        
        return k > allString.size() ? "" : allString.get(k-1);
        
    }

    public void bracktrack(List<String> s, StringBuilder path,int n, int k){
        if(s.size() >= k ) return;
        if( path.length() == n ) {
           // if("")
            s.add(path.toString());
            return;
        }else if(path.length() > n) {
            return;
        }

        for(char c : new char[]{'a','b','c'}) {
            
            if( path.length() < 1 ||
                c != path.charAt(path.length()-1)
            ) {
                path.append(c);
                bracktrack(s,path,n,k);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}