class TrieNode {
    Map<Character,TrieNode> child = new HashMap<>();
    boolean isWord = false;
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        
        TrieNode current = root;

        for(int i = 0;i< word.length();  i++ ){
            char c = word.charAt(i);
            current = current.child.computeIfAbsent(c, v -> new TrieNode());
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {

        TrieNode current = root;
        for(int i = 0; i< word.length(); i++ ){
            char c = word.charAt(i);
            if( !current.child.containsKey(c)) return false;
            current = current.child.get(c);
        }

        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {

        TrieNode current = root;
        for(int i = 0; i< prefix.length(); i++ ){
            char c = prefix.charAt(i);
            if( !current.child.containsKey(c)) return false;
            current = current.child.get(c);
        }

        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */