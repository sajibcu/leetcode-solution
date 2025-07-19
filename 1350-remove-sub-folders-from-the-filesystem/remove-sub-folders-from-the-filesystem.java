class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        Trie trie = new Trie();
        for( String s: folder) {
            trie.insert(s);
        }
        return trie.search();
        
    }

}
class TrieNode {
    boolean isFolder;
    Map<String, TrieNode> child;
    TrieNode() {
        this.isFolder = false;
        child = new HashMap<>();
    }
}
class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String s) {
        String[] folders = s.split("/");
        TrieNode node = root;
        for( String folder : folders) {
            if( "".equals(folder)) continue;
            if(!node.child.containsKey(folder)) {
                node.child.put(folder, new TrieNode());
            }
            node = node.child.get(folder);
            if( node.isFolder) break;

        }
        node.isFolder = true;
        node.child.clear();
    }

    public List<String> search() {
        List<String> ans = new ArrayList<>();
        dfs(root, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(TrieNode node, StringBuilder path, List<String> ans) {
        if( node.isFolder) {
            ans.add(path.toString());
            return;
        }

        for(String k : node.child.keySet()) {
            TrieNode child = node.child.get(k);
            int len = path.length();
            path.append("/").append(k);
            dfs(child,path,ans);
            path.setLength(len); //backtrack
           
        }
    }

}