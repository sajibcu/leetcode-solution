class Solution {
    public String smallestNumber(String pattern) {
        boolean[] isUsed = new boolean[10];
        return bracktrack(pattern, new StringBuilder(), 0,isUsed);

    }
    public String bracktrack(String p, StringBuilder path, int index, boolean[] isUsed ) {
        if(path.length()-1 == p.length() ) {
            return path.toString();
        }

        for(int i=1;i<=9;i++) {
            if( isUsed[i] ) continue;
            //char c = p.charAt(index-1);
            if( index==0 || 
                (p.charAt(index-1)== 'I' &&  (path.charAt(path.length() -1) - '0') < i ) ||
                (p.charAt(index-1)== 'D' &&  (path.charAt(path.length() -1) - '0') > i ) 
                
            ){
                path.append(i);
                isUsed[i] = true;
                String ans = bracktrack(p,path,index+1,isUsed);
                if( !"".equals(ans)) return ans;
                isUsed[i] = false;
                path.deleteCharAt(path.length() -1 );
            }

        }

        return "";
    }
}