// 543. Diameter of Binary Tree
public class DiameterOfBinaryTree {
    private static int ans;

    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        maxDepth(root);
        return ans;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        ans =  Math.max(ans, lDepth + rDepth);
        return Math.max(lDepth, rDepth) + 1;
    }
}
