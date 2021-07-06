package linked;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        RemoveNthFromEnd node = new RemoveNthFromEnd();

        // 构造一个链表
        RemoveNthFromEnd.ListNode head = new RemoveNthFromEnd.ListNode(4);
        RemoveNthFromEnd.ListNode second = new RemoveNthFromEnd.ListNode(5);
        RemoveNthFromEnd.ListNode third = new RemoveNthFromEnd.ListNode(1);
        RemoveNthFromEnd.ListNode fourth = new RemoveNthFromEnd.ListNode(9);
        head.next = second;
        second.next = third;
        third.next = fourth;

        printLinked(head);
        printLinked(node.removeNthFromEnd3(head, 1));
    }

    private static void printLinked(RemoveNthFromEnd.ListNode head) {
        StringBuilder builder = new StringBuilder();
        RemoveNthFromEnd.ListNode cur = head;
        while (cur != null) {
            builder.append(cur.val);
            builder.append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        System.out.println(builder);
    }

    /**
     * 双指针解决
     * 定义快慢指针，开始都指向头节点
     * 让快指针先向后移动n步
     * 然后快慢指针一起向后移，此时快指针再移动size-n步就到达末尾，则此时慢指针也向后移动了size-n步
     * 所以此时慢指针正好移动到了倒数第n个位置的前一个位置
     * 将次位置指导下下个位置即删除了倒数第n个位置
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;

        // fast先向后移动n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 如果fast说明是删除头节点了（这里也可以用虚拟头节点处理这个问题）
        if (fast == null) {
            return head.next;
        }
        // 这里判断 fast.next!=null，这样其实fast总共移动了size-1步
        // slow移动了size-n-1步，正好是倒数第n步的前一个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 使用虚拟头节点处理
     * 这种方式不需要单独处理头节点问题
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head); // 虚拟头节点

        // 先计算出总长度
        int size = 0;
        ListNode cur = dummyHead.next;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        // 找出待删除节点的前一个节点
        ListNode pre = dummyHead;
        for (int i = 0; i < size - n; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;

        // 注意返回的是dummyHead.next而不是head
        return dummyHead.next;
    }

    /**
     * 注意头节点需要单独处理
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 先计算出总长度
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        // 删除头节点需要单独处理
        if (size == n) {
            return head.next;
        }

        // 找出待删除节点的前一个节点
        ListNode pre = head;
        for (int i = 1; i < size - n; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;

        return head;
    }

}
