package LinkedList_Array;

import Linked_List.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // If list is empty or only one node or k = 0, return head
        if (head == null || head.next == null || k == 0)
            return head;

        // Initialize length and tail
        int length = 1;
        ListNode tail = head;

        // Traverse to find tail and calculate length
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make the list circular
        tail.next = head;

        // Calculate effective rotation
        k = k % length;

        // Traverse to new tail position
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // New head is next of newTail
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode rotatedHead = rotateList.rotateRight(head, k);

        // Print rotated list
        ListNode current = rotatedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

}
