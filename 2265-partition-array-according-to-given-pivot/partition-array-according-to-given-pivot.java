class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        List<Integer> smalls = new ArrayList<>();
        List<Integer> greters = new ArrayList<>();
        List<Integer> privots = new ArrayList<>();

        for(int n: nums ) {
            if( n < pivot ) {
               smalls.add(n); 
            } else if( n > pivot ) {
               greters.add(n); 
            }
            else {
                privots.add(n);
            }
        }
        smalls.addAll( privots);
        smalls.addAll(greters);
        return smalls.stream().mapToInt(Integer::intValue).toArray();
    }
}