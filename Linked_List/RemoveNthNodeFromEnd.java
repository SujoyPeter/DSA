package Linked_List;
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class RemoveNthNodeFromEnd {
     public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node before head to handle edge cases
        ListNode dummy = new ListNode(0, head);

        // Initialize slow and fast pointers at dummy
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer N+1 steps ahead to create a gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow is now at node before target → delete target node
        slow.next = slow.next.next;

        // Return updated head
        return dummy.next;
    }
    public static void main(String[] args) {
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();

        // Example: Creating a linked list 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // Remove the 2nd node from the end

        // Remove the Nth node from the end
        ListNode updatedHead = solution.removeNthFromEnd(head, n);

        // Print the updated linked list
        ListNode current = updatedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
