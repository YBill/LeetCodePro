package linked;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * 提示：
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * <p>
 * 例如：
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class DeleteNode {

    public static void main(String[] args) {
        DeleteNode node = new DeleteNode();

        // 构造一个链表
        int[] arr = new int[]{4, 5, 1, 9};
        ListNode head = new ListNode(arr);

        head.printLinked();

        // 删除链表第二个元素
        ListNode second = head.next;
        node.deleteNode(second);

        head.printLinked();
    }

    /**
     * 正常要删除一个单链表的节点，应该拿到要删除节点的前一个节点，然后让前一个节点指向待删除节点的下一个节点即可
     * 这里只给出了但前要删除的节点，没法获取到他的前一个节点，所以可以说是没法删除这个节点的
     * 但是因为题目说了，给出的待删除的节点不是未节点，所以可以用一个巧妙的方法解决：
     * 1、将待删除节点的下一个节点的内容(val)赋值给待删除节点，这样待删除节点的值就是下一个节点的值了
     * 2、将待删除节点的下一个节点指像他的下一个再下一个节点，就是把待删除节点的下一个节点给删除了，
     * 因为待删除节点已经保存了下一个节点的值了，所以相当于将待删除节点给删了
     *
     * @param node 待删除的节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
