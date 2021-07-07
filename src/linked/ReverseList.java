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
        // 头节点为空或只有一个节点，不需要反转，就返回自己
        if (head == null || head.next == null)
            return head;

        // 得到的就是部分反转后的链表
        ListNode newHead = reverseList2(head.next); // 1
        // 将head的下一个节点指向head自己
        head.next.next = head; // 2
        // 将head之前的指向断开
        head.next = null; // 3

        // 为啥上面第2和3行代码执行后会改变newHead呢？
        // 因为head本来的指向的元素其实挂到了newHead的链接后的最后一个节点上了
        // 在执行了第2行代码后其实是将head链接到了newHead后面，然后第3行代码将head后面节点断开
        // 其实2、3行代码的意思就是将head那一个元素链接到newHead后面了
        return newHead;
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
