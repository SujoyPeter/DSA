package Linked_List;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Traverse while fast and fast.next are not null
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;

            // Move fast two steps
            fast = fast.next.next;

            // If they meet, cycle is present
            if (slow == fast) {
                // Reset slow to head
                slow = head;

                // Move both one step to find start of loop
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the starting node of loop
                return slow;
            }
        }

        // If no cycle found
        return null;
    }
   public static void main(String[] args) {
        // Example usage:
        LinkedListCycle2 solution = new LinkedListCycle2();
        
        // Creating a linked list with a cycle for testing
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle here

        ListNode cycleStartNode = solution.detectCycle(head);
        if (cycleStartNode != null) {
            System.out.println("Cycle starts at node with value: " + cycleStartNode.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
