class Solution {
    public int minOperations(int[][] grid, int x) {

        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] freq = new int[10001];
        List<Integer> values = new ArrayList<>();

        int i=0;
        for( int[] row : grid) {
            for( int num: row) {
                freq[num]++;
                if(freq[num]==1) values.add(num); 
            }
        }
        if (values.size() < 2) return 0;
        int ans = 0;

        int median =findMedian(freq, size/2);
        //System.out.println(median);
        for( int num: values) {
            int gap =  Math.abs(median - num); 
            if( gap % x != 0) return -1;
           // System.out.println(freq[num]);
            ans +=(gap/x)*freq[num];
        }

        return ans;
        
    }

    public int findMedian(int[] freq, int size) {
        int cnt = 0;
        for( int i =0 ; i< freq.length; i++) {
            cnt += freq[i];
            if( cnt > size ) return i;
        }
        return freq.length;
    }
}