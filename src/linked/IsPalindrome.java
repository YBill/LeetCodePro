package linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 输入: 1->2
 * 输出: false
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome node = new IsPalindrome();

        // 构造一个链表
        int[] arr = new int[]{1, 2, 2, 1};
        ListNode head = new ListNode(arr);

        head.printLinked();

        boolean result = node.isPalindrome(head);

        System.out.println(result);
    }

    /**
     * 借助ArrayList实现
     */
    public boolean isPalindrome2(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int length = list.size();
        for (int i = 0; i < length / 2; i++) {
            if (list.get(i).val != list.get(length - i - 1).val) {
                return false;
            }
        }

        return true;

    }

    /**
     * 反转后半段实现
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode first = head;
        ListNode slow = head;
        while (first != null && first.next != null) {
            first = first.next.next;
            slow = slow.next;
        }

        // 奇数时指向的是中间的节点，再向后移一位
        // first==null 是偶数，first.next==null 是奇数
        if (first != null)
            slow = slow.next;

        // 后半段反转
        ListNode halfBack = reverse(slow);
        // 此时fast是null或fast.next是null，所以fast没啥用了
        // fast
        // 反转后slow也没用了，其结构也被破坏了
        // slow
        // 注意调用reverse()反转后，此时head已经不是原来的head了，因为反转会对head原有链路做破坏
        // 不过因为是反转的后半部分，所以head的前半部分还是完整的，所以还可以使用head来和反转后的后半部分做比较
        // 不过因为head不完整了，所以一定要用slow做条件处理结束，slow是完整的反转后的后半部分
        // head

        // 也正是因为反转后会对head破坏，所以不可以使用head整体反转，然后使用反转后的链表和原来的head做比较
        // 因为head不是原来的head了

        while (halfBack != null) {
            if (halfBack.val != head.val) {
                return false;
            }
            halfBack = halfBack.next;
            head = head.next;
        }

        return true;

    }

    // 反转列表
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }
        return newHead;
    }

}
