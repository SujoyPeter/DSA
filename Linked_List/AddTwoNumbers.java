package Linked_List;
 class AddTwoNumbers {
    int val;
    AddTwoNumbers next;
    AddTwoNumbers() {}
    AddTwoNumbers(int val) { this.val = val; }
    AddTwoNumbers(int val, AddTwoNumbers next) { 
     this.val = val; 
     this.next = next; 
    }
public class AddTwoNumbers {
 
    public AddTwoNumbers addTwoNumbers(AddTwoNumbers l1, AddTwoNumbers l2) {
       //Initialize a dummy node as a new node
        AddTwoNumbers dummy = new AddTwoNumbers(); 
        AddTwoNumbers temp = dummy; 
        int carry = 0;
        //Iterate till the end of both the lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
             //Repeat the same process for l2 as l1
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            //Carry gets added to sum in the node (carry=sum/10)
            sum += carry;
            carry = sum / 10;

            AddTwoNumbers node = new AddTwoNumbers(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;
    }

    static AddTwoNumbers createList(int[] arr) {
        AddTwoNumbers head = new AddTwoNumbers(arr[0]);
        AddTwoNumbers temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new AddTwoNumbers(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    static void printList(AddTwoNumbers head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num1 = {2, 4, 3}; // represents 342
        int[] num2 = {5, 6, 4}; // represents 465
        AddTwoNumbers l1 = createList(num1);
        AddTwoNumbers l2 = createList(num2);

        AddTwoNumbers sol = new AddTwoNumbers();
        AddTwoNumbers result = sol.addTwoNumbers(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8
    }

}
 }