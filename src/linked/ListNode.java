package linked;

public class ListNode {

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

    ListNode(int[] arr) {
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    public void printLinked() {
        printLinked("");
    }

    public void printLinked(String msg) {
        StringBuilder builder = new StringBuilder(msg);
        ListNode cur = this;
        while (cur != null) {
            builder.append(cur.val);
            builder.append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        System.out.println(builder);
    }

}
