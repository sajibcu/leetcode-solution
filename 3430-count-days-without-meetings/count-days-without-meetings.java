class Solution {
    // public int countDays(int days, int[][] meetings) {
    //     int[] line = new int[days+1];

    //     for(int m[]: meetings ) {
    //         line[m[0]] = Math.max(line[m[0]],m[1]); 
    //     }
    //     int available = 0;
    //     for( int i =1; i<= days; i++) {
    //         line[i] = Math.max(line[i], line[i-1] );
    //         if(line[i] < i ) line[i] = 0;
    //         if( line[i] == 0 ) available++;
    //     }
    //     return available;
    // }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        int available = 0, lastOccupied = 0;

        for( int meeting[]: meetings ) {
            int start = meeting[0], end = meeting[1];
            if( start-1  > lastOccupied ) available +=(start-1)-lastOccupied;
            lastOccupied = Math.max(lastOccupied, end);
        }
        if( days > lastOccupied)
        available +=days-lastOccupied;

        return available;
    }
    
}