import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 637. Average of Levels in Binary Tree
public class AverageOfLevelInBinaryTreeSolution {

    // BFS Solution (Better Solution)
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double temp = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                temp = (temp*i + node.val)/(i+1);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            avg.add(temp);
        }
        return avg;
    }

    // DFS Solution
     public static List<Double> averageOfLevelsDFS(TreeNode root) {
         List<Double> res = new ArrayList<>();
         List<Integer> count = new ArrayList();
         average(root, 0, res, count);
         for (int i=0; i<res.size(); i++) {
             res.set(i, res.get(i)/count.get(i));
         }
         return res;
     }

     public static void average(TreeNode node, int i, List<Double> sum, List<Integer> count) {
         if (node == null)
             return;
         if (i < sum.size()) {
             sum.set(i, sum.get(i) + node.val);
             count.set(i, count.get(i) + 1);
         } else {
             sum.add(1.0*node.val);
             count.add(1);
         }
         average(node.left, i+1, sum, count);
         average(node.right, i+1, sum, count);
     }
}
