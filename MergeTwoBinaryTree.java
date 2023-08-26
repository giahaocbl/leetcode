import java.util.Stack;

// 617. Merge Two Binary Trees
public class MergeTwoBinaryTree {
    // Recursion Solution
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
         if (root1 == null || root2 == null)
             return root1 == null ? root2 : root1;
         root1.val += root2.val;
         root1.left = mergeTrees(root1.left, root2.left);
         root1.right = mergeTrees(root1.right, root2.right);
         return root1;
    }

    // Iterator Solution
    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root1, root2});
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            if (nodes[0] == null || nodes[1] == null)
                continue;
            nodes[0].val += nodes[1].val;
            if (nodes[0].left == null)
                nodes[0].left = nodes[1].left;
            else
                stack.push(new TreeNode[] {nodes[0].left, nodes[1].left});
            if (nodes[0].right == null)
                nodes[0].right = nodes[1].right;
            else
                stack.push(new TreeNode[] {nodes[0].right, nodes[1].right});
        }
        return root1;
    }
}
