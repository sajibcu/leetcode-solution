class Solution {
    public int minimumRecolors(String blocks, int k) {
        int w = 0, b = 0 , ans = k;
        int i = 0;
        while( i < k ){
            if(blocks.charAt(i) == 'W') w++;
            else b++;
            i++;
        }

        ans = Math.min(w, ans);

        while( i < blocks.length() ){
            // System.out.println(w+"##" + b + "##" + ans);
            if(blocks.charAt(i) == 'W') w++;
            else b++;

            if(blocks.charAt(i-k) == 'W') w--;
            else b--;
            ans = Math.min(w, ans);
            i++;
        }

        return ans;
        
    }
}