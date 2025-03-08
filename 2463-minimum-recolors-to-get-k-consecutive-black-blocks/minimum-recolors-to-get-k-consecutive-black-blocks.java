class Solution {
    public int minimumRecolors(String blocks, int k) {
        int w = 0 , ans = k;
        int i = 0;
        while( i < k ){
            if(blocks.charAt(i) == 'W') w++;
            i++;
        }

        ans = Math.min(w, ans);

        while( i < blocks.length() ){
            if(blocks.charAt(i) == 'W') w++;
            if(blocks.charAt(i-k) == 'W') w--;
            ans = Math.min(w, ans);
            i++;
        }

        return ans;
        
    }
}