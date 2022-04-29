// 235. Lowest Common Ancestor of a Binary Search Tree
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ( (root.val - p.val) * (root.val - q.val) > 0 )
            root = root.val < p.val ? root.right : root.left;
        return root;
    }
}
