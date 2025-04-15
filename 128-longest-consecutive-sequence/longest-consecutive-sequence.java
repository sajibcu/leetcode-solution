class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int n : nums) {
            mp.put(n, 1);
        }

        int ans = 0;

        for (int n : nums) {
            if (!mp.containsKey(n)) continue;

            int temp = 0;

            // Count upwards
            for (int i = n; ; i++) {
                if (mp.containsKey(i)) {
                    temp++;
                    mp.remove(i);
                } else {
                    break;
                }
            }

            // Count downwards
            for (int i = n - 1; ; i--) {
                if (mp.containsKey(i)) {
                    temp++;
                    mp.remove(i);
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
