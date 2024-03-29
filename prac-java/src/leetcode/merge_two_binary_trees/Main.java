package leetcode.merge_two_binary_trees;

// https://leetcode.com/problems/merge-two-binary-trees/
public class Main {
    //
}


class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 둘 다 null 이면 null 이 return
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}