package leetcode.implement_trie_prefix_tree;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        boolean search = trie.search("abc");
        boolean prefix = trie.startsWith("ab");

        System.out.println(search + " " + prefix);
    }
}
