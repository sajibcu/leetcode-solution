class Solution {
    public int findContentChildren(int[] g, int[] s) {
         
        Thread sortG = new Thread(()-> Arrays.sort( g ) );
        Thread sortS = new Thread(() -> Arrays.sort( s ) );
        sortG.start();
        sortS.start();
        try{
            sortG.join();
            sortS.join();

        }catch (Exception e) {
            
        }

        int i= 0;
        int j=0;
        while( i<g.length && j<s.length ){ 
            if( s[j] < g[i] ){
                j++;
                continue;
            } 
            j++;
            i++;
        }
        return i;
        
    }
}