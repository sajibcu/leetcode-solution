class Solution {
    boolean[] isVowels;
    public String sortVowels(String s) {
        initiate();

        List<Character> vowels = new ArrayList<>();
        for(int i=0;i<s.length(); i++) {
            char c = s.charAt(i);
            if( isVowels[c]) {
                vowels.add(c);
            }
        }

        Collections.sort(vowels);
        StringBuilder ans = new StringBuilder();
        int l =0;

        for(int i=0;i<s.length(); i++) {
            char c = s.charAt(i);
            if( isVowels[c]) {
                ans.append(vowels.get(l++));
            }else {
                ans.append(c);
            }
        }

        return ans.toString();

    }

    public void initiate() {
        isVowels = new boolean[256];
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        for (char v : vowels) {
            isVowels[v] = true;
        }
    }
}