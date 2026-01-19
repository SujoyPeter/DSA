package Linked_List;
 
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // Initialize the slow pointer to the head.
        ListNode slow = head; 
        
        // Initialize the fast pointer to the head.
        ListNode fast = head;   

        // Traverse the linked list using
        // the Tortoise and Hare algorithm.
        while (fast != null && fast.next != null && slow != null) {
            // Move fast two steps.
            fast = fast.next.next;  
            // Move slow one step.
            slow = slow.next;        
        }
        // Return the slow pointer,
        // which is now at the middle node.
        return slow;  
    }
    public static void main(String[] args) {
        MiddleOfLinkedList sol = new MiddleOfLinkedList();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Find the middle node
        ListNode middle = sol.middleNode(head);

        // Print the value of the middle node
        System.out.println("Middle Node Value: " + middle.val); 
    }
}
