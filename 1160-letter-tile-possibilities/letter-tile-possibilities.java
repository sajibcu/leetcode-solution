class Solution {
    public int numTilePossibilities(String tiles) {

        Set<String> set = new HashSet<>();
        makeAllPossibitites("",tiles,set);

        return set.size();
    }

    public void makeAllPossibitites(String s, String t,Set<String> set){
        if( !"".equals(s)) {
            set.add(s);
        }

        for (int i = 0; i < t.length(); i++) {
            makeAllPossibitites(s + t.charAt(i), t.substring(0, i) + t.substring(i + 1), set);
        }
    }
}