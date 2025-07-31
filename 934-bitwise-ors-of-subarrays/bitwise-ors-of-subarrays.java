class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> allOr = new HashSet<>();
        Set<Integer> previous = new HashSet<>();

        for(int n: arr) {
            Set<Integer> curOrs = new HashSet<>();
            curOrs.add(n);
            for( int a: previous) curOrs.add(a|n);
            previous = curOrs;
            allOr.addAll(previous);
        }

        return allOr.size();  
    }
}