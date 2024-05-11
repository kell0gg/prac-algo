package basic.trie.basic;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        word = word.toLowerCase();
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.word = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
        }
        return current.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
        }
        return true;
    }

}
