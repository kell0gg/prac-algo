package leetcode.implement_trie_prefix_tree;

class TrieNode {
    boolean leafNode;
    TrieNode[] children;

    public TrieNode() {
        this.leafNode = false;
        this.children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        // root 부터 시작
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            // 자식 노드로 추가할 수 있다면 추가함
            if (currentNode.children[c - 'a'] == null) {
                currentNode.children[c - 'a'] = new TrieNode();
            }
            currentNode = currentNode.children[c - 'a'];
        }

        currentNode.leafNode = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;

        for (char c : word.toCharArray()) {
            if (currentNode.children[c - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.children[c - 'a'];
        }

        return currentNode.leafNode;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;

        for (char c : prefix.toCharArray()) {
            if (currentNode.children[c - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.children[c - 'a'];
        }

        return true;
    }
}
