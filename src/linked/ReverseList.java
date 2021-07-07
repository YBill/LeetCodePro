package linked;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseList node = new ReverseList();

        // 构造一个链表
        int[] arr = new int[]{1, 2, 3};
        ListNode head = new ListNode(arr);

        head.printLinked();

        ListNode result = node.reverseList2(head);

        result.printLinked();
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        // 终止条件
        if (head == null || head.next == null)
            return head;
        // 保存当前节点的下一个结点
        ListNode next = head.next;
        // 从当前节点的下一个结点开始递归调用
        ListNode reverse = reverseList2(next);
        // 这里head相当于变成了尾结点，尾结点都是为空的，否则会构成环
        head.next = null;
        // reverse是反转之后的链表，因为函数reverseList表示的是对链表的反转，
        // 所以反转完之后next肯定是链表reverse的尾结点，然后我们再把当前节点
        // head挂到next节点的后面就完成了链表的反转。
        next.next = head;
        return reverse;
    }

    // 循环遍历
    public ListNode reverseList(ListNode head) {
        // 当前节点
        ListNode cur = head; // 使用cur语意好理解
        // 创建一个新链表
        ListNode newNode = null;
        while (cur != null) {
            // 先将下一个节点保存起来，要不后面断开了就找不到了
            ListNode temp = cur.next;
            // 将当前节点指向前面的节点（向前指向）
            cur.next = newNode;
            // 指向当前节点
            newNode = cur;
            // 重新赋值为刚断开的下一个节点，继续循环
            cur = temp;
        }
        return newNode;
    }

}
