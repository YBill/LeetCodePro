package linked;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists node = new MergeTwoLists();

        // 构造一个链表
        int[] arr1 = new int[]{1, 2, 4};
        int[] arr2 = new int[]{1, 3, 4};

        ListNode node1 = new ListNode(arr1);
        ListNode node2 = new ListNode(arr2);

        ListNode result = node.mergeTwoLists2(node1, node2);

        result.printLinked();
    }

    /**
     * 递归
     * mergeTwoLists2()的宏观意义是传入两个链表，返回合并好的新链表
     * 然后是确定小的节点（因为小的往后连大的），然后看作是小节点连接mergeTwoLists2()
     * 所以就是小的.next=mergeTwoLists2() 就可以了
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null)
            return l1;

        // 记录头节点，要不后面newNode向后移找不到头了
        ListNode dummyHead = new ListNode();
        ListNode newNode = dummyHead;
        while (true) {
            if (l1.val < l2.val) {
                newNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            newNode = newNode.next;

            if (l1 == null) {
                newNode.next = l2;
                break;
            }
            if (l2 == null) {
                newNode.next = l1;
                break;
            }
        }
        return dummyHead.next;

    }

}
