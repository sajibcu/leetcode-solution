class Solution {

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for( String s: strs) {
            trie.insert(s);
        }

        // trie.print();

        return trie.findLCP();
        
    }
}

class TrieNode{
    Map<Character,TrieNode> children = new HashMap<>();
    boolean isEndWord = false;
}

class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String s) {
        TrieNode temp = root;

        for(int i =0; i< s.length(); i++) {
            char c = s.charAt(i);
            temp = temp.children.computeIfAbsent(c,t -> new TrieNode() );
        }
        temp.isEndWord = true;

    }

    public String findLCP() {
        StringBuilder sb = new StringBuilder();

        TrieNode temp = root;
        while(temp != null) {
            
            if( temp.isEndWord || temp.children.keySet().size() != 1 ) break;
            for( char c: temp.children.keySet() ) {
                sb.append(c);
                temp = temp.children.get(c);
                break;
            }

        }

        return sb.toString();

    }

    public void print() {
        System.out.println("----------print-----------");
        // TrieNode temp = root;
        Stack<TrieNode> node = new Stack<>();
        node.add(root);

        while(!node.isEmpty()) {
            var child = node.pop().children;
            for(char c : child.keySet()) {
                System.out.print(c+",");
                node.push(child.get(c));
            }
            System.out.println();

        }

    }
}