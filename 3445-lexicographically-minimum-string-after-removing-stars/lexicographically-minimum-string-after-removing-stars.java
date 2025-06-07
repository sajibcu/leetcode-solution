class Solution {
    public String clearStars(String s) {

        List<PriorityQueue<Integer>> pq = new ArrayList<>();
    
        for(int i=0;i<26;i++)  {
            pq.add(new PriorityQueue<>(Collections.reverseOrder()));
            pq.get(i).add(-1);
        }

        boolean[] isDeleted = new boolean[s.length()];
        int[] freq = new int[26];
 
        for(int i =0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(c == '*') {
                isDeleted[i] = true;
                int min = 0;
                while(min < 26 && freq[min]==0) min++;
                
                int minIndex = pq.get(min).poll();
                isDeleted[minIndex] = true;
                freq[min]--;

            }else {
                freq[c-'a']++;
                pq.get(c-'a').add(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i =0; i< isDeleted.length; i++) {
            if(!isDeleted[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
        
    }
}