class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for(String s: words) trie.insert(s);

        return trie.findLongest();
        
    }
}

class Trie {
    private TrieNode root = new TrieNode();

    public void insert( String s) {
        TrieNode current = root;

        for(int i =0; i< s.length(); i++) {
            current = current.child.computeIfAbsent(s.charAt(i), v-> new TrieNode() );
        }

        current.isWord = true;
    }

     public String findLongest() {
        return dfs(root, new StringBuilder());
    }

    public String dfs(TrieNode current, StringBuilder sb) {
        String longest = sb.toString();

        for( char c : current.child.keySet() ) {
            TrieNode node = current.child.get(c);
            if( node.isWord ) {
                sb.append(c);
                String candidate = dfs(node, sb);
                if( candidate.length() > longest .length() || 
                (candidate.length() == longest .length() &&  candidate.compareTo(longest) < 0 )) {
                    longest = candidate;
                }

                sb.deleteCharAt(sb.length()-1);
            }
        }

        return longest;

    }
}

class TrieNode {
    Map<Character,TrieNode> child = new HashMap<>();
    boolean isWord = false;
}