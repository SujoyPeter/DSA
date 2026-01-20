package Linked_List;

import java.util.HashMap;

public class LinkedListCycle {
    public boolean detectLoop(ListNode head) {
        // Initialize a pointer 'temp'
        // at the head of the linked list
        ListNode temp = head;

        // Create a map to keep track of
        // encountered nodes
        HashMap<ListNode, Integer> nodeMap = new HashMap<>();

        // Step 2: Traverse the linked list
        while (temp != null) {
            // If the node is already in the
            // map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            // Store the current node
            // in the map
            nodeMap.put(temp, 1);

            // Move to the next node
            temp = temp.next;
        }

        // Step 3: If the list is successfully traversed 
        // without a loop, return false
        return false;
    }
    public static void main(String[] args) {
        // Example usage:
        // Create a linked list with a cycle for testing
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head; // Creates a cycle

        LinkedListCycle llc = new LinkedListCycle();
        boolean hasCycle = llc.detectLoop(head);
        System.out.println("Linked List has cycle: " + hasCycle); 
    }
}
