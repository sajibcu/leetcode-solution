class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0,j=0;
        int pl = players.length;
        int tl = trainers.length;
        int ans = 0;
        while(i<pl && j<tl) {
            if( trainers[j] >= players[i] ) {
                i++;
                j++;
                ans++;
            }else {
                j++;
            }
        }

        return ans;
        
    }
}