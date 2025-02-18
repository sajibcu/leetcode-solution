class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> p = new ArrayList<>();

        bracktrack(p, new ArrayList<>(), nums);

        return p;
    }

    public void bracktrack(List<List<Integer>> p, List<Integer> temp, int[] nums ) {
        if( nums.length == temp.size()) {
            p.add(new ArrayList<>(temp));
            return;
        }

        for(int n: nums) {
            if( temp.contains(n)) continue;
            temp.add(n);
            bracktrack(p, temp, nums);
            temp.remove( temp.size() - 1 );
        }
    }
}