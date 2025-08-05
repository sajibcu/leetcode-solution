class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int unplaced =0;
        for( int f: fruits) {
            int i=0;
            while(i < baskets.length && f > baskets[i]) i++;
            if( i == baskets.length) {
                unplaced++;
            }else {
                baskets[i] = -1;
            }
            
        }
        return unplaced;
        
    }
}