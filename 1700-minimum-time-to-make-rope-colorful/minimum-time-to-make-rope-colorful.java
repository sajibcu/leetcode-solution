class Solution {
    public int minCost(String colors, int[] neededTime) {

        int tempMax = neededTime[0];
        int total = neededTime[0];

        for(int i = 1; i < colors.length(); i++ ) {
            total += neededTime[i];
            if(colors.charAt(i) != colors.charAt(i-1) ) {
                total -=tempMax;
                tempMax = neededTime[i];
            }
            tempMax = Math.max(neededTime[i], tempMax);
        }

        total -=tempMax;

        return total;
        
    }

    public int getRemovedTime(List<Integer> time) {
        int max = 0;
        int total = 0;
        for( int t : time) {
            total +=t;
            if( t > max) max = t;
        }

        return total - max;
    }
}