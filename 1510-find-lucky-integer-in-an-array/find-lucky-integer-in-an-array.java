class Solution {
    public int findLucky(int[] arr) {

        int[] freq = new int[501];
        int max = 0;
        for(int n : arr) {
            freq[n]++;
            //if( n > max) max = n;
        }
        for(int i=500;i > 0;i--) {
            if( freq[i]==i) return i;
        }
        return -1;
        
    }
}