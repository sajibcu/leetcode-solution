class Solution {

    int[] parent;
    int[] rank;
    int[] ands;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {

        parent = new int[n];
        rank = new int[n];
        ands = new int[n];
        int[] ans = new int[query.length];

        for(int i = 0; i< n; i++ ) {
            parent[i] = i;
            ands[i] = Integer.MAX_VALUE;
        }

        for(int[] e:  edges ) {
            union(e[0],e[1],e[2]);
        } 
        int i=0;

        for( int[] q: query) {
            int q1 = find(q[0]);
            int q2 = find(q[1]);
            ans[i++] = (q1 == q2 ) ? ands[q1] : -1;
        }

        return ans;
    }

    public void union(int u, int v, int w) {
        int rootU = find(u);
        int rootV = find(v);

        if( rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
            ands[rootU] &=(w&ands[rootV]); 
            rank[rootU]++;
        }else {

            parent[rootU] = rootV;
            ands[rootV] &=(w&ands[rootU]); 
            rank[rootV]++; 
        }
    }

    public int find( int i) {
        if( parent[i] == i) return i;
        return find(parent[i]);
    }
}