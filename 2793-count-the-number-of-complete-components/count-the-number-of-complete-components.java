class Solution {
    int[] parent; // Stores the parent of each node for union-find
    int[] rank;   // Stores the rank (depth) of each tree in union-find
    
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        int[] numberOfEadge = new int[n]; // Stores the number of edges in each component

        // Initialize parent array, where each node is its own parent initially
        for(int i = 0; i < n; i++) parent[i] = i;

        // Perform union operation on all edges to form connected components
        for(int e[] : edges) {
            union(e[0], e[1]); 
        }

        int[] numberOfNode = new int[n]; // Stores the number of nodes in each component
        Set<Integer> st = new HashSet<>(); // Set to track unique root nodes (components)
        
        for(int i = 0; i < n; i++) {
            numberOfNode[find(i)]++; // Count nodes in each component
            st.add(find(i)); // Track unique components
        }

        // Count the number of edges in each component
        for(int e[] : edges) {
            numberOfEadge[find(e[0])]++;
        }

        int completed = 0; // Counter for complete components

        // Check if each component is a complete component
        for(int root : st) {
            int expected = numberOfNode[root] * (numberOfNode[root] - 1) / 2; // Expected number of edges in a complete graph
            if(numberOfEadge[root] == expected) completed++; // If actual edges match expected, it's a complete component
        }

        return completed;
    }

    // Union-Find: Union operation with rank-based merging
    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if(rootU == rootV) return; // Already in the same component

        // Attach smaller tree to the larger tree to balance depth
        if(rank[rootU] >= rank[rootV]) {
            rank[rootU]++;
            parent[rootV] = rootU;
        } else {
            rank[rootV]++;
            parent[rootU] = rootV;
        }
    }

    // Union-Find: Find operation with path compression
    public int find(int i) {
        if(parent[i] != i) parent[i] = find(parent[i]); // Path compression
        return parent[i];
    }
}
