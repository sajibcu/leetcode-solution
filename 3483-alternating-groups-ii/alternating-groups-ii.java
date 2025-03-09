class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int cnt = 0;
        int n = colors.length;
        int alternate = 0;
        // for( int i = 0; i< k-1;i++ ){
        //     if(colors[i] != colors[i+1]) alternate++;
        // }
        // if (alternate == k-1) cnt++;

        for(int i = 0; i< n + k-2  ; i++){
            if(colors[i%n] != colors[(i+1)%n]) alternate++;
            else alternate = 0;

             if (alternate >= k-1 ) {
                cnt++;
                 
             }
        }
        return cnt;
        
    }
}