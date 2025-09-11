class Solution {
    public String sortVowels(String s) {

        List<Character> vowels = new ArrayList<>();
        for(int i=0;i<s.length(); i++) {
            char c = s.charAt(i);
            if( isVowel(c)) {
                vowels.add(c);
            }
        }

        Collections.sort(vowels);
        StringBuilder ans = new StringBuilder();
        int l =0;

        for(int i=0;i<s.length(); i++) {
            char c = s.charAt(i);
            if( isVowel(c)) {
                ans.append(vowels.get(l++));
            }else {
                ans.append(c);
            }
        }

        return ans.toString();

    }

    public boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
}
}