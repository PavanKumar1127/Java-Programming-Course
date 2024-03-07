package javaCollectionsFramework.linkedlist;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        // Base case: if the head is null or it is the only node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursive call to reverse the rest of the list
        ListNode reversedList = reverseList(head.next);
        
        // Reverse the current node's pointer
        head.next.next = head;
        head.next = null;
        
        // Return the head of the reversed list
        return reversedList;
    }
    
    // Utility method to print the reversed list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
    	ReverseLL solution = new ReverseLL();
        
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println("Original list:");
        solution.printList(head);
        
        // Reverse the linked list
        ListNode reversedList = solution.reverseList(head);
        
        System.out.println("Reversed list:");
        solution.printList(reversedList);
    }
}
