// 572. Subtree of Another Tree
public class SubtreeOfAnotherTree {
    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        if (p.val != q.val)
            return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        if (isSame(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
