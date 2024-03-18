package leetcode.binary_search_tree_to_greater_sum_tree;

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode node = new TreeNode(4);
        node.left =  new TreeNode(1);
        node.right =  new TreeNode(6);
        node.right.right =  new TreeNode(7);
        node.right.left =  new TreeNode(5);
        TreeNode result = solution.bstToGst(node);
    }
}

class Solution {
    private int CURRENT_CUMULATIVE_SUM = 0;
    public TreeNode bstToGst(TreeNode root) {
        return postOrderSearch(root);
    }

    private TreeNode postOrderSearch(TreeNode node){
        if(node == null) return null;
        postOrderSearch(node.right);
        CURRENT_CUMULATIVE_SUM += node.val;
        node.val = CURRENT_CUMULATIVE_SUM;
        postOrderSearch(node.left);
        return node;
    }
}
