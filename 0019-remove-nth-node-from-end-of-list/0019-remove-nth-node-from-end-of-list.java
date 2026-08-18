class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Find length
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // If removing head
        if (n == length) {
            return head.next;
        }

        // Find previous node
        temp = head;

        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }

        // Delete node
        temp.next = temp.next.next;

        return head;
    }
}