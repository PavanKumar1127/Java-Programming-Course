package blind75;

public class Blind75_17_ReverseLinkedList206 {
	
	public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode present = head;
        ListNode next = head.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
           if (next != null) {
                next = next.next;
            }
        }
        
        return prev;
    }
}

