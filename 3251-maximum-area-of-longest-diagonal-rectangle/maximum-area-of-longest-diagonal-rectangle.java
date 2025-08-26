class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {

        double diagonal = 0f;
        int area = 0;

        for(int d[] : dimensions ) {
            double current = Math.sqrt(d[0]*d[0] + d[1]*d[1]);
            if( current > diagonal) {
                diagonal = current;
                area = d[0]*d[1];
            }else if( current ==diagonal ) area = Math.max(area, d[0]*d[1]);
        }

        return area;
        
    }
}