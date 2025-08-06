class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
       
        int n = baskets.length;
        int m = (int) Math.sqrt(n);
        int section = (n + m - 1) / m;
        int count = 0;
        int[] maxV = new int[section];
        for(int i=0;i<n; i++) {
            maxV[i/m] = Math.max(maxV[i/m],baskets[i]);
        }

        int unplaced =0;
        int maxUplaced = Integer.MAX_VALUE;

        for(int f: fruits) {
            if(f >= maxUplaced){
                unplaced++;
                continue;
            }
            boolean isPlaced = false;
            
            for(int i=0; i<section; i++) {
                if(maxV[i] < f) continue;
                maxV[i] = -1;
                for(int j=0;j<m;j++) {
                    int mainIndex = i*m+j;
                    if( !isPlaced && mainIndex < n && baskets[mainIndex] >= f ) {
                        baskets[mainIndex] = -1;
                        isPlaced = true;
                    }
                    if( mainIndex < n )
                    maxV[i] = Math.max(maxV[i],baskets[mainIndex]);
                }
                break;
            }
            if(!isPlaced) {
                unplaced++;
                maxUplaced = Math.min(maxUplaced,f);
            }
            
        }

        return unplaced;
        
    }
}