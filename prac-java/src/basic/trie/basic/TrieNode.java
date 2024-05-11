package basic.trie.basic;

public class TrieNode {
    boolean word;
    TrieNode[] children;

    public TrieNode() {
        this.word = false;
        this.children = new TrieNode[26];
    }
}
