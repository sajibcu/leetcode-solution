class Solution {
    public int minCost(String colors, int[] neededTime) {

        int removedTime = 0;
        int consecutiveColor = 0;
        List<Integer> time = new ArrayList<>();
        time.add(neededTime[0]); 
        for(int i = 1; i < colors.length(); i++ ) {
            if(colors.charAt(i) != colors.charAt(i-1) ) {
                removedTime +=getRemovedTime(time);
                time = new ArrayList<>();
            }
            time.add(neededTime[i]);
        }

        removedTime +=getRemovedTime(time);

        return removedTime;
        
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