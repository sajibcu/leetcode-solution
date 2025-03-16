class Solution {
    public long repairCars(int[] ranks, int cars) {
        int minRank = Arrays.stream(ranks).min().getAsInt();
        long l = 0, r = 1L*minRank*cars*cars;

        long mid = l + (r-l)/2;
        long result = 0;

        while( l <= r) {
            mid = l + (r-l)/2;
            if( canRepair(ranks, mid) >= cars) {
                result = mid;
                r = mid-1;
            }else {
                l = mid + 1;
            }
        }

        return result;
    }

    public long canRepair( int[] ranks, long minites ) {
        long cars = 0;
        for(int r: ranks ) {
            cars += (int) Math.sqrt(minites / r);
        }
        // System.out.println(cars+"##"+minites);

        return cars;
    }
}