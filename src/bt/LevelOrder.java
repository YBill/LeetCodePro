package bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {

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

        LevelOrder obj = new LevelOrder();
        List<List<Integer>> list = obj.levelOrder(head);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    // 非递归实现
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> levelList = new ArrayList<>(num);
            while (num > 0) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                num--;
            }
            list.add(levelList);
        }
        return list;
    }

    // 递归实现
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        return list;
    }

    private void levelOrder(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null)
            return;
        if (list.size() == level)
            list.add(new ArrayList<>());

        list.get(level).add(node.val);
        levelOrder(node.left, list, level + 1);
        levelOrder(node.right, list, level + 1);

    }


}
