class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for( String s: strs ) {
           int[] count = new int[26];  // Frequency array for characters 'a' to 'z'
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // Convert frequency array to a string key
            String key = Arrays.toString(count);

            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(mp.values());
        
    }
}