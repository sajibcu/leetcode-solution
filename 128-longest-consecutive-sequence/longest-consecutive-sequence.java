class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        HashSet<Integer> isVisited = new HashSet<>();

        for (int n : nums) {
            mp.put(n, 1);
        }

        int ans = 0;

        for (int n : nums) {
            if (isVisited.contains(n)) continue;

            int temp = 0;

            // Count upwards
            for (int i = n; ; i++) {
                if (mp.containsKey(i)) {
                    temp++;
                    isVisited.add(i);
                } else {
                    break;
                }
            }

            // Count downwards
            for (int i = n - 1; ; i--) {
                if (mp.containsKey(i)) {
                    temp++;
                   isVisited.add(i);
                } else {
                    break;
                }
            }

            if (temp > ans) {
                ans = temp;
            }
        }

        return ans;
    }
}
