package LinkedList_Array;

import Linked_List.ListNode;

public class CopyListWithRandomPointer {
    public ListNode copyRandomList(ListNode head) {
        if (head == null) return null;

    // Step 1: Insert copy of
    // ListNodes in between
    insertCopyInBetween(head);
    // Step 2: Connect random
    // pointers of copied ListNodes
    connectRandomPointers(head);
    // Step 3: Retrieve the deep
    // copy of the linked list
    return getDeepCopyList(head); 
    }
    void insertCopyInBetween(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
        ListNode nextElement = temp.next;
        // Create a new ListNode with the same data
        ListNode copy = new ListNode(temp.val);

        // Point the copy's next to
        // the original ListNode's next
        copy.next = nextElement;

        // Point the original
        // ListNode's next to the copy
        temp.next = copy;

        // Move to the next original ListNode
        temp = nextElement;
    }
}
    void connectRandomPointers(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
        // Access the copied ListNode
        ListNode copyListNode = temp.next;

        // If the original ListNode
        // has a random pointer
        if (temp.random != null) {
            // Point the copied ListNode's random to the
            // corresponding copied random ListNode
            copyListNode.random = temp.random.next;
        } else {
            // Set the copied ListNode's random to
            // null if the original random is null
            copyListNode.random = null;
        }

        // Move to the next original ListNode
        temp = temp.next.next;
    }
}

// Function to retrieve the
// deep copy of the linked list
ListNode getDeepCopyList(ListNode head) {
    ListNode temp = head;
    // Create a dummy ListNode
    ListNode dummyListNode = new ListNode(-1);
    // Initialize a result pointer
    ListNode res = dummyListNode;

    while (temp != null) {
        // Creating a new List by
        // pointing to copied ListNodes
        res.next = temp.next;
        res = res.next;

        // Disconnect and revert back to the
        // initial state of the original linked list
        temp.next = temp.next.next;
        temp = temp.next;
    }

    // Return the deep copy of the
    // list starting from the dummy ListNode
    return dummyListNode.next;
}
    void printClonedLinkedList(ListNode head) {
    while (head != null) {
        System.out.print("Data: " + head.val);
        if (head.random != null) {
            System.out.print(", Random: " + head.random.val);
        } else {
            System.out.print(", Random: null");
        }
        System.out.println();
        // Move to the next ListNode
        head = head.next;
    }
} 
public static void main(String[] args) {
    CopyListWithRandomPointer list = new CopyListWithRandomPointer();

    // Creating a linked list with random pointers
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.random = head.next.next; // 1's random points to 3
    head.next.random = head;       // 2's random points to 1
    head.next.next.random = head.next; // 3's random points to 2

    System.out.println("Original linked list:");
    list.printClonedLinkedList(head);

    ListNode clonedHead = list.copyRandomList(head);

    System.out.println("\nCloned linked list:");
    list.printClonedLinkedList(clonedHead);

}
}
