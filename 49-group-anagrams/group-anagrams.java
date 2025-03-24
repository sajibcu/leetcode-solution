class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for( String s: strs ) {
            String sortedString = s.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
            mp.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> ans = new ArrayList<>();

        for( String key : mp.keySet()) {
            ans.add( mp.get(key) );
        }

        return ans;
        
    }
}