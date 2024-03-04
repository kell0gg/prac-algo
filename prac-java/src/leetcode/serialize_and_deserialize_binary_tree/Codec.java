package leetcode.serialize_and_deserialize_binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {
    private static final String END_OF_LEAF = "#";
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return END_OF_LEAF;
        StringBuilder stringBuilder = new StringBuilder();

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        stringBuilder.append(root.val);
        stringBuilder.append(DELIMITER);

        while (!deque.isEmpty()) {
            TreeNode current = deque.pollFirst();
            stringBuilder.append(convertVal(current.left));
            stringBuilder.append(DELIMITER);
            stringBuilder.append(convertVal(current.right));
            stringBuilder.append(DELIMITER);

            if (current.left != null) {
                deque.addLast(current.left);
            }
            if (current.right != null) {
                deque.addLast(current.right);
            }
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(END_OF_LEAF)) return null;

        String[] nodes = data.split(DELIMITER);
        int childIdx = 1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode current = deque.pollFirst();
            // left
            if (!nodes[childIdx].equals(END_OF_LEAF)) {
                current.left = new TreeNode(Integer.parseInt(nodes[childIdx]));
                deque.addLast(current.left);
            }
            childIdx++;
            // right
            if (!nodes[childIdx].equals(END_OF_LEAF)) {
                current.right = new TreeNode(Integer.parseInt(nodes[childIdx]));
                deque.addLast(current.right);
            }
            childIdx++;
        }
        return root;
    }

    private String convertVal(TreeNode node) {
        if (node == null) return END_OF_LEAF;
        else return String.valueOf(node.val);
    }
}
