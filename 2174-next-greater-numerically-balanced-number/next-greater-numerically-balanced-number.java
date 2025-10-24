class Solution {
    public int nextBeautifulNumber(int n) {

        while( true){
            n++;
            //System.out.println(n);
            //if( n >100) return n;
            if(isBalanced(n)) return n;
        }
        
    }

    public boolean isBalanced(int n) {
        int[] freq = new int[10];
        while( n > 0) {
            int r = n%10;
            freq[r]++;
            n/=10;
            if( freq[r] > r) return false;
        }
        for(int i=0;i<10;i++) if( freq[i] != 0 && freq[i] !=i) return false;
        return true;
    }
}