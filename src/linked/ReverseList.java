package linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

        ListNode result = node.reverseList3(head);

        result.printLinked();
    }

    /**
     * 使用栈，因为栈是后进先出的，正好先后入栈的再拿出来反过来了
     * 但是栈是线程安全的，感觉没必要使用他，这里使用ArrayList了
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null)
            return null;

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            // 分别放出list中，但是需要注意的是，放进去的不是简单的一个链表的节点
            // 而是节点后还带着节点了，只不过头逐渐向后了；但是这样后面取得时候需要将每一个都断开
            list.add(head);
            head = head.next;
        }

        int length = list.size();
        // 倒着取出
        ListNode newHead = list.get(length - 1);
        // 记录列表头，要不一会向后移找不到头了
        ListNode dummyHead = newHead;
        for (int i = length - 2; i >= 0; i--) {
            ListNode temp = list.get(i);
            // 这里注意一定要置空，置空后就变成一个简单的节点了
            // 不置空的话temp后面还跟一串节点了
            temp.next = null;
            newHead.next = temp;
            newHead = newHead.next;
        }

        return dummyHead;

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
