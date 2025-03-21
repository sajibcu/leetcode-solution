class Solution {

    int[] parent; // Array to store parent of each node (for union-find)
    int[] rank;   // Array to store the rank (height) of each tree in union-find
    int[] ands;   // Array to store the AND operation result for each connected component

    public int[] minimumCost(int n, int[][] edges, int[][] query) {

        parent = new int[n];
        rank = new int[n];
        ands = new int[n];
        int[] ans = new int[query.length];

        // Initialize each node as its own parent and set the initial AND values to the maximum integer value
        for(int i = 0; i < n; i++) {
            parent[i] = i;  // Initially, each node is its own parent
            ands[i] = Integer.MAX_VALUE;  // Set maximum value, as we will perform AND operations
        }

        // Process all edges and apply union operation
        for(int[] e : edges) {
            union(e[0], e[1], e[2]); // Merge the components with the given edge weight
        } 

        int i = 0;

        // Process each query
        for(int[] q : query) {
            int q1 = find(q[0]);  // Find the root of the first node
            int q2 = find(q[1]);  // Find the root of the second node
            ans[i++] = (q1 == q2) ? ands[q1] : -1; // If both nodes are in the same component, return AND value, otherwise return -1
        }

        return ans; // Return the result for all queries
    }

    // Union operation: merges two sets and updates the AND operation
    public void union(int u, int v, int w) {
        int rootU = find(u);  // Find root of node u
        int rootV = find(v);  // Find root of node v

        // Merge based on rank to keep tree balanced
        if(rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;  // Attach rootV to rootU
            ands[rootU] &= (w & ands[rootV]);  // Update AND value for the merged component
            rank[rootU]++;  // Increase rank of rootU
        } else {
            parent[rootU] = rootV;  // Attach rootU to rootV
            ands[rootV] &= (w & ands[rootU]);  // Update AND value for the merged component
            rank[rootV]++;  // Increase rank of rootV
        }
    }

    // Find operation (without path compression)
    public int find(int i) {
        if(parent[i] == i) return i; // If node is its own parent, return it as the root
        return find(parent[i]); // Recursively find the root of the component
    }
}
