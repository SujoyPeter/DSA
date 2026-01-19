package Linked_List;
 

public class IntersectionOfTwoLinkedLists {
	public void insertNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
         ListNode d1 = head1;
        ListNode d2 = head2;

        // Traverse both lists, when one reaches the end, redirect it to the head of the other list
        while (d1 != d2) {
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }

        return d1; 
    }
     public void printList(ListNode head) {
        while (head != null && head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        if (head != null) {
            System.out.print(head.val);
        }
        System.out.println();
    }
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists list = new IntersectionOfTwoLinkedLists();
		ListNode head1 = new ListNode(4);
		list.insertNode(head1, 1);
		ListNode intersection = new ListNode(8);
		list.insertNode(intersection, 4);
		list.insertNode(intersection, 5);
		head1.next.next = intersection; 

		ListNode head2 = new ListNode(5);
		list.insertNode(head2, 0);
		list.insertNode(head2, 1);
		head2.next.next.next = intersection; 

		System.out.println("List 1:");
		list.printList(head1);
		System.out.println("List 2:");
		list.printList(head2);

		ListNode intersectNode = list.getIntersectionNode(head1, head2);
		if (intersectNode != null) {
			System.out.println("Intersection at node with value: " + intersectNode.val);
		} else {
			System.out.println("No intersection.");
		}
	}

}
