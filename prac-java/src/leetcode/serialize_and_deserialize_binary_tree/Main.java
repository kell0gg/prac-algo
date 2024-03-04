package leetcode.serialize_and_deserialize_binary_tree;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class Main {

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        String ser = codec.serialize(root);
        TreeNode deser = codec.deserialize(ser);
    }
}