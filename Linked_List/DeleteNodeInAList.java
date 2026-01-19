package Linked_List;

public class DeleteNodeInAList {
    public void deleteNode(ListNode node) {
         // Copy value of next node into current node
        node.val = node.next.val;

        // Bypass the next node
        node.next = node.next.next;
    }
    public static void main(String[] args) {
        DeleteNodeInAList solution = new DeleteNodeInAList();

        // Example: Creating a linked list 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Node to be deleted (node with value 5)
        ListNode nodeToDelete = head.next;

        // Delete the node
        solution.deleteNode(nodeToDelete);

        // Print the updated linked list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
