/**
 * Zhia's Interview Prep Course <Week 2>
 *
 * @author Chloe Kim (chloekim@cmu.edu)
 */
import java.util.*;
/**
 * [Question 4]
 * Write a function to print a binary tree level-by-level.
 *       1
 *     9  -2
 *  13    5 4 
 *
 * [Explanation]
 * I would use a queue and it's initial size per each level.
 */
class PrintBinaryTreeLevelByLevel {

    public static void main(String[] args) {
        PrintBinaryTreeLevelByLevel bt = new PrintBinaryTreeLevelByLevel();
        TreeNode root = new TreeNode(1);
        bt.buildTree(root);
        bt.print(root);
    }

    public void print(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode tn = q.poll();
                if (tn.left != null) q.offer(tn.left);
                if (tn.right != null) q.offer(tn.right);
                System.out.print(tn.val+" ");
                size--;
            }
            System.out.println();
        }
    }

    private void buildTree(TreeNode root) {
        root.left = new TreeNode(9);
        root.right = new TreeNode(-2);
        root.left.left = new TreeNode(13);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
   }
}