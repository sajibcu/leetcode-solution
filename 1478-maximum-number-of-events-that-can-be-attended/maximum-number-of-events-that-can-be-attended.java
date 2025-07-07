class Solution {
    int[] parent;
    public int maxEvents(int[][] events) {

        Arrays.sort(events, (a,b) -> a[1] - b[1]);
        parent = new int[100002];
        for(int i=0;i<100002; i++) parent[i] = i;
        int ans = 0;

        for(int[] e : events) {
           int day = find(e[0]);
           if( day <= e[1]) {
            ans++;
            parent[day] = find(day+1);
           }
        }
        return ans; 
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}