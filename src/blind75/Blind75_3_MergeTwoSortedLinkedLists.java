package blind75;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
}

public class Blind75_3_MergeTwoSortedLinkedLists {
	


	private void printList(ListNode mergedList) {
		
		System.out.print(" Start ");
		while (mergedList != null ) {
			System.out.print(mergedList.val+" -> ");
			mergedList = mergedList.next;
		}
		System.out.print(" null ");

	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				current.next=l1;
				l1 = l1.next;
			}else {
				current.next=l2;
				l2 = l2.next;
			}
			current = current.next;

		}
		
		while (l1 == null && l2 != null) {
			current.next = l2;
			l2 = l2.next;
			current = current.next;
		}
		while (l2 == null && l1 != null) {
			current.next = l1;
			l1 = l1.next;
			current = current.next;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		Blind75_3_MergeTwoSortedLinkedLists merger = new Blind75_3_MergeTwoSortedLinkedLists();

        // Example usage
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(5);

        ListNode mergedList = merger.mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        merger.printList(mergedList);
    }

}

//
//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
//
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
//
//Input: list1 = [], list2 = []
//Output: []
//Example 3:
//
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
//Constraints:
//
//The number of nodes in both lists is in the range [0, 50].
//-100 <= Node.val <= 100
//Both list1 and list2 are sorted in non-decreasing order.