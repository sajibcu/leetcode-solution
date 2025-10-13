class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);

        for( int i=1;i<words.length;i++) {
            if ( !isAnagram(words[i], words[i-1])) {
                ans.add(words[i]);
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