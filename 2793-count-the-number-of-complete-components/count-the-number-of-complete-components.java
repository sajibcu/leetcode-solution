class Solution {
    int[] parent;
    int[] rank;
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        int[] numberOfEadge = new int[n];

        for(int i =0; i<n; i++) parent[i] = i;

        for(int e[]: edges) {
            union(e[0], e[1]); 
        }

        int[] numberOfNode = new int[n];

        Set<Integer> st = new HashSet<>();
        for(int i=0;i<n;i++) {
            numberOfNode[find(i)]++;
            st.add(find(i));
        }

        for(int e[]: edges) {
            // union(e[0], e[1]);  
            numberOfEadge[find(e[0])]++;
        }

        int completed = 0;

        for(int root : st) {
            int expected = numberOfNode[root] * (numberOfNode[root] - 1)/2;
            if( numberOfEadge[root] == expected ) completed++;
        }

        return completed;
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if( rootU == rootV) return;

        if( rank[rootU] >= rank[rootV]) {
            rank[rootU]++;
            parent[rootV] = rootU;
        }else {
            rank[rootV]++;
            parent[rootU] = rootV;
        }
    }

    public int find(int i) {
        if( parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }
}