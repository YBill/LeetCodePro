package linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 */
public class HasCycle {

    public static void main(String[] args) {
        HasCycle node = new HasCycle();

        // 构造一个链表
        int[] arr = new int[]{3, 2, 0, -4};
        ListNode head = new ListNode(arr);

        // 取出第二个准备构成环
        ListNode second = head.next;

        // 定位到尾节点
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        ListNode lastNode = cur;

        // 将链表的最后一个节点指向他的第二个节点，构成环
        lastNode.next = second;

        boolean result = node.hasCycle3(head);

        System.out.println(result);
    }


    /**
     * 使用快慢指针解决
     * 如果存在环一直移动下去快慢指针最终肯定会相遇的
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;

    }

    /**
     * 使用集合
     */
    public boolean hasCycle2(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, false);
            head = head.next;
        }
        return false;
    }

    /**
     * 递归
     * 递归的结束条件有两个，分别对应有没有环
     * 有环的时候是永远不会出现head为空的情况，通过head.next=head最终都是自己指向了自己，所以最后head.next=head了
     * 无环的时候通过head.next=head最终也会都自己指向自己，但是在最后一个节点ListNode nextNode=head.next这里获取
     * 的时候首先是空了，所以下次递归进去的时候head就是null，所以可以认为是无环的
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null)
            return false;

        if (head.next == head) {
            return true;
        }

        ListNode nextNode = head.next;
        head.next = head;

        return hasCycle3(nextNode);

    }

    /**
     * 反转
     * 将链表发反转，如果有环反转后的头节点还是之前的节点(通过断点发现反转后所有节点都是头节点互联的)
     * 所以可以反转后再比较头节点就可以了
     */
    public boolean hasCycle4(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode reverseNode = reverseList(head);
        if (head == reverseNode) {
            return true;
        }
        return false;
    }

    private ListNode reverseList(ListNode head) {
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
