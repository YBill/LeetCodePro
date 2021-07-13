package bt;

/**
 * 将有序数组转换为二叉搜索树
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        SortedArrayToBST bst = new SortedArrayToBST();

        int[] nums = new int[]{0, 1, 2, 3, 4, 5};
        TreeNode root = bst.sortedArrayToBST(nums);

    }

    // 递归
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        return add(nums, 0, nums.length - 1);
    }

    // 分治，返回[start, end]范围的nums中，新的树的根
    private TreeNode add(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) >> 1;
//        mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = add(nums, start, mid - 1);
        root.right = add(nums, mid + 1, end);

        return root;
    }

}
