package bt;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class IsValidBST {

    public static void main(String[] args) {
        // 简单的构建一下树
        TreeNode head = new TreeNode(9);
        TreeNode level2Left = new TreeNode(9);
        TreeNode level2Right = new TreeNode(20);
        head.left = level2Left;
        head.right = level2Right;

        IsValidBST obj = new IsValidBST();
        System.out.println(obj.isValidBST(head));
        System.out.println(obj.isValidBST2(head));
    }

    // 中序遍历-递归
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, null);
    }

    private Integer preVal = null;

    // 注意这里需要一个全局变量，通过局部变量val的值不能及时更新到上一个上面
    private boolean isValidBST2(TreeNode root, Integer val) {
        if (root == null)
            return true;

        if (!isValidBST2(root.left, preVal))
            return false;

        if (preVal != null && preVal >= root.val)
            return false;
        preVal = root.val;

        if (!isValidBST2(root.right, preVal))
            return false;

        return true;
    }

    // 中序遍历-非递归
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Integer max = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (max != null) {
                    if (max >= cur.val) {
                        return false;
                    }
                }
                max = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }

}
