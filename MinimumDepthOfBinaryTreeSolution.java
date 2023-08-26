import java.util.LinkedList;
import java.util.Queue;

// 111. Minimum Depth of Binary Tree
public class MinimumDepthOfBinaryTreeSolution {

    // DFS
     public static int minDepthDFS(TreeNode root) {
         if (root == null)
             return 0;
         int lDepth = minDepth(root.left);
         int rDepth = minDepth(root.right);
         if (lDepth == 0 || rDepth == 0)
             return 1 + Math.max(lDepth, rDepth);
         return 1 + Math.min(lDepth, rDepth);
     }

    // BFS (Better Solution)
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}
