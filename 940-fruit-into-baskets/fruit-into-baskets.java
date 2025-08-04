class Solution {
    public int totalFruit(int[] fruits) {

        int ans = 0;
        int temp =0;

        Map<Integer,Integer> mp = new HashMap<>();
        int left = 0;
        for(int i=0;i<fruits.length; i++) {
            mp.put(fruits[i], mp.getOrDefault(fruits[i], 0) +1);
            while( left < i && mp.keySet().size() > 2 ) {
                if(mp.get(fruits[left]) == 1) {
                    mp.remove(fruits[left]);
                }else {
                    mp.put(fruits[left], mp.getOrDefault(fruits[left], 0) -1);
                }
                left++;
            }

            ans = Math.max(i-left+1,ans);
            //System.out.println(i+"$$"+left+"$$"+ans);
        }
        return ans;
        
    }
}