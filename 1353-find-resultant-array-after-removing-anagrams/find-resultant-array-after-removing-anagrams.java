class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();

        for( String s: words) {
            if( ans.size() == 0) ans.add(s);
            else if ( !isAnagram(ans.get(ans.size()-1), s)) {
                ans.add(s);
            }
        }

        return ans;
        
    }

    public boolean isAnagram(String s1, String s2) {
        int l1 = s1.length(), l2 =s2.length();
        if( l1 != l2 ) return false; 
        int[] freq = new int[256];
        for( int i = 0; i< l1;i++) freq[s1.charAt(i)]++;
        for( int i = 0; i< l2;i++){
            freq[s2.charAt(i)]--;
            if(freq[s2.charAt(i)] < 0) return false;
        }

        return true;
    }
}