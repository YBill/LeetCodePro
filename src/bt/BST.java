package bt;

import java.util.*;

/**
 * 不是LeetCode题目
 * 自己组建的二分搜索树
 * 二分搜索树：每个节点的值都大于其左子树所有节点的值，并且小于其右子树所有节点的值
 * 功能包括：包括添加、遍历元素（前中后递归和非递归）
 */
public class BST {

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;
    private int size;

    public void add(int val) {
        root = add(root, val);
    }

    // 递归添加
    private Node add(Node root, int val) {
        if (root == null) {
            size++;
            return new Node(val);
        }

        if (root.val < val) {
            root.right = add(root.right, val);
        } else {
            root.left = add(root.left, val);
        }

        return root;

    }

    // 前序遍历-递归
    public List<Integer> preOrder() {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);

    }

    /**
     * 前序遍历，非递归
     * 通过栈来辅助
     * 取出栈顶并保存（使用），然后先将右节点入栈，再将左节点入栈
     * 为啥先入栈右节点，再左节点呢，因为栈是后入先出，所以左节点后入，
     * 然后后面取出栈顶就是先取出左节点了
     */
    public List<Integer> preOrderNR() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return list;

    }

    /**
     * 前序遍历，非递归，套用模版
     * Stack<Node> stack = new Stack<>();
     * Node cur = root;
     * while (cur != null || !stack.isEmpty()) {
     *    if (cur != null) {
     *
     *    } else { // cur == null && !stack.isEmpty()
     *
     *    }
     * }
     */
    public List<Integer> preOrderNR2() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                list.add(cur.val); // 前序遍历，在最开始保存
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return list;

    }

    // 中序遍历-递归
    public List<Integer> inOrder() {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

    }

    /**
     * 中遍历，非递归，套用模版
     * Stack<Node> stack = new Stack<>();
     * Node cur = root;
     * while (cur != null || !stack.isEmpty()) {
     *    if (cur != null) {
     *
     *    } else { // cur == null && !stack.isEmpty()
     *
     *    }
     * }
     */
    public List<Integer> inOrderNR() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    // 后序遍历-递归
    public List<Integer> postOrder() {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }

    /**
     * 后序遍历，非递归，套用模版
     *
     * Stack<Node> stack = new Stack<>();
     * Node cur = root;
     * while (cur != null || !stack.isEmpty()) {
     *    if (cur != null) {
     *
     *    } else { // cur == null && !stack.isEmpty()
     *
     *    }
     * }
     *
     * 可以看到前中序遍历套用模版代码基本一样，就是保存值的地方不一样，不过后序遍历比较复杂，
     * 还需要借助一个Node变量保存前一个右节点的值
     */
    public List<Integer> postOrderNR() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        // 保存上一个右节点
        Node pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if (cur.right == null || cur.right == pre) {
                    stack.pop();
                    list.add(cur.val);
                    pre = cur;
                    cur = null;

                } else
                    cur = cur.right;
            }
        }
        return list;
    }


    /**
     * 后序遍历-非递归
     * 后序遍历有一个比较好实现的方法，也可以说是个规律
     * 前序遍历是 跟节点-左子树-右子树
     * 然后改变下前序遍历为 跟节点-右子树-左子树
     * 上面遍历后得到的结果就是后序遍历反转后结果
     * 所以可以通过遍历 跟节点-右子树-左子树，然后再反转就是后序遍历的结果
     */
    public List<Integer> postOrderNR2() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            // 注意这里跟前序遍历相反，先将左子树入栈，则后面出栈时就是右子树先出来遍历了
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        Collections.reverse(list); // 反转
        return list;
    }

    /**
     * 跟上面一样，套用模版来下，并将结果倒这添加到List中，就不用反转了
     */
    public List<Integer> postOrderNR3() {
        // 因为要倒着添加，所以都添加到头部，使用队列了
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                list.add(0, cur.val);
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.left;
            }
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        // 打印树，并打印出树深度
        print(root, 0, builder);
        return builder.toString();
    }

    private void print(Node node, int deep, StringBuilder builder) {
        if (node == null) {
            builder.append(generaLine(deep));
            builder.append("null");
            builder.append("\n");
            return;
        }

        builder.append(generaLine(deep));
        builder.append(node.val);
        builder.append("\n");

        print(node.left, deep + 1, builder);
        print(node.right, deep + 1, builder);

    }

    private String generaLine(int deep) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < deep; i++) {
            builder.append("--");
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 6, 2, 4, 8};

        BST bst = new BST();

        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }

        // 遍历
//        System.out.println(bst);

        System.out.println("前序遍历：");
        print(bst.preOrder());
        print(bst.preOrderNR());
        print(bst.preOrderNR2());

        System.out.println("中序遍历：");
        print(bst.inOrder());
        print(bst.inOrderNR());

        System.out.println("后序遍历：");
        print(bst.postOrder());
        print(bst.postOrderNR());
        print(bst.postOrderNR2());
        print(bst.postOrderNR3());
    }

    private static void print(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
        System.out.println();
    }

}
