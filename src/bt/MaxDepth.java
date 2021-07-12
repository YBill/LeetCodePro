package bt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MaxDepth {

    // 这道题其实跟获取层序遍历一样
    public static void main(String[] args) {
        // 简单的构建一下树
        TreeNode head = new TreeNode(3);
        TreeNode level2Left = new TreeNode(9);
        TreeNode level2Right = new TreeNode(20);
        head.left = level2Left;
        head.right = level2Right;

        TreeNode level2RightLeft = new TreeNode(15);
        TreeNode level2RightRight = new TreeNode(7);
        level2Right.left = level2RightLeft;
        level2Right.right = level2RightRight;

        MaxDepth obj = new MaxDepth();
        System.out.println(obj.maxDepth0(head));
        System.out.println(obj.maxDepth1(head));
        System.out.println(obj.maxDepth2(head));
    }

    /**
     * 非递归
     */
    public int maxDepth0(TreeNode root) {
        int deep = 0;
        if (root == null)
            return deep;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            while (num > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                num--;
            }
            deep++;
        }
        return deep;
    }

    public int maxDepth1(TreeNode root) {
        return maxDepth1(root, 0);
    }

    // 递归
    private int maxDepth1(TreeNode node, int deep) {
        if (node == null)
            return deep;
        int leftDeep = maxDepth1(node.left, deep + 1);
        int rightDeep = maxDepth1(node.right, deep + 1);
        return Math.max(leftDeep, rightDeep);
    }

    // 递归-2
    public int maxDepth2(TreeNode node) {
        if (node == null)
            return 0;
        int leftDeep = maxDepth2(node.left);
        int rightDeep = maxDepth2(node.right);
        return Math.max(leftDeep, rightDeep) + 1;
    }

}
