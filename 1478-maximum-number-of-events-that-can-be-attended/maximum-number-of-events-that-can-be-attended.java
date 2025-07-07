class Solution {
    int[] parent;
    public int maxEvents(int[][] events) {

        Arrays.sort(events, (a,b) -> a[1] - b[1]);
        int max = 0;
        for(int[] e: events) max =Math.max(e[1],max);
        parent = new int[max+2];
        for(int i=0;i<max+2; i++) parent[i] = i;
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