class Solution {
    public int maxEvents(int[][] events) {

        Arrays.sort(events, (a,b) -> a[1] - b[1]);
        int max = 0,min=100000;
        for(int[] e : events) {
            max = Math.max(max,e[1]);
            min = Math.min(min, e[0]);
        }
        TreeSet<Integer> availableDays = new TreeSet<>();

        while(min <= max) 
        {
            availableDays.add(min);
            min++;
        }
        int ans = 0;

        for(int[] e : events) {
            Integer day = availableDays.ceiling(e[0]);
            if( day != null && day <=e[1] ) {
                ans++;
                availableDays.remove(day);
            }
        }
        return ans;


        
    }
}