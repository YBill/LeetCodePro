package bt;

import java.util.*;

/**
 * 对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode level2Left = new TreeNode(2);
        TreeNode level2Right = new TreeNode(2);
        head.left = level2Left;
        head.right = level2Right;
        TreeNode level2LeftLeft = new TreeNode(3);
        TreeNode level2LeftRight = new TreeNode(4);
        level2Left.left = level2LeftLeft;
        level2Left.right = level2LeftRight;
        TreeNode level2RightLeft = new TreeNode(4);
        TreeNode level2RightRight = new TreeNode(3);
        level2Right.left = level2RightLeft;
        level2Right.right = level2RightRight;

        IsSymmetric obj = new IsSymmetric();
        System.out.println(obj.isSymmetric2(head));
        System.out.println(obj.isSymmetric(head));
    }

    // 递归实现
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric2(root.left, root.right);
    }

    // 以left和right为跟的两个子树是否是对称的
    private boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left);
    }

    // 非递归实现
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null)
                continue;
            if (left == null || right == null || left.val != right.val)
                return false;
            stack.push(right.left);
            stack.push(left.right);
            stack.push(right.right);
            stack.push(left.left);
        }
        return true;
    }

}
