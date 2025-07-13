class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Thread sortPlayers = new Thread(()-> Arrays.sort(players) );
        Thread sortTrainers = new Thread(() -> Arrays.sort(trainers));
        sortPlayers.start();
        sortTrainers.start();
        try{
            sortPlayers.join();
            sortTrainers.join();

        }catch (Exception e) {
            
        }


        // process
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